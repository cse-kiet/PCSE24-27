
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookPackage extends JFrame implements ActionListener{
    
    Choice cpackage;
    JTextField tfpersons;
    String username;
    JLabel labelusername,labelid,labelphone,labelprice,labelnumber;
    JButton checkprice , bookpackage,back;
    
    BookPackage(String username){
        this.username = username;
        setBounds(200,60,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Book Package");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblusername.setBounds(40,60,150,25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(200,60,200,25);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Package");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblpackage.setBounds(40,110,150,25);
        add(lblpackage);
        
        cpackage = new Choice();
        cpackage.add("Gold Package");
        cpackage.add("Silver Package");
        cpackage.add("Bronze Package");
        cpackage.setBounds(200,110,150,25);
        add(cpackage);
       
        
        JLabel lbpersons = new JLabel("Total Persons");
        lbpersons.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbpersons.setBounds(40,160,150,25);
        add(lbpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(200,160,150,25);
        add(tfpersons);
        
        JLabel lbid = new JLabel("ID");
        lbid.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbid.setBounds(40,210,150,25);
        add(lbid);
        
        labelid = new JLabel();
        labelid.setBounds(200,210,150,25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbnumber.setBounds(40,260,150,25);
        add(lbnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(200,260,150,25);
        add(labelnumber);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbphone.setBounds(40,310,150,25);
        add(lbphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(200,310,150,25);
        add(labelphone);
        
        JLabel lbtotal = new JLabel("Total Price");
        lbtotal.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbtotal.setBounds(40,360,150,25);
        add(lbtotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(200,360,150,25);
        add(labelprice);
        
       
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,410,120,30);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Package");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,410,120,30);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,410,120,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(400,50,400,300);
        add(l1);
        
        
         try{
            Conn c = new Conn();
            String query = "Select * from customer where username = '"+username+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelusername.setText(rs.getString("username"));
                labelid.setText(rs.getString("id"));
                labelnumber.setText(rs.getString("number"));
                labelphone.setText(rs.getString("phone"));
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
        setVisible(true);
    }
            
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkprice){
            String pack = cpackage.getSelectedItem();
            int cost = 0;
            
            if(pack.equals("Gold Package")){
                cost +=12000;
            }
            else if(pack.equals("Silver Package")){
                cost +=24000;
            }
            else{
                cost +=32000;
            }
            
            int persons = Integer.parseInt(tfpersons.getText());
            cost *= persons;
            labelprice.setText("Rs" + cost);
        }
        else if(ae.getSource()== bookpackage){
            try{
                Conn c= new Conn();
                c.s.executeLargeUpdate("insert into bookpackage values('"+labelusername.getText()+"','"+cpackage.getSelectedItem()+"','"+tfpersons.getText()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Package Booked successfully");
                setVisible(false);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }
    
    
    
    public static void main(String[] args){
        new BookPackage("Khagendra");
        
        
    }
}
