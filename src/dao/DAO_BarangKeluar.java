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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_Distributor;
import model.Model_BarangKeluar;
import model.Model_Pengguna;
import service.Service_BarangKeluar;

/**
 *
 * @author aridw
 */
public class DAO_BarangKeluar implements Service_BarangKeluar{
    Connection conn;
    
    public DAO_BarangKeluar(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_BarangKeluar mdBK) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang_keluar(id_barang_keluar, tgl_keluar, total_keluar, id_pengguna) VALUES(?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdBK.getId_barang_keluar());
            st.setString(2, mdBK.getTgl_keluar());
            st.setInt(3, mdBK.getTotalKeluar());
            st.setString(4, mdBK.getPengguna().getId_pengguna());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public Model_BarangKeluar getById(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_BarangKeluar mdBK = null;
        Model_Distributor mdd = null;
        Model_Pengguna mdpg = null;
        String sql = "SELECT * FROM barang_keluar WHERE id_barang_keluar=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            while (rs.next()){
                mdBK = new Model_BarangKeluar();
                mdpg = new Model_Pengguna();
                mdBK.setId_barang_keluar(rs.getString("id_barang_keluar"));
                mdBK.setTgl_keluar(rs.getString("tgl_keluar"));
                mdBK.setTotalKeluar(rs.getInt("total_keluar"));
                mdpg.setId_pengguna(rs.getString("id_pengguna"));
                
                mdBK.setPengguna(mdpg);
            }
            return mdBK;
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<Model_BarangKeluar> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM barang_keluar";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_BarangKeluar mdBK = new Model_BarangKeluar();
                Model_Pengguna mdpg = new Model_Pengguna();
                
                mdBK.setId_barang_keluar(rs.getString("id_barang_keluar"));
                mdBK.setTgl_keluar(rs.getString("tgl_keluar"));
                mdBK.setTotalKeluar(rs.getInt("total_keluar"));
                mdpg.setId_pengguna(rs.getString("id_pengguna"));
                
                mdBK.setPengguna(mdpg);;
                list.add(mdBK);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String id = null;
      
        String sql = "SELECT RIGHT(id_barang_keluar, 5) AS id FROM barang_keluar ORDER BY id DESC LIMIT 1";
        try{
            st =conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int noId = Integer.parseInt(rs.getString("id"));
                noId++;
                id = String.format("BRK%05d", noId);
            }else{
                id = "BRK00001";
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_BarangKeluar.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return id;
    }
    
    @Override
    public void updateStok() {
        String sql = "UPDATE barang SET stok = stok - ? WHERE id_barang = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Mendapatkan data dari tabel
            String query = "SELECT * FROM keranjang_barang_keluar";
            Statement selectStatement = conn.createStatement();
            ResultSet resultSet = selectStatement.executeQuery(query);

            // Melakukan update stok
            while (resultSet.next()) {
                String idBarang = resultSet.getString(2); 
                int stok = resultSet.getInt(5); 

                // Mengatur parameter jumlah dan id_barang
                statement.setInt(1, stok);
                statement.setString(2, idBarang);

                // Menjalankan pernyataan UPDATE
                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
