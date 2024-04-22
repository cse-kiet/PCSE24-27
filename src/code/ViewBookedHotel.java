
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class ViewBookedHotel extends JFrame implements ActionListener{
    JButton back;
    ViewBookedHotel(String username){
        setBounds(200,60,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("VIEW BOOKED HOTEL DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(200,10,350,30);
        add(text);
        
        
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,120,25);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Hotel Name");
        lblpackage.setBounds(30,90,150,25);
        add(lblpackage);
        
        JLabel labelpackage = new JLabel();
        labelpackage.setBounds(220,90,120,25);
        add(labelpackage);
        
        JLabel lbtotalpersons = new JLabel("Total Persons");
        lbtotalpersons.setBounds(30,130,150,25);
        add(lbtotalpersons);
        
        JLabel labelpersons = new JLabel();
        labelpersons.setBounds(220,130,120,25);
        add(labelpersons);
        
        JLabel lbldays = new JLabel("Total Days");
        lbldays.setBounds(30,170,150,25);
        add(lbldays);
        
        JLabel labeldays = new JLabel();
        labeldays.setBounds(220,170,120,25);
        add(labeldays);
        
        JLabel lblac = new JLabel("AC/Non-AC");
        lblac.setBounds(30,210,150,25);
        add(lblac);
        
        JLabel labelac = new JLabel();
        labelac.setBounds(220,210,120,25);
        add(labelac);
        
        JLabel lblfood = new JLabel("Food Included");
        lblfood.setBounds(30,250,150,25);
        add(lblfood);
        
        JLabel labelfood = new JLabel();
        labelfood.setBounds(220,250,120,25);
        add(labelfood);
        
        JLabel lbid = new JLabel("ID");
        lbid.setBounds(30,290,150,25);
        add(lbid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,290,120,25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30,330,150,25);
        add(lbnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,330,120,25);
        add(labelnumber);
        
        JLabel lbphonenumber = new JLabel("Phone Number");
        lbphonenumber.setBounds(30,370,150,25);
        add(lbphonenumber);
        
        JLabel labelphonenumber = new JLabel();
        labelphonenumber.setBounds(220,370,120,25);
        add(labelphonenumber);
        
        JLabel lbprice = new JLabel("Price");
        lbprice.setBounds(30,410,150,25);
        add(lbprice);
        
        JLabel labelprice = new JLabel();
        labelprice.setBounds(220,410,120,25);
        add(labelprice);
        
       
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(50,450,100,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,50,450,400);
        add(image);
        
        
        
        try {
            Conn conn = new Conn();
            String query = "Select * from bookhotel where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelpackage.setText(rs.getString("Hotel Name"));
                labelpersons.setText(rs.getString("Total Persons"));
                labeldays.setText(rs.getString("Total Days"));
                labelac.setText(rs.getString("AC/Non-AC"));
                labelfood.setText(rs.getString("Food Included"));
                labelid.setText(rs.getString("ID"));
                labelnumber.setText(rs.getString("Number"));
                labelphonenumber.setText(rs.getString("Phone Number"));
                labelprice.setText(rs.getString("Price"));

            }
        }catch(Exception e){
        
    }
        
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String args[]){
        new ViewBookedHotel("Khagendra");
    }
}

