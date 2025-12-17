package MainMenu;

import javax.swing.*;
import java.awt.*;

public class CzyKochalaBysMniebardziejZaJave extends JPanel {
    int width;
    int height;

    public CzyKochalaBysMniebardziejZaJave(int Windowwidth, int Windowheight) {
        int tileHeight = (int)(Windowheight*0.1);
        int tileWidth = (int)( tileHeight*3/4*1.5);
        width = tileWidth;
        height = tileHeight;

        this.setBounds(0,0,tileWidth, tileHeight);
        setOpaque(false);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(Color.BLUE);
        g2.fillOval(0,
               20
//                0
                ,width/4,height/4);
        g2.dispose();
    }

}
