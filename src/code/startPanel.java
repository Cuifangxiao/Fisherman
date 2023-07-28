package code;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class startPanel extends JPanel {
    BufferedImage bg = ImageUtils.getImage("/resource/StartLayerBg1.png");
    BufferedImage gName = ImageUtils.getImage("/resource/GameName.png");
    public startPanel(){
        repaint();
    }

    public void paint(Graphics g){
        g.setColor(Color.black);
        g.drawImage(bg,0,0,null);
        g.drawImage(gName,200,-30,null);
    }

}
