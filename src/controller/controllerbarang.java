/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.daobarang;
import dao.implementbarang;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModTblbarang;
import model.Modbarang;
import view.FromBarang;

/**
 *
 * @author aditya anugrah
 */
public class controllerbarang {
    FromBarang frame;
    implementbarang impelbarang;
    List<Modbarang> lmb;

    public controllerbarang(FromBarang frame) {
        this.frame = frame;
        impelbarang = new daobarang();
        lmb = impelbarang.getAll();
        
    }
    
    public void Reset(){
        frame.getTf_no().setText("");
        frame.getTf_nama().setText("");
        frame.getTf_comen().setText("");
    }
    
    public void isitable(){
        lmb = impelbarang.getAll();
        ModTblbarang mtb = new ModTblbarang(lmb);
        frame.getTbl_barang().setModel(mtb);
    }
    
    public void isifield(int row){
        frame.getTf_no().setText(String.valueOf(lmb.get(row).getNo()));
        frame.getTf_nama().setText(String.valueOf(lmb.get(row).getNama()));
        frame.getTf_comen().setText(String.valueOf(lmb.get(row).getComen()));
        
    }
    
    public void insert(){
        if(!frame.getTf_nama().getText().trim().isEmpty() & !frame.getTf_nama().getText().trim().isEmpty()){
            Modbarang mb = new Modbarang();
            mb.setNama(frame.getTf_nama().getText());
            mb.setComen(frame.getTf_comen().getText());
            
            impelbarang.insert(mb);
            JOptionPane.showMessageDialog(null,"coment telah disimpan");
            
        }else{
            JOptionPane.showMessageDialog(null,"coment tidak dapat disimpan");
            
        }
    }
    
    public void delete(){
        if(!frame.getTf_no().getText().trim().isEmpty()){
            int no = Integer.parseInt(frame.getTf_no().getText());
            
            impelbarang.delete(no);
            JOptionPane.showMessageDialog(null,"Data telah dihapus");
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Data gagal dihapus");
            
        }
        
    }
    
    public void update(){
        if(!frame.getTf_no().getText().trim().isEmpty()){
            Modbarang mb = new Modbarang();
            mb.setNama(frame.getTf_nama().getText());
            mb.setComen(frame.getTf_comen().getText());
            mb.setNo(Integer.valueOf(frame.getTf_no().getText()));
            
            impelbarang.update(mb);
            JOptionPane.showMessageDialog(null,"Data telah diupdate");
            
            
        }else{
            JOptionPane.showMessageDialog(null,"Data gagal diupdate");
            
        }
    }
    
}
