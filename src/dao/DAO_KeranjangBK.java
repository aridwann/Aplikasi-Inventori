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
import model.Model_DetailBK;
import model.Model_KeranjangKeluar;
import model.Model_BarangKeluar;
import service.Service_KeranjangKeluar;

/**
 *
 * @author aridw
 */
public class DAO_KeranjangBK implements Service_KeranjangKeluar {
    Connection conn;
    
    public DAO_KeranjangBK(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_KeranjangKeluar mdKK) {
        PreparedStatement st = null;
        String sql = "INSERT INTO keranjang_barang_keluar(id_barang_keluar, id_barang, nama_barang, harga_jual, jumlah_keluar, subtotal_keluar) VALUES(?,?,?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdKK.getBarang_keluar().getId_barang_keluar());
            st.setString(2, mdKK.getBarang().getId_barang());
            st.setString(3, mdKK.getBarang().getNama_barang());
            st.setInt(4, mdKK.getBarang().getHarga_jual());
            st.setInt(5, mdKK.getDetail_barang_keluar().getJumlah_keluar());
            st.setInt(6, mdKK.getDetail_barang_keluar().getSubtotal_keluar());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void updateData(Model_KeranjangKeluar mdKK) {
        PreparedStatement st = null;
        String sql = "UPDATE keranjang_barang_keluar SET nama_barang=?, harga_jual=?, jumlah_keluar=?, subtotal_keluar=? WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdKK.getBarang().getNama_barang());
            st.setInt(2, mdKK.getBarang().getHarga_jual());
            st.setInt(3, mdKK.getDetail_barang_keluar().getJumlah_keluar());
            st.setInt(4, mdKK.getDetail_barang_keluar().getSubtotal_keluar());
            st.setString(5, mdKK.getBarang().getId_barang());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void deleteData(String id) {
        PreparedStatement st = null;
        String sql = "DELETE FROM keranjang_barang_keluar WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<Model_KeranjangKeluar> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM keranjang_barang_keluar";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_BarangKeluar mbk = new Model_BarangKeluar();
                Model_DetailBK mdBK = new Model_DetailBK();
                Model_KeranjangKeluar mdKK = new Model_KeranjangKeluar();
                Model_Barang mdb = new Model_Barang();
                
                mbk.setId_barang_keluar(rs.getString("id_barang_keluar"));
                
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_jual(rs.getInt("harga_jual"));
                
                mdBK.setJumlah_keluar(rs.getInt("jumlah_keluar"));
                mdBK.setSubtotal_keluar(rs.getInt("subtotal_keluar"));
                 
                mdKK.setBarang(mdb);
                mdKK.setDetail_barang_keluar(mdBK);
                
                list.add(mdKK);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangBK.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

}
