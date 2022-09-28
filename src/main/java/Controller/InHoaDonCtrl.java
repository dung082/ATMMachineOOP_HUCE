/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.ConnectMySQL;
import Form.InHoaDon;
import Form.LoginForm;
import Form.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Asus
 */
public class InHoaDonCtrl {
    public void setIn(JButton btnin,JButton btntrove ,String id , String mk , InHoaDon view ){
        btnin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            JFrame j = new JFrame("thông báo");    
            int result = JOptionPane.showConfirmDialog(j,"Bạn có muốn in hóa đơn chứ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
                JFrame j1 = new JFrame("Thông báo");
                JOptionPane.showMessageDialog(j1, "Mời bạn nhận biên lai");
                String sql = "select stk , sotien , nguoidung from account where stk = '" + id + "'";
                try{
                    Connection conn = ConnectMySQL.getConnection();
                    Statement st = conn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if(rs.next()){
                        String sotk = rs.getString(1);
                        int tien = rs.getInt(2);
                        String ten = rs.getString(3);
                         Document document = new Document();
                try {
                    PdfWriter.getInstance(document, new FileOutputStream("HoaDon.pdf"));
                    document.open();
                    
                            Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR_OF_DAY);
                    int minute = cal.get(Calendar.MINUTE);
                    int second = cal.get(Calendar.SECOND);
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    Font f = new Font();
                    f.setSize(30);
                    f.setColor(BaseColor.RED);
                     
                    Paragraph g1 = new Paragraph("ATM BANKING",f);
                    g1.setAlignment(Element.ALIGN_CENTER);
                    g1.setSpacingAfter(20);
                    Paragraph g10 = new Paragraph("NGAY & GIO   :                        "+day+"/"+month+"/"+year+"    "+hour+":"+minute+":"+second);
                    g10.setSpacingAfter(15);
                    g10.setSpacingBefore(20);
                    Paragraph g2 = new Paragraph("SO TAI KHOAN  :                     "+sotk );
                    g2.setSpacingBefore(15);
                    g2.setSpacingAfter(15);
                    Paragraph g3 = new Paragraph("SO TIEN             :                      "+tien);
                    g3.setSpacingBefore(15);
                    g3.setSpacingAfter(15);
                    Paragraph g4 = new Paragraph("TEN NGUOI DUNG:                  "+ten);
                    g4.setSpacingBefore(15);
                    g4.setSpacingAfter(30);
                    Paragraph g5 = new Paragraph("----------------------------------------------------------------------------------------------------------------------");
                    g5.setSpacingBefore(30);
                    g5.setAlignment(Element.ALIGN_CENTER);
                    Paragraph g8 = new Paragraph("XIN TRAN TRONG CAM ON QUY KHACH! ");
                    g8.setAlignment(Element.ALIGN_CENTER);
                    Paragraph g9 = new Paragraph("MONG SE SOM DUOC GAP LAI QUY KHACH!");
                    g9.setAlignment(Element.ALIGN_CENTER);
                    //Phrase p1 = new Phrase(sotk);
                    document.open();
                    document.add(g1);
                    document.add(g10);
                    document.add(g2);
                    document.add(g3);
                    document.add(g4);
                    document.add(g5);
                    document.add(g8);
                    document.add(g9);
                    
                    document.close();
                    System.out.println("DONE");
                }
                catch(DocumentException d){
                    System.out.println("hoho");
                }
                catch(FileNotFoundException  fn){
                    System.out.println("hihi");
                }
                    }
                   
                }
                catch(ClassNotFoundException | SQLException ex){
                    System.out.println("a");
                }
                
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
        });
        
                btntrove.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            JFrame j = new JFrame("thông báo");    
            view.hide();
            new Menu(id,mk).setVisible(true);
            }
        });
    }
}
