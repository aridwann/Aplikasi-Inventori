/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Tentang;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author aridw
 */
public class Tentang extends javax.swing.JPanel {

    /**
     * Creates new form MasterBarang
     */
    public Tentang() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        namaUsaha14 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namaUsaha15 = new javax.swing.JLabel();
        namaUsaha16 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblYt = new javax.swing.JLabel();
        lblWhatsapp = new javax.swing.JLabel();
        lblInsta = new javax.swing.JLabel();
        lblBlog = new javax.swing.JLabel();
        lblFb = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(17, 79, 109));

        jLabel1.setFont(new java.awt.Font("Inter", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tentang");

        jPanel1.setBackground(new java.awt.Color(17, 79, 109));

        namaUsaha14.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        namaUsaha14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaUsaha14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo/LogoMufti100.jpg"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Aridwan Ega Sulanjana Firman Gifari");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        namaUsaha15.setBackground(new java.awt.Color(0, 0, 0));
        namaUsaha15.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        namaUsaha15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaUsaha15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/foto.jpg"))); // NOI18N
        namaUsaha15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        namaUsaha15.setPreferredSize(new java.awt.Dimension(502, 282));

        namaUsaha16.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        namaUsaha16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        namaUsaha16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo/LOGO KAMPUS WHITE BG.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(17, 79, 109));

        lblYt.setFont(new java.awt.Font("Inter", 2, 14)); // NOI18N
        lblYt.setForeground(new java.awt.Color(0, 255, 255));
        lblYt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblYt.setText("Youtube");
        lblYt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblYtMouseClicked(evt);
            }
        });

        lblWhatsapp.setFont(new java.awt.Font("Inter", 2, 14)); // NOI18N
        lblWhatsapp.setForeground(new java.awt.Color(0, 255, 255));
        lblWhatsapp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblWhatsapp.setText("Whatsapp");
        lblWhatsapp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWhatsappMouseClicked(evt);
            }
        });

        lblInsta.setFont(new java.awt.Font("Inter", 2, 14)); // NOI18N
        lblInsta.setForeground(new java.awt.Color(0, 255, 255));
        lblInsta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsta.setText("Instagram");
        lblInsta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblInstaMouseClicked(evt);
            }
        });

        lblBlog.setFont(new java.awt.Font("Inter", 2, 14)); // NOI18N
        lblBlog.setForeground(new java.awt.Color(0, 255, 255));
        lblBlog.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBlog.setText("Blog");
        lblBlog.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBlogMouseClicked(evt);
            }
        });

        lblFb.setFont(new java.awt.Font("Inter", 2, 14)); // NOI18N
        lblFb.setForeground(new java.awt.Color(0, 255, 255));
        lblFb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFb.setText("Facebook");
        lblFb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFbMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Hubungi melalui media sosial di bawah ini!");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(lblBlog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(408, 408, 408))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(583, 583, 583)
                        .addComponent(lblFb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(lblInsta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(276, 276, 276))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(455, 455, 455)
                        .addComponent(lblYt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(128, 128, 128))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblWhatsapp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(582, 582, 582)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblWhatsapp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBlog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblYt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblInsta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        jLabel14.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Danny Aidil Rismayadi, S.SI., M.Kom.");

        jLabel12.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("yang diampu oleh ");

        jLabel13.setFont(new java.awt.Font("Inter", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Aplikasi ini dibangun untuk memenuhi tugas UAS ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(14, 14, 14)
                                            .addComponent(namaUsaha16)
                                            .addGap(10, 10, 10)
                                            .addComponent(namaUsaha14))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(namaUsaha15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(namaUsaha15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namaUsaha16)
                            .addComponent(namaUsaha14))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addGap(11, 11, 11)
                        .addComponent(jLabel14)))
                .addGap(20, 20, 20)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblWhatsappMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWhatsappMouseClicked
        createLinkWA();
    }//GEN-LAST:event_lblWhatsappMouseClicked

    private void lblInstaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblInstaMouseClicked
        createLinkIG();
    }//GEN-LAST:event_lblInstaMouseClicked

    private void lblFbMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFbMouseClicked
        createLinkFB();
    }//GEN-LAST:event_lblFbMouseClicked

    private void lblYtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblYtMouseClicked
        createLinkYT();
    }//GEN-LAST:event_lblYtMouseClicked

    private void lblBlogMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBlogMouseClicked
        createLinkBlog();
    }//GEN-LAST:event_lblBlogMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBlog;
    private javax.swing.JLabel lblFb;
    private javax.swing.JLabel lblInsta;
    private javax.swing.JLabel lblWhatsapp;
    private javax.swing.JLabel lblYt;
    private javax.swing.JLabel namaUsaha14;
    private javax.swing.JLabel namaUsaha15;
    private javax.swing.JLabel namaUsaha16;
    // End of variables declaration//GEN-END:variables

    private void createLinkWA(){
        try {
            Desktop.getDesktop().browse(new URI("http://wa.me/+6285872988649"));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
    
    private void createLinkIG(){
        try {
            Desktop.getDesktop().browse(new URI("https://www.instagram.com/aridwaannn/"));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
    
    private void createLinkFB(){
        try {
            Desktop.getDesktop().browse(new URI(""));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
    
    private void createLinkBlog(){
        try {
            Desktop.getDesktop().browse(new URI(""));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
    
    private void createLinkYT(){
        try {
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/@aridwan1828/videos"));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
}
