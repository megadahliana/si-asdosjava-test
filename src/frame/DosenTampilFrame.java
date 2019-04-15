
package frame;

import model.Dosen;
import db.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class DosenTampilFrame extends javax.swing.JFrame {

    Dosen dosen;
    public DosenTampilFrame() {
        initComponents();
        setLocationRelativeTo(null);
        resetTable("");
        setTitle("Arsip Data Dosen");
    }

   public ArrayList<Dosen> getDosenList(String keyword){
        ArrayList<Dosen> dosenList;
                  dosenList = new  ArrayList<>();
        Koneksi koneksi ;
                  koneksi= new Koneksi();
        Connection connection =(Connection) koneksi.getConnection();
        
        String query = "SELECT * FROM dosen " +keyword;
        Statement st;
        ResultSet rs;
       
        
        
        try {
            st = (Statement) connection.createStatement();
            rs =  st.executeQuery(query);
            while (rs.next()){
                dosen = new Dosen(
                    rs.getInt("nip"),
                    rs.getString("nama_dosen"),
                    rs.getString("almt_dmsli"),
                    rs.getString("no_hp"),
                    rs.getString("mata_kuliah"));
                    
                dosenList.add(dosen);
            }
        } catch (SQLException | NullPointerException ex) {
            System.err.println("Koneksi Null Gagal");
        }
        return dosenList;  
    }
   public void selectDosen (String keyword){
        ArrayList<Dosen> list = getDosenList(keyword);
        DefaultTableModel model = (DefaultTableModel)tDosen.getModel();
        Object[] row = new  Object[5];
        
            for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getNip();
            row[1] = list.get(i).getNamadosen();
            row[2] = list.get(i).getAlamat();
            row[3] = list.get(i).getNohp();
            row[4] = list.get(i).getMatakuliah();
            
            model.addRow(row);
        }
    }
   public  final void resetTable(String keyword){
        DefaultTableModel model = (DefaultTableModel)tDosen.getModel();
        model.setRowCount(0);
        selectDosen(keyword);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        eCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bTutup = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tDosen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Cari petugas");

        bCari.setText("Cari");
        bCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCariActionPerformed(evt);
            }
        });

        bTambah.setText("Tambah");
        bTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTambahActionPerformed(evt);
            }
        });

        bUbah.setText("Ubah");
        bUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUbahActionPerformed(evt);
            }
        });

        bHapus.setText("Hapus");
        bHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHapusActionPerformed(evt);
            }
        });

        bBatal.setText("Batal");
        bBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBatalActionPerformed(evt);
            }
        });

        bTutup.setText("Tutup");
        bTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTutupActionPerformed(evt);
            }
        });

        tDosen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nip", "Nama Dosen", "Alamat Domisili", "No Hp", "Mata Kuliah"
            }
        ));
        scrollPane.setViewportView(tDosen);
        if (tDosen.getColumnModel().getColumnCount() > 0) {
            tDosen.getColumnModel().getColumn(0).setMaxWidth(70);
            tDosen.getColumnModel().getColumn(1).setMaxWidth(100);
            tDosen.getColumnModel().getColumn(2).setMaxWidth(150);
            tDosen.getColumnModel().getColumn(3).setMaxWidth(80);
            tDosen.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(eCari)
                        .addGap(18, 18, 18)
                        .addComponent(bCari))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bTambah)
                                .addGap(34, 34, 34)
                                .addComponent(bUbah)
                                .addGap(18, 18, 18)
                                .addComponent(bHapus)
                                .addGap(18, 18, 18)
                                .addComponent(bBatal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bTutup))
                            .addComponent(scrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari))
                .addGap(35, 35, 35)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bUbah)
                    .addComponent(bHapus)
                    .addComponent(bBatal)
                    .addComponent(bTutup))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        resetTable("");
    }//GEN-LAST:event_bBatalActionPerformed

    private void bTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTutupActionPerformed
       dispose();
    }//GEN-LAST:event_bTutupActionPerformed

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        resetTable(" WHERE nama_dosen like '% "+eCari.getText()+"%'OR"
         + " nama_dosen like '%"+eCari.getText()+"%'");
    }//GEN-LAST:event_bCariActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
        int i = tDosen.getSelectedRow();
        int pilihan = JOptionPane.showConfirmDialog(null, 
                "Yakin ingin Menghapus   ?",
                "Konfirmasi Hapus ",
                JOptionPane.YES_NO_OPTION);
        if (pilihan==0){
            if(i>=0){
                try {
                    TableModel model =tDosen.getModel();
                    Koneksi koneksi = new Koneksi();
                    Connection con = koneksi.getConnection();
                    String executeQuery = "delete from dosen where nip =?";
                    PreparedStatement ps = con.prepareStatement(executeQuery);
                    ps.setString (1, model.getValueAt(i, 0).toString());
                    ps.executeUpdate();                
                    
                }
                catch (SQLException ex){
                      System.err.println(ex);
                      
            }
        }
            else {
                JOptionPane.showMessageDialog(null, "PILIH DATA YANG INGIN DIHAPUS");
            }
        }
        resetTable("");
    }//GEN-LAST:event_bHapusActionPerformed

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
       DosenTambahFrame dosenTambahFrame = new DosenTambahFrame();
       dosenTambahFrame.setVisible(true);
    }//GEN-LAST:event_bTambahActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
       int i = tDosen.getSelectedRow();
        if (i>=0){
            TableModel model =tDosen.getModel();
            dosen = new Dosen();
            dosen.setNip(Integer.parseInt(model.getValueAt(i, 0).toString()));
            dosen.setNamadosen(model.getValueAt(i, 1).toString());
            dosen.setAlamat(model.getValueAt(i, 2).toString());
            dosen.setNohp(model.getValueAt(i, 3).toString());
            dosen.setMatakuliah(model.getValueAt(i, 4).toString());
            DosenTambahFrame dosenTambahFrame = new DosenTambahFrame(dosen);
            dosenTambahFrame.setVisible(true);           
        }
        else{
            JOptionPane.showMessageDialog(null, "pilih Data yang ingin di Update");
        } 
    
    }//GEN-LAST:event_bUbahActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        resetTable("");
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(DosenTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DosenTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DosenTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DosenTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DosenTampilFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bTutup;
    private javax.swing.JButton bUbah;
    private javax.swing.JTextField eCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tDosen;
    // End of variables declaration//GEN-END:variables
}
