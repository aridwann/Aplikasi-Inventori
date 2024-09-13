/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Model_Barang;
import model.Model_Pengguna;
import service.Service_Dasbor;

/**
 *
 * @author aridw
 */
public class DAO_Dasbor implements Service_Dasbor{
    private Connection conn;
    
    public DAO_Dasbor(){
        conn = Koneksi.getConnection();
    }
    
    
    @Override
    public List<Model_Barang> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM barang ORDER BY stok";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_Barang mdBarang = new Model_Barang();
                mdBarang.setId_barang(rs.getString("id_barang"));
                mdBarang.setNama_barang(rs.getString("nama_barang"));
                mdBarang.setStok(rs.getInt("stok"));
                
                list.add(mdBarang);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_Dasbor.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Dasbor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Dasbor.class.getName()).log(Level.SEVERE, null, e);
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
                mdPengguna.setNama_pengguna(rs.getString("nama_pengguna"));
            }
            return mdPengguna;
        }catch(SQLException e){
            Logger.getLogger(DAO_Dasbor.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Dasbor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    @Override
    public int getJumlahBarangKeluar(){
        PreparedStatement st = null;
        ResultSet rs = null;
        int jumlahBarangKeluar = 0;
        String sql = "SELECT SUM(jumlah_keluar) FROM detail_barang_keluar";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                jumlahBarangKeluar = rs.getInt(1);
            }
            return jumlahBarangKeluar;
        }catch(SQLException e){
            Logger.getLogger(DAO_Dasbor.class.getName()).log(Level.SEVERE, null, e);
            return jumlahBarangKeluar;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Dasbor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
}
