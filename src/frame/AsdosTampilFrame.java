/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import db.Koneksi;
import java.awt.Graphics2D;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Asdos;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Statement;
import java.util.Vector;
import javax.imageio.ImageIO;
import model.Dosen;
import model.KeyValue;

/**
 *
 * @author my computer
 */
public class AsdosTampilFrame extends javax.swing.JFrame {
    Asdos asdos;
    BufferedImage bImage;
    Statement st;
    ResultSet rs;
    Blob Fotonya;
    private final int IMG_WIDTH =183;
    private final int IMG_HEIGHT =224;
    /**
     * Creates new form AsdosTampilFrame
     */
    public AsdosTampilFrame() {
        initComponents();
        setSize(1000,600);
        setLocationRelativeTo(null);
        jRadioButton1.doClick();
        resetTable("");
        setTitle("Arsip Anggota Asisten Dosen");
    }
    public ArrayList<Asdos> getAsdosList(String keyword){
     ArrayList<Asdos> asdosList = new ArrayList<Asdos>();
     Koneksi koneksi = new Koneksi();
     Connection connection = koneksi.getConnection();
     PreparedStatement ps;
     ResultSet rs;
     String query = "SELECT asdos.*, dosen.* FROM asdos "
                   + "INNER JOIN dosen ON asdos.nip_dosen = dosen.nip";
     String order = " ORDER BY asdos.id";
     if (!keyword.equals("")){
        query = query+ " WHERE asdos.id = ? OR nama like ?";
     query = query+order;
     }
     if (jRadioButton2.isSelected()){
         query=query+" WHERE jenis_kelamin like '%Laki-Laki%'";
     }
     if (jRadioButton3.isSelected()){
         query=query+" WHERE jenis_kelamin like '%Perempuan%'";
     }
     try {
         ps = connection.prepareStatement(query);
         if(!keyword.equals("")){
             ps.setString(1, eCari.getText());
             ps.setString(2, "%"+eCari.getText()+"%");
         }
         rs = ps.executeQuery();
         while(rs.next()){
             asdos = new Asdos(
                     rs.getString("asdos.id"),
                     rs.getString("nama"),
                     rs.getString("jenis_kelamin"),
                     rs.getString("tgl_lahir"),
                     rs.getString("no_hp"),
                     rs.getString("tupoksi"),
                     rs.getInt("nip_dosen"),
                     rs.getString("dosen.nama_dosen"),
                     rs.getBlob("foto_asdos"));
             asdosList.add(asdos);
         }
     }catch (SQLException ex){
         System.err.println("ERROR getAsdosList : "+ex);
     }
     return asdosList;
 }
    public void selectAsdos(String keyword){
    ArrayList<Asdos> list = getAsdosList(keyword);
    DefaultTableModel model = (DefaultTableModel)tAsdos.getModel();
    Object[] row = new Object[9];
    
     for (int i = 0; i < list.size(); i++) {
        row[0] = list.get(i).getId();
        row[1] = list.get(i).getNama();
        row[2] = list.get(i).getJenisKelamin();
        row[3] = list.get(i).getTanggalLahir();
        row[4] = list.get(i).getNoHp();
        row[5] = list.get(i).getTupoksi();
        row[6] = list.get(i).getDosen().getNip();
        row[7] = list.get(i).getDosen().getNamadosen();
        row[8] = list.get(i).getFotoAsdos();
        
       model.addRow(row);
     }  
 }
    public  final void resetTable(String keyword){
        DefaultTableModel model = (DefaultTableModel)tAsdos.getModel();
        model.setRowCount(0);
        selectAsdos(keyword);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        eCari = new javax.swing.JTextField();
        bCari = new javax.swing.JButton();
        bTambah = new javax.swing.JButton();
        bUbah = new javax.swing.JButton();
        bHapus = new javax.swing.JButton();
        bBatal = new javax.swing.JButton();
        bTutup = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tAsdos = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbGambar = new javax.swing.JLabel();
        lbaja = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Cari Asdos");

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

        tAsdos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama Lengkap", "Jenis Kelamin", "Tanggal Lahir", "No Hp", "Tugas Pokok Asdos", "Dosen", "nama dosen", "Foto Asdos"
            }
        ));
        tAsdos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tAsdosMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(tAsdos);
        if (tAsdos.getColumnModel().getColumnCount() > 0) {
            tAsdos.getColumnModel().getColumn(0).setMaxWidth(80);
            tAsdos.getColumnModel().getColumn(1).setMaxWidth(250);
            tAsdos.getColumnModel().getColumn(2).setMaxWidth(250);
            tAsdos.getColumnModel().getColumn(3).setMaxWidth(250);
            tAsdos.getColumnModel().getColumn(4).setMaxWidth(100);
            tAsdos.getColumnModel().getColumn(5).setMaxWidth(350);
            tAsdos.getColumnModel().getColumn(6).setMaxWidth(250);
            tAsdos.getColumnModel().getColumn(8).setMinWidth(0);
            tAsdos.getColumnModel().getColumn(8).setMaxWidth(0);
        }

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Umum");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Laki - Laki");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Perempuan");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Urutkan Menurut");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbGambar)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        lbaja.setText("Foto Diri");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addGap(39, 39, 39)
                                        .addComponent(jRadioButton2)
                                        .addGap(27, 27, 27)
                                        .addComponent(jRadioButton3))
                                    .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bTambah)
                                .addGap(59, 59, 59)
                                .addComponent(bUbah)
                                .addGap(18, 18, 18)
                                .addComponent(bHapus)
                                .addGap(51, 51, 51)
                                .addComponent(bBatal)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bTutup)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(bCari))))
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(39, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbaja)
                        .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(eCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lbaja)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTambah)
                    .addComponent(bUbah)
                    .addComponent(bHapus)
                    .addComponent(bBatal)
                    .addComponent(bTutup))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCariActionPerformed
        resetTable(eCari.getText());
    }//GEN-LAST:event_bCariActionPerformed

    private void bTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTutupActionPerformed
       dispose();
    }//GEN-LAST:event_bTutupActionPerformed

    private void bBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBatalActionPerformed
        eCari.setText("");
        jRadioButton1.doClick();
    }//GEN-LAST:event_bBatalActionPerformed

    private void bHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHapusActionPerformed
            int i = tAsdos.getSelectedRow();
    int pilihan = JOptionPane.showConfirmDialog(null, 
                "Yakin ingin Menghapus   ?",
                "Konfirmasi Hapus ",
                JOptionPane.YES_NO_OPTION);
        if (pilihan==0){
            if(i>=0){
                try {
                    TableModel model =tAsdos.getModel();
                    Koneksi koneksi = new Koneksi();
                    Connection con = koneksi.getConnection();
                    String executeQuery = "delete from asdos where id =?";
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

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        bCari.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void tAsdosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tAsdosMouseClicked
        // TODO add your handling code here:
        int i = tAsdos.getSelectedRow();
        if(i>=0){
            TableModel model = tAsdos.getModel();
            asdos = new Asdos();
            asdos.setId(model.getValueAt(i, 0).toString());
            asdos.setNama(model.getValueAt(i, 1).toString());
            asdos.setJenisKelamin(model.getValueAt(i, 2).toString());
            asdos.setTanggalLahir(model.getValueAt(i, 3).toString());
            asdos.setNoHp(model.getValueAt(i, 4).toString());
            asdos.setTupoksi(model.getValueAt(i, 5).toString());
            asdos.setDosen(new Dosen
                    (Integer.parseInt(model.getValueAt(i, 6).toString()),
                     model.getValueAt(i, 7).toString()));
            Blob blob = (Blob) model.getValueAt(i, 8);
            asdos.setFotoAsdos(blob);
            bImage = getBufferedImage(asdos.getFotoAsdos());
            lbaja.setIcon(new ImageIcon(bImage));
        }
    }//GEN-LAST:event_tAsdosMouseClicked

    private void bTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTambahActionPerformed
        AsdosTambahFrame asdosTambahFrame = new AsdosTambahFrame();
        asdosTambahFrame.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_bTambahActionPerformed

    private void bUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUbahActionPerformed
    int i = tAsdos.getSelectedRow();
        if(i>=0){
            AsdosTambahFrame asdosTambahFrame = new  AsdosTambahFrame(asdos);
            asdosTambahFrame.setVisible(true);
            dispose();
        }else{
            JOptionPane.showMessageDialog(null, "Pilih data yang ingin diubah");
      
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bUbahActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        resetTable("");
// TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        bCari.doClick();
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed
    public Vector getCbData (String qry,String key, String value){
      Vector v = new Vector();
      try {
          Koneksi koneksi = new Koneksi();
          Connection con = koneksi.getConnection();
          st = con.createStatement();
          rs = st.executeQuery(qry);
          while(rs.next()){
              v.addElement(new KeyValue(rs.getInt(key),
                                        rs.getString(value)));    
          }
      } catch (SQLException ex){
          System.err.println("Error getData() :"+ex);
      }
      return v;
    }
    
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
            java.util.logging.Logger.getLogger(AsdosTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AsdosTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AsdosTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AsdosTampilFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AsdosTampilFrame().setVisible(true);
            }
        });
    }
    public BufferedImage getBufferedImage(Blob imageBlob) {
         InputStream binaryStream = null;
         BufferedImage b = null;
         try { 
             binaryStream = imageBlob.getBinaryStream();
             b = ImageIO.read(binaryStream);
         } catch (SQLException | IOException ex) {
             System.err.println("Error getBufferedImage : "+ex);
         }
         return b;      
    }
    private BufferedImage resizeImage(BufferedImage originalImage, int type){
         BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
         Graphics2D g = resizedImage.createGraphics();
         g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
         g.dispose();
         return resizedImage;
         }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBatal;
    private javax.swing.JButton bCari;
    private javax.swing.JButton bHapus;
    private javax.swing.JButton bTambah;
    private javax.swing.JButton bTutup;
    private javax.swing.JButton bUbah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField eCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JLabel lbGambar;
    private javax.swing.JLabel lbaja;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tAsdos;
    // End of variables declaration//GEN-END:variables

   
    
}
