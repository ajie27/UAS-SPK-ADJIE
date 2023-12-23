/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Jamal
 */
public class updateModel {
    public void updateAlternatif(String id_alt, String nama_alternatif){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "UPDATE alternatif SET nama_alternatif=? WHERE id_alt=?";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, nama_alternatif);
            prestat.setString(2, id_alt);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateKriteria(String id_krit, String nama, String bobot){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "UPDATE kriteria SET nama=?,bobot=? WHERE id_krit=?";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, nama);
            prestat.setString(2, bobot);
            prestat.setString(3, id_krit);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updatenilai(String id_nilai, String id_alt, String id_krit, String nilai){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "UPDATE nilai SET id_alt=?,id_krit=?, nilai=? WHERE id_nilai=?";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, id_alt);
            prestat.setString(2, id_krit);
            prestat.setString(3, nilai);
            prestat.setString(4, id_nilai);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }

    void updateAlternatif(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
