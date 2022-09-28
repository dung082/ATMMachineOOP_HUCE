/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import Database.ConnectMySQL;
import Form.InHoaDon;
import Form.Menu;
import Form.XemSoDuForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class XemSoDuCtrl {
    public void setXemSoDu(JButton btnxn , JButton btntrove,String id, String mk,XemSoDuForm xemsodu) {
    btnxn.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            xemsodu.hide();
            new InHoaDon(id,mk).setVisible(true);
        }
    });
    
    btntrove.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            xemsodu.hide();
            new Menu(id,mk).setVisible(true);
        }
    });
        
    }
}
