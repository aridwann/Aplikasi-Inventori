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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Model_Distributor;
import model.Model_BarangMasuk;
import model.Model_Pengguna;
import service.Service_BarangMasuk;

/**
 *
 * @author aridw
 */
public class DAO_BarangMasuk implements Service_BarangMasuk{
    Connection conn;
    
    public DAO_BarangMasuk(){
        conn = Koneksi.getConnection();
    }
    
    @Override
    public void addData(Model_BarangMasuk mdBM) {
        PreparedStatement st = null;
        String sql = "INSERT INTO barang_masuk(id_barang_masuk, tgl_masuk, id_distributor, total_masuk, id_pengguna, status) VALUES(?,?,?,?,?,?)";
        
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, mdBM.getId_barang_masuk());
            st.setString(2, mdBM.getTgl_masuk());
            st.setString(3, mdBM.getDistributor().getId_distributor());
            st.setInt(4, mdBM.getTotalmasuk());
            st.setString(5, mdBM.getPengguna().getId_pengguna());
            st.setString(6, mdBM.getStatus());
            
            st.executeUpdate();
        }catch(SQLException e){
            Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public Model_BarangMasuk getById(String id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        Model_BarangMasuk mdBM = null;
        Model_Distributor mdd = null;
        Model_Pengguna mdpg = null;
        String sql = "SELECT * FROM barang_masuk WHERE id_barang_masuk=?";
        try{
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            
            rs = st.executeQuery();
            while (rs.next()){
                mdBM = new Model_BarangMasuk();
                mdd = new Model_Distributor();
                mdpg = new Model_Pengguna();
                mdBM.setId_barang_masuk(rs.getString("id_barang_masuk"));
                mdBM.setTgl_masuk(rs.getString("tgl_masuk"));
                mdd.setId_distributor(rs.getString("id_distributor"));
                mdBM.setTotalmasuk(rs.getInt("total_masuk"));
                mdpg.setId_pengguna(rs.getString("id_pengguna"));
                
                mdBM.setDistributor(mdd);
                mdBM.setPengguna(mdpg);
            }
            return mdBM;
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
    public List<Model_BarangMasuk> getData() {
        PreparedStatement st = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM barang_masuk";
        try{
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()){
                Model_BarangMasuk mdBM = new Model_BarangMasuk();
                Model_Distributor mdd = new Model_Distributor();
                Model_Pengguna mdpg = new Model_Pengguna();
                
                mdBM.setId_barang_masuk(rs.getString("id_barang_masuk"));
                mdBM.setTgl_masuk(rs.getString("tgl_masuk"));
                mdd.setId_distributor(rs.getString("id_distributor"));
                mdBM.setTotalmasuk(rs.getInt("total_masuk"));
                mdpg.setId_pengguna(rs.getString("id_pengguna"));
                
                mdBM.setDistributor(mdd);
                mdBM.setPengguna(mdpg);;
                list.add(mdBM);
            }
            return list;
        }catch(SQLException e){
            Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public String nomor() {
        PreparedStatement st = null;
        ResultSet rs = null;
        String id = null;
      
        String sql = "SELECT RIGHT(id_barang_masuk, 5) AS id FROM barang_masuk ORDER BY id DESC LIMIT 1";
        try{
            st =conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()){
                int noId = Integer.parseInt(rs.getString("id"));
                noId++;
                id = String.format("BRM%05d", noId);
            }else{
                id = "BRM00001";
            }
        }catch(SQLException e){
            Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st!=null){
                try{
                    st.close();
                }catch(SQLException e){
                    java.util.logging.Logger.getLogger(DAO_BarangMasuk.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return id;
    }

    @Override
    public void updateStok() {
        String sql = "UPDATE barang SET stok = stok + ? WHERE id_barang = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Mendapatkan data dari tabel
            String query = "SELECT * FROM keranjang_barang_masuk";
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
    
    @Override
    public void updateStokFromPemesanan(String id_pemesanan) {
        String sql = "UPDATE barang SET stok = stok + ? WHERE id_barang = ?";

        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            // Mendapatkan data dari tabel
            String query = "SELECT * FROM detail_pemesanan WHERE id_pemesanan = ?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, id_pemesanan);
            ResultSet resultSet = st.executeQuery();

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
    
    private String tanggal(){
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        return sdf.format(now);
    }
    
    @Override
    public void completeTheOrder(String id_pemesanan, String id_pengguna){
        PreparedStatement st1 = null;
        PreparedStatement st2 = null;
        PreparedStatement st3 = null;
        PreparedStatement st4 = null;
        String sql = "INSERT INTO barang_masuk(id_barang_masuk, tgl_masuk, id_distributor, total_masuk, id_pengguna, status)"
                + "SELECT ?, ?, id_distributor, total_pemesanan, ?, ? FROM pemesanan WHERE id_pemesanan = ?";
        String sql1 = "UPDATE pemesanan SET status = 'Selesai' WHERE id_pemesanan = ?";
        String sql2 = "UPDATE detail_pemesanan SET status = 'Selesai' WHERE id_pemesanan = ?";
        String sql3 = "INSERT INTO detail_barang_masuk(id_barang_masuk, id_barang, nama_barang, harga_beli, jumlah_masuk, subtotal_masuk, status) "
                + "SELECT ?, id_barang, nama_barang, harga_beli, jumlah_pesan, subtotal_pesan, ? FROM detail_pemesanan WHERE id_pemesanan = ?";
        try{
            st1 = conn.prepareStatement(sql);
            st1.setString(1, nomor());
            st1.setString(2, tanggal());
            st1.setString(3, id_pengguna);
            st1.setString(4, "Masuk");
            st1.setString(5, id_pemesanan);
            
            st2 = conn.prepareStatement(sql1);
            st2.setString(1, id_pemesanan);
            
            
            st3 = conn.prepareStatement(sql2);
            st3.setString(1, id_pemesanan);
            
            st4 = conn.prepareStatement(sql3);
            st4.setString(1, nomor());
            st4.setString(2, "Masuk");
            st4.setString(3, id_pemesanan);

            st1.executeUpdate();
            st2.executeUpdate();
            st3.executeUpdate();
            st4.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pemesanan diselesaikan");
        }catch(SQLException e){
            Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
        }finally{
            if(st1!=null){
                try{
                    st1.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
                }
            }else if(st2!=null){
                try{
                    st2.close();
                }catch(SQLException e){
                    Logger.getLogger(DAO_DetailP.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
}
