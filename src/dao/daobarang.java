/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.koneksiDB;
import model.Modbarang;

/**
 *
 * @author aditya anugrah
 */
public class daobarang implements implementbarang {
    
    Connection connection;
    final String insert = "INSERT INTO artikel (nama,comen) VALUES (?,?)";
    final String delete = "DELETE FROM artikel WHERE no=?";
    final String update = "UPDATE artikel set nama=?,comen=? WHERE no=?";
    final String select = "SELECT * FROM artikel";

    public daobarang() {
        connection = koneksiDB.connection();
    }
    
    
    
    
    

    @Override
    public void insert(Modbarang mb) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareCall(insert);
            
            statement.setString(1, mb.getNama());
            statement.setString(2, mb.getComen());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()){
                mb.setNo(rs.getInt(1));
            }
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int no) {
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareCall(delete);
            
            statement.setInt(1, no);
            statement.executeUpdate();
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    @Override
    public void update(Modbarang mb) {
        
        PreparedStatement statement = null;
        
        try {
            statement = connection.prepareCall(update);
            
            statement.setString(1, mb.getNama());
            statement.setString(2, mb.getComen());
            statement.setInt(3, mb.getNo());
            statement.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        
    }

    @Override
    public List<Modbarang> getAll() {
        List<Modbarang> lmb = null;
        
        
        try {
            lmb = new ArrayList<Modbarang>();
            Statement st  = connection.createStatement();
            
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                Modbarang mb = new Modbarang();
                mb.setNo(rs.getInt("no"));
                mb.setNama(rs.getString("nama"));
                mb.setComen(rs.getString("comen"));
                lmb.add(mb);
                
            }
            
            
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        
        }
        return lmb;
        
        
    }
    
}
