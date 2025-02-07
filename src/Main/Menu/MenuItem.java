/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main.Menu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;

/**
 *
 * @author aridw
 */
public class MenuItem extends javax.swing.JPanel {

    private final ArrayList<MenuItem> subMenu = new ArrayList<>();
    private ActionListener act;
    
    public MenuItem(Icon icon, boolean isSubMenu, Icon subIcon, String menuName, ActionListener act, MenuItem... subMenu) {
        initComponents();
        
        lbIcon.setIcon(icon);
        lbSubIcon.setIcon(subIcon);
        lbSubIcon.setVisible(isSubMenu);
        lbMenuName.setText(menuName);
        
        if (act != null){
            this.act = act;
        }
        
        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
        for(int i = 0; i < subMenu.length; i++){
            this.subMenu.add(subMenu[i]);
            subMenu[i].setVisible(false);
        }
    }
    
    public ArrayList<MenuItem> getSubMenu() {
        return subMenu;
    }
    
    private void hideMenu(){
        new Thread(new Runnable() {
            public void run(){
                for(int i = subMenu.size() - 1; i>= 0; i--){
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }
    
    private void showMenu(){
        new Thread(new Runnable() {
            public void run(){
                for(int i = 0; i < subMenu.size(); i++){
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                getParent().repaint();
                getParent().revalidate();
                showing = true;
            }
        }).start();
    }
    
    private void sleep(){
        try{
            Thread.sleep(25);
        }catch(Exception e){
            
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

        lbMenuName = new javax.swing.JLabel();
        lbSubIcon = new javax.swing.JLabel();
        lbIcon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(3, 57, 84));
        setForeground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(230, 50));
        setPreferredSize(new java.awt.Dimension(230, 50));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        lbMenuName.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbMenuName.setForeground(new java.awt.Color(255, 255, 255));
        lbMenuName.setText("MenuItem");
        lbMenuName.setPreferredSize(new java.awt.Dimension(110, 24));

        lbSubIcon.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbSubIcon.setPreferredSize(new java.awt.Dimension(24, 24));

        lbIcon.setFont(new java.awt.Font("Inter", 0, 12)); // NOI18N
        lbIcon.setPreferredSize(new java.awt.Dimension(24, 24));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbSubIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbMenuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbMenuName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSubIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(showing){
            hideMenu();
        }else{
            showMenu();
        }
        if(act != null){
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        this.setBackground(new Color(17,79,109));
        lbMenuName.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        this.setBackground(new Color(3,57,84));
        lbMenuName.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_formMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbIcon;
    private javax.swing.JLabel lbMenuName;
    private javax.swing.JLabel lbSubIcon;
    // End of variables declaration//GEN-END:variables

    
}
