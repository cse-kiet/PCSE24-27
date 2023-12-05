
package tourism.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addPersonDetails,ViewPersonDetails,
            UpdatePersonDetails,CheckPackages,BookPackage,
            ViewPackage,ViewHotels,Destinations,BookHotel,
            ViewBookedHotel,payments,Notepad,calculator,About,DeletePersonDetails;
    Dashboard(String username){
        this.username=username;
      // setBounds(0,0,1285,700);
       setExtendedState(JFrame.MAXIMIZED_BOTH);
       setLayout(null);
       
       JPanel p1 = new JPanel();
       p1.setLayout(null);
       p1.setBackground(new Color(0,0,102));
       p1.setBounds(0,0,1290,55);
       add(p1);
       
       ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
       Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel icon = new JLabel(i3);
       icon.setBounds(5,0,70,70);
       p1.add(icon);
       
       JLabel heading = new JLabel("Dashboard");
       heading.setBounds(80,5,300,40);
       heading.setForeground(Color.WHITE);
       heading.setFont(new Font("Tahoma",Font.BOLD,20));
       p1.add(heading);
       
       JPanel p2 = new JPanel();
       p2.setLayout(null);
       p2.setBackground(new Color(0,0,102));
       p2.setBounds(0,55,300,600);
       add(p2);
       
        addPersonDetails = new JButton("Add Personal Details");
       addPersonDetails.setBounds(0,0,300,40);
       addPersonDetails.setBackground(new Color(0,0,102));
       addPersonDetails.setForeground(Color.WHITE);
       addPersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       addPersonDetails.setMargin(new Insets(0,0,0,60));
       addPersonDetails.addActionListener(this);
       p2.add(addPersonDetails);
       
       UpdatePersonDetails = new JButton("Update Personal Details");
       UpdatePersonDetails.setBounds(0,40,300,40);
       UpdatePersonDetails.setBackground(new Color(0,0,102));
       UpdatePersonDetails.setForeground(Color.WHITE);
       UpdatePersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       UpdatePersonDetails.setMargin(new Insets(0,0,0,30));
       UpdatePersonDetails.addActionListener(this);
       p2.add(UpdatePersonDetails);
       
       ViewPersonDetails = new JButton("View Details");
       ViewPersonDetails.setBounds(0,80,300,40);
       ViewPersonDetails.setBackground(new Color(0,0,102));
       ViewPersonDetails.setForeground(Color.WHITE);
       ViewPersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       ViewPersonDetails.setMargin(new Insets(0,0,0,130));
       ViewPersonDetails.addActionListener(this);
       p2.add(ViewPersonDetails);
       
       DeletePersonDetails = new JButton("Delete Personal Details");
       DeletePersonDetails.setBounds(0,120,300,40);
       DeletePersonDetails.setBackground(new Color(0,0,102));
       DeletePersonDetails.setForeground(Color.WHITE);
       DeletePersonDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
       DeletePersonDetails.setMargin(new Insets(0,0,0,30));
       DeletePersonDetails.addActionListener(this);
       p2.add(DeletePersonDetails);

       
       CheckPackages = new JButton("Check Packages");
       CheckPackages.setBounds(0,160,300,40);
       CheckPackages.setBackground(new Color(0,0,102));
       CheckPackages.setForeground(Color.WHITE);
       CheckPackages.setFont(new Font("Tahoma",Font.PLAIN,20));
       CheckPackages.setMargin(new Insets(0,0,0,90));
       CheckPackages.addActionListener(this);
       p2.add(CheckPackages);
       
       BookPackage = new JButton("Book Package");
       BookPackage.setBounds(0,200,300,40);
       BookPackage.setBackground(new Color(0,0,102));
       BookPackage.setForeground(Color.WHITE);
       BookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
       BookPackage.setMargin(new Insets(0,0,0,110));
       BookPackage.addActionListener(this);
       p2.add(BookPackage);
       
       ViewPackage = new JButton("View Package");
       ViewPackage.setBounds(0,240,300,40);
       ViewPackage.setBackground(new Color(0,0,102));
       ViewPackage.setForeground(Color.WHITE);
       ViewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
       ViewPackage.setMargin(new Insets(0,0,0,110));
       ViewPackage.addActionListener(this);
       p2.add(ViewPackage);
       
       ViewHotels = new JButton("View Hotels");
       ViewHotels.setBounds(0,280,300,40);
       ViewHotels.setBackground(new Color(0,0,102));
       ViewHotels.setForeground(Color.WHITE);
       ViewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
       ViewHotels.setMargin(new Insets(0,0,0,130));
       ViewHotels.addActionListener(this);
       p2.add(ViewHotels);
       
       BookHotel = new JButton("Book Hotel");
       BookHotel.setBounds(0,320,300,40);
       BookHotel.setBackground(new Color(0,0,102));
       BookHotel.setForeground(Color.WHITE);
       BookHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
       BookHotel.setMargin(new Insets(0,0,0,140));
       BookHotel.addActionListener(this);
       p2.add(BookHotel);
       
       
       ViewBookedHotel = new JButton("View Booked Hotel");
       ViewBookedHotel.setBounds(0,360,300,40);
       ViewBookedHotel.setBackground(new Color(0,0,102));
       ViewBookedHotel.setForeground(Color.WHITE);
       ViewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
       ViewBookedHotel.setMargin(new Insets(0,0,0,70));
       ViewBookedHotel.addActionListener(this);
       p2.add(ViewBookedHotel);
       
       
       Destinations = new JButton("Destinations");
       Destinations.setBounds(0,400,300,40);
       Destinations.setBackground(new Color(0,0,102));
       Destinations.setForeground(Color.WHITE);
       Destinations.setFont(new Font("Tahoma",Font.PLAIN,20));
       Destinations.setMargin(new Insets(0,0,0,130));
       Destinations.addActionListener(this);
       p2.add(Destinations);
       
       
       payments = new JButton("Payments");
       payments.setBounds(0,440,300,40);
       payments.setBackground(new Color(0,0,102));
       payments.setForeground(Color.WHITE);
       payments.setFont(new Font("Tahoma",Font.PLAIN,20));
       payments.setMargin(new Insets(0,0,0,150));
       payments.addActionListener(this);
       p2.add(payments);
       
       
       calculator = new JButton("Calculator");
       calculator.setBounds(0,480,300,40);
       calculator.setBackground(new Color(0,0,102));
       calculator.setForeground(Color.WHITE);
       calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
       calculator.setMargin(new Insets(0,0,0,150));
       calculator.addActionListener(this);
       p2.add(calculator);
       
       Notepad = new JButton("Notepad");
       Notepad.setBounds(0,520,300,40);
       Notepad.setBackground(new Color(0,0,102));
       Notepad.setForeground(Color.WHITE);
       Notepad.setFont(new Font("Tahoma",Font.PLAIN,20));
       Notepad.setMargin(new Insets(0,0,0,160));
       Notepad.addActionListener(this);
       p2.add(Notepad);
       
       About = new JButton("About");
       About.setBounds(0,560,300,40);
       About.setBackground(new Color(0,0,102));
       About.setForeground(Color.WHITE);
       About.setFont(new Font("Tahoma",Font.PLAIN,20));
       About.setMargin(new Insets(0,0,0,180));
       About.addActionListener(this);
       p2.add(About);

       
       ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
       Image i5 = i4.getImage().getScaledInstance(1650, 1000,Image.SCALE_DEFAULT);
       ImageIcon i6 = new ImageIcon(i5);
       JLabel image = new JLabel(i6);
       image.setBounds(0,0,1650,1000);
       add(image);
       
       JLabel text = new JLabel("Travel and Tourism Management System");
       text.setBounds(320,50,1000,70);
       text.setForeground(Color.white);
       text.setFont(new Font("Raleways",Font.PLAIN,50));
       image.add(text);
       
       
       setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==addPersonDetails){
            new AddCustomer(username);
        }
        else if(ae.getSource() == ViewPersonDetails){
            new ViewCustomer(username);
        }
        else if(ae.getSource() == UpdatePersonDetails){
            new UpdateCustomer(username);
        }
        else if(ae.getSource() == CheckPackages){
            new CheckPackage();
        }
        else if(ae.getSource() == BookPackage){
            new BookPackage(username);
        }
        else if(ae.getSource() == ViewPackage){
            new ViewPackage(username);
        }
        else if(ae.getSource() == ViewHotels){
            new CheckHotels();
        }
        else if(ae.getSource() == Destinations){
            new Destinations();
        }
         else if(ae.getSource() == BookHotel){
            new BookHotel(username);
        }
        else if(ae.getSource() == ViewBookedHotel){
            new ViewBookedHotel(username);
        }
        else if(ae.getSource() == payments){
            new Payment();
        }
        else if(ae.getSource() == calculator){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        else if(ae.getSource() == Notepad){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        else if(ae.getSource()==About){
            new About();
        }
        else if(ae.getSource()== DeletePersonDetails){
            new DeleteDetails(username);
        }
    }
    public static void main(String args[])
    {
        new Dashboard("");
    }
}
