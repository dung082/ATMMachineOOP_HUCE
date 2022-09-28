/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Form.FormDoiMK;
import Form.InHoaDon;
import Form.LoginForm;
import Form.Menu;
import Form.NhapSTKForm;
import Form.RutTienForm;
import Form.ThemTienKForm;
import Form.XemSoDuForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class MenuCtrl {
    public void setMenuCtrl(JButton btnck , JButton btndoimk, JButton btnrt, JButton btnsodu, JButton btnthoat,JButton btntt,Menu viewMenu ,String id,String mk){
        btnthoat.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    int cancel = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình không?",
                        "Hủy Đăng Nhập", JOptionPane.YES_NO_OPTION);
                if (cancel == JOptionPane.YES_OPTION) {
                   viewMenu.setVisible(false);
                   new LoginForm().setVisible(true);
                };
            }
            
        });
        
        btndoimk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMenu.hide();
                new FormDoiMK(id,mk).setVisible(true);
            }
            
        });
        
        btnsodu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewMenu.hide();
                    new XemSoDuForm(id,mk).setVisible(true);

                }

        });
        
               btnrt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                    viewMenu.hide();
                    new RutTienForm(id,mk).setVisible(true);
                }

        });
               
               btnck.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMenu.hide();
                new NhapSTKForm(id,mk).setVisible(true);
            }
               });
               
               
            btntt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewMenu.hide();
                new ThemTienKForm(id,mk).setVisible(true);
            }
        });

    }
}
