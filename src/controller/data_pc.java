/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author acer
 */
public class data_pc {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String nomer;
    public String id_pc;
    public String merek;
    public String harga;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO pc(nomer,id_pc,merek,harga)VALUE(?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nomer);
        pst.setString(2,id_pc);
        pst.setString(3,merek);
        pst.setString(4,harga);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE pc set id_pc=?, merek=?, harga=? where nomer=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,id_pc);
        pst.setString(2,merek);
        pst.setString(3,harga);
        pst.setString(4, nomer);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from pc where nomer=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, nomer);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatepcTABLE()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select nomer,id_pc,merek,harga from pc";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
