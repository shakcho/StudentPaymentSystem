/**
 *
 * @author Sakti Kr. Chourasia
 */
package student;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddStudent implements ActionListener{
        String url = "jdbc:mysql://localhost/student";
        String userid = "root";
        String pwd = "";
        JFrame frm1;
        JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
        JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
        JButton btn1,btn2,btn3;
        JPanel p1;
        InsidePanel p2;
    public AddStudent() throws IOException
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
            catch (Exception e) 
            {
                System.out.println("Can't set look and feel");
            } 
            p1 = new JPanel(null);
            p1.setBounds(50,50,500,500);
            p1.setBackground(new Color(255,255,255));
            p2 = new InsidePanel();
            p2.setBounds(0,0,500,80);
            lb1= new JLabel("Welcome ");
            lb2 = new JLabel("Add New Student Information");
            lb2.setFont(new Font("roboto", Font.BOLD, 15));
            lb2.setForeground(Color.WHITE);
            lb3 = new JLabel("Name");
            lb4 = new JLabel("Stream");
            lb5 = new JLabel("Year");
            lb6 = new JLabel("Sem");
            lb7 = new JLabel("");
            tf1 = new JTextField();
            tf2= new JTextField();
            tf3= new JTextField();
            tf4= new JTextField();
            tf5= new JTextField();
            tf6= new JTextField();
            tf7= new JTextField();
            btn3 = new JButton("Back");
            btn1 = new JButton("Submit");
            btn2 = new JButton("Cancel");
            lb1.setFont(new Font("Courier New", Font.ITALIC, 14));
            lb1.setForeground(Color.WHITE);
            lb1.setBounds(50,0,300,40);
            lb2.setBounds(170,10,400,40);
            lb3.setBounds(100,90,50,30);
            lb4.setBounds(100,130,50,30);
            lb5.setBounds(100,170,50,30);
            lb6.setBounds(100,210,50,30);
            tf1.setBounds(150,90,250,30);
            tf2.setBounds(150,130,250,30);
            tf3.setBounds(150,170,250,30);
            tf4.setBounds(150,210,250,30);
            lb7.setBounds(100,310,400,25);
            btn1.setBounds(150,250,100,50);
            btn2.setBounds(260,250,100,50);
            btn3.setBounds(400,10,100,40);
            frm1.add(p1);
            frm1.add(lb1);
            p1.add(p2);
            p2.add(lb2);
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
            p1.add(btn1);
            p1.add(btn2);
            frm1.add(btn3);
            btn1.addActionListener(this);
            btn2.addActionListener(this);
            btn3.addActionListener(this);
        }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String username,password,name,sem, year,stream;
        name = tf1.getText();
        sem=tf2.getText();
        year = tf3.getText();
        stream = tf4.getText();
        String[] splited = name.split(" ");
        username = splited[0];
        password = "123456";
        JButton b = (JButton) e.getSource();
        String s = b.getText();
        if(s.equalsIgnoreCase("submit"))
        {
            if(tf6.getText()!=null )
            {
               try{
                   Connection con = DriverManager.getConnection(url, userid, pwd);
                   System.out.println("database connected to students");
                   PreparedStatement stmt = con.prepareStatement("insert into studentsdata(username,pwd,fname,stream,sem,year) values(?,?,?,?,?,?)");
                   stmt.setString(1,username);
                   stmt.setString(2,password);
                   stmt.setString(3,name);
                   stmt.setString(4,stream);
                   stmt.setString(5,sem);
                   stmt.setString(6,year);
                   stmt.execute();
                   lb7.setFont(new Font("Courier New", Font.BOLD, 18));
                   lb7.setForeground(Color.GREEN);
                   lb7.setText("Data addded successfully");
               }
               catch(SQLException er)
               {
                System.out.println("Can not insert data into database");
               }
            }
            
        }
        if(s.equalsIgnoreCase("cancel"))
        {
            tf1.setText(null);
            tf2.setText(null);
            tf3.setText(null);
            tf4.setText(null);
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
