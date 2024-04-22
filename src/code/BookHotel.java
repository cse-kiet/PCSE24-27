
package tourism.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookHotel extends JFrame implements ActionListener{
    
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays;
    String username;
    JLabel labelusername,labelid,labelphone,labelprice,labelnumber;
    JButton checkprice , bookpackage,back;
    
    BookHotel(String username){
        this.username = username;
        setBounds(200,60,850,550);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text = new JLabel("Book Hotel");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,25));
        add(text);
        
        JLabel lblusername = new JLabel("Username");
        lblusername.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblusername.setBounds(40,50,150,25);
        add(lblusername);
        
        labelusername = new JLabel();
        labelusername.setBounds(200,50,200,25);
        add(labelusername);
        
        JLabel lblpackage = new JLabel("Select Hotel");
        lblpackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblpackage.setBounds(40,90,150,25);
        add(lblpackage);
        
        chotel = new Choice();
        chotel.setBounds(200,90,150,25);
        add(chotel);
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel");
            while(rs.next()){
                chotel.add(rs.getString("name"));
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lbpersons = new JLabel("Total Persons");
        lbpersons.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbpersons.setBounds(40,130,150,25);
        add(lbpersons);
        
        tfpersons = new JTextField("1");
        tfpersons.setBounds(200,130,150,25);
        add(tfpersons);
        
        JLabel lbldays = new JLabel("No Of Days");
        lbldays.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbldays.setBounds(40,170,150,25);
        add(lbldays);
        
        tfdays = new JTextField("1");
        tfdays.setBounds(200,170,150,25);
        add(tfdays);
        
        JLabel lblac = new JLabel("AC/ Non-AC");
        lblac.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblac.setBounds(40,210,150,25);
        add(lblac);
        
         cac = new Choice();
         cac.add("AC");
         cac.add("Non-AC");
        cac.setBounds(200,210,150,25);
        add(cac);
        
         JLabel lblfood = new JLabel("Food Included");
        lblfood.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblfood.setBounds(40,250,150,25);
        add(lblfood);
        
         cfood = new Choice();
         cfood.add("YES");
         cfood.add("NO");
        cfood.setBounds(200,250,150,25);
        add(cfood);
        
        JLabel lbid = new JLabel("ID");
        lbid.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbid.setBounds(40,290,150,25);
        add(lbid);
        
        labelid = new JLabel();
        labelid.setBounds(200,290,150,25);
        add(labelid);
        
        JLabel lbnumber = new JLabel("Number");
        lbnumber.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbnumber.setBounds(40,330,150,25);
        add(lbnumber);
        
        labelnumber = new JLabel();
        labelnumber.setBounds(200,330,150,25);
        add(labelnumber);
        
        JLabel lbphone = new JLabel("Phone");
        lbphone.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbphone.setBounds(40,370,150,25);
        add(lbphone);
        
        labelphone = new JLabel();
        labelphone.setBounds(200,370,150,25);
        add(labelphone);
        
        JLabel lbtotal = new JLabel("Total Price");
        lbtotal.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbtotal.setBounds(40,410,150,25);
        add(lbtotal);
        
        labelprice = new JLabel();
        labelprice.setBounds(200,410,150,25);
        add(labelprice);
        
       
        checkprice = new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(40,450,130,30);
        checkprice.addActionListener(this);
        add(checkprice);
        
        bookpackage = new JButton("Book Hotel");
        bookpackage.setBackground(Color.BLACK);
        bookpackage.setForeground(Color.WHITE);
        bookpackage.setBounds(200,450,130,30);
        bookpackage.addActionListener(this);
        add(bookpackage);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(360,450,130,30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
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
            try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from hotel where name='"+chotel.getSelectedItem()+"'");
            while(rs.next()){
                int cost = Integer.parseInt(rs.getString("costperperson"));
                int food = Integer.parseInt(rs.getString("foodincluded"));
                int ac = Integer.parseInt(rs.getString("acroom"));
                
                int persons = Integer.parseInt(tfpersons.getText());
                int days = Integer.parseInt(tfdays.getText());
                
                String acselected = cac.getSelectedItem();
                String foodselected = cfood.getSelectedItem();
                
                if(persons*days>0){
                    int total=0;
                    total += acselected.equals("AC") ? ac : 0;
                    total += foodselected.equals("YES") ? food : 0;
                    total += cost;
                    total += persons*days*total;
                    labelprice.setText("Rs " + total);
                    
                }else{
                    JOptionPane.showMessageDialog(null,"Enter a valid Number");
                }
            }
         
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource()== bookpackage){
            try{
                Conn c= new Conn();
                c.s.executeLargeUpdate("insert into bookhotel values('"+labelusername.getText()+"','"+chotel.getSelectedItem()+"','"+tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+labelid.getText()+"','"+labelnumber.getText()+"','"+labelphone.getText()+"','"+labelprice.getText()+"')");
                JOptionPane.showMessageDialog(null,"Hotel Booked successfully");
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
        new BookHotel("Khagendra");
        
        
    }
}
