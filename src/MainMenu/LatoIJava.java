package MainMenu;

import javax.swing.*;
import java.awt.*;

public class LatoIJava extends JPanel {
    int width;
    int height;
    Image chainImage;

    public LatoIJava(int Windowwidth, int Windowheight) {
        int tileHeight = (int)(Windowheight*0.1);
        int tileWidth = (int)( (double) (tileHeight * 3) /4 +5);
        width = tileWidth;
        height = tileHeight;
        chainImage = new ImageIcon("src/imgs/chains.png").getImage();
        System.out.println(chainImage + " ughm what the smigma");
        System.out.println(
                chainImage.getWidth(null) + " x " + chainImage.getHeight(null)
        );


        this.setBounds(0,0,tileWidth, tileHeight);
        setOpaque(false);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
//        g2.setColor(Color.GREEN);
//        g2.fillRect(0, 0, width, height);

        g2.drawImage(chainImage, 0, 0, width, height,null);
        g2.dispose();
    }

}
