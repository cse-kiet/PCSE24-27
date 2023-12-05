
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelusername,labelname;
    JComboBox comboid;
    JTextField tfnumber,tfaddress,tfcountry,tfemail,tfphone,tfid,tfgender;
    JRadioButton rmale , rfemale;
    JButton add,back;
    
    UpdateCustomer(String username){
        setBounds(200,60,850,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel Text = new JLabel("UPDATE CUTSOMER DETAILS");
        Text.setBounds(100,0,300,35);
        Text.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(Text);
        
        
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(30,50,150,30);
        add(lbusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(220,50,150,25);
        add(labelusername);
         
        
        JLabel lbid = new JLabel("ID");
        lbid.setBounds(30,90,150,25);
        add(lbid);
        
        tfid = new JTextField();
        tfid.setBounds(220,90,150,30);
        tfid.setBackground(Color.WHITE);
        add(tfid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setBounds(30,130,150,25);
        add(lbnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(220,130,150,30);
        add(tfnumber);
        
        
        JLabel lbname = new JLabel("Name");
        lbname.setBounds(30,170,150,30);
        add(lbname);
        
        labelname = new JLabel();
        labelname.setBounds(220,170,150,25);
        add(labelname);
        
        JLabel lbgender = new JLabel("Gender");
        lbgender.setBounds(30,210,150,30);
        add(lbgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220,210,150,30);
        tfgender.setBackground(Color.WHITE);
        add(tfgender);
        
        JLabel lbcountry = new JLabel("Country");
        lbcountry.setBounds(30,250,150,25);
        add(lbcountry);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(220,250,150,30);
        add(tfcountry);
        
        JLabel lbaddress = new JLabel("Address");
        lbaddress.setBounds(30,290,150,25);
        add(lbaddress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,290,150,30);
        add(tfaddress);
        
        
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setBounds(30,330,150,25);
        add(lbphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,30);
        add(tfphone);
        
        JLabel lbemail = new JLabel("Email");
        lbemail.setBounds(30,370,150,25);
        add(lbemail);
        
        
        tfemail= new JTextField();
        tfemail.setBounds(220,370,150,30);
        add(tfemail);
        
        add = new JButton("Update");
        add.setBounds(70,430,100,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(220,430,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(300,350,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel  image = new JLabel(i3);
        image.setBounds(470,70,300,350);
        add(image);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from customer where username = 'Khagendra'");
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelname.setText(rs.getString("name"));
                tfid.setText(rs.getString("id"));
                tfnumber.setText(rs.getString("number"));
                tfgender.setText(rs.getString("gender"));
                tfcountry.setText(rs.getString("country"));
                tfaddress.setText(rs.getString("address"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String username = labelusername.getText();
            String id = tfid.getText();
            String number = tfnumber.getText();
            String name = labelname.getText();
            String gender = tfgender.getText();
            String country = tfcountry.getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
            
            try{
                Conn c = new Conn();
                String query ="Update customer set username= '"+username+"',id= '"+id+"',number= '"+number+"',name= '"+name+"',gender= '"+gender+"',country= '"+country+"',address= '"+address+"',phone= '"+phone+"',email= '"+email+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Customer Details Updated Succesfully");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }
    
    
    public static void main(String args[]){
        new UpdateCustomer("Khagendra");
     }
}

