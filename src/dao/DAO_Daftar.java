/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import PreApp.Daftar;
import PreApp.Masuk;
import config.Koneksi;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Model_Pengguna;
import service.Service_Daftar;

/**
 *
 * @author aridw
 */
public class DAO_Daftar implements Service_Daftar{
    private Connection conn;
    
    public DAO_Daftar(){
        conn = Koneksi.getConnection();
    }
    
    public void addData(Model_Pengguna mdPengguna) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pengguna(id_pengguna, nama_pengguna, password, username, telp_pengguna, alamat_pengguna, jabatan, foto, status) VALUES(?,?,?,?,?,?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdPengguna.getId_pengguna());
            st.setString(2, mdPengguna.getNama_pengguna());
            st.setString(3, mdPengguna.getPassword());
            st.setString(4, mdPengguna.getUsername());
            st.setString(5, mdPengguna.getTelp_pengguna());
            st.setString(6, mdPengguna.getAlamat_pengguna());
            st.setString(7, mdPengguna.getJabatan());
            st.setString(8, mdPengguna.getFoto());
            st.setString(9, mdPengguna.getStatus());
            
            st.executeUpdate();
            Masuk masuk = new Masuk();
            masuk.setVisible(true);
            masuk.revalidate();

            JOptionPane.showMessageDialog(null, "Daftar berhasil");
            Daftar daftar = new Daftar();
            daftar.tutup = true;
        }catch(SQLException e){
            Logger.getLogger(DAO_Daftar.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Daftar.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public String nomor(String jabatan) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String id = null;
        String name_id = getNameId(jabatan);
        
        String sql = "SELECT RIGHT(id_pengguna, 5) AS no_id FROM pengguna WHERE id_pengguna LIKE ? ORDER BY no_id DESC LIMIT 1";
        try{
            st =conn.prepareStatement(sql);
            st.setString(1, "%"+name_id+"%");
            rs = st.executeQuery();
            if(rs.next()){
                int noId = Integer.parseInt(rs.getString("no_id"));
                noId++;
                id = name_id + String.format("%05d", noId);
            }else if(jabatan == "Super Admin"){
                id = "SUP00001";
            }else if(jabatan == "Owner"){
                id = "OWN00001";
            }else if(jabatan == "Staff"){
                id = "STF00001";
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_Daftar.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Daftar.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return id;
    }
    
    private String getNameId(String jabatan){
       switch (jabatan) {
            case "Super Admin":
                return "SUP";
            case "Owner":
                return "OWN";
            case "Staff":
                return "STF";
            default:
                break;
        }
        return "";
    }
    
    @Override
    public String JChooser() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        String fotoPath = null;

        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String folderPath = "src/fotoPengguna/"; 
            
            String fileName = selectedFile.getName();
            if (fileName != null && !fileName.isEmpty()) {
                File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
                File destinationFile = new File(folder, fileName);
                fotoPath = destinationFile.getAbsolutePath();

                try {
                    Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("File berhasil disimpan di: " + destinationFile.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Nama file tidak valid.");
            }
        }
        return fotoPath;
    
    }
}
