/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Koneksi;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Model_Pengguna;
import model.Model_Pengguna;
import service.Service_UbahAkun;

/**
 *
 * @author aridw
 */
public class DAO_UbahAkun implements Service_UbahAkun {
    private Connection conn;
    
    public DAO_UbahAkun(){
        conn = Koneksi.getConnection();
    }

    @Override
    public void updateData(Model_Pengguna mdPengguna) {
        PreparedStatement st = null;
        String sql = "UPDATE pengguna SET nama_pengguna=?, alamat_pengguna=?, telp_pengguna=?, username=?, password=?, foto=? WHERE id_pengguna=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdPengguna.getNama_pengguna());
            st.setString(2, mdPengguna.getAlamat_pengguna());
            st.setString(3, mdPengguna.getTelp_pengguna());
            st.setString(4, mdPengguna.getUsername());
            st.setString(5, mdPengguna.getPassword());
            st.setString(6, mdPengguna.getFoto());
            st.setString(7, mdPengguna.getId_pengguna());
            
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diperbarui, Silahkan Masuk Ulang");
        }catch(SQLException e){
            Logger.getLogger(DAO_UbahAkun.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_UbahAkun.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public Model_Pengguna getById(String Id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_Pengguna mdPengguna = null;
        String sql = "SELECT * FROM pengguna WHERE id_pengguna=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, Id);
            
            rs = st.executeQuery();
            while (rs.next()){
                mdPengguna = new Model_Pengguna();
                mdPengguna.setId_pengguna(rs.getString("id_pengguna"));
                mdPengguna.setNama_pengguna(rs.getString("nama_pengguna"));
                mdPengguna.setPassword(rs.getString("password"));
                mdPengguna.setUsername(rs.getString("username"));
                mdPengguna.setTelp_pengguna(rs.getString("telp_pengguna"));
                mdPengguna.setAlamat_pengguna(rs.getString("alamat_pengguna"));
                mdPengguna.setFoto(rs.getString("foto"));
            }
            return mdPengguna;
        }catch(SQLException e){
            Logger.getLogger(DAO_UbahAkun.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_UbahAkun.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
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
