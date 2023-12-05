
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class DeleteDetails extends JFrame implements ActionListener{
    JButton delete;
    String username;
    DeleteDetails(String username){
        this.username =username;
        setBounds(230,70,870,525);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(30,50,150,25);
        add(lblusername);
        
        JLabel labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
        
        JLabel lblid = new JLabel("ID");
        lblid.setBounds(30,100,150,25);
        add(lblid);
        
        JLabel labelid = new JLabel();
        labelid.setBounds(220,100,150,25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30,150,150,25);
        add(lbnumber);
        
        JLabel labelnumber = new JLabel();
        labelnumber.setBounds(220,150,150,25);
        add(labelnumber);
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30,200,150,25);
        add(lbname);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(220,200,150,25);
        add(labelname);
        
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(30,250,150,25);
        add(lbgender);
        
        JLabel labelgender = new JLabel();
        labelgender.setBounds(220,250,150,25);
        add(labelgender);
        
        JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(470,50,150,25);
        add(lbcountry);
        
        JLabel labelcountry = new JLabel();
        labelcountry.setBounds(680,50,150,25);
        add(labelcountry);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(470,100,150,25);
        add(lbphone);
        
        JLabel labelphone = new JLabel();
        labelphone.setBounds(680,100,150,25);
        add(labelphone);
        
        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(470,150,150,25);
        add(lbemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(680,150,150,25);
        add(labelemail);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(470,200,150,25);
        add(lbaddress);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(680,200,150,25);
        add(labeladdress);
        
        delete = new JButton("Delete");
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setBounds(470,250,100,25);
        delete.addActionListener(this);
        add(delete);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(10,300,600,200);
        add(image);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5 = i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image2 = new JLabel(i6);
        image2.setBounds(610,300,600,200);
        add(image2);
        
        
        try {
            Conn conn = new Conn();
            String query = "Select * from customer where username = '"+username+"'";
            ResultSet rs = conn.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelname.setText(rs.getString("name"));
                labelgender.setText(rs.getString("gender"));
                labelcountry.setText(rs.getString("country"));
                labeladdress.setText(rs.getString("address"));
                labelphone.setText(rs.getString("phone"));
                labelemail.setText(rs.getString("email"));

            }
        }catch(Exception e){
        
    }
        
        setVisible(true);
    }
     
    public void actionPerformed(ActionEvent ae){
        try{
            Conn c = new Conn();
            c.s.executeUpdate("delete from account where username= '"+username+"'");
            c.s.executeUpdate("delete from customer where username= '"+username+"'");
            c.s.executeUpdate("delete from bookpackage where username= '"+username+"'");
            c.s.executeUpdate("delete from bookhotel where username= '"+username+"'");
            
            JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
            setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    
    public static void main(String args[]){
        new DeleteDetails("Khagendra");
    }
}
