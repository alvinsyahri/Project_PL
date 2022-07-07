
package transaksi;

import Form.konfig;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class kasir extends javax.swing.JPanel {

    int id_transaksi, pembeli = 0;
    public DefaultTableModel model = new DefaultTableModel();
    
    public void tanggal() {
        Date now = new Date();
        tgl_transaksi.setDate(now);

    }
    
    public kasir() {
        initComponents();
        pembeli();
        tanggal();
        tampilkan_data();
        Date date = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyy");
        ttlhrg.setText("");
        bayar.setText("");
        kembalian.setText("");
        
    }

    private void tampilkan_data() {

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("id_Transaksi");
        model.addColumn("Id Barang");
        model.addColumn("Nama Minuman");
        model.addColumn("Harga Minuman");
        model.addColumn("Jumlah Pesanan");
        model.addColumn("Total Pesanan");

        try {
            String ds = "yyyy-MM-dd";
            SimpleDateFormat dst = new SimpleDateFormat(ds);
            Calendar kalender = Calendar.getInstance();
            String tgl = dst.format(kalender.getTime());
            String sql = "SELECT t.*, b.nama_barang, b.harga_barang FROM transaksi t LEFT JOIN barang b ON t.barang = b.id_barang where t.tanggal = '" + tgl + "' and pembeli = " + pembeli + "";
            java.sql.Connection conn = (Connection) konfig.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                model.addRow(new Object[]{res.getInt(1), res.getInt(2), res.getString(8), res.getInt(9), res.getInt(5), res.getInt(6)});
            }
            tbpsnn.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }

    public void pembeli() {
        try {
            java.sql.Connection conn = (Connection) konfig.configDB();
            String sql = "SELECT MAX(pembeli) as i FROM transaksi";
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                pembeli = Integer.parseInt(res.getString("i"));
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void cari() {
        try {
            String Nama = null;
            int Harga = 0;
            java.sql.Connection conn = (Connection) konfig.configDB();
            String sql = "SELECT nama_barang, harga_barang FROM barang where id_barang like '" + idbrg.getText() + "'";
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                Nama = res.getString("nama_barang");
                Harga = res.getInt("harga_barang");
            }
            nmbrg.setText(Nama);
            hrgbrg.setText(String.valueOf(Harga));
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public int harga() {
        int harga = 0;
        try {
            java.sql.Connection conn = (Connection) konfig.configDB();
            String sql = "SELECT harga_barang FROM barang where id_barang like '" + idbrg.getText() + "'";
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            if (res.next()) {
                harga = Integer.parseInt(res.getString("harga_barang"));
            }
        } catch (Exception e) {

        }
        return harga;
    }

    public void totalbayar() {
        int jumlahBaris = tbpsnn.getRowCount();
        int totalBiaya = 0;
        int jumlahbarang, hargabarang;
        for (int i = 0; i < jumlahBaris; i++) {
            jumlahbarang = Integer.parseInt(tbpsnn.getValueAt(i, 3).toString());
            hargabarang = Integer.parseInt(tbpsnn.getValueAt(i, 4).toString());
            totalBiaya = totalBiaya + (jumlahbarang * hargabarang);
        }
        ttlhrg.setText(String.valueOf(totalBiaya));
        tampil.setText("Rp. " + totalBiaya + ",00");
    }

    public int jumlah(){
        int stok = 0;
            try{
                String sql = "SELECT stok FROM barang where id_barang = '"+idbrg.getText()+"' ";
                java.sql.Connection conn = (Connection)konfig.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                if(res.next()){
                   stok = res.getInt("stok");
                }
            }catch(HeadlessException | SQLException e){
                System.out.println(e);
            }
        return stok;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tgl_transaksi = new com.toedter.calendar.JDateChooser();
        txtcari = new javax.swing.JButton();
        idbrg = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        idkrywn = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        nmbrg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hrgbrg = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jmlhbrg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpsnn = new javax.swing.JTable();
        btntmbh = new javax.swing.JButton();
        btnhps = new javax.swing.JButton();
        btnsmpn = new javax.swing.JButton();
        tampil = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ttlhrg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        strkbyr = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1000, 617));

        jPanel1.setBackground(new java.awt.Color(135, 51, 24));
        jPanel1.setPreferredSize(new java.awt.Dimension(1300, 786));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(135, 51, 24));
        jPanel2.setPreferredSize(new java.awt.Dimension(581, 64));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TRANSAKSI PEMBAYARAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(337, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(98, 98, 98))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 837, 69));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Tanggal");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, -1, -1));

        tgl_transaksi.setEnabled(false);
        jPanel1.add(tgl_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 200, 30));

        txtcari.setBackground(new java.awt.Color(255, 204, 204));
        txtcari.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtcari.setText("Cari");
        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });
        jPanel1.add(txtcari, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 145, -1));
        jPanel1.add(idbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 480, 35));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("ID Kasir");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, -1));
        jPanel1.add(idkrywn, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 200, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("Nama Minuman");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, -1));

        nmbrg.setEnabled(false);
        jPanel1.add(nmbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 200, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("Harga Minuman");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, -1, -1));

        hrgbrg.setEnabled(false);
        jPanel1.add(hrgbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 200, 200, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("Jumlah Pesanan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, -1, -1));

        jmlhbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmlhbrgActionPerformed(evt);
            }
        });
        jPanel1.add(jmlhbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 200, -1));

        tbpsnn.setModel(new javax.swing.table.DefaultTableModel(
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
        tbpsnn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpsnnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbpsnn);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 270, 640, 130));

        btntmbh.setBackground(new java.awt.Color(255, 204, 204));
        btntmbh.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btntmbh.setText("Tambah");
        btntmbh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntmbhActionPerformed(evt);
            }
        });
        jPanel1.add(btntmbh, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 115, 40));

        btnhps.setBackground(new java.awt.Color(255, 204, 204));
        btnhps.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnhps.setText("Hapus");
        btnhps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhpsActionPerformed(evt);
            }
        });
        jPanel1.add(btnhps, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 350, 115, 40));

        btnsmpn.setBackground(new java.awt.Color(255, 204, 204));
        btnsmpn.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btnsmpn.setText("Simpan");
        btnsmpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsmpnActionPerformed(evt);
            }
        });
        jPanel1.add(btnsmpn, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 510, 115, 40));

        tampil.setBackground(new java.awt.Color(255, 204, 204));
        tampil.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        tampil.setText("Rp. 0");
        tampil.setEnabled(false);
        tampil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampilActionPerformed(evt);
            }
        });
        jPanel1.add(tampil, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 260, 50));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setText("Total Pesanan");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 420, -1, -1));

        ttlhrg.setEnabled(false);
        jPanel1.add(ttlhrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 450, 241, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setText("Uang Yang Di Bayarkan");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 500, -1, -1));

        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });
        jPanel1.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 530, 241, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setText("Kembalian");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 580, -1, -1));
        jPanel1.add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 600, 241, 40));

        strkbyr.setBackground(new java.awt.Color(255, 204, 204));
        strkbyr.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        strkbyr.setText("STRUK");
        strkbyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strkbyrActionPerformed(evt);
            }
        });
        jPanel1.add(strkbyr, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 115, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txtcariActionPerformed

    private void jmlhbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmlhbrgActionPerformed
        // TODO add your handling code here:
        //        TambahTransaksi();
    }//GEN-LAST:event_jmlhbrgActionPerformed

    private void tbpsnnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpsnnMouseClicked
        // TODO add your handling code here:
        int baris = tbpsnn.rowAtPoint(evt.getPoint());
        String Id = tbpsnn.getValueAt(baris, 0).toString();
        id_transaksi = Integer.parseInt(Id);

        String ID = tbpsnn.getValueAt(baris, 1).toString();
        idbrg.setText(ID);

        String Nmbrg = tbpsnn.getValueAt(baris, 2).toString();
        nmbrg.setText(Nmbrg);
        
        String Jmlbrg = tbpsnn.getValueAt(baris, 4).toString();
        jmlhbrg.setText(Jmlbrg);
    }//GEN-LAST:event_tbpsnnMouseClicked

    private void btntmbhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntmbhActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        try {
            String ds = "yyyy-MM-dd";
            SimpleDateFormat dst = new SimpleDateFormat(ds);
            Calendar kalender = Calendar.getInstance();
            String tgl = dst.format(kalender.getTime());
            int harga = harga() * Integer.parseInt(jmlhbrg.getText());
            String sql = "INSERT INTO transaksi (barang,karyawan,tanggal,jumlah,total,pembeli) VALUES (" + idbrg.getText() + "," + idkrywn.getText() + ",'" + tgl + "'," + jmlhbrg.getText() + "," + harga + "," + pembeli + ")";
            java.sql.Connection conn = (Connection) konfig.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            int jumlah = Integer.parseInt(jmlhbrg.getText());
            String sql1 = "UPDATE barang SET stok = "+(jumlah()-jumlah)+" WHERE id_barang = '"+idbrg.getText()+"' ";
            java.sql.PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.execute();
            JOptionPane.showMessageDialog(null, "Proses Simpan Data Berhasil..");
            tampilkan_data();
            //            kosong();
        } catch (HeadlessException | SQLException e) {
            System.out.println(e);
        }
        totalbayar();
    }//GEN-LAST:event_btntmbhActionPerformed

    private void btnhpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhpsActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbpsnn.getModel();
        int row = tbpsnn.getSelectedRow();
        model.removeRow(row);
        totalbayar();
        bayar.setText("");
        kembalian.setText("");
        try {
            java.sql.Connection conn = (Connection) konfig.configDB();
            int jumlah = Integer.parseInt(jmlhbrg.getText());
            String sql1 = "UPDATE barang SET stok = "+(jumlah()+jumlah)+" WHERE id_barang = '"+idbrg.getText()+"' ";
            java.sql.PreparedStatement pstm1 = conn.prepareStatement(sql1);
            pstm1.execute();
            String sql = "DELETE FROM transaksi WHERE id_transaksi='" + id_transaksi + "'";
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Hapus Data Berhasil...");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this, "Data Gagal Dihapus");
        }
        tampilkan_data();
        //        kosong();
    }//GEN-LAST:event_btnhpsActionPerformed

    private void btnsmpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsmpnActionPerformed
        pembeli = pembeli + 1;
        tampilkan_data();
    }//GEN-LAST:event_btnsmpnActionPerformed

    private void tampilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampilActionPerformed
        // TODO add your handling code here:
        //        TambahTransaksi();
    }//GEN-LAST:event_tampilActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
        int total, byr, kmbln;
        total = Integer.valueOf(ttlhrg.getText());
        byr = Integer.valueOf(bayar.getText());

        if (total > byr) {
            JOptionPane.showMessageDialog(null, "Uang Tidak Cukup Melakukan Pembayaran");
        } else if (byr == total) {
            kembalian.setText("0");
            JOptionPane.showMessageDialog(null, "Uang Yang DiBayarkan Pass");
        } else {
            kmbln = byr - total;
            kembalian.setText(String.valueOf(kmbln));
        }
    }//GEN-LAST:event_bayarActionPerformed

    private void strkbyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strkbyrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strkbyrActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.JButton btnhps;
    private javax.swing.JButton btnsmpn;
    private javax.swing.JButton btntmbh;
    private javax.swing.JTextField hrgbrg;
    private javax.swing.JTextField idbrg;
    private javax.swing.JTextField idkrywn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jmlhbrg;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField nmbrg;
    private javax.swing.JButton strkbyr;
    private javax.swing.JTextField tampil;
    private javax.swing.JTable tbpsnn;
    private com.toedter.calendar.JDateChooser tgl_transaksi;
    private javax.swing.JTextField ttlhrg;
    private javax.swing.JButton txtcari;
    // End of variables declaration//GEN-END:variables
}
