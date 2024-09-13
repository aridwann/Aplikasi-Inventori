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
import model.Model_Distributor;
import model.Model_Pemesanan;
import model.Model_Pengguna;
import service.Service_Pemesanan;

/**
 *
 * @author aridw
 */
public class DAO_PemesananBarang implements Service_Pemesanan{
    Connection conn;
    
    public DAO_PemesananBarang(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_Pemesanan mdPemesanan) {
        PreparedStatement st = null;
        String sql = "INSERT INTO pemesanan(id_pemesanan, tgl_pemesanan, id_distributor, total_pemesanan, id_pengguna, status) VALUES(?,?,?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdPemesanan.getId_pemesanan());
            st.setString(2, mdPemesanan.getTgl_pemesanan());
            st.setString(3, mdPemesanan.getDistributor().getId_distributor());
            st.setInt(4, mdPemesanan.getTotal_pemesanan());
            st.setString(5, mdPemesanan.getPengguna().getId_pengguna());
            st.setString(6, mdPemesanan.getStatus());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public Model_Pemesanan getById(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_Pemesanan mdp = null;
        Model_Distributor mdd = null;
        Model_Pengguna mdpg = null;
        String sql = "SELECT * FROM pemesanan WHERE id_pemesanan=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            while (rs.next()){
                mdp = new Model_Pemesanan();
                mdd = new Model_Distributor();
                mdpg = new Model_Pengguna();
                mdp.setId_pemesanan(rs.getString("id_pemesanan"));
                mdp.setTgl_pemesanan(rs.getString("tgl_pemesanan"));
                mdd.setId_distributor(rs.getString("id_distributor"));
                mdp.setTotal_pemesanan(rs.getInt("total_pemesanan"));
                mdpg.setId_pengguna(rs.getString("id_pengguna"));
                
                mdp.setDistributor(mdd);
                mdp.setPengguna(mdpg);
            }
            return mdp;
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
    public List<Model_Pemesanan> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM pemesanan";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_Pemesanan mdp = new Model_Pemesanan();
                Model_Distributor mdd = new Model_Distributor();
                Model_Pengguna mdpg = new Model_Pengguna();
                
                mdp.setId_pemesanan(rs.getString("id_pemesanan"));
                mdp.setTgl_pemesanan(rs.getString("tgl_pemesanan"));
                mdd.setId_distributor(rs.getString("id_distributor"));
                mdp.setTotal_pemesanan(rs.getInt("total_pemesanan"));
                mdpg.setId_pengguna(rs.getString("id_pengguna"));
                mdp.setStatus(rs.getString("status"));
                
                mdp.setDistributor(mdd);
                mdp.setPengguna(mdpg);;
                list.add(mdp);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String id = null;
      
        String sql = "SELECT RIGHT(id_pemesanan, 5) AS id FROM pemesanan ORDER BY id DESC LIMIT 1";
        try{
            st =conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int noId = Integer.parseInt(rs.getString("id"));
                noId++;
                id = String.format("PSN%05d", noId);
            }else{
                id = "PSN00001";
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return id;
    }

    @Override
    public boolean checkStatus(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        String status = null;
      
        String sql = "SELECT status FROM pemesanan WHERE id_pemesanan = ?";
        try{
            st =conn.prepareStatement(sql);
            st.setString(1, id);
            rs = st.executeQuery();
            while(rs.next()){
                status = rs.getString("status");
            }
            
            if(status.equals("Dipesan")){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_PemesananBarang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return false;
    }
    
   
}
