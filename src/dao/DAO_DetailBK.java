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
import model.Model_BarangKeluar;
import model.Model_DetailBK;
import model.Model_Barang;
import service.Service_DetailBK;

/**
 *
 * @author aridw
 */
public class DAO_DetailBK implements Service_DetailBK{
    Connection conn;
    
    public DAO_DetailBK(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_DetailBK mdDBK) {
        PreparedStatement st = null;
        String sql = "INSERT INTO detail_barang_keluar(id_barang_keluar, id_barang, nama_barang, harga_jual, jumlah_keluar, subtotal_keluar) SELECT * FROM keranjang_barang_keluar";
        
        try{
            st = conn.prepareStatement(sql);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public int sumTotal() {
        PreparedStatement st = null;
        ResultSet rs = null;
        int total = 0;
        String sql = "SELECT SUM(subtotal_keluar) FROM keranjang_barang_keluar";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                total = rs.getInt(1);
            }
            return total;
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return 0;
    }

    @Override
    public void temporaryDelete() {
        PreparedStatement st = null;
        String sql = "DELETE FROM keranjang_barang_keluar";
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
    public List<Model_DetailBK> getById(String id) {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        
        String sql = "SELECT * FROM detail_barang_keluar WHERE id_barang_keluar=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            Model_DetailBK mdDBK = new Model_DetailBK();
            Model_BarangKeluar mdBK = new Model_BarangKeluar();
            Model_Barang mdb = new Model_Barang();  
            while (rs.next()){
                mdBK.setId_barang_keluar(rs.getString("id_barang_keluar"));
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_jual(rs.getInt("harga_jual"));
                mdDBK.setJumlah_keluar(rs.getInt("jumlah_keluar"));
                mdDBK.setSubtotal_keluar(rs.getInt("subtotal_keluar"));
                
                mdDBK.setBarang_keluar(mdBK);
                mdDBK.setBarang(mdb);
                
                list.add(mdDBK);
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
    public List<Model_DetailBK> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM detail_barang_keluar";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_DetailBK mdDBK = new Model_DetailBK();
                Model_BarangKeluar mdBK = new Model_BarangKeluar();
                Model_Barang mdb = new Model_Barang();  
                
                mdBK.setId_barang_keluar(rs.getString("id_barang_keluar"));
                mdDBK.setJumlah_keluar(rs.getInt("jumlah_keluar"));
                mdDBK.setSubtotal_keluar(rs.getInt("subtotal_keluar"));
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_jual(rs.getInt("harga_jual"));
                
                mdDBK.setBarang_keluar(mdBK);
                mdDBK.setBarang(mdb);
                
                list.add(mdDBK);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public boolean stokValidation(String id, int jumlah) {
        PreparedStatement st = null;
        ResultSet rs = null;
        int stok = 0;
        String sql = "SELECT stok FROM barang WHERE id_barang = ?";
        try{ 
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while (rs.next()){
               stok = rs.getInt("stok");
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return jumlah <= stok;
    }
    
}
