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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
public class Payment  implements ActionListener {
    JFrame frm1;
    JPanel p1;
    PPanel p2;  
    JTable tb1;
    JLabel lb1;
    String url = "jdbc:mysql://localhost/student";
    String userid = "root";
    String pwd = "";
    ResultSet rs;
    JButton btn3;
public Payment() throws IOException
{
            try
             {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                    System.out.println("Driver loaded sucessfully");
             }
             catch(ClassNotFoundException | InstantiationException | IllegalAccessException e)
             {
                System.err.println("Problem with the driver");
             }
             try
            {
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            } 
            catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) 
            {
                System.out.println("Can't set look and feel");
            } 
             try{
             Connection con = DriverManager.getConnection(url, userid, pwd);
                        System.out.println("database connected to student");
                        PreparedStatement stmt = con.prepareStatement("Select * from demand");
                        rs = stmt.executeQuery();
             }
             catch(SQLException er)
             {
                 System.out.println("Can not retrive data "+er.getMessage());
             }
            frm1 =new JFrame("welcome to Student Payment System(Admin Panel)");
            frm1.setLayout(null);
            frm1.setSize(900,600);
            frm1.setVisible(true);
            frm1.getContentPane().setBackground(new Color(84,103,112));
            frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
            p1 = new JPanel(null);
            p1.setBounds(50,50,800,500);
            p1.setBackground(new Color(255,255,255));
            p2 = new PPanel();
            p2.setBounds(0,0,800,80);
            btn3 = new JButton("Back");
            btn3.setBounds(700,10,100,40);
            tb1 = new JTable();
            tb1.setBounds(0,90,800,400);
            JScrollPane scrollpane = new JScrollPane(tb1);
            tb1.setFillsViewportHeight(true);
            tb1.setModel(returndata(rs));
            lb1= new JLabel("Payment Details View");
            lb1.setBounds(280,20,400,30);
            lb1.setFont(new Font("ROBOTO", Font.BOLD, 27));
            lb1.setForeground(Color.WHITE);
            frm1.add(p1);
            p2.add(lb1);
            p1.add(p2);
            p1.add(tb1);
            frm1.add(btn3);
            btn3.addActionListener(this);
            
    }
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton b = (JButton) e.getSource();
        String s = b.getText();
            if(s.equalsIgnoreCase("back"))
           {
                    
                    try
                    {
                        AdminInfo a = new AdminInfo();
                        
                    }
                     catch (IOException ex)
                     {
                        Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      finally{
            frm1.setVisible(false);
            }
            }
        
    }
 public DefaultTableModel returndata(ResultSet rs) 
    {
        DefaultTableModel model = new DefaultTableModel(); 
        {
            try {
                
                ResultSetMetaData rsMD = rs.getMetaData();
                int contcolum = rsMD.getColumnCount(); 
                Object[] objeto = new Object[contcolum]; 
                for (int i=0; i < contcolum; i++)
                {
                    objeto[i] = rsMD.getColumnLabel(i+1);
                }
                model.setColumnIdentifiers(objeto);
                while (rs.next()) 
                {
                    Object[] datosFila = new Object[model.getColumnCount()];
                    for (int i=0; i< model.getColumnCount(); i++)
                    {
                        datosFila[i] = rs.getObject(i+1);
                    }
                    model.addRow(datosFila);
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return model; 
    }
}

