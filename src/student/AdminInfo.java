/**
 *
 * @author Sakti Kr. Chourasia
 */
package student;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class AdminInfo implements ActionListener{
String url = "jdbc:mysql://localhost/student";
        String userid = "root";
        String pwd = "";
        JFrame frm1;
        JLabel lb1,lb2,lb3,lb4,lb5,lb6;
        JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
        JButton btn1,btn2,btn3;
        String name,stream,sem,year;
        JPanel p1;
        InsidePanel p2;
    public AdminInfo() throws IOException
    {
             try
             {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    System.out.println("Driver loaded sucessfully");
             }
             catch(Exception e)
             {
                System.err.println("Problem with the driver");
             }
            frm1 =new JFrame("welcome to Student Payment System(Admin Panel)");
            frm1.setLayout(null);
            frm1.setSize(600,600);
            frm1.setVisible(true);
            frm1.getContentPane().setBackground(new Color(84,103,112));
            frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            try
            {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) 
            {
                System.out.println("Can't set look and feel");
            } 
            p1 = new JPanel(null);
            p1.setBounds(50,50,500,500);
            p1.setBackground(new Color(255,255,255));
            p2 = new InsidePanel();
            p2.setBounds(0,0,500,80);
            lb1= new JLabel("Welcome ");
            lb2 = new JLabel("Admin Information");
            lb2.setFont(new Font("roboto", Font.BOLD, 20));
            lb2.setForeground(Color.WHITE);
            lb3 = new JLabel("Admin ID");
            lb4 = new JLabel("Name");
            tf1 = new JTextField();
            tf2= new JTextField();
            btn1 = new JButton("Add Students");
            btn2 = new JButton("Update Payment");
            btn3 = new JButton("View Payment list");
            tf1.setEditable(false);
            tf2.setEditable(false);
            lb1.setFont(new Font("Courier New", Font.ITALIC, 14));
            lb1.setForeground(Color.WHITE);
            btn1.setFont(new Font("ROBOTO", Font.BOLD, 14));
            btn2.setFont(new Font("ROBOTO", Font.BOLD, 14));
            btn3.setFont(new Font("ROBOTO", Font.BOLD, 14));
            lb1.setBounds(50,0,500,40);
            lb2.setBounds(170,10,400,40);
            lb3.setBounds(100,90,60,30);
            lb4.setBounds(100,130,60,30);
            tf1.setBounds(160,90,250,30);
            tf2.setBounds(160,130,250,30);
            btn1.setBounds(160,180,200,50);
            btn2.setBounds(160,240,200,50);
            btn3.setBounds(160,300,200,50);
            frm1.add(p1);
            frm1.add(lb1);
            p1.add(p2);
            p2.add(lb2);
            p1.add(lb3);
            p1.add(lb4);
            p1.add(tf1);
            p1.add(tf2);
            p1.add(btn1);
            p1.add(btn2);
            p1.add(btn3);
            btn1.addActionListener(this);
            btn2.addActionListener(this);
            btn3.addActionListener(this);
        }
public void lunch(String name,String username)
{
    System.out.print(name);
    tf1.setText(username);
    tf2.setText(name);
}
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton b = (JButton) e.getSource();
        String s = b.getText();
        if(s.equalsIgnoreCase("Add Students"))
        {
           AddStudent as;
            try {
                as = new AddStudent();
            } catch (IOException ex) {
                Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
            }  
           frm1.setVisible(false);
        }
        if(s.equalsIgnoreCase("Update Payment"))
        {
            try {
                UpdatePayment u = new UpdatePayment();
            } catch (IOException ex) {
                Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
            frm1.setVisible(false);
        
        }
        if(s.equalsIgnoreCase("View Payment list"))
        {
            try {
                Payment p = new Payment();
                frm1.setVisible(false);
            } catch (IOException ex) {
                Logger.getLogger(AdminInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
    }
    }


