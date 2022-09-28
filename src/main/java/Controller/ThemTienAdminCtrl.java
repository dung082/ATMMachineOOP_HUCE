/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectMySQL;
import Form.LoginForm;
import Form.Menu;
import Form.ThemTienAdForm;
import Form.ThemTienForm;
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
public class ThemTienAdminCtrl {
    public void add(JTextField txt500 ,JTextField txt200 ,JTextField txt100,JTextField txt50,JTextField txt20,JTextField txt10 ,JButton btnxn , JButton btntv , ThemTienAdForm view){
        btntv.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent z) {
                view.hide();
                new ThemTienForm().setVisible(true);
            }
        });
        
           btnxn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent z) {
                try{
                    int a;
                    int b;
                    int c;
                    int d;
                    int e;
                    int f;
                    
                     a = Integer.parseInt(txt500.getText().trim()); // if(a == null || a =""
                     b = Integer.parseInt(txt200.getText().trim());
                     c = Integer.parseInt(txt100.getText().trim());
                     d = Integer.parseInt(txt50.getText().trim());
                     e = Integer.parseInt(txt20.getText().trim());
                     f = Integer.parseInt(txt10.getText().trim());
                     
                    if(a == 0 && b == 0 && c ==0 && d ==0 && e ==0 && f ==0 ){
                        JFrame j000 = new JFrame("Thông báo");
                        JOptionPane.showMessageDialog(j000,"Vui lòng nhập số tiền tương ứng");
                    }
                    else{
                    String sql2 = "select st500, st200 , st100 , st50 , st20 , st10 from totien where id = 1";
                    
                    String sql3 = "update totien set st500 =  ? , st200 = ? , st100 = ? , st50 = ?,st20 = ? , st10 = ? where id = 1";
                   
                    //int tien2 = a*500000 + b*200000 + c *100000 + d*50000 + e*20000 + f*10000;
                    JFrame frame = new JFrame("Xác Nhận");
                    int result = JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn muốn thêm tiền","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(result == JOptionPane.YES_OPTION){
                        try{
                            Connection conn = ConnectMySQL.getConnection();
                            
                            PreparedStatement pr = conn.prepareStatement(sql3);
                            Statement ss = conn.createStatement();
                            ResultSet rr = ss.executeQuery(sql2);
                            

                                if(rr.next()){
                                    int st500k = rr.getInt(1);
                                    int st200k = rr.getInt(2);
                                    int st100k = rr.getInt(3);
                                    int st50k = rr.getInt(4);
                                    int st20k = rr.getInt(5);
                                    int st10k = rr.getInt(6);
                                    
                                    int tien2 = a*500000 + b*200000 + c *100000 + d*50000 + e*20000 + f*10000;
                                    
                                    pr.setInt(1, a +st500k);
                                    pr.setInt(2, b +st200k);
                                    pr.setInt(3, c +st100k);
                                    pr.setInt(4, d +st50k);
                                    pr.setInt(5, e +st20k);
                                    pr.setInt(6, f +st10k);
                                    
                                        if(pr.executeUpdate() == 1){
                                            JFrame j1 = new JFrame("Thông báo");
                                            JOptionPane.showMessageDialog(j1, "Bạn đã thêm tiền thành công");
                                            view.hide();
                                            new ThemTienForm().setVisible(true);
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
    }
}
