/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aditya anugrah
 */
public class koneksiDB {
    static Connection con;
    
    public static Connection connection(){
        if(con == null){
            try {
                MysqlDataSource data = new MysqlDataSource();
                data.setDatabaseName("mypupuk");
                data.setUser("root");
                data.setPassword("");
                
                con = data.getConnection();
            } catch (SQLException ex) {
                
                ex.printStackTrace();
            
            }
        }
        return con;
    }
    
    
}
