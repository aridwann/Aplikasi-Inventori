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
import model.Model_BarangMasuk;
import model.Model_DetailBM;
import model.Model_Barang;
import service.Service_DetailBM;

/**
 *
 * @author aridw
 */
public class DAO_DetailBM implements Service_DetailBM{
    Connection conn;
    
    public DAO_DetailBM(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_DetailBM mdDBM) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_barang_masuk(id_barang_masuk, id_barang, nama_barang, harga_beli, jumlah_masuk, subtotal_masuk, status) SELECT * FROM keranjang_barang_masuk";
        
        try{
            st = conn.prepareStatement(sql);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailBM.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public int sumTotal() {
        PreparedStatement st = null;
        ResultSet rs = null;
        int total = 0;
        String sql = "SELECT SUM(subtotal_masuk) FROM keranjang_barang_masuk";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
            return total;
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailBM.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 0;
    }

    @Override
    public void temporaryDelete() {
        PreparedStatement st = null;
        String sql = "DELETE FROM keranjang_barang_masuk";
        try{
            st = conn.prepareStatement(sql);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
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
    public List<Model_DetailBM> getById(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        
        String sql = "SELECT * FROM detail_barang_masuk WHERE id_barang_masuk =?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            while (rs.next()){
                Model_DetailBM mdDBM = new Model_DetailBM();
                Model_BarangMasuk mdBM = new Model_BarangMasuk();
                Model_Barang mdb = new Model_Barang();  
                
                mdBM.setId_barang_masuk(rs.getString("id_barang_masuk"));
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_beli(rs.getInt("harga_beli"));
                mdDBM.setJumlah_masuk(rs.getInt("jumlah_masuk"));
                mdDBM.setSubtotal_masuk(rs.getInt("subtotal_masuk"));
                mdDBM.setStatus(rs.getString("status"));
                
                mdDBM.setBarang_masuk(mdBM);
                mdDBM.setBarang(mdb);
                
                list.add(mdDBM);
            }
            return list;
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
    public List<Model_DetailBM> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM detail_barang_masuk";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_DetailBM mdDBM = new Model_DetailBM();
                Model_BarangMasuk mdBM = new Model_BarangMasuk();
                Model_Barang mdb = new Model_Barang();  
                
                mdBM.setId_barang_masuk(rs.getString("id_barang_masuk"));
                mdDBM.setJumlah_masuk(rs.getInt("jumlah_masuk"));
                mdDBM.setSubtotal_masuk(rs.getInt("subtotal_masuk"));
                mdDBM.setStatus(rs.getString("status"));
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_beli(rs.getInt("harga_beli"));
                
                mdDBM.setBarang_masuk(mdBM);
                mdDBM.setBarang(mdb);
                
                list.add(mdDBM);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailBM.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
}
