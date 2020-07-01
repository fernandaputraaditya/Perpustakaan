package Controller;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import Model.Member;
import java.util.Date;

public class Controller_Member {

    private final Koneksi koneksi;
    ArrayList<Member> arrMember;

    public Controller_Member() {
        this.koneksi = new Koneksi();
        this.arrMember = new ArrayList<>();
    }

    public void insert(int id_member, String nama, String alamat, String jenis_kelamin, String tanggal_lahir, String no_telp, int nik, String email, String password) {
        String kodeSql = "INSERT INTO Member_07015 (Id_Member, Nama, Alamat, Jenis_Kelamin, Tanggal_Lahir, No_Telp, Nik, Email, Password) VALUES ("
                + id_member + ", '" + nama + "', '" + alamat + "', '" + jenis_kelamin + "', to_date('"
                + tanggal_lahir + "', 'dd/MM/yyyy'), '" + no_telp + "', '" + nik + "', '" + email + "', '" + password + "')";
        this.koneksi.ManipulasiData(kodeSql);

        System.out.println("INSERT INTO Member_07015 (Id_Member, Nama, Alamat, Jenis_Kelamin, Tanggal_Lahir, No_Telp, Nik, Email, Password) VALUES ("
                + id_member + ", '" + nama + "', '" + alamat + "', '" + jenis_kelamin + "', to_date('"
                + tanggal_lahir + "', 'dd/MM/yyyy'), '" + no_telp + "', '" + nik + "', '" + email + "', '" + password + "')");
    }

    public void delete(int id_member) {
        String kodeSql = "DELETE FROM Member_07015 WHERE id_member = " + id_member;

        System.out.println("DELETE FROM Member_07015 WHERE id_member = " + id_member);
        this.koneksi.ManipulasiData(kodeSql);
    }

    public void update(int id_member, String nama, String alamat, String jenis_kelamin, String tanggal_lahir, String no_telp, int nik, String email, String password) {
        String kodeSql = "UPDATE Member_07015 SET " + "nama = '" + nama + "', " + "alamat = '" + alamat + "', "
                + "jenis_kelamin = '" + jenis_kelamin + "', " + "tanggal_lahir = to_date('"
                + tanggal_lahir + "', 'yyyy-MM-dd'), " + "no_telp = '" + no_telp + "', "
                + "nik = '" + nik + "', " + "email = '" + email + "', " + "password = '" + password + "'"
                + "WHERE id_member = " + id_member;
        this.koneksi.ManipulasiData(kodeSql);
    }

    public void clear() {
        String kodeSql = "DELETE FROM Member_07015";
        this.koneksi.ManipulasiData(kodeSql);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel dtmMember = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmMember.addColumn("ID Member");
        dtmMember.addColumn("Nama");
        dtmMember.addColumn("Alamat");
        dtmMember.addColumn("Jenis Kelamin");
        dtmMember.addColumn("Tgl Lahir");
        dtmMember.addColumn("No Telp");
        dtmMember.addColumn("NIK");
        dtmMember.addColumn("Email");
        dtmMember.addColumn("Password");

        String kodeSql = "SELECT * FROM Member_07015 ORDER BY Id_Member ASC";
        ResultSet hasilKodeSql = this.koneksi.GetData(kodeSql);
        while (hasilKodeSql.next()) {
            int id_member = hasilKodeSql.getInt("id_member");
            String nama = hasilKodeSql.getString("nama");
            String alamat = hasilKodeSql.getString("alamat");
            String jenis_kelamin = hasilKodeSql.getString("jenis_kelamin");
            Date tanggal_lahir = hasilKodeSql.getDate("tanggal_lahir");
            String no_telp = hasilKodeSql.getString("no_telp");
            int nik = hasilKodeSql.getInt("nik");
            String email = hasilKodeSql.getString("email");
            String password = hasilKodeSql.getString("password");

            Member member = new Member();
            member.setId_Member(id_member);
            member.setNama(nama);
            member.setAlamat(alamat);
            member.setJenis_Kelamin(jenis_kelamin);
            member.setTanggal_Lahir(tanggal_lahir);
            member.setNo_Telp(no_telp);
            member.setNIK(nik);
            member.setEmail(email);
            member.setPassword(password);
            Object[] temp = new Object[9];
            temp[0] = member.getId_Member();
            temp[1] = member.getNama();
            temp[2] = member.getAlamat();
            temp[3] = member.getJenis_Kelamin();
            temp[4] = member.getTanggal_Lahir();
            temp[5] = member.getNo_Telp();
            temp[6] = member.getNIK();
            temp[7] = member.getEmail();
            temp[8] = member.getPassword();
            dtmMember.addRow(temp);
        }
        return dtmMember;
    }

    public ArrayList<Member> getDataMember() throws SQLException {
        this.arrMember.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM MEMBER_07015");
        while (rs.next()) {
            Member member = new Member();
            member.setId_Member(rs.getInt("ID_MEMBER"));
            member.setNama(rs.getString("NAMA"));
            member.setAlamat(rs.getString("ALAMAT"));
            member.setJenis_Kelamin(rs.getString("JENIS_KELAMIN"));
            member.setTanggal_Lahir(rs.getDate("TANGGAL_LAHIR"));
            member.setNo_Telp(rs.getString("NO_TELP"));
            member.setNIK(rs.getInt("NIK"));
            member.setEmail(rs.getString("EMAIL"));
            member.setPassword(rs.getString("PASSWORD"));

            this.arrMember.add(member);
        }
        return this.arrMember;
    }

    public int cariIdMember(String password) throws SQLException {
        String kodeSql = "SELECT id_member FROM Member_07015 WHERE Password LIKE '" + password + "'";
        ResultSet rs = this.koneksi.GetData(kodeSql);
        rs.next();
        return rs.getInt("id_member");
    }

    public Member cariDataMember(int id_member) throws SQLException {
        Member member = null;
        String kodeSql = "SELECT * FROM Member_07015 WHERE id_member = " + id_member;
        ResultSet rs = this.koneksi.GetData(kodeSql);
        if (rs.next()) {
            String nama = rs.getString("NAMA");
            String alamat = rs.getString("ALAMAT");
            String jenis_kelamin = rs.getString("JENIS_KELAMIN");
            Date tanggal_lahir = rs.getDate("TANGGAL_LAHIR");
            String no_telp = rs.getString("NO_TELP");
            int nik = rs.getInt("NIK");
            String email = rs.getString("Email");
            String password = rs.getString("Password");
            member = new Member();
            member.setId_Member(id_member);
            member.setNama(nama);
            member.setAlamat(alamat);
            member.setJenis_Kelamin(jenis_kelamin);
            member.setTanggal_Lahir(tanggal_lahir);
            member.setNo_Telp(no_telp);
            member.setNIK(nik);
            member.setEmail(email);
            member.setPassword(password);
            
        }
        return member;
    }

}
