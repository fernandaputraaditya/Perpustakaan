package Controller;

import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Model.Buku;
import java.util.ArrayList;

public class Controller_Buku implements InterfaceViewTabel {

    private final Koneksi koneksi;
    ArrayList<Buku> arrBuku;

    public Controller_Buku() {
        this.koneksi = new Koneksi();
        this.arrBuku = new ArrayList<>();
    }

    public void insert(int id_buku, String judul_buku, String pengarang, int tahun_terbit) {
        String kodeSql = "INSERT INTO Buku_07015 (id_buku, judul_buku, pengarang, tahun_terbit) VALUES ("
                + id_buku + ", '" + judul_buku + "', '" + pengarang + "', '" + tahun_terbit + "')";
        this.koneksi.ManipulasiData(kodeSql);
    }

    public void delete(int id_buku) {
        String kodeSql = "DELETE FROM Buku_07015 WHERE id_buku = " + id_buku;
        this.koneksi.ManipulasiData(kodeSql);
    }

    public void update(int id_buku, String judul_buku, String pengarang, int tahun_terbit) {
        String kodeSql = "UPDATE Buku_07015 SET " + "judul_buku = '" + judul_buku + "', "
                + "pengarang = '" + pengarang + "', " + "tahun_terbit = '" + tahun_terbit + "'"
                + "WHERE id_buku = " + id_buku;
        this.koneksi.ManipulasiData(kodeSql);
    }

    public void clear() {
        String kodeSql = "DELETE FROM Buku_07015";
        this.koneksi.ManipulasiData(kodeSql);
    }

    public DefaultTableModel viewTabel() throws SQLException {
        DefaultTableModel dtmBuku = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        dtmBuku.addColumn("ID Buku");
        dtmBuku.addColumn("Judul Buku");
        dtmBuku.addColumn("Pengarang");
        dtmBuku.addColumn("Tahun Terbit");

        String kodeSql = "SELECT * FROM Buku_07015 ORDER BY Id_Buku ASC";
        ResultSet hasilKodeSql = this.koneksi.GetData(kodeSql);
        while (hasilKodeSql.next()) {
            int id_buku = hasilKodeSql.getInt("id_buku");
            String judul_buku = hasilKodeSql.getString("judul_buku");
            String pengarang = hasilKodeSql.getString("pengarang");
            int tahun_terbit = hasilKodeSql.getInt("tahun_terbit");

            Buku buku = new Buku();
            buku.setId_Buku(id_buku);
            buku.setJudul_Buku(judul_buku);
            buku.setPengarang(pengarang);
            buku.setTahun_Terbit(tahun_terbit);
            Object[] temp = new Object[4];
            temp[0] = buku.getId_Buku();
            temp[1] = buku.getJudul_Buku();
            temp[2] = buku.getPengarang();
            temp[3] = buku.getTahun_Terbit();
            dtmBuku.addRow(temp);
        }
        return dtmBuku;
    }
    
        public ArrayList<Buku> getDataBuku() throws SQLException {
        this.arrBuku.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM BUKU_07015 ORDER BY ID_BUKU ASC");
        while (rs.next()) {
            Buku buku = new Buku();
            buku.setId_Buku(rs.getInt("ID_BUKU"));
            buku.setJudul_Buku(rs.getString("JUDUL_BUKU"));
            buku.setPengarang(rs.getString("PENGARANG"));
            buku.setTahun_Terbit(rs.getInt("TAHUN_TERBIT"));

            this.arrBuku.add(buku);
        }
        return this.arrBuku;
    }

}
