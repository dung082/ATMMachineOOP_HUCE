/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectMySQL;
import Form.LoginForm;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class ThemTienATMCtrl {
    public void setThemTien(JButton btnxn , JButton btndx ,JLabel tientk, ThemTienForm viewtt ){
        btndx.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            viewtt.hide();
            new LoginForm().setVisible(true);
            }
        });
        
        
        btnxn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            viewtt.hide();
            new ThemTienAdForm().setVisible(true);
            }        
            });
    }
    
    
}
