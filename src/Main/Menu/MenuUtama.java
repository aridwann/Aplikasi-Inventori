/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Menu;

import PreApp.Daftar;
import Main.Tentang.Tentang;
import Main.Kontak.Kontak;
import Main.Dasbor.Dasbor;
import Main.Laporan.LaporanBarang;
import Main.Laporan.LaporanBarangKeluar;
import Main.Laporan.LaporanBarangMasuk;
import Main.Laporan.LaporanKeuangan;
import Main.Laporan.LaporanPemesanan;
import Main.Master.MasterBarang;
import Main.Master.MasterPengguna;
import Main.Master.MasterDistributor;
import Main.Master.MasterJenisBarang;
import Main.Transaksi.TransaksiBarangKeluar;
import Main.Transaksi.TransaksiBarangMasuk;
import Main.Transaksi.TransaksiPemesananBarang;
import dao.DAO_Masuk;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import service.Service_Login;


/**
 *
 * @author aridw
 */
public class MenuUtama extends javax.swing.JFrame {

    private Service_Login service = new DAO_Masuk();
    String id, nama, jabatan, pathFoto;
    JFrame main = this;
    /**
     * Creates new form MenuUtama
     */
    public MenuUtama() {
        initComponents();
        
        this.setExtendedState(MAXIMIZED_BOTH);
        execute();
    }
     
    public MenuUtama(String id, String nama, String jabatan, String pathFoto) {
        initComponents();
        this.id = id;
        this.nama = nama;
        this.jabatan = jabatan;
        this.pathFoto = pathFoto;
        
        try {
            BufferedImage bi = ImageIO.read(new File(pathFoto));
            Image img = bi.getScaledInstance(70, 90, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblFoto.setText("");
            lblFoto.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(Daftar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lblNama.setText(nama);
        lblJabatan.setText(jabatan);
        this.setExtendedState(MAXIMIZED_BOTH);
        execute();
    }

    private void addMenu(MenuItem... subMenu){
        for (int i = 0; i < subMenu.length; i++){
            pnMenuBar.add(subMenu[i]);
            ArrayList<MenuItem> menu = subMenu[i].getSubMenu();
            for(MenuItem m : menu){
                addMenu(m);
            }
        }
        pnMenuBar.revalidate();
    }
    
    private void execute(){
        ImageIcon iconDasbor = new ImageIcon(getClass().getResource("/img/icon/dasbor.png"));
        MenuItem menuDasbor = new MenuItem(iconDasbor, false, null, "Dasbor", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new Dasbor(id));
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
      
        
        ImageIcon iconMJBarang = new ImageIcon(getClass().getResource("/img/icon/jenisBarang.png"));     
        MenuItem menuMJBarang = new MenuItem(null, true, iconMJBarang, "Jenis Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new MasterJenisBarang());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        ImageIcon iconMBarang = new ImageIcon(getClass().getResource("/img/icon/barang.png"));
        MenuItem menuMBarang = new MenuItem(null, true, iconMBarang, "Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new MasterBarang());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        ImageIcon iconMDistributor = new ImageIcon(getClass().getResource("/img/icon/distributor.png"));
        MenuItem menuMDistributor = new MenuItem(null, true, iconMDistributor, "Distributor", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new MasterDistributor());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        ImageIcon iconMPengguna = new ImageIcon(getClass().getResource("/img/icon/pengguna.png"));
        MenuItem menuMPengguna = new MenuItem(null, true, iconMPengguna, "Pengguna", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new MasterPengguna());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        
        ImageIcon iconMaster = new ImageIcon(getClass().getResource("/img/icon/master.png"));
        
        ImageIcon iconPemesanan = new ImageIcon(getClass().getResource("/img/icon/pemesananBarang.png"));     
        MenuItem menuPemesanan = new MenuItem(null, true, iconPemesanan, "Pemesanan Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new TransaksiPemesananBarang(id));
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        ImageIcon iconBarangMasuk = new ImageIcon(getClass().getResource("/img/icon/barangMasuk.png"));
        MenuItem menuBarangMasuk = new MenuItem(null, true, iconBarangMasuk, "Barang Masuk",  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new TransaksiBarangMasuk(id));
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        ImageIcon iconBarangKeluar = new ImageIcon(getClass().getResource("/img/icon/barangKeluar.png"));
        MenuItem menuBarangKeluar = new MenuItem(null, true, iconBarangKeluar, "Barang Keluar",  new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new TransaksiBarangKeluar(id));
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        
        ImageIcon iconTransaksi = new ImageIcon(getClass().getResource("/img/icon/transaksi.png"));
        MenuItem menuTransaksi = new MenuItem(iconTransaksi, false, null, "Transaksi", null, menuPemesanan, menuBarangMasuk, menuBarangKeluar);
        
        ImageIcon iconLaporan = new ImageIcon(getClass().getResource("/img/icon/laporan.png"));
        MenuItem menuLStokBarang = new MenuItem(null, true, iconLaporan, "Stok Barang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new LaporanBarang());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        MenuItem menuLPemesanan = new MenuItem(null, true, iconLaporan, "Pemesanan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new LaporanPemesanan());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        MenuItem menuLBarangMasuk = new MenuItem(null, true, iconLaporan, "Barang Masuk", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new LaporanBarangMasuk());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        MenuItem menuLBarangKeluar = new MenuItem(null, true, iconLaporan, "Barang Keluar", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new LaporanBarangKeluar());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        MenuItem menuLKeuangan = new MenuItem(null, true, iconLaporan, "Keuangan", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new LaporanKeuangan());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        
        MenuItem menuLaporan = new MenuItem(iconLaporan, false, null, "Laporan", null, menuLStokBarang, menuLPemesanan, menuLBarangMasuk, menuLBarangKeluar, menuLKeuangan);
        
        ImageIcon iconKontak = new ImageIcon(getClass().getResource("/img/icon/kontak.png"));
        MenuItem menuKontak = new MenuItem(iconKontak, false, null, "Kontak", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new Kontak());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        ImageIcon iconTentang = new ImageIcon(getClass().getResource("/img/icon/tentang.png"));
        MenuItem menuTentang = new MenuItem(iconTentang, false, null, "Tentang", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pnKontenUtama.removeAll();
                pnKontenUtama.add(new Tentang());
                pnKontenUtama.repaint();
                pnKontenUtama.revalidate();
            }
        });
        
        if(jabatan.equals("Super Admin")){
            MenuItem menuMaster = new MenuItem(iconMaster, false, null, "Master", null, menuMJBarang, menuMBarang, menuMDistributor, menuMPengguna);
            addMenu(menuDasbor, menuMaster, menuTransaksi, menuLaporan, menuKontak, menuTentang);
        }else if(jabatan.equals("Owner")){
            MenuItem menuMaster = new MenuItem(iconMaster, false, null, "Master", null, menuMJBarang, menuMBarang, menuMDistributor);
            addMenu(menuDasbor, menuMaster, menuLaporan, menuKontak, menuTentang);
        }else if(jabatan.equals("Staff")){
            addMenu(menuDasbor, menuTransaksi, menuLaporan, menuKontak, menuTentang);
        }else{
            MenuItem menuMaster = new MenuItem(iconMaster, false, null, "Master", null, menuMJBarang, menuMBarang, menuMDistributor, menuMPengguna);
            addMenu(menuDasbor, menuMaster, menuTransaksi, menuLaporan, menuKontak, menuTentang);
        }
    }
    
    public void changePanel(javax.swing.JPanel newPanel) {
        pnKontenUtama.removeAll();
        pnKontenUtama.add(newPanel);
        pnKontenUtama.revalidate();
        pnKontenUtama.repaint();
    }
    
    public void showMenuAkun() {
        new PopUp.MenuAkun(main, rootPaneCheckingEnabled, pnKontenUtama, id, nama, jabatan, pathFoto).setVisible(true);
    }
    
    public void showPilihVideo() {
        new PopUp.PilihVideo(main, rootPaneCheckingEnabled, pnKontenUtama).setVisible(true);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnSidebar = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnMenuBar = new javax.swing.JPanel();
        pnAkun = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblJabatan = new javax.swing.JLabel();
        pnKontenUtama = new javax.swing.JPanel();
        pnNavbar1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnSidebar.setBackground(new java.awt.Color(3, 57, 84));
        pnSidebar.setPreferredSize(new java.awt.Dimension(250, 620));
        pnSidebar.setLayout(new java.awt.BorderLayout());

        jScrollPane1.setBackground(new java.awt.Color(3, 57, 84));
        jScrollPane1.setBorder(null);
        jScrollPane1.setToolTipText("");

        pnMenuBar.setBackground(new java.awt.Color(3, 57, 84));
        pnMenuBar.setMaximumSize(new java.awt.Dimension(250, 1000));
        pnMenuBar.setPreferredSize(new java.awt.Dimension(250, 600));
        pnMenuBar.setRequestFocusEnabled(false);
        pnMenuBar.setLayout(new javax.swing.BoxLayout(pnMenuBar, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(pnMenuBar);

        pnSidebar.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnAkun.setBackground(new java.awt.Color(3, 57, 84));
        pnAkun.setPreferredSize(new java.awt.Dimension(250, 150));
        pnAkun.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFoto.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        lblFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblFoto.setPreferredSize(new java.awt.Dimension(70, 90));
        lblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFotoMouseClicked(evt);
            }
        });
        pnAkun.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        lblNama.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(255, 255, 255));
        lblNama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNama.setText("Nama");
        lblNama.setPreferredSize(new java.awt.Dimension(60, 60));
        pnAkun.add(lblNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, 22));

        lblJabatan.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lblJabatan.setForeground(new java.awt.Color(255, 255, 255));
        lblJabatan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblJabatan.setText("Jabatan");
        lblJabatan.setPreferredSize(new java.awt.Dimension(60, 60));
        pnAkun.add(lblJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 250, 16));

        pnSidebar.add(pnAkun, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(pnSidebar, java.awt.BorderLayout.LINE_START);

        pnKontenUtama.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnKontenUtama, java.awt.BorderLayout.CENTER);

        pnNavbar1.setBackground(new java.awt.Color(6, 37, 53));
        pnNavbar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 40, 1, 40));
        pnNavbar1.setPreferredSize(new java.awt.Dimension(1280, 70));
        pnNavbar1.setLayout(new java.awt.BorderLayout());

        jLabel13.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Mufti Aquarian Official");
        jLabel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        pnNavbar1.add(jLabel13, java.awt.BorderLayout.CENTER);

        jLabel14.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo/logo40.png"))); // NOI18N
        pnNavbar1.add(jLabel14, java.awt.BorderLayout.WEST);

        jLabel15.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icon/bantuan.png"))); // NOI18N
        jLabel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel15.setInheritsPopupMenu(false);
        jLabel15.setMaximumSize(new java.awt.Dimension(24, 40));
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
        });
        pnNavbar1.add(jLabel15, java.awt.BorderLayout.EAST);

        getContentPane().add(pnNavbar1, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(1298, 767));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        pnKontenUtama.removeAll();
        pnKontenUtama.add(new Dasbor(id));
        pnKontenUtama.repaint();
        pnKontenUtama.revalidate();
    }//GEN-LAST:event_formWindowOpened

    private void lblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFotoMouseClicked
        showMenuAkun();
    }//GEN-LAST:event_lblFotoMouseClicked

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        showPilihVideo();
    }//GEN-LAST:event_jLabel15MouseClicked

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
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblNama;
    private javax.swing.JPanel pnAkun;
    private javax.swing.JPanel pnKontenUtama;
    private javax.swing.JPanel pnMenuBar;
    private javax.swing.JPanel pnNavbar1;
    private javax.swing.JPanel pnSidebar;
    // End of variables declaration//GEN-END:variables
}
