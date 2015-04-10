/**
 *
 * @author user
 */
package student;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
class InsidePanel extends JPanel {
 BufferedImage image;
    public InsidePanel()  {
    try{image = ImageIO.read(new File("/Users/user/Desktop/windowsapp/topbackin.png"));
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
