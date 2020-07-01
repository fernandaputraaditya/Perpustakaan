package Model;

import java.util.ArrayList;
import java.util.Date;

public class Peminjaman {

    private Integer Id_Peminjaman;
    private Admin admin;
    private Member member;
    private Buku buku;
    private Date Tanggal_Pinjam;
    private ArrayList<Detail_Peminjaman> arrDetail_Peminjaman;

    public Integer getId_Peminjaman() {
        return Id_Peminjaman;
    }

    public void setId_Peminjaman(Integer Id_Peminjaman) {
        this.Id_Peminjaman = Id_Peminjaman;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Date getTanggal_Pinjam() {
        return Tanggal_Pinjam;
    }

    public void setTanggal_Pinjam(Date Tanggal_Pinjam) {
        this.Tanggal_Pinjam = Tanggal_Pinjam;
    }

    public ArrayList<Detail_Peminjaman> getArrDetail_Peminjaman() {
        return arrDetail_Peminjaman;
    }

    public void setArrDetail_Peminjaman(ArrayList<Detail_Peminjaman> arrDetail_Peminjaman) {
        this.arrDetail_Peminjaman = arrDetail_Peminjaman;
    }

}
