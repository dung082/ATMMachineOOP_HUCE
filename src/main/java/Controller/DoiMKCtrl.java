package Controller;

import Database.ConnectMySQL;
import Database.Database;
import Form.FormDoiMK;
import Form.LoginForm;
import Form.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class DoiMKCtrl {
    public void setDoiMK(JPasswordField txtoldpass ,JPasswordField txtnewpass, JPasswordField txtconfirmnewpass , JButton btnXacnhan ,JButton btnhuy,String id,String mk,FormDoiMK viewdoimk)
    {
        btnXacnhan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String mkdadoi;
                String oldpass = String.valueOf(txtoldpass.getText().trim());
                String newpass = String.valueOf(txtnewpass.getText().trim());
                String cfmnewpass = String.valueOf(txtconfirmnewpass.getText().trim());
                //String sql = "Update account set pass ='"+newpass+"'where stk ='"+id+"';";
                String sql = "Update account set pass =? where stk = ?";
                JFrame frame = new JFrame("Xác Nhận");
                int result = JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn đổi mật khẩu","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                if(oldpass.equals(mk)){
                    if(newpass.equals(cfmnewpass)){
                        if(newpass.length() == 6){
                            if(newpass.matches("^[0-9]{6}"))
                            {
                        try{
                        Connection conn = ConnectMySQL.getConnection();
                            PreparedStatement ps = conn.prepareStatement(sql);
                            ps.setString(1, newpass);
                            ps.setString(2, id);
                            JFrame frame11 = new JFrame("Thông báo");
                            System.out.println(id + "   "+ newpass);
                            if(ps.executeUpdate() ==1){
                            JOptionPane.showMessageDialog(frame11, "Đổi mật khẩu thành công");
                            mkdadoi = newpass;
                            JFrame j = new JFrame("Thông báo");
                            int result1 = JOptionPane.showConfirmDialog(j,"Bạn có muốn sử dụng tiếp dịch vụ","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                            
                            if(result1 == JOptionPane.YES_OPTION){
                                
                                //viewdoimk.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
                                viewdoimk.hide();
                                new Menu(id,mkdadoi).setVisible(true);
                            }
                            else{
                                JFrame jtb = new JFrame("Thông báo");
                                JOptionPane.showMessageDialog(jtb, "Cảm ơn bạn đã sử dụng dịch vụ");
                                //viewdoimk.dispatchEvent(new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
                                viewdoimk.hide();
                                new LoginForm().setVisible(true);
                            }
                        }
                        }
                            
                        catch(ClassNotFoundException | SQLException ex){
                            System.out.println("aa");
                        }
                    }
                            else{
                        JFrame frame10 = new JFrame("Lỗi");
                        JOptionPane.showMessageDialog(frame10, "Mật khẩu mới phải là số");
                            }
                        }
                        else{
                        JFrame frame6 = new JFrame("Lỗi");
                        JOptionPane.showMessageDialog(frame6, "Mật khẩu mới phải đúng 6 ký tự");
                    }
                    }
                    
                        
                    else{
                        JFrame frame1 = new JFrame("Lỗi");
                        JOptionPane.showMessageDialog(frame1, "Mật Khẩu mới không khớp");
                    }
                    
                }
                else{
                    JFrame frame2 = new JFrame("Lỗi");
                    JOptionPane.showMessageDialog(frame2, "Mật Khẩu cũ không đúng");
                }
            }
            else if (result == JOptionPane.NO_OPTION){

            }
            }
        });
        
        btnhuy.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewdoimk.hide();
                    new Menu(id,mk).setVisible(true);
            }
            
        });
    }
    
}
