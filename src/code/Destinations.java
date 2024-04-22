
package tourism.management.system;

import javax.swing.*;
import java.awt.*;


public class Destinations extends JFrame implements Runnable{
    
    Thread t1;
     JLabel l1 ,l2,l3,l4,l5,l6,l7,l8;
     JLabel[] label = new JLabel[]{l1 ,l2,l3,l4,l5,l6,l7,l8};
     //JLabel caption;
     public void run(){
         
        // String[] text = new String[]{"Palm Beach Jumeriah","The Oberoi Villas","The Atlantis","JW Mariott Hotel","Hotel Pacific","The Bhragudev's","The Bay Club Hotel","The Taj Hotel","The Burj Al Arab","The Westin Excelsior"};
         try{
             for(int i=0;i<=7;i++){
                 label[i].setVisible(true);
                 Thread.sleep(2000);
                 label[i].setVisible(false);
             }
             
         }catch(Exception e){
             e.printStackTrace();
         }
     }
    
    Destinations(){
        setBounds(200,60,850,550);
        
        
        
        ImageIcon i1=null,i2=null,i3=null,i4=null,i5=null,i6=null,i7=null,i8=null;
        ImageIcon[] image = new ImageIcon[]{i1,i2,i3,i4,i5,i6,i7,i8};
        
        Image j1=null,j2=null,j3=null,j4=null,j5=null,j6=null,j7=null,j8=null;
        Image[] jimage = new Image[]{j1,j2,j3,j4,j5,j6,j7,j8};
        
        ImageIcon k1=null,k2=null,k3=null,k4=null,k5=null,k6=null,k7=null,k8=null;
        ImageIcon[] kimage = new ImageIcon[]{k1,k2,k3,k4,k5,k6,k7,k8};
        
        for(int i=0;i<=7;i++){
            
        image[i] = new ImageIcon(ClassLoader.getSystemResource("icons/dest"+(i+1)+".jpg"));
        jimage[i]  =image[i].getImage().getScaledInstance(850,550,Image.SCALE_DEFAULT);
        kimage[i]  = new ImageIcon(jimage[i]);
        label[i] = new JLabel(kimage[i]);
        label[i].setBounds(0,0,850,550);
        add(label[i]);
        }
        
        t1 = new Thread(this);
        t1.start();
        setVisible(true);
    }
    
    
    
    
    public static void main(String args[]){
        new Destinations();
    }
}
