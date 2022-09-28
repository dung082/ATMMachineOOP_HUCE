/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectMySQL;
import Form.LoginForm;
import Form.Menu;
import Form.ThemTienKForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class ThemTienKCtrl {
    public void Add(JTextField txt500k , JTextField txt200k , JTextField txt100k , JTextField txt50k ,JTextField txt20k ,JTextField txt10k,String id,String mk,JButton btntt , JButton btntv , ThemTienKForm view){
        btntt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent z) {
                try{
                    int a = Integer.parseInt(txt500k.getText().trim());
                    int b = Integer.parseInt(txt200k.getText().trim());
                    int c = Integer.parseInt(txt100k.getText().trim());
                    int d = Integer.parseInt(txt50k.getText().trim());
                    int e = Integer.parseInt(txt20k.getText().trim());
                    int f = Integer.parseInt(txt10k.getText().trim());
                    
                    if(a == 0 && b == 0 && c ==0 && d ==0 && e ==0 && f ==0 ){
                        JFrame j000 = new JFrame("Thông báo");
                        JOptionPane.showMessageDialog(j000,"Vui lòng nhập số tiền tương ứng");
                    }
                    else{
                    String sql1 = "select sotien from account where stk ='"+id+"'";
                    String sql2 = "select st500, st200 , st100 , st50 , st20 , st10 from totien where id = 1";
                    String sql3 = "update totien set st500 =  ? , st200 = ? , st100 = ? , st50 = ?,st20 = ? , st10 = ? where id = 1";
                    String sql4 = "update account set sotien =? where stk = '"+id +"'";
                    //int tien2 = a*500000 + b*200000 + c *100000 + d*50000 + e*20000 + f*10000;
                    JFrame frame = new JFrame("Xác Nhận");
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn muốn thêm tiền","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        try{
                            Connection conn = ConnectMySQL.getConnection();
                            PreparedStatement ps = conn.prepareStatement(sql4);
                            PreparedStatement pr = conn.prepareStatement(sql3);
                            
                            Statement st = conn.createStatement();
                            ResultSet rs = st.executeQuery(sql1);
                            
                            Statement ss = conn.createStatement();
                            ResultSet rr = ss.executeQuery(sql2);
                            
                            if(rs.next()){
                                int tien = rs.getInt(1);
                                if(rr.next()){
                                    int st500 = rr.getInt(1);
                                    int st200 = rr.getInt(2);
                                    int st100 = rr.getInt(3);
                                    int st50 = rr.getInt(4);
                                    int st20 = rr.getInt(5);
                                    int st10 = rr.getInt(6);
                                    int tien2 = a*500000 + b*200000 + c *100000 + d*50000 + e*20000 + f*10000;
                                    ps.setInt(1, tien + tien2);
                                    pr.setInt(1, a +st500);
                                    pr.setInt(2, b +st200);
                                    pr.setInt(3, c +st100);
                                    pr.setInt(4, d +st50);
                                    pr.setInt(5, e +st20);
                                    pr.setInt(6, f +st10);
                                    if(ps.executeUpdate() == 1){
                                        if(pr.executeUpdate() == 1){
                                            JFrame j1 = new JFrame("Thông báo");
                                            JOptionPane.showMessageDialog(j1, "Bạn đã thêm tiền thành công");
                                              JFrame j2 = new JFrame("thông báo");    
                                             int result1 = JOptionPane.showConfirmDialog(j2,"Bạn có muốn sử dụng tiếp dịch vụ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                             if(result1 == JOptionPane.YES_OPTION){
                                            view.hide();
                                            new Menu(id,mk).setVisible(true);
                                            }
                                             else{
                                            JOptionPane.showMessageDialog(j1, "Cảm ơn bạn đã sử dụng dịch vụ");
                                           view.hide();
                                           new LoginForm().setVisible(true);
                                            }
                                        }
                                    }
                                }
                                
                            }
                            
                        }
                        catch(ClassNotFoundException | SQLException ex)
                        {
                            System.out.println("Noooo");
                        }
                    }
                }
                }
                catch(java.lang.NumberFormatException ex){
                    JFrame jtb7= new JFrame("Thông báo");
                    JOptionPane.showMessageDialog(jtb7, "Vui lòng nhập đúng số tiền giao dịch ");
                    
                }
            }
            
        });
        
        btntv.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            view.hide();
            new Menu(id,mk).setVisible(true);
            
            }
        });
    }
}
