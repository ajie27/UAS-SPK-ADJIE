/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Acer
 */
public class inputModel {
    public void inputAlternatif (String id_alt, String nama_alternatif ){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "INSERT INTO alternatif VALUES (?,?)";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, id_alt);
            prestat.setString(2, nama_alternatif);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
}
public void inputKriteria (String id_krit, String nama, String bobot, String kepentingan){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "INSERT INTO kriteria VALUES (?,?,?,?)";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, id_krit);
            prestat.setString(2, nama);
            prestat.setString(3, bobot);
            prestat.setString(4, kepentingan);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
public void inputHitung (){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query1 = "TRUNCATE TABLE jumlah_b";
            //String query2 = "SELECT SUM(bobot) FROM kriteria";
            String query = "INSERT INTO jumlah_b(id_krit,nilai) SELECT id_krit, SUM(bobot) FROM kriteria";
            String query2 = "TRUNCATE TABLE norm_bobot";
            String query3 = "INSERT INTO norm_bobot( id_krit, bobot_norm) SELECT kriteria.id_krit, kriteria.bobot/jumlah_b.nilai FROM kriteria INNER JOIN jumlah_b";
            String query4 = "TRUNCATE TABLE kepentingan";
            String query5 = "INSERT INTO kepentingan"
                    + "(id_krit,id_norm,hasil)SELECT kriteria.id_krit, norm_bobot.id_norm,kriteria.kepentingan*norm_bobot.bobot_norm "
                    + "FROM kriteria INNER JOIN norm_bobot ON kriteria.id_krit = norm_bobot.id_krit";
            PreparedStatement prestat1 = koneksi.prepareStatement(query1);
            PreparedStatement prestat = koneksi.prepareStatement(query);
            PreparedStatement prestat2 = koneksi.prepareStatement(query2);
            PreparedStatement prestat3 = koneksi.prepareStatement(query3);
            PreparedStatement prestat4 = koneksi.prepareStatement(query4);
            PreparedStatement prestat5 = koneksi.prepareStatement(query5);
            //prestat.setString(1, id_alternatif);
            //prestat.setString(2, hasil);
            prestat1.executeUpdate();
            prestat.executeUpdate();
            prestat2.executeUpdate();
            prestat3.executeUpdate();
            prestat4.executeUpdate();
            prestat5.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
}
public void inputNilai (String id_nilai, String id_alt, String id_krit,  String nilai){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query = "INSERT INTO nilai VALUES(?,?,?,?)";
            PreparedStatement prestat = koneksi.prepareStatement(query);
            prestat.setString(1, null);
            prestat.setString(2, id_alt);
            prestat.setString(3, id_krit);
            prestat.setString(4, nilai);
            prestat.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "DATA TIDAK DISIMPAN","ERROR",JOptionPane.ERROR_MESSAGE);
        }
    }
public void inputPangkat (){
        try{
               Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query1 = "TRUNCATE TABLE transaksi";
            String query5 = "INSERT INTO transaksi (id_alt, id_krit, nilai_alt) SELECT nilai.id_alt, kepentingan.id_krit, POW (nilai.nilai,kepentingan.hasil) FROM kepentingan INNER JOIN nilai ON kepentingan.id_krit = nilai.id_krit";
            String query2 = "INSERT INTO pangkat(id_trans, id_alt, pangkat) SELECT transaksi.id_trans, transaksi.id_alt, sum(nilai_alt)from transaksi";
            PreparedStatement prestat5 = koneksi.prepareStatement(query5);
            PreparedStatement prestat1 = koneksi.prepareStatement(query1);
            PreparedStatement prestat2 = koneksi.prepareStatement(query2);
            //prestat.setString(1, id_alternatif);
            //prestat.setString(2, hasil);
            prestat1.executeUpdate();
            prestat5.executeUpdate();
            prestat2.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
}
public void inputVektorS(){
    try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query1 = "TRUNCATE TABLE hitung_s";
            String query5 = "INSERT INTO hitung_s (id_trans, id_alt, nilai_s) SELECT transaksi.id_trans, transaksi.id_alt, SUM(nilai_alt) FROM transaksi GROUP BY id_alt";
            PreparedStatement prestat5 = koneksi.prepareStatement(query5);
            PreparedStatement prestat1 = koneksi.prepareStatement(query1);
            //PreparedStatement prestat2 = koneksi.prepareStatement(query2);
            //prestat.setString(1, id_alternatif);
            //prestat.setString(2, hasil);
            prestat1.executeUpdate();
            prestat5.executeUpdate();
            //prestat2.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
}
public void inputVektorV(){
     try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query1 = "TRUNCATE TABLE jumlah_b";
            //String query2 = "SELECT SUM(bobot) FROM kriteria";
            String query = "INSERT INTO jumlah_v(id_s,hasil) SELECT id_s, SUM(nilai_s) FROM hitung_s";
            String query2 = "TRUNCATE TABLE hitung_v";
            String query3 = "INSERT INTO hitung_v( id_s, hasil) SELECT (hitung_s.id_s), (hitung_s.nilai_s/jumlah_v.hasil) FROM hitung_s INNER JOIN jumlah_v GROUP by id_s";
            String query4 = "TRUNCATE TABLE hasil";
            String query5 = "INSERT INTO hasil(nama_alaternatif, hasil) SELECT (alternatif.nama_alternatif), (hitung_v.hasil) FROM alternatif INNER JOIN hitung_v WHERE alternatif.id_alt = hitung_v.id_s ORDER by hitung_v.hasil DESC";
            PreparedStatement prestat1 = koneksi.prepareStatement(query1);
            PreparedStatement prestat = koneksi.prepareStatement(query);
            PreparedStatement prestat2 = koneksi.prepareStatement(query2);
            PreparedStatement prestat3 = koneksi.prepareStatement(query3);
            PreparedStatement prestat4 = koneksi.prepareStatement(query4);
            PreparedStatement prestat5 = koneksi.prepareStatement(query5);
            prestat1.executeUpdate();
            prestat.executeUpdate();
            prestat2.executeUpdate();
            prestat3.executeUpdate();
            prestat4.executeUpdate();
            prestat5.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
}
public void inputHasilnilai(){
    try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost/db_wp","root","");
            String query1 = "TRUNCATE TABLE lihatnilai";
            String query5 = "INSERT INTO lihatnilai (nama_alternatif, nama, nilai) SELECT alternatif.nama_alternatif,  kriteria.nama, nilai.nilai FROM nilai INNER JOIN alternatif INNER JOIN kriteria WHERE alternatif.id_alt = nilai.id_alt AND kriteria.id_krit = nilai.id_krit";
            PreparedStatement prestat5 = koneksi.prepareStatement(query5);
            PreparedStatement prestat1 = koneksi.prepareStatement(query1);
            //PreparedStatement prestat2 = koneksi.prepareStatement(query2);
            //prestat.setString(1, id_alternatif);
            //prestat.setString(2, hasil);
            prestat1.executeUpdate();
            prestat5.executeUpdate();
            //prestat2.executeUpdate();
            koneksi.close();
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "QUERRY ERROR"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
}

    void inputAlternati(Object object, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}