/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import Database.ConnectMySQL;
import Database.Database;
import Form.NhapSTKForm;
import Form.Menu;
import Form.NhapTien;
import Model.TK;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class NhapSTKCtrl {

    public void setCk(JTextField txtstk ,JButton btnxn , JButton btntrove ,String id,String mk ,JComboBox cb1, NhapSTKForm viewCk ){

        btnxn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        Database db = new Database();
        String nh = cb1.getSelectedItem().toString();
        String sql = "select stk from account where nganhang ='" +nh+ "' and stk != '" + id + "'";
        List<TK> list = db.getListTK(sql);
            String stk = txtstk.getText().trim();
            boolean check = false;
            if(stk.equals(id)){
            JFrame j1 = new JFrame("Thông báo");
            JOptionPane.showMessageDialog(j1, "Số tài khoản trùng với số tài khoản của bạn");
            }
            else{
            for(TK items : list){
                if(stk.equals(items.getTK())){
                    check = true;
                    String id3 = items.getTK(); 
                }
            }
            if(check == true ) {
                viewCk.hide();
                new NhapTien(id,mk,nh,stk).setVisible(true);

            }
            else {
                JFrame j = new JFrame("Thông báo");
                JOptionPane.showMessageDialog(j, "Số tài khoản không có trong ngân hàng "+ nh);
            }
        }
        }
    });
        
        
        btntrove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewCk.hide();
                new Menu(id,mk).setVisible(true);
            }
        });
    }
}
