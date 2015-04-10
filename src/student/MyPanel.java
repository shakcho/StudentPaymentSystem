/**
 *
 * @author Sakti Kr. Chourasia
 */
package student;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
public class MyPanel extends JPanel {
 BufferedImage image;
    public MyPanel() throws IOException {
    image = ImageIO.read(new File("/Users/user/Desktop/windowsapp/topback.png"));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(null);
    }
    @Override   
    public void paintComponent(Graphics g) {
    super.paintComponent(g);       
    g.drawImage(image,0,0,this);
    }  
}
