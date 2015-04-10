/**
 *
 * @author Sakti Kr. Chourasia
 */
package student;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
class PPanel extends JPanel {
    BufferedImage image;
    public PPanel()  {
    try{image = ImageIO.read(new File("/Users/user/Desktop/windowsapp/ppanel.png"));
    setBorder(BorderFactory.createLineBorder(Color.black));
    setLayout(null);
    }
    catch(Exception e)
         {
         System.out.println("can't render the image");
         } 
    }
    @Override    public void paintComponent(Graphics g) {
        super.paintComponent(g);       
        g.drawImage(image,0,0,this);
    }  
}
