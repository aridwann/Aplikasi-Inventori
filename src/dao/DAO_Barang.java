/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.Connection;
import config.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model_Barang;
import model.Model_Jenis;
import service.Service_Barang;

/**
 *
 * @author aridw
 */
public class DAO_Barang implements Service_Barang {
    Connection conn;
    
    public DAO_Barang(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_Barang mdBarang) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang(id_barang, id_jenis, nama_barang, satuan, harga_beli, harga_jual, stok) VALUES(?,?,?,?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdBarang.getId_barang());
            st.setString(2, mdBarang.getJenis().getId_jenis());
            st.setString(3, mdBarang.getNama_barang());
            st.setString(4, mdBarang.getSatuan());
            st.setInt(5, mdBarang.getHarga_beli());
            st.setInt(6, mdBarang.getHarga_jual());
            st.setInt(7, mdBarang.getStok());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void updateData(Model_Barang mdBarang) {
        PreparedStatement st = null;
        String sql = "UPDATE barang SET id_jenis=?, nama_barang=?, satuan=?, harga_beli=?, harga_jual=?, stok=? WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdBarang.getJenis().getId_jenis());
            st.setString(2, mdBarang.getNama_barang());
            st.setString(3, mdBarang.getSatuan());
            st.setInt(4, mdBarang.getHarga_beli());
            st.setInt(5, mdBarang.getHarga_jual());
            st.setInt(6, mdBarang.getStok());
            st.setString(7, mdBarang.getId_barang());
            
            st.executeUpdate();
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
    public void deleteData(String id) {
        PreparedStatement st = null;
        String sql = "DELETE FROM barang WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public Model_Barang getById(String Id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_Jenis mdJB = null;
        Model_Barang mdB = null;
        String sql = "SELECT * FROM barang WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, Id);
            
            rs = st.executeQuery();
            while (rs.next()){
                mdJB = new Model_Jenis();
                mdB = new Model_Barang();
                mdB.setId_barang(rs.getString("id_barang"));
                mdJB.setId_jenis(rs.getString("id_jenis"));
                mdB.setNama_barang(rs.getString("nama_barang"));
                mdB.setSatuan(rs.getString("satuan"));
                mdB.setHarga_beli(rs.getInt("harga_beli"));
                mdB.setHarga_jual(rs.getInt("harga_jual"));
                mdB.setStok(rs.getInt("stok"));
                
                mdB.setjenis(mdJB);
            }
            return mdB;
        }catch(SQLException e){
            Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<Model_Barang> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT brg.id_barang, brg.id_jenis, jb.nama_jenis, brg.nama_barang, brg.satuan, brg.harga_beli, brg.harga_jual, brg.stok FROM barang brg INNER JOIN jenis_barang jb ON brg.id_jenis = jb.id_jenis";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_Barang mdBarang = new Model_Barang();
                Model_Jenis mdJenisBarang = new Model_Jenis();
                
                mdBarang.setId_barang(rs.getString("id_barang"));
                mdBarang.setNama_barang(rs.getString("nama_barang"));
                mdBarang.setSatuan(rs.getString("satuan"));
                mdBarang.setHarga_beli(rs.getInt("harga_beli"));
                mdBarang.setHarga_jual(rs.getInt("harga_jual"));
                mdBarang.setStok(rs.getInt("stok"));
                
                mdJenisBarang.setId_jenis(rs.getString("id_jenis"));
                mdJenisBarang.setNama_jenis(rs.getString("nama_jenis"));
                
                mdBarang.setjenis(mdJenisBarang);
                list.add(mdBarang);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String id = null;
        String sql = "SELECT RIGHT(id_barang, 5) AS id FROM barang ORDER BY id DESC LIMIT 1";
        try{
            st =conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int noId = Integer.parseInt(rs.getString("id"));
                noId++;
                id = String.format("BRG%05d", noId);
            }else{
                id = "BRG00001";
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return id;
    }

  
    
}
