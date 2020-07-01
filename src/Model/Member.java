package Model;

import java.util.Date;

public class Member {

    private Integer Id_Member;
    private String Nama;
    private String Alamat;
    private String Jenis_Kelamin;
    private Date Tanggal_Lahir;
    private String No_Telp;
    private Integer NIK;
    private String Email;
    private String Password;

    public Integer getId_Member() {
        return Id_Member;
    }

    public void setId_Member(Integer Id_Member) {
        this.Id_Member = Id_Member;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getJenis_Kelamin() {
        return Jenis_Kelamin;
    }

    public void setJenis_Kelamin(String Jenis_Kelamin) {
        this.Jenis_Kelamin = Jenis_Kelamin;
    }

    public Date getTanggal_Lahir() {
        return Tanggal_Lahir;
    }

    public void setTanggal_Lahir(Date Tanggal_Lahir) {
        this.Tanggal_Lahir = Tanggal_Lahir;
    }

    public String getNo_Telp() {
        return No_Telp;
    }

    public void setNo_Telp(String No_Telp) {
        this.No_Telp = No_Telp;
    }

    public Integer getNIK() {
        return NIK;
    }

    public void setNIK(Integer NIK) {
        this.NIK = NIK;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }


}
