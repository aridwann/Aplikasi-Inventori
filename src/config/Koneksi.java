/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aridw
 */
public class Koneksi {
    private static Connection connection;
    public static Connection getConnection(){
        if(connection == null){
            try{
                String url = "jdbc:mysql://localhost:3306/db_mufti_aquarian";
                String user = "root";
                String pw = "";
                
                Class.forName("com.mysql.jdbc.Driver");
                connection = (Connection) DriverManager.getConnection(url, user, pw);
            }catch(Exception e){
                Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, e);
            }
            
        }
        return connection;
    }
}
