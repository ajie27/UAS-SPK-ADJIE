
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class inputnilai extends javax.swing.JFrame {
    private koneksi db = new koneksi();
    inputModel imt = new inputModel();
    updateModel umt = new updateModel();
    deleteModel dmt = new deleteModel();

    /**
     * Creates new form inputnilai
     */
    public inputnilai() {
        initComponents();
        comboAlternatif();
        comboKriteria();
        this.setLocationRelativeTo(null);
        this.clearData();
        txtAlt.setEnabled(false);
        txtkrit.setEnabled(false);
        txtidnilai.setEnabled(false);
        btnubah.setEnabled(false);
        btnhapus.setEnabled(false);
    }
    final void clearData(){
        //cmbKr.setSelectedIndex(0);
        cmbAlter.setSelectedIndex(0);
        combokrit.setSelectedIndex(0);
        txtnilai.setText("");
        txtAlt.setText("");
        txtkrit.setText("");
        datatable();
    }
    public void comboAlternatif(){
        db.koneksiDatabase();
        try {
            String query = "SELECT * FROM alternatif";
            java.sql.Statement st = db.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
             
            while (rs.next()) {                
                cmbAlter.addItem(rs.getString("nama_alternatif"));
            }
             
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
             
        } catch (SQLException e) {
        }
    }
    public void tampil_Alternatif(){
        txtAlt.setVisible(true);
        try{
            db.koneksiDatabase();
            String query = "SELECT id_alt FROM alternatif WHERE nama_alternatif='"+cmbAlter.getSelectedItem()+"'";
            java.sql.Statement st = db.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString(1);
                
                txtAlt.setText((String) ob[0]);
            }
            
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        } catch (SQLException e){
        }
    }
    public void comboKriteria(){
        db.koneksiDatabase();
        try {
            String query = "SELECT * FROM kriteria";
            java.sql.Statement st = db.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
             
            while (rs.next()) {                
                combokrit.addItem(rs.getString("nama"));
            }
             
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
             
        } catch (SQLException e) {
        }
    }
    public void tampil_kriteria(){
        txtkrit.setVisible(true);
        try{
            db.koneksiDatabase();
            String query = "SELECT id_krit FROM kriteria WHERE nama='"+combokrit.getSelectedItem()+"'";
            java.sql.Statement st = db.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Object[] ob = new Object[1];
                ob[0] = rs.getString(1);
                
                txtkrit.setText((String) ob[0]);
            }
            
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        } catch (SQLException e){
        }
    }
    
    public void opsisimpan(){
        try{
            db.koneksiDatabase();
            String query = "SELECT * FROM nilai WHERE id_krit='"+txtkrit.getText()+"' AND id_alt='"+txtAlt.getText()+"'";
            java.sql.Statement st = db.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                Object[] ob = new Object[2];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                
                JOptionPane.showMessageDialog(null, "DATA SUDAH ADA", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
                
            }
            
            rs.last();
            int jumlahdata = rs.getRow();
            rs.first();
        } catch (SQLException e){
        }
    }
    public void datatable(){
        
        DefaultTableModel tbl=new DefaultTableModel();
        tbl.addColumn("ID Nilai");
        tbl.addColumn("ID Alternatif");
        tbl.addColumn("ID Kriteria");
        tbl.addColumn("Nilai");
        tabel.setModel(tbl);
        try{
            db.koneksiDatabase();
            String query = "SELECT * FROM nilai";
            java.sql.Statement st = db.getKoneksi().createStatement();
            ResultSet rs= st.executeQuery(query);
            while(rs.next())
            {
                tbl.addRow(new Object[] {
                    rs.getString("id_nilai"),
                    rs.getString("id_alt"),
                    rs.getString("id_krit"),
                    rs.getString("nilai")
                });
                tabel.setModel(tbl);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane,"Belum terkoneksi ke Database");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbAlter = new javax.swing.JComboBox<>();
        combokrit = new javax.swing.JComboBox<>();
        txtnilai = new javax.swing.JTextField();
        btnsimpan = new javax.swing.JButton();
        txtAlt = new javax.swing.JTextField();
        txtkrit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnubah = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        btnhapus = new javax.swing.JButton();
        txtidnilai = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Pokemon", 1, 18)); // NOI18N
        jLabel1.setText("INPUT NILAI ALTERNATIF");

        jLabel3.setText("ALTERNATIF");

        jLabel4.setText("KRITERIA");

        jLabel5.setText("NILAI");

        cmbAlter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH ALTERNATIF--" }));
        cmbAlter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlterActionPerformed(evt);
            }
        });

        combokrit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--PILIH KRITERIA--" }));
        combokrit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combokritActionPerformed(evt);
            }
        });

        btnsimpan.setText("SIMPAN");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        txtAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAltActionPerformed(evt);
            }
        });

        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnubah.setText("UBAH");
        btnubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnubahActionPerformed(evt);
            }
        });

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        btnhapus.setText("HAPUS");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });

        txtidnilai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidnilaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidnilai, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(btnsimpan))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                        .addComponent(btnubah, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(btnhapus, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(txtnilai))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbAlter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(combokrit, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtkrit, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                            .addComponent(txtAlt))
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbAlter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAlt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(combokrit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtkrit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtnilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsimpan)
                    .addComponent(jButton1)
                    .addComponent(btnubah)
                    .addComponent(btnhapus))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(txtidnilai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbAlterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlterActionPerformed
        // TODO add your handling code here:
        tampil_Alternatif();
    }//GEN-LAST:event_cmbAlterActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
        opsisimpan();
        int tanya = JOptionPane.showConfirmDialog(null, "ANDA YAKIN DATA INI INGIN DISIMPAN?", "INFORMASI", JOptionPane.CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (tanya == JOptionPane.OK_OPTION) {
            imt.inputNilai(null, txtAlt.getText(),
                txtkrit.getText(),txtnilai.getText());
            JOptionPane.showMessageDialog(null, "DATA TELAH DISIMPAN", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            this.clearData();
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void txtAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAltActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtAltActionPerformed

    private void combokritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combokritActionPerformed
        // TODO add your handling code here:
        tampil_kriteria();
    }//GEN-LAST:event_combokritActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new utama().show();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnubahActionPerformed
        // TODO add your handling code here:
        int tanya = JOptionPane.showConfirmDialog(null, "ANDA YAKIN DATA INI INGIN DIUBAH?","INFORMASI",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (tanya == JOptionPane.OK_OPTION){
            umt.updatenilai(txtidnilai.getText(), txtAlt.getText(), txtkrit.getText(),txtnilai.getText()
              );
            JOptionPane.showMessageDialog(null, "DATA TELAH DIUBAH", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            this.clearData();
            datatable();
        }
    }//GEN-LAST:event_btnubahActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        cmbAlter.setEnabled(false);
        combokrit.setEnabled(false);
        btnhapus.setEnabled(true);
        btnubah.setEnabled(true);
        btnsimpan.setEnabled(false);
        int i = tabel.getSelectedRow();
        TableModel model = tabel.getModel();
        txtAlt.setText(model.getValueAt(i,1).toString());
        txtkrit.setText(model.getValueAt(i,2).toString());
        txtnilai.setText(model.getValueAt(i,3).toString());
        txtidnilai.setText(model.getValueAt(i,0).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
        int tanya = JOptionPane.showConfirmDialog(null, "ANDA YAKIN DATA INI INGIN DIHAPUS?","INFORMASI",JOptionPane.CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (tanya == JOptionPane.OK_OPTION){
            dmt.hapusAlternatif(txtidnilai.getText());
            JOptionPane.showMessageDialog(null, "DATA TELAH DIHAPUS", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            this.clearData();
            datatable();
        }
    }//GEN-LAST:event_btnhapusActionPerformed

    private void txtidnilaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidnilaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidnilaiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(inputnilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inputnilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inputnilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inputnilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new inputnilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnubah;
    private javax.swing.JComboBox<String> cmbAlter;
    private javax.swing.JComboBox<String> combokrit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField txtAlt;
    private javax.swing.JTextField txtidnilai;
    private javax.swing.JTextField txtkrit;
    private javax.swing.JTextField txtnilai;
    // End of variables declaration//GEN-END:variables
}
