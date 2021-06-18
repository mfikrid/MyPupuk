/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Modbarang;

/**
 *
 * @author aditya anugrah
 */
public interface implementbarang {
    
    public void insert(Modbarang mb);
    public void delete(int no);
    public void update(Modbarang mb);
    public List<Modbarang> getAll();
    
}
