package MainMenu;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PisarzJavy extends JPanel {
    private String text;
    Font Jap;
    int width;
    int height;

    public PisarzJavy(String text, int Windowwidth, int Windowheight) {
        int tileHeight = (int)(Windowheight*0.1);
        int tileWidth = (int)( tileHeight*3/4*1.5);
        width = tileWidth;
        height = tileHeight;
        this.text = text;
        this.setBounds(0,0,600, 600);
        setOpaque(false);
        setLayout(null);
        Font temp;
        try {
            Jap = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fonts/YOZAKURA-Regular.otf")).deriveFont((float)(Windowheight/20));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            Jap = new Font("Arial", Font.BOLD, 40);
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (text != null) {
            Graphics2D g2 = (Graphics2D) g.create();
//            g2.fillOval(0,0,100,100);

            g2.rotate(Math.toRadians(90), width/2, height/2);
            g2.setColor(Color.RED);
            g2.setFont(Jap);
            g2.drawString(text,
//                    (int)(width*0.5)
                    10
                    ,
//                    height/5
                    55
            )
            ;

            g2.dispose();
        }
    }
}
