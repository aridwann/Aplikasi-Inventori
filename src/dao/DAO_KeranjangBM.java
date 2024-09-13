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
import model.Model_Barang;
import model.Model_DetailBM;
import model.Model_KeranjangMasuk;
import model.Model_BarangMasuk;
import service.Service_KeranjangMasuk;

/**
 *
 * @author aridw
 */
public class DAO_KeranjangBM implements Service_KeranjangMasuk {
    Connection conn;
    
    public DAO_KeranjangBM(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_KeranjangMasuk mdKM) {
        PreparedStatement st = null;
        String sql = "INSERT INTO keranjang_barang_masuk(id_barang_masuk, id_barang, nama_barang, harga_beli, jumlah_masuk, subtotal_masuk, status) VALUES(?,?,?,?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdKM.getBarang_masuk().getId_barang_masuk());
            st.setString(2, mdKM.getBarang().getId_barang());
            st.setString(3, mdKM.getBarang().getNama_barang());
            st.setInt(4, mdKM.getBarang().getHarga_beli());
            st.setInt(5, mdKM.getDetail_barang_masuk().getJumlah_masuk());
            st.setInt(6, mdKM.getDetail_barang_masuk().getSubtotal_masuk());
            st.setString(7, mdKM.getDetail_barang_masuk().getStatus());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void updateData(Model_KeranjangMasuk mdKM) {
        PreparedStatement st = null;
        String sql = "UPDATE keranjang_barang_masuk SET nama_barang=?, harga_beli=?, jumlah_masuk=?, subtotal_masuk=? WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdKM.getBarang().getNama_barang());
            st.setInt(2, mdKM.getBarang().getHarga_beli());
            st.setInt(3, mdKM.getDetail_barang_masuk().getJumlah_masuk());
            st.setInt(4, mdKM.getDetail_barang_masuk().getSubtotal_masuk());
            st.setString(5, mdKM.getBarang().getId_barang());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void deleteData(String id) {
        PreparedStatement st = null;
        String sql = "DELETE FROM keranjang_barang_masuk WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<Model_KeranjangMasuk> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM keranjang_barang_masuk";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_BarangMasuk mbm = new Model_BarangMasuk();
                Model_DetailBM mdBM = new Model_DetailBM();
                Model_KeranjangMasuk mdKM = new Model_KeranjangMasuk();
                Model_Barang mdb = new Model_Barang();
                
                mbm.setId_barang_masuk(rs.getString("id_barang_masuk"));
                
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_beli(rs.getInt("harga_beli"));
                
                mdBM.setJumlah_masuk(rs.getInt("jumlah_masuk"));
                mdBM.setSubtotal_masuk(rs.getInt("subtotal_masuk"));
                mdBM.setStatus(rs.getString("status"));
                
                mdKM.setBarang(mdb);
                mdKM.setDetail_barang_masuk(mdBM);
                
                list.add(mdKM);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBM.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

}
