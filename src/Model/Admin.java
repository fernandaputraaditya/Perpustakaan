package Model;

public class Admin {

    private Integer Id_Admin;
    private String Nama;
    private String Alamat;
    private String Jenis_Kelamin;
    private String Password;

    public Integer getId_Admin() {
        return Id_Admin;
    }

    public void setId_Admin(Integer Id_Admin) {
        this.Id_Admin = Id_Admin;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
