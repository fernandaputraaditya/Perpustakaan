package Model;

public class Buku {

    private Integer Id_Buku;
    private String Judul_Buku;
    private Integer Tahun_Terbit;
    private String Pengarang;

    public Integer getId_Buku() {
        return Id_Buku;
    }

    public void setId_Buku(Integer Id_Buku) {
        this.Id_Buku = Id_Buku;
    }

    public String getJudul_Buku() {
        return Judul_Buku;
    }

    public void setJudul_Buku(String Judul_Buku) {
        this.Judul_Buku = Judul_Buku;
    }

    public Integer getTahun_Terbit() {
        return Tahun_Terbit;
    }

    public void setTahun_Terbit(Integer Tahun_Terbit) {
        this.Tahun_Terbit = Tahun_Terbit;
    }

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

}
