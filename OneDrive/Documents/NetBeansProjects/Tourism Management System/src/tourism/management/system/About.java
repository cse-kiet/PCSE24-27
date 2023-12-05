
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    About(){
        setBounds(400,100,500,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("About");
        l1.setBounds(150,10,100,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        
        String s ="The Main objective of this Travel & Tourism project is to make the travel easy and comfortable for the users right from finding the routes and buses to till the booking of the tickets. In this project, we have two modules, Admin, and user.\n" +
"\n" +
"Admin in this Travel & Tourism Management System project will log in with the default username and password and admin has authority to add the bus routes and add the travel and assign the route id’s and bus id’s and finally, the admin will add the buses at particular times in different routes. Admin will also add the different travel agencies while adding buses admin will fix the ticket price and the capacity of seats.\n" +
"\n" +
"Finally, the user will register and log in and the find the appropriate routes and use the route id he will search the bus by giving all details like date of journey and type of seat etc. After selecting the information user will be headed to select seats in a view the selected seats will be displayed as red and then after successful payment the booking confirmation will be shown.";
        
        
        
        TextArea area = new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);
        
        JButton back = new JButton("Back");
        back.setBounds(190,410,100,30);
        back.addActionListener(this);
        add(back);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    public static void main(String args[]){
        new About();
    }
}
