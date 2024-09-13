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
import model.Model_Pemesanan;
import model.Model_DetailP;
import model.Model_Barang;
import service.Service_DetailP;

/**
 *
 * @author aridw
 */
public class DAO_DetailP implements Service_DetailP{
    Connection conn;
    
    public DAO_DetailP(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_DetailP mdDetailP) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_pemesanan(id_pemesanan, id_barang, nama_barang, harga_beli, jumlah_pesan, subtotal_pesan, status) SELECT * FROM keranjang_pemesanan";
        
        try{
            st = conn.prepareStatement(sql);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public int sumTotal() {
        PreparedStatement st = null;
        ResultSet rs = null;
        int total = 0;
        String sql = "SELECT SUM(subtotal_pesan) FROM keranjang_pemesanan";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
            return total;
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 0;
    }

    @Override
    public void temporaryDelete() {
        PreparedStatement st = null;
        String sql = "DELETE FROM keranjang_pemesanan";
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
    public List<Model_DetailP> getById(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        
        String sql = "SELECT * FROM detail_pemesanan WHERE id_pemesanan =?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            while (rs.next()){
                Model_DetailP mddp = new Model_DetailP();
                Model_Pemesanan mdp = new Model_Pemesanan();
                Model_Barang mdb = new Model_Barang();  
                
                mdp.setId_pemesanan(rs.getString("id_pemesanan"));
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_beli(rs.getInt("harga_beli"));
                mddp.setJumlah_pemesanan(rs.getInt("jumlah_pesan"));
                mddp.setSubtotal_pemesanan(rs.getInt("subtotal_pesan"));
                mddp.setStatus(rs.getString("status"));
                
                mddp.setPemesanan(mdp);
                mddp.setBarang(mdb);
                
                list.add(mddp);
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
    public List<Model_DetailP> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM detail_pemesanan";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_DetailP mddp = new Model_DetailP();
                Model_Pemesanan mdp = new Model_Pemesanan();
                Model_Barang mdb = new Model_Barang();  
                
                mdp.setId_pemesanan(rs.getString("id_pemesanan"));
                mddp.setJumlah_pemesanan(rs.getInt("jumlah_pemesanan"));
                mddp.setSubtotal_pemesanan(rs.getInt("subtotal_pemesanan"));
                mddp.setStatus(rs.getString("status"));
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_beli(rs.getInt("harga_beli"));
                
                mddp.setPemesanan(mdp);
                mddp.setBarang(mdb);
                
                list.add(mddp);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
}
