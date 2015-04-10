/**
 *
 * @author Sakti Kr.Chourasia
 */
package student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
public class UpdatePayment implements ActionListener {
        String url = "jdbc:mysql://localhost/student";
        String userid = "root";
        String pwd = "";
        JFrame frm1;
        JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb,lb8;
        JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
        JButton btn1,btn2,btn3;
        String name,stream,sem,year,dd,dos,amount;
        JPanel p1;
        InsidePanel p2;
        public UpdatePayment() throws IOException
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
            lb = new JLabel("Update Payment details");
            lb.setFont(new Font("Courier New", Font.BOLD, 19));
            lb.setForeground(Color.WHITE);
            lb.setBounds(150,10,400,40);
            lb1= new JLabel("Name");
            lb2 = new JLabel("year");
            lb3 = new JLabel("Stream");
            lb4 = new JLabel("sem");
            lb5 = new JLabel("DD No.");
            lb6 = new JLabel("Date");
            lb7 = new JLabel("Amount");
            lb8 = new JLabel("");
            tf1 = new JTextField();
            tf2 = new JTextField();
            tf3 = new JTextField();
            tf4 = new JTextField();
            tf5 = new JTextField();
            tf6 = new JTextField();
            tf7 = new JTextField();
            btn1 = new JButton("Submit");
            btn2 = new JButton("Cancel");
            btn3 = new JButton("Back");
            lb1.setBounds(100,90,50,30);
            lb2.setBounds(100,130,50,30);
            lb3.setBounds(100,170,50,30);
            lb4.setBounds(100,210,50,30);
            lb5.setBounds(100,250,50,30);
            lb6.setBounds(100,290,50,30);
            lb7.setBounds(100,330,50,30);
            tf1.setBounds(150,90,250,30);
            tf2.setBounds(150,130,250,30);
            tf3.setBounds(150,170,250,30);
            tf4.setBounds(150,210,250,30);
            tf5.setBounds(150,250,250,30);
            tf6.setBounds(150,290,250,30);
            tf7.setBounds(150,330,250,30);
            btn1.setBounds(150,370,100,50);
            btn2.setBounds(260,370,100,50);
            lb8.setBounds(160,420,350,30);
            btn3.setBounds(400,10,100,40);
            frm1.add(p1);
            frm1.add(btn3);
            p1.add(p2);
            p1.add(lb1);
            p1.add(lb2);
            p1.add(lb3);
            p1.add(lb4);
            p1.add(lb5);
            p1.add(lb6);
            p1.add(lb7);
            p1.add(tf1);
            p1.add(tf2);
            p1.add(tf3);
            p1.add(tf4);
            p1.add(tf5);
            p1.add(tf6);
            p1.add(tf7);
            p1.add(btn1);
            p1.add(btn2);
            p2.add(lb);
            p1.add(lb8);
            lb8.setFont(new Font("ROBOTO", Font.BOLD, 19));
            lb8.setForeground(Color.GREEN);
            btn1.addActionListener(this);
            btn2.addActionListener(this); 
            btn3.addActionListener(this);
       }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        
        JButton b = (JButton) e.getSource();
        String s = b.getText();
        if(s.equalsIgnoreCase("Submit"))
        {
            name=tf1.getText();
            year= tf2.getText();
            sem=tf3.getText();
            stream = tf4.getText();
            dd = tf5.getText();
            dos = tf6.getText();
            amount = tf7.getText();
               try{
                   Connection con = DriverManager.getConnection(url, userid, pwd);
                   System.out.println("database connected to students");
                   PreparedStatement stmt = con.prepareStatement("insert into demand(fname,year,sem,stream,dd,dos,amount) values(?,?,?,?,?,?,?)");
                   stmt.setString(1,name);
                   stmt.setString(2,year);
                   stmt.setString(3,sem);
                   stmt.setString(4,stream);
                   stmt.setString(5,dd);
                   stmt.setString(6,dos);
                   stmt.setString(7,amount);
                   stmt.execute();
                   //System.out.println("data added succcessfully");
                   
                   lb8.setText("Data addded successfully");
               }
               catch(SQLException er)
               {
                System.out.println("Can not insert data into database "+er.getMessage());
               }
        }
        if(s.equalsIgnoreCase("cancel"))
        {
           tf1.setText(null);
           tf2.setText(null);
           tf3.setText(null);
           tf4.setText(null);
           tf5.setText(null);
           tf6.setText(null);
           tf7.setText(null);
        }
            if(s.equalsIgnoreCase("back"))
        {
            
            try {
                AdminInfo a = new AdminInfo();
                //a.lunch();
            } catch (IOException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
              finally{
            frm1.setVisible(false);
            }
        }
    }
}
