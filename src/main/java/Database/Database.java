/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;


import Model.TK;
import Model.TaiKhoan;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class Database {
     public  List<TaiKhoan> getListTaikhoan(String sql) {
         List<TaiKhoan> list = null;
        try {
            Connection conn = ConnectMySQL.getConnection();
            list = new ArrayList<>();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
             while(rs.next()){
              TaiKhoan taikhoan = new TaiKhoan();
              taikhoan.setTaiKhoan(rs.getString(1));
              taikhoan.setMatKhau(rs.getString(2));
              taikhoan.setQuyen(rs.getString(3));
              list.add(taikhoan);
             }
             ps.close();    
             rs.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
               ex.getMessage();
        }
      return list;
    }
     
          public  List<TK> getListTK(String sql) {
         List<TK> list = null;
        try {
            Connection conn = ConnectMySQL.getConnection();
            list = new ArrayList<>();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sql);
             while(rs.next()){
              TK tk = new TK();
              tk.setTK(rs.getString(1));
              list.add(tk);
             }
             ps.close();    
             rs.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
               ex.getMessage();
        }
      return list;
    }
     
    public void setDataIntoDB(String sql) throws ClassNotFoundException{
      Connection conn = ConnectMySQL.getConnection();
      Statement ps;
        try {
            ps = conn.createStatement();
            ps.executeUpdate(sql);
        } catch (SQLException ex) {
                ex.getMessage();
        }
      
    }
    
}
