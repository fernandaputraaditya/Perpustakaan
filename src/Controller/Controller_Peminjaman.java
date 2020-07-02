package Controller;

import Model.Admin;
import Model.Member;
import Model.Buku;
import Model.Detail_Peminjaman;
import Model.Peminjaman;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Controller_Peminjaman {

    Koneksi koneksi;
    ArrayList<Admin> arrAdmin;
    ArrayList<Member> arrMember;
    ArrayList<Buku> arrBuku;
    ArrayList<Peminjaman> arrPeminjaman;

    public Controller_Peminjaman() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrAdmin = new ArrayList<>();
        this.arrMember = new ArrayList<>();
        this.arrBuku = new ArrayList<>();
        this.arrPeminjaman = new ArrayList<>();
    }

    public ArrayList<Peminjaman> getDataPeminjaman() throws SQLException {
        this.arrPeminjaman.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM DATA_PEMINJAMAN");

        while (rs.next()) {
            Admin admin = new Admin();
            admin.setId_Admin(rs.getInt("ID_ADMIN"));
            admin.setNama(rs.getString("NAMA_ADMIN"));
            admin.setAlamat(rs.getString("ALAMAT_ADMIN"));
            admin.setJenis_Kelamin(rs.getString("JENIS_KELAMIN_ADMIN"));
            admin.setPassword(rs.getString("PASSWORD_ADMIN"));

            Member member = new Member();
            member.setId_Member(rs.getInt("ID_MEMBER"));
            member.setNama(rs.getString("NAMA_MEMBER"));
            member.setAlamat(rs.getString("ALAMAT_MEMBER"));
            member.setJenis_Kelamin(rs.getString("JENIS_KELAMIN_MEMBER"));
            member.setTanggal_Lahir(rs.getDate("TANGGAL_LAHIR_MEMBER"));
            member.setNo_Telp(rs.getString("NO_TELP_MEMBER"));
            member.setNIK(rs.getInt("NIK_MEMBER"));
            member.setEmail(rs.getString("EMAIL_MEMBER"));
            member.setPassword(rs.getString("PASSWORD_MEMBER"));

            Buku buku = new Buku();
            buku.setId_Buku(rs.getInt("ID_BUKU"));
            buku.setJudul_Buku(rs.getString("JUDUL_BUKU"));
            buku.setPengarang(rs.getString("PENGARANG"));
            buku.setTahun_Terbit(rs.getInt("TAHUN_TERBIT"));

            Peminjaman peminjaman = new Peminjaman();
            peminjaman.setId_Peminjaman(rs.getInt("ID_PEMINJAMAN"));
            peminjaman.setAdmin(admin);
            peminjaman.setMember(member);
            peminjaman.setBuku(buku);
            peminjaman.setTanggal_Pinjam(rs.getDate("TANGGAL_PINJAM"));

            ResultSet rsDetail_Peminjaman = this.koneksi.GetData("SELECT * FROM DETAIL_PEMINJAMAN_07015 JOIN PEMINJAMAN_07015 ON "
                    + "DETAIL_PEMINJAMAN_07015.ID_PEMINJAMAN = PEMINJAMAN_07015.ID_PEMINJAMAN JOIN BUKU_07015 ON "
                    + "DETAIL_PEMINJAMAN_07015.ID_BUKU = BUKU_07015.ID_BUKU "
                    + "WHERE DETAIL_PEMINJAMAN_07015.ID_PEMINJAMAN = " + rs.getInt("ID_PEMINJAMAN"));
            ArrayList<Detail_Peminjaman> dp = new ArrayList<>();
            
            while (rsDetail_Peminjaman.next()) {
                Buku bk = new Buku();
                bk.setId_Buku(rsDetail_Peminjaman.getInt("ID_BUKU"));
                bk.setJudul_Buku(rsDetail_Peminjaman.getString("JUDUL_BUKU"));
                bk.setPengarang(rsDetail_Peminjaman.getString("PENGARANG"));
                bk.setTahun_Terbit(rsDetail_Peminjaman.getInt("TAHUN_TERBIT"));

                Peminjaman pinjam = new Peminjaman();
                pinjam.setId_Peminjaman(rsDetail_Peminjaman.getInt("ID_PEMINJAMAN"));
                pinjam.setBuku(bk);
                pinjam.setTanggal_Pinjam(rsDetail_Peminjaman.getDate("TANGGAL_PINJAM"));

                Detail_Peminjaman detail_peminjaman = new Detail_Peminjaman();
                detail_peminjaman.setPeminjaman(pinjam);

                dp.add(detail_peminjaman);
            }
            peminjaman.setArrDetail_Peminjaman(dp);

            this.arrPeminjaman.add(peminjaman);
        }
        return this.arrPeminjaman;
    }

    public void insertPeminjaman(Peminjaman peminjaman) {
        try {
            String datePeminjaman = new SimpleDateFormat("dd/MM/yyyy").format(peminjaman.getTanggal_Pinjam());

            this.koneksi.ManipulasiData("INSERT INTO PEMINJAMAN_07015 VALUES (SEQ_PEMINJAMAN.NEXTVAL, "
                    + peminjaman.getAdmin().getId_Admin() + ", " + peminjaman.getMember().getId_Member() + ", "
                    + peminjaman.getBuku().getId_Buku() + ", TO_DATE('" + datePeminjaman + "','dd/mm/yyyy'))");
            ResultSet rs = this.koneksi.GetData("SELECT SEQ_PEMINJAMAN.CURRVAL FROM DUAL");
            rs.next();
            int id_peminjaman = rs.getInt("CURRVAL");
            for (Detail_Peminjaman p : peminjaman.getArrDetail_Peminjaman()) {
                this.koneksi.ManipulasiData("INSERT INTO DETAIL_PEMINJAMAN_07015 VALUES (" + id_peminjaman + "," + p.getBuku().getId_Buku() + ")");
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void cariData(int id_peminjaman) throws SQLException {
        String kodeSql = "SELECT * FROM Peminjaman_07015 WHERE id_peminjaman LIKE '%" + id_peminjaman + "%'";
        ResultSet hasilKodeSql = this.koneksi.GetData(kodeSql);
        while (hasilKodeSql.next()) {

            Peminjaman peminjaman = new Peminjaman();
            peminjaman.setId_Peminjaman(hasilKodeSql.getInt("ID_PEMINJAMAN"));
            peminjaman.setTanggal_Pinjam(hasilKodeSql.getDate("TANGGAL_PINJAM"));
        }

    }

}
