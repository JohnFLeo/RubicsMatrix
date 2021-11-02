import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class FENSTER extends JFrame  {
    BufferedImage image;
    public FENSTER(){
        setSize(1000,1000);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        image = new BufferedImage(1000,1000,BufferedImage.TYPE_4BYTE_ABGR);

    }
    public Graphics getImageGraphic(){
        return image.getGraphics();
    }
    @Override
    public void paint(Graphics g) {
        g.fillRect(0,0,getWidth(),getHeight());
        g.drawImage(image,0,0,null);
    }



}
