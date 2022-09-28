/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;

import Database.ConnectMySQL;
import Form.LoginForm;
import Form.Menu;
import Form.RutTienForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Asus
 */
public class RuttienCtrl {
    public void setRutTien(JTextField txtnhaptien , JButton btnrut , JButton btntrove , String id,String mk,RutTienForm viewRT )
    {
        btnrut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent z) {
                try{
                int x = Integer.parseInt(txtnhaptien.getText().trim());
                String sql5 ="select st500, st200 , st100 , st50 , st20 , st10 from totien where id = 1";
                String sql6 = "update totien set st500 =  ? , st200 = ? , st100 = ? , st50 = ?,st20 = ? , st10 = ? where id = 1";
                String sql1 = "select sotien from account where stk = '" + id + "'"; 
                String sql3 = "update account set sotien =? where stk = '"+id +"'";
                
                JFrame frame = new JFrame("Xác Nhận");
                int result = JOptionPane.showConfirmDialog(frame,"Bạn chắc chắn rút tiền","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    try {
                        Connection conn = ConnectMySQL.getConnection();
                        PreparedStatement pr = conn.prepareStatement(sql3);
                        PreparedStatement ps = conn.prepareStatement(sql6);
                        boolean check = false;
                        
                        Statement st = conn.createStatement();
                        ResultSet rs = st.executeQuery(sql1);
                        
                        Statement sr = conn.createStatement();
                        ResultSet rr = sr.executeQuery(sql5);
                        if(rs.next()){
                            
                            int sotien1 = rs.getInt(1);
                            if(rr.next()){
                                
                                int a = rr.getInt(1);
                                int b = rr.getInt(2);
                                int c = rr.getInt(3);
                                int d = rr.getInt(4);
                                int e = rr.getInt(5);
                                int f = rr.getInt(6);
                                int sotien2 = a*500000 + b*200000+c*100000+d*50000+e*20000+f*10000;
                                if(sotien1 >=x){
                                    if(x <= sotien2){
                                       if(x >= 50000){
                    System.out.println(a + " " + b +" " + c+ "   "+d +" " + e + "    "+f);
      int tien111 = x;
if( x%500000 == 0){
            int g = x/500000;
            if(g>a){
                x = x - 500000*a;
                a = 0;
                if (x%200000  == 0){
                    int h = x/200000;
                    if(h>b){
                        x = x - 200000*b;
                        b =0;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                                }
                    }
                    else{
                        x = x - 200000*h;
                        b = b-h;
                        System.out.println("Thành công");
                        check = true;
                    }
                }
                else{
                    int h = x/200000;
                    if(h>b){
                        x = x -200000*b;
                        b =0;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                                }
                    }
                    else{
                        x = x -200000*h;
                        b = b- h;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                                }
                    }
                    
                }
            }
            else{
                x = x - g*500000;
                a = a -g ;
                System.out.println("Thành công");
                check = true;
            }
        }
        else{// chia 500k dư
            int g = x/500000;
            if(g>a){
                x = x - 500000*a;
                a =0 ;
                if (x%200000  == 0){
                    int h = x/200000;
                    if(h>b){
                        x = x - 200000*b;
                        b =0;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                                }
                    }
                    else{
                        x = x - 200000*h;
                        b = b-h;
                        System.out.println("Thành công");
                        check = true;
                    }
                }
                else{
                    int h = x/200000;
                    if(h>b){
                        x = x -200000*b;
                        b =0;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                                }
                    }
                    else{
                        x = x -200000*h;
                        b = b- h;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                                }
                    }
                    
                }
            }
            else{
                x = x -500000*g;
                a = a - g;
                if (x%200000  == 0){
                    int h = x/200000;
                    if(h>b){
                        x = x - 200000*b;
                        b =0;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                                }
                    }
                    else{
                        x = x - 200000*h;
                        b = b-h;
                        System.out.println("Thành công");
                        check = true;
                    }
                }
                else{
                    int h = x/200000;
                    if(h>b){
                        x = x -200000*b;
                        b =0;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                                }
                    }
                    else{
                        x = x -200000*h;
                        b = b- h;
                        if(x%100000 ==0 ){
                        int k = x/100000;
                            if(k>c){
                                x = x - 100000*c;
                                c = 0;
                                if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x - 100000*k;
                                c = c -k;
                                System.out.println("thành công");
                                check = true;
                            }
                        }
                        else{
                            int k = x/100000;
                            if(k>c){
                                x = x -100000*c;
                                c = 0;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            else{
                                x = x-100000*k;
                                c = c -k;
                                 if (x%50000 ==0 ){
                                int i = x /50000;
                                    if(i>d){
                                        x = x- 50000*d;
                                        d = 0;
                                        if(x%20000 == 0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại ");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{ //chia 10k dư
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{ // chia 20k dư
                                            int j = x/20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e = 0;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");   
                                                    }
                                                    else{
                                                        x = x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x -20000*j;
                                                e = e -j;
                                                if(x%10000 ==0){
                                                    int l = x / 10000;
                                                    if (l>f){
                                                        System.out.println(" thất bại ");
                                                    }
                                                    else{
                                                        x= x -10000*l;
                                                        f = f-l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại"); 
                                                }   
                                            }
                                        }
                                    }
                                    else{
                                        x = x - 50000*i;
                                        d= d -i;
                                        System.out.println("thành công");
                                        check = true;
                                    }
                                }
                                else{ // chia 50k dư
                                    int i = x/50000;
                                    if(i>d){
                                        x = x - 50000*d;
                                        d = 0;
                                        if(x%20000 ==0){
                                            int j = x / 20000;
                                            if(j>e){
                                                x = x - 20000*e;
                                                e =0;
                                                if(x%10000 == 0){
                                                    int l = x /10000;
                                                    if(l>f){
                                                        System.out.println("thất bại"); 
                                                    }
                                                    else{
                                                        x  = x - 10000*l;
                                                        f = f - l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại ");
                                                }
                                            }
                                            else{
                                                x = x- 20000*j;
                                                e = e-j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                           int j = x/20000;
                                           if(j>e){
                                               x = x -20000*e;
                                               e =0;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                               
                                           }
                                           else{
                                               x = x - 20000*j;
                                               e = e-j;
                                               if(x%10000 ==0){
                                                   int l = x/10000;
                                                   if(l>f){
                                                       System.out.println("thất bại");
                                                   }
                                                   else{
                                                       x = x- 10000*l;
                                                       f = f-l;
                                                       System.out.println("thành công");
                                                       check = true;
                                                   }
                                               }
                                               else{
                                                   System.out.println("thất bại");
                                               }
                                           }
                                        }
                                    }
                                    else{
                                        x = x-50000*i;
                                        d = d -i;
                                        if(x%20000 ==0){
                                            int j = x/20000;
                                            if(j>e){
                                                x = x -20000*e;
                                                e =0;
                                                if(x%10000 ==0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println("thất bại");
                                                    }
                                                    else{
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x= x - 20000*j;
                                                e = e -j;
                                                System.out.println("thành công");
                                                check = true;
                                            }
                                        }
                                        else{
                                            int j = x/20000;
                                            if(j>e){
                                                x = x- 20000*e;
                                                e = 0;
                                                 if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                            else{
                                                x = x - 20000*j;
                                                e = e -j;
                                                if(x%10000 == 0){
                                                    int l = x/10000;
                                                    if(l>f){
                                                        System.out.println(" thất bại");
                                                    }
                                                    else {
                                                        x = x - 10000*l;
                                                        f = f -l;
                                                        System.out.println("thành công");
                                                        check = true;
                                                    }
                                                }
                                                else{
                                                    System.out.println("thất bại");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                               
                     }
                    }
                    
                }
            }
}

        if(check == true){
                pr.setInt(1, sotien1 - tien111);
                ps.setInt(1,a);
                ps.setInt(2,b);
                ps.setInt(3,c);
                ps.setInt(4,d);
                ps.setInt(5,e);
                ps.setInt(6,f);
                if(ps.executeUpdate() ==1 ){
                    if(pr.executeUpdate() == 1){
                        System.out.println("Thành Công");
                        JFrame j1 = new JFrame("Thông báo");
                        JOptionPane.showMessageDialog(j1, "Mời bạn nhận tiền");
                          JFrame j2 = new JFrame("thông báo");    
                         int result1 = JOptionPane.showConfirmDialog(j2,"Bạn có muốn sử dụng tiếp dịch vụ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                         if(result1 == JOptionPane.YES_OPTION){
                        viewRT.hide();
                        new Menu(id,mk).setVisible(true);
                        }
                         else{
                        JOptionPane.showMessageDialog(j1, "Cảm ơn bạn đã sử dụng dịch vụ");
                       viewRT.hide();
                       new LoginForm().setVisible(true);
                        }
                    }
                }
            }
            else {
                JFrame jtb10= new JFrame("Thông báo");
                JOptionPane.showMessageDialog(jtb10, "Cây không đủ mệnh giá");
            }
                            
                                    
                                        }
                                        else{
                                        JFrame jtb5= new JFrame("Thông báo");
                                        JOptionPane.showMessageDialog(jtb5, "Số tiền cần rút lớn hơn 50000 việt nam đồng"); 
                                        }
                                    }
                                    else{
                                        JFrame jtb3= new JFrame("Thông báo");
                                        JOptionPane.showMessageDialog(jtb3, "Số tiền trong cây không đủ để thực hiện giao dịch");
                                    }
                                }
                                else{
                                    JFrame jtb4= new JFrame("Thông báo");
                                    JOptionPane.showMessageDialog(jtb4, "Số tiền trong tài khoản không đủ để thực hiện giao dịch");
                                }
                            }
                        }
                                                
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Nooo");
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
                  viewRT.hide();
                  new Menu(id,mk).setVisible(true);
            }
            
        });
    }
}
