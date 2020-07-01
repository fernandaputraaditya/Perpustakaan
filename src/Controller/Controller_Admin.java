package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Admin;
import database.Koneksi;

public class Controller_Admin {

    private final Koneksi koneksi;
    ArrayList<Admin> arrAdmin;

    public Controller_Admin() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrAdmin = new ArrayList<>();
    }

    public ArrayList<Admin> getDataAdmin() throws SQLException {
        this.arrAdmin.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM ADMIN_07015 ORDER BY ID_ADMIN ASC");
        while (rs.next()) {
            Admin admin = new Admin();
            admin.setId_Admin(rs.getInt("ID_ADMIN"));
            admin.setNama(rs.getString("NAMA"));
            admin.setAlamat(rs.getString("ALAMAT"));
            admin.setJenis_Kelamin(rs.getString("JENIS_KELAMIN"));
            admin.setPassword(rs.getString("PASSWORD"));

            this.arrAdmin.add(admin);
        }
        return this.arrAdmin;
    }

    public int cariIdAdmin(String password) throws SQLException {
        String kodeSql = "SELECT id_admin FROM admin_07015 WHERE Password LIKE '" + password + "'";
        ResultSet rs = this.koneksi.GetData(kodeSql);
        rs.next();
        return rs.getInt("id_admin");
    }
    
    public Admin cariDataAdmin(int id_admin) throws SQLException {
        Admin admin = null;
        String kodeSql = "SELECT * FROM Admin_07015 WHERE id_admin = " + id_admin;
        ResultSet rs = this.koneksi.GetData(kodeSql);
        if (rs.next()) {
            String nama = rs.getString("NAMA");
            String alamat = rs.getString("ALAMAT");
            String jenis_kelamin = rs.getString("JENIS_KELAMIN");
            String password = rs.getString("PASSWORD");
            admin = new Admin();
            admin.setId_Admin(id_admin);
            admin.setNama(nama);
            admin.setAlamat(alamat);
            admin.setJenis_Kelamin(jenis_kelamin);
            admin.setPassword(password);
        }
        return admin;
    }
}
