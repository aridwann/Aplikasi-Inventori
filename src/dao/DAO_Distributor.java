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
import model.Model_Distributor;
import service.Service_Distributor;


/**
 *
 * @author aridw
 */
public class DAO_Distributor implements Service_Distributor{
    private Connection conn;
    
    public DAO_Distributor(){
        conn = Koneksi.getConnection();
    }

    @Override
    public void addData(Model_Distributor mdDistributor) {
        PreparedStatement st = null;
        String sql = "INSERT INTO distributor(id_distributor, nama_distributor, telp_distributor, alamat_distributor) VALUES(?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdDistributor.getId_distributor());
            st.setString(2, mdDistributor.getNama_distributor());
            st.setString(3, mdDistributor.getTelp_distributor());
            st.setString(4, mdDistributor.getAlamat_distributor());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void updateData(Model_Distributor mdDistributor) {
        PreparedStatement st = null;
        String sql = "UPDATE distributor SET nama_distributor=?, telp_distributor=?, alamat_distributor=? WHERE id_distributor=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdDistributor.getNama_distributor());
            st.setString(2, mdDistributor.getTelp_distributor());
            st.setString(3, mdDistributor.getAlamat_distributor());
            st.setString(4, mdDistributor.getId_distributor());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public void deleteData(String id) {
        PreparedStatement st = null;
        String sql = "DELETE FROM distributor WHERE id_distributor=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public Model_Distributor getById(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_Distributor mdDistributor = null;
        String sql = "SELECT * FROM distributor WHERE id_distributor=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            while (rs.next()){
                mdDistributor = new Model_Distributor();
                mdDistributor.setId_distributor(rs.getString("id_distributor"));
                mdDistributor.setNama_distributor(rs.getString("nama_distributor"));
                mdDistributor.setTelp_distributor(rs.getString("telp_distributor"));
                mdDistributor.setAlamat_distributor(rs.getString("alamat_distributor"));
            }
            return mdDistributor;
        }catch(SQLException e){
            Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<Model_Distributor> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM distributor";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_Distributor mdDistributor = new Model_Distributor();
                mdDistributor.setId_distributor(rs.getString("id_distributor"));
                mdDistributor.setNama_distributor(rs.getString("nama_distributor"));
                mdDistributor.setTelp_distributor(rs.getString("telp_distributor"));
                mdDistributor.setAlamat_distributor(rs.getString("alamat_distributor"));
                
                list.add(mdDistributor);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String id = null;
        String sql = "SELECT RIGHT(id_distributor, 5) AS id FROM distributor ORDER BY id DESC LIMIT 1";
        try{
            st =conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int noId = Integer.parseInt(rs.getString("id"));
                noId++;
                id = String.format("DIS%05d", noId);
            }else{
                id = "DIS00001";
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_Distributor.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return id;
    }

    
}
