/**
 *
 * @author sakti Kr.Chourasia
 */
package student;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class view  implements ActionListener{
      JFrame frm;
        JLabel l3;
        JButton b1,b2;
        MyPanel p1,p2; 
        Image img;
        public view() throws IOException
        {
            frm =new JFrame("Student Payment System");
            frm.setLayout(null);
            frm.setSize(600,400);
            frm.setVisible(true);
            frm.getContentPane().setBackground(new Color(84,103,112));
            frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            try {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } catch (Exception e) {
                System.out.println("Can't set look and feel");
            }
            p1 = new MyPanel();
            p1.setBackground(Color.WHITE);
            p2 = new MyPanel();
            p1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
            p2.setBounds(0, 0,500,100);
            p1.setBounds(50,50,500,300);
            l3 = new JLabel("Student Payment System");
            l3.setFont(new Font("Courier New", Font.BOLD, 25));
            l3.setForeground(Color.WHITE);
            b1 = new JButton("Student Zone");
            b2 = new JButton("Administrator Zone");                       
        }
        public void lunch()
        {
            l3.setBounds(50, 30, 460, 30);
            b1.setBounds(170, 150, 200, 50);
            b2.setBounds(170, 210,200, 50);
            frm.add(p1);
            p1.add(p2);
            p2.add(l3);
            p1.add(b1);
            p1.add(b2);
            b1.addActionListener(this);
            b2.addActionListener(this);
        }
     @Override
     public void actionPerformed(ActionEvent e) 
        {
        JButton b = (JButton) e.getSource();
        String s = b.getText();
        if(s.equalsIgnoreCase("Student Zone"))
        {
            Student  f;
            try {
                f = new Student();
                f.lunch();
            } catch (IOException ex) {
                Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error in lunching admin panel");
            }
            finally{
                frm.setVisible(false);
            }
        }
        else if(s.equalsIgnoreCase("Administrator Zone"))
        {
            Admin a;  
             try {
                a = new Admin();
                a.lunch();
            } 
             catch (IOException ex) {
                Logger.getLogger(view.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error in lunching admin panel");
            }
            finally{
                frm.setVisible(false);
            }
        }
}
         public static void main(String[] args) throws IOException
    {
        view v = new view();
        v.lunch();         
    }
}
