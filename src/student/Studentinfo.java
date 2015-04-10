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
import java.sql.ResultSet;
import java.sql.SQLException;

public class Studentinfo implements ActionListener{
        String url = "jdbc:mysql://localhost/student";
        String userid = "root";
        String pwd = "";
        JFrame frm1;
        JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
        JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
        JButton btn1,btn2;
        String name,stream,sem,year;
        JPanel p1;
        InsidePanel p2;
    public Studentinfo(String name) throws IOException
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
            frm1 =new JFrame("welcome to Student Payment System(Studens Panel)");
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
            lb1= new JLabel("Welcome "+name);
            lb2 = new JLabel("Student Information");
            lb2.setFont(new Font("roboto", Font.BOLD, 20));
            lb2.setForeground(Color.WHITE);
            lb3 = new JLabel("Name");
            lb4 = new JLabel("Stream");
            lb5 = new JLabel("Year");
            lb6 = new JLabel("Sem");
            lb7 = new JLabel("");
            lb8 = new JLabel("");
            lb9 = new JLabel("DD No.");
            lb10 = new JLabel("Date");
            lb11 = new JLabel("");
            tf1 = new JTextField();
            tf2= new JTextField();
            tf3= new JTextField();
            tf4= new JTextField();
            tf5= new JTextField();
            tf6= new JTextField();
            tf7= new JTextField();
            tf1.setEditable(false);
            tf2.setEditable(false);
            tf3.setEditable(false);
            tf4.setEditable(false);
            lb1.setFont(new Font("Courier New", Font.ITALIC, 14));
            lb1.setForeground(Color.WHITE);
            lb1.setBounds(50,0,500,40);
            lb2.setBounds(170,10,400,40);
            lb3.setBounds(100,90,50,30);
            lb4.setBounds(100,130,50,30);
            lb5.setBounds(100,170,50,30);
            lb6.setBounds(100,210,50,30);
            tf1.setBounds(150,90,250,30);
            tf2.setBounds(150,130,250,30);
            tf3.setBounds(150,170,250,30);
            tf4.setBounds(150,210,250,30);
            lb7.setBounds(70,250,400,25);
            lb8.setBounds(80,280,400,30);
            /*code for payment form */
            lb9.setBounds(60,320,60,30);
            lb10.setBounds(280,320,60,30);
            lb11.setBounds(220,435,400,30);
            tf6.setBounds(60,350,200,30);
            tf7.setBounds(280,350,200,30);
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
            p1.add(lb8);
            p1.add(lb9);
            p1.add(lb10);
            p1.add(tf6);
            p1.add(tf7);
            p1.add(lb11);
            btn1 = new JButton("Submit");
            //btn2 = new JButton("Cancel");
            btn1.setBounds(230,390,100,50);
            p1.add(btn1);
            //p1.add(btn2);
            btn1.addActionListener(this);
            //btn2.addActionListener(this);
        }
public void lunch(String name, String year, String sem, String stream)
{
    System.out.print(name);
    tf1.setText(name);
    tf2.setText(stream);
    tf3.setText(year);
    tf4.setText(sem);
    lb7.setFont(new Font("Courier New", Font.BOLD, 18));
    lb7.setForeground(Color.GRAY);
    if(sem.equals("1st"))
    lb7.setText("You need to pay amount of Rs 37,000");
    if(sem.equals("2nd"))
    lb7.setText("You need to pay amount of Rs 37,000 ");
    if(sem.equals("3rd"))
    lb7.setText("You need to pay amount of Rs 38,000");
    if(sem.equals("4th"))
    lb7.setText("You need to pay amount of Rs 38,000");
    if(sem.equals("5th"))
    lb7.setText("You need to pay amount of Rs 39,000");
    if(sem.equals("6th"))
    lb7.setText("You need to pay amount of Rs 39,000");
    if(sem.equals("7th"))
    lb7.setText("You need to pay amount of Rs 40,000");
    if(sem.equals("8th"))
    lb7.setText("You need to pay amount of Rs 40,000");
    lb8.setFont(new Font("Ariel", Font.BOLD, 14));
    lb8.setForeground(Color.GRAY);
    lb8.setText("Enter the Demand Draft details in the form below");
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        JButton b = (JButton) e.getSource();
        String s = b.getText();
        if(s.equalsIgnoreCase("submit"))
        {
            if(tf6.getText()!=null )
            {
                try
                {       String dd = tf6.getText();
                        String dno = null;
                        String date = null;
                        Connection con = DriverManager.getConnection(url, userid, pwd);
                        System.out.println("database connected to student");
                        PreparedStatement stmt = con.prepareStatement("Select * from demand Where dd='" + dd + "'");
                        ResultSet rs = stmt.executeQuery();
                        while(rs.next())
                        {
                           dno= rs.getString("dd");
                           date=rs.getString("dos");
                        }
                        con.close();
                        if(dno.equalsIgnoreCase(tf6.getText()) && date.equalsIgnoreCase(tf7.getText()))
                        {
                          lb11.setForeground(Color.GREEN); 
                          lb11.setText("Transaction Sucessfull");
                        }
                        else
                        {
                        lb11.setForeground(Color.RED);
                        lb11.setText("Invalid credential");
                        }
                }
                catch(SQLException er)
                {
                    System.out.println("Sql Error");
                }
            }
            
        }
    }
}
