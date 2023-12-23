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
public class deleteModel {
    public void hapusAlternatif(String id_alt){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "DELETE FROM alternatif WHERE id_alt=?";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, id_alt);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void hapusKriteria(String id_krit){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "DELETE FROM kriteria WHERE id_krit=?";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, id_krit);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void hapusnilai(String id_krit){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "DELETE FROM nilai WHERE id_nilai=?";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, id_krit);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
