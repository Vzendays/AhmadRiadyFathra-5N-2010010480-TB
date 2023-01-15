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
public class data_penyewa {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    private String sql;
    public String nomer;
    public String nama;
    public String alamat;
    public String kontak;
    public String tanggal;
    
    public void simpan()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "INSERT INTO penyewa(nomer,nama,alamat,kontak,tanggal)VALUE(?,?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nomer);
        pst.setString(2,nama);
        pst.setString(3,alamat);
        pst.setString(4,kontak);
        pst.setString(5,tanggal);
        pst.execute();
        pst.close();
    }
    
    public void edit()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "UPDATE penyewa set nama=?, alamat=?, kontak=?, tanggal=? where nomer=?";
        pst = conn.prepareStatement(sql);
        pst.setString(1,nama);
        pst.setString(2,alamat);
        pst.setString(3,kontak);
        pst.setString(4,tanggal);
        pst.setString(5, nomer);
        pst.execute();
        pst.close();
    }
    
    public void hapus() throws SQLException{
        conn=Koneksi.getKoneksi();
        String sql="DELETE from penyewa where nomer=?";
        try{
            pst=conn.prepareStatement(sql);
            pst.setString(1, nomer);
            pst.execute();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ResultSet UpdateTBLpenyewa()throws SQLException{
        conn = Koneksi.getKoneksi();
        sql = "select nomer,nama,alamat,kontak,tanggal from penyewa";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        return rs;
    }
}
