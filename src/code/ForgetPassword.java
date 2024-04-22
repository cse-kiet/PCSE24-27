
package tourism.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    
    JTextField tfusername,tfname,tfsecurity,tfanswer,tfpassword;
    JButton Search,Retrieve,Back;
    JLabel lbname, lbanswer,lbpassword;
    
    ForgetPassword(){
        setBounds(250,150,800,400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(560,70,200,200);
        add(image);
        
        
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(30,30,500,300);
        add(p1);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(10,20,130,30);
        lblusername.setFont(new Font("Tahoma",Font.BOLD , 20));
        p1.add(lblusername);
        
        tfusername = new JTextField();
        tfusername.setBounds(200,20,130,30);
        p1.add(tfusername);
        
        Search = new JButton("Search");
        Search.setBackground(Color.GRAY);
        Search.setForeground(Color.WHITE);
        Search.setBounds(360,20,100,30);
        Search.addActionListener(this);
        p1.add(Search);
        
        lbname = new JLabel("Name");
        lbname.setFont(new Font("Tahoma",Font.BOLD,20));
        lbname.setBounds(10,70,130,30);
        p1.add(lbname);
        
        tfname = new JTextField();
        tfname.setBounds(200,70,130,30);
        p1.add(tfname);
        
        JLabel lbsecurity = new JLabel("Security Question");
        lbsecurity.setFont(new Font("Tahoma",Font.BOLD,20));
        lbsecurity.setBounds(10,120,180,30);
        p1.add(lbsecurity);
       
        tfsecurity = new JTextField();
        tfsecurity.setBounds(200,120,130,30);
        p1.add(tfsecurity);
        
         lbanswer = new JLabel("Answer");
         lbanswer.setFont(new Font("Tahoma",Font.BOLD,20));
         lbanswer.setBounds(10,170,130,30);
         p1.add(lbanswer);
         
        tfanswer = new JTextField();
        tfanswer.setBounds(200,170,130,30);
        p1.add(tfanswer);
         
        Retrieve = new JButton("Retrieve");
        Retrieve.setBackground(Color.GRAY);
        Retrieve.setForeground(Color.WHITE);
        Retrieve.setBounds(360,170,100,30);
        Retrieve.addActionListener(this);
        p1.add(Retrieve);
        
        lbpassword = new JLabel("Password");
        lbpassword.setFont(new Font("Tahoma",Font.BOLD,20));
         lbpassword.setBounds(10,220,130,30);
         p1.add(lbpassword);
         
        tfpassword = new JTextField();
        tfpassword.setBounds(200,220,130,30);
        p1.add(tfpassword);
        
        Back = new JButton("Back");
        Back.setBackground(Color.GRAY);
        Back.setForeground(Color.WHITE);
        Back.setBounds(200,260,130,30);
        Back.addActionListener(this);
        p1.add(Back);

       
        
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Search){
            try{ 
                String query = "Select * from account where username = '"+tfusername.getText()+"'";
                Conn c= new Conn();
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                   tfname.setText(rs.getString("name"));
                   tfsecurity.setText(rs.getString("security"));
               }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource()== Retrieve){
             try{
                String query = "Select * from account where answer = '"+tfanswer.getText()+"' AND username = '"+tfusername.getText()+"'";
                Conn c= new Conn();
                
               ResultSet rs = c.s.executeQuery(query);
               while(rs.next()){
                   tfpassword.setText(rs.getString("password"));
          
               }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Login();
        }
    }
       
    public static void main(String args[]){
        new ForgetPassword();
    }
}
