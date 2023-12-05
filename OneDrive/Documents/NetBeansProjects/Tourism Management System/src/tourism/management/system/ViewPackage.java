
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewPackage extends JFrame implements ActionListener{
    JButton back;
    ViewPackage(String username){
        setBounds(200,60,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(200,10,300,30);
        add(text);
        
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Package");
        lblpackage.setBounds(30,100,150,25);
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,100,150,25);
        add(labelpackage);
        
        JLabel lbtotalpersons = new JLabel("Total Persons");
        lbtotalpersons.setBounds(30,150,150,25);
        add(lbtotalpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220,150,150,25);
        add(labelpersons);
        
        JLabel lbid = new JLabel("ID");
        lbid.setBounds(30,200,150,25);
        add(lbid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,200,150,25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30,250,150,25);
        add(lbnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,250,150,25);
        add(labelnumber);
        
        JLabel lbphonenumber = new JLabel("Phone Number");
        lbphonenumber.setBounds(30,300,150,25);
        add(lbphonenumber);
        
        JLabel labelphonenumber = new JLabel();
        labelphonenumber.setBounds(220,300,150,25);
        add(labelphonenumber);
        
        JLabel lbprice = new JLabel("Price");
        lbprice.setBounds(30,350,150,25);
        add(lbprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,350,150,25);
        add(labelprice);
        
       ;
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(50,400,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,400,400);
        add(image);
        
        
        
        try {
            Conn conn = new Conn();
            String query = "Select * from bookpackage where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelpackage.setText(rs.getString("package"));
                labelprice.setText(rs.getString("price"));
                labelphonenumber.setText(rs.getString("phone"));
                labelpersons.setText(rs.getString("persons"));
                

            }
        }catch(Exception e){
        
    }
        
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String args[]){
        new ViewPackage("Khagendra");
    }
}

