package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SignUp extends JFrame implements ActionListener {
    
    JButton create, back;
    JTextField tfusername , tfpassword,tfanswer, tfname;
    Choice security;
    
    SignUp(){
        setBounds(300,150,800,360);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);
        
        JLabel lbusername = new JLabel("Username");
        lbusername.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbusername.setBounds(50,30,120,20);
        p1.add(lbusername);
        
         tfusername = new JTextField();
        tfusername.setBounds(180,30,160,20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);
        
        JLabel lbname = new JLabel("Name");
        lbname.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbname.setBounds(50,70,120,20);
        p1.add(lbname);
        
         tfname = new JTextField();
        tfname.setBounds(180,70,160,20);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);
        
        JLabel lbpassword = new JLabel("Password");
        lbpassword.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbpassword.setBounds(50,110,120,20);
        p1.add(lbpassword);
        
        tfpassword = new JTextField();
        tfpassword.setBounds(180,110,160,20);
        tfpassword.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpassword);
        
        JLabel lbsecurity = new JLabel("Security Question");
        lbsecurity.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbsecurity.setBounds(50,150,120,20);
        p1.add(lbsecurity);
        
        security = new Choice();
        security.add("Favourite Cricketer");
        security.add("Favourite Actress");
        security.add("Favourite Destination");
        security.setBounds(180,150,240,20);
        p1.add(security);
        
        JLabel lbanswer = new JLabel("Answer");
        lbanswer.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbanswer.setBounds(50,190,120,20);
        p1.add(lbanswer);
        
         tfanswer = new JTextField();
        tfanswer.setBounds(180,190,160,20);
        tfanswer.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfanswer);
        
         create = new JButton("Create");
        create.setBackground(Color.WHITE);
        create.setForeground(Color.BLACK);
        create.setFont(new Font("Tahoma",Font.BOLD,20));
        create.setBounds(70,240,100,25);
        create.addActionListener(this);
        p1.add(create);
        
        back = new JButton("Back");
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.setFont(new Font("Tahoma",Font.BOLD,20));
        back.setBounds(210,240,100,25);
        back.addActionListener(this);
        p1.add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50,280,200);
        add(image);
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == create){
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpassword.getText();
            String question = security.getSelectedItem();
           
            String answer = tfanswer.getText();
            
            
            String query = "insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+answer+"')";
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
               
                JOptionPane.showMessageDialog(null,"Account Created Successfully");
                setVisible(false);
                new Login();
                
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == back){
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String args[]){
        new SignUp();
    }
}
