    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import Database.ConnectMySQL;
import Form.LoginForm;
import Form.Menu;
import Form.NhapTien;
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


public class NhaptienCtrl {
    public void setNhaptien(String id,String mk , String nh , String id2 ,JButton btnxn,JButton btntrove,JTextField txtnhaptien,NhapTien viewNhap){
            
        btnxn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            try
            {
                String sql1 = "select sotien from account where stk = '" + id + "'";
                String sql2 = "select sotien from account where stk = '" + id2 +"' and nganhang ='" + nh +"'";
                String sql3 = "update account set sotien = ? where stk = ? ";
                String sql4 = "update account set sotien = ? where stk = ? and nganhang = ?";
                int tien = Integer.parseInt(txtnhaptien.getText().trim());
                JFrame frame = new JFrame("Xác nhận");
                int result = JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn chuyển ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    try{
                        Connection conn = ConnectMySQL.getConnection();
                        PreparedStatement ps = conn.prepareStatement(sql3);
                        PreparedStatement pr = conn.prepareStatement(sql4);
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery(sql1);
                        Statement sr = conn.createStatement();
                        ResultSet rr = sr.executeQuery(sql2);
                        if(rs.next()){
                            int tien1 = rs.getInt(1);
                            if(rr.next()){
                                int tien2 = rr.getInt(1);
                                if(tien1 >= tien){
                                    if(tien>=50000){
                                    ps.setInt(1,tien1 - tien);
                                    ps.setString(2,id);
                                    pr.setInt(1, tien2 + tien);
                                    pr.setString(2,id2);
                                    pr.setString(3,nh);
                                    JFrame jtb = new JFrame("Thông báo");
                                    if(ps.executeUpdate()==1){
                                        if(pr.executeUpdate()==1){   
                                              JOptionPane.showMessageDialog(jtb, "Đã chuyển khoản thành công");
                                                JFrame j = new JFrame("Thông báo");
                                                int result1 = JOptionPane.showConfirmDialog(j,"Bạn có muốn sử dụng tiếp dịch vụ","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

                                                if(result1 == JOptionPane.YES_OPTION){

                                                    //viewdoimk.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
                                                    viewNhap.hide();
                                                    new Menu(id,mk).setVisible(true);
                                                }
                                                else{
                                                    JFrame jtb2= new JFrame("Thông báo");
                                                    JOptionPane.showMessageDialog(jtb2, "Cảm ơn bạn đã sử dụng dịch vụ");
                                                    //viewdoimk.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
                                                    viewNhap.hide();
                                                    new LoginForm().setVisible(true);
                                                    }
                                            }
                                        }
                                    }
                                    else{
                                        JFrame jcb1 = new JFrame("Cảnh báo");
                                        JOptionPane.showMessageDialog(jcb1, "Số tiền cần chuyển phải trên 50000 việt nam đồng");
                                    }
                                }
                                else{
                                    JFrame jcb = new JFrame("Cảnh báo");
                                    JOptionPane.showMessageDialog(jcb, "Tài khoản của bạn không đủ để thực hiện giao dịch");
                                }
                            }
                        }
                    }
                    catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Nooo");
                        System.out.println(id + "   " + nh +"   " + id2 + "     "+mk);
                    }
                }
            }
           catch(java.lang.NumberFormatException ex){
           JFrame jtb7= new JFrame("Thông báo");
           JOptionPane.showMessageDialog(jtb7, "Vui lòng nhập đúng số tiền giao dịch ");
           }
        
    }
        });
        
        
        
        
        btntrove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewNhap.hide();
                new Menu(id,mk).setVisible(true);
            }
        });
    }

}
