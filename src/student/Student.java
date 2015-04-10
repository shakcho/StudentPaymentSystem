/**
 *
 * @author Sakti Kr.Chourasia
 */
package student;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student implements ActionListener{
        String url = "jdbc:mysql://localhost/student";
        String userid = "root";
        String pwd = "";
        JFrame frm;
        JLabel l1,l2,l3;
        JTextField t1;
        JPasswordField t2;
        JButton b1,b2;
        MyPanel p1,p2; 
        Image img;
        public Student() throws IOException
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
            l1 = new JLabel("Student ID");
            l2 = new JLabel("Password");
            l3 = new JLabel("Student Payment System-Students Zone");
            l3.setFont(new Font("Courier New", Font.BOLD, 20));
            l3.setForeground(Color.WHITE);
            t1 = new JTextField();
            t2 = new JPasswordField();
            b1 = new JButton("Submit");
            b2 = new JButton("Cancel");                       
        }
        public void lunch()
        {
            l1.setBounds(100,100,80,40);
            l2.setBounds(100,150,80,40);
            t1.setBounds(220, 100, 250, 40);
            t2.setBounds(220, 150, 250, 40);
            b1.setBounds(250, 200, 100, 50);
            b2.setBounds(360, 200,100, 50);
            l3.setBounds(50, 30, 460, 30);
            frm.add(p1);
            p1.add(l1);
            p1.add(l2);
            p1.add(t1);
            p1.add(t2);
            p1.add(b1);
            p1.add(b2);
            p1.add(l3);
            b1.addActionListener(this);
            b2.addActionListener(this);
        }
     @Override
     public void actionPerformed(ActionEvent e) 
        {
        JButton b = (JButton) e.getSource();
        String s = b.getText();
        if(s.equalsIgnoreCase("submit"))
        {
            if(t1.getText()!=null )
            {
                try
                {       String user = t1.getText();
                        String username = null;
                        String password = null;
                        String name = null;
                        String year = null;
                        String sem= null;
                        String stream = null;
                        Connection con = DriverManager.getConnection(url, userid, pwd);
                        System.out.println("database connected to student");
                        PreparedStatement stmt = con.prepareStatement("Select * from studentsdata Where username='" + user + "'");
                        ResultSet rs = stmt.executeQuery();
                        while(rs.next())
                        {
                            username = rs.getString("username");
                            password = rs.getString("pwd");
                            name = rs.getString("fname");
                            year = rs.getString("year");
                            sem = rs.getString("sem");
                            stream = rs.getString("stream");
                           
                        }
                        con.close();   
                        if(username.equalsIgnoreCase(t1.getText()) && password.equalsIgnoreCase(t2.getText()))
                        {
                            try
                            {
                                Studentinfo h = new Studentinfo(name);
                                h.lunch(name,year,sem,stream);
                                
                            }
                             catch (IOException ex) 
                             {
                                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                             }
                            finally
                            {
                                frm.setVisible(false);
                            }
                        }                   
                        else 
                        {
                            JOptionPane.showMessageDialog(frm, "Invalid Username/Password");
                        }
                    
                }
                catch (SQLException err) 
                {
                        System.out.println("no database connection" +err.getMessage());
                } 
               
            }

        } 
        else if(s.equalsIgnoreCase("cancel"))
        {
                t1.setText("");
                t2.setText("");
        }

    }

}
