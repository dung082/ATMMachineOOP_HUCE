/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.Database;
import Form.LoginForm;
import Form.Menu;
import Form.ThemTienForm;
import Model.TaiKhoan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginCtrl {

    
    public void setLogin(JTextField txtusername,JPasswordField txtpassword , JButton btnlogin ,JButton btnhuy,LoginForm viewLogin){
        Database db = new Database();
        String sql = "Select stk , pass ,quyen from account";
        List<TaiKhoan> listtk = db.getListTaikhoan(sql);
        btnlogin.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
           boolean check = false;
           String position = null;
           String id = null;
           String pass1 = null;
           String tk = txtusername.getText().trim();
           String mk = txtpassword.getText().trim();
           JFrame frame = new JFrame("Xác Nhận");
           int result = JOptionPane.showConfirmDialog(frame,"Bạn muốn đăng nhập chứ","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
           if(result == JOptionPane.YES_OPTION){
               for(TaiKhoan items : listtk){
                   if(tk.equals(items.getTaiKhoan()) && mk.equals(items.getMatKhau())){
                       check = true;
                       position = items.getQuyen();
                       id = items.getTaiKhoan();
                       pass1 = items.getMatKhau();
                   }
               }
               
               if(check == true){
               if(position.equals("admin")){
                   System.out.println("Admin");
                   ThemTienForm tt = new ThemTienForm();
                   tt.setVisible(true);
                   viewLogin.hide();
               }
               else if(position.equals("guess")){
                   Menu mf = new Menu(id,pass1);
                   mf.setVisible(true); 
                   viewLogin.hide();}
           }
           
        else{
         JFrame frame1 = new JFrame("Lỗi");
                  JOptionPane.showMessageDialog(frame1,
                "Tài khoản hoặc mật khẩu không chính xác vui lòng thử lại",
                "Lỗi nhập",
                JOptionPane.ERROR_MESSAGE);
       }
           }
           else if (result == JOptionPane.NO_OPTION){
                    
           }
           
            }    
            
        });
        
                btnhuy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int hoi = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình không?",
                        "Hủy Đăng Nhập", JOptionPane.YES_NO_OPTION);
                if (hoi == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
    
}
