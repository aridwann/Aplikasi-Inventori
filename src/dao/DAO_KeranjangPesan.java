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
import model.Model_DetailP;
import model.Model_KeranjangPesan;
import model.Model_Pemesanan;
import service.Service_KeranjangPesan;

/**
 *
 * @author aridw
 */
public class DAO_KeranjangPesan implements Service_KeranjangPesan {
    Connection conn;
    
    public DAO_KeranjangPesan(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_KeranjangPesan mdKP) {
        PreparedStatement st = null;
        String sql = "INSERT INTO keranjang_pemesanan(id_pemesanan, id_barang, nama_barang, harga_beli, jumlah_pesan, subtotal_pesan, status) VALUES(?,?,?,?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdKP.getPemesanan().getId_pemesanan());
            st.setString(2, mdKP.getBarang().getId_barang());
            st.setString(3, mdKP.getBarang().getNama_barang());
            st.setInt(4, mdKP.getBarang().getHarga_beli());
            st.setInt(5, mdKP.getDetail_pemesanan().getJumlah_pemesanan());
            st.setInt(6, mdKP.getDetail_pemesanan().getSubtotal_pemesanan());
            st.setString(7, mdKP.getDetail_pemesanan().getStatus());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangPesan.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangPesan.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void updateData(Model_KeranjangPesan mdKP) {
        PreparedStatement st = null;
        String sql = "UPDATE keranjang_pemesanan SET nama_barang=?, harga_beli=?, jumlah_pesan=?, subtotal_pesan=? WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdKP.getBarang().getNama_barang());
            st.setInt(2, mdKP.getBarang().getHarga_beli());
            st.setInt(3, mdKP.getDetail_pemesanan().getJumlah_pemesanan());
            st.setInt(4, mdKP.getDetail_pemesanan().getSubtotal_pemesanan());
            st.setString(5, mdKP.getBarang().getId_barang());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangPesan.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangPesan.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void deleteData(String id) {
        PreparedStatement st = null;
        String sql = "DELETE FROM keranjang_pemesanan WHERE id_barang=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_JenisBarang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangPesan.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<Model_KeranjangPesan> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM keranjang_pemesanan";
        try{ 
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_Pemesanan mp = new Model_Pemesanan();
                Model_DetailP mddp = new Model_DetailP();
                Model_KeranjangPesan mkp = new Model_KeranjangPesan();
                Model_Barang mdb = new Model_Barang();
                
                mp.setId_pemesanan(rs.getString("id_pemesanan"));
                
                mdb.setId_barang(rs.getString("id_barang"));
                mdb.setNama_barang(rs.getString("nama_barang"));
                mdb.setHarga_beli(rs.getInt("harga_beli"));
                
                mddp.setJumlah_pemesanan(rs.getInt("jumlah_pesan"));
                mddp.setSubtotal_pemesanan(rs.getInt("subtotal_pesan"));
                mddp.setStatus(rs.getString("status"));
                
                mkp.setBarang(mdb);
                mkp.setDetail_pemesanan(mddp);
                
                list.add(mkp);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_KeranjangPesan.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangPesan.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_KeranjangPesan.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

}
