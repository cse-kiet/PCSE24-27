

package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton Login, fgpassword,Signup;
    JTextField tfusername , tfpassword;
    
    Login(){
        setSize(800,400);
        setLocation(250,150);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 120,200,200);
        
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,355,300);
        add(p2);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setBounds(50,30,100,30);
        lbusername.setFont(new Font("SAN_SARIF",Font.PLAIN,20));
        p2.add(lbusername);
        
         tfusername = new JTextField();
        tfusername.setBounds(50,60,270,30);
        p2.add(tfusername);
        
        
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setBounds(50,120,100,30);
        lbpassword.setFont(new Font("SAN_SARIF",Font.PLAIN,20));
        p2.add(lbpassword);
        
         tfpassword = new JTextField();
        tfpassword.setBounds(50,150,270,30);
        p2.add(tfpassword);
        
         Login = new JButton("Login");
        Login.setBounds(50,200,100,30);
        Login.setBackground(new Color(133,193,233));
        Login.addActionListener(this);
        p2.add(Login);
        
         Signup = new JButton("Signup");
        Signup.setBounds(220,200,100,30);
        Signup.setBackground(new Color(133,193,233));
        Signup.addActionListener(this);
        p2.add(Signup);
        
         fgpassword = new JButton("Forgot Password");
        fgpassword.setBounds(50,250,270,30);
        fgpassword.setBackground(new Color(133,193,233));
        fgpassword.addActionListener(this);
        p2.add(fgpassword);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == Login){
            try{ 
                String username = tfusername.getText();
                String password = tfpassword.getText();
                String query = "Select * from account where username = '"+username+"' AND password ='"+password+"'";
                Conn c= new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                  setVisible(false);
                  new Loading(username);
                }else{
                  JOptionPane.showMessageDialog(null,"Incorrect username or Password");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == Signup){
            setVisible(false);
            new SignUp();
        }else{
            setVisible(false);
            new ForgetPassword();
        }
    }


    public static void main(String args[]){
       new Login();
        
    }
}
