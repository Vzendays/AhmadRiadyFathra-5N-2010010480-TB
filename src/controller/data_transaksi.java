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
 * @author lenovo
 */
public class data_transaksi {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String nomer;
    public String lama;
    public String harga;
    public String merek;
    public String total;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO transaksi(nomer,lama,harga,merek,total)VALUE(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nomer);
        pst.setString(2,lama);
        pst.setString(3,harga);
        pst.setString(4,merek);
        pst.setString(5,total);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE transaksi set lama=?, harga=?, merek=?, total=? where nomer=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,lama);
        pst.setString(2,harga);
        pst.setString(3,merek);
        pst.setString(4,total);
        pst.setString(5, nomer);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from transaksi where nomer=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, nomer);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdatetblTran()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select nomer,lama,harga,merek,total from transaksi";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}