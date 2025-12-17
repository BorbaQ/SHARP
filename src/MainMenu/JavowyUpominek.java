package MainMenu;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class JavowyUpominek extends JPanel {
    private String text;
    Font Jap;
    int width;
    int height;
    FontMetrics labelSize;

    public JavowyUpominek(String Power, int Windowwidth, int Windowheight) {
        int tileHeight = (int)((Windowwidth * 0.9) / 8);
        int tileWidth = (int) ((Windowheight * 0.7 * 0.8 * 0.5));
        width = tileWidth;
        height = tileHeight;

        this.text = Power;
        this.setBounds(0,0,600, 600);
        setOpaque(false);
        setLayout(null);
        Font temp;
        try {
            Jap = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fonts/YOZAKURA-Regular.otf")).deriveFont((float)(Windowheight/20));
        } catch (FontFormatException | IOException e) {
            System.out.println("font fail upominek");
            e.printStackTrace();
            Jap = new Font("Arial", Font.BOLD, 40);
        }
        JLabel FontMetricsLabel = new JLabel();
        FontMetricsLabel.setFont(Jap);
        labelSize = FontMetricsLabel.getFontMetrics(FontMetricsLabel.getFont());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (text != null) {
            Graphics2D g2 = (Graphics2D) g.create();

            g2.setColor(Color.RED);
            g2.setFont(Jap);
            g2.drawString("Power: "+text,
                    (int)(width*0.5-labelSize.stringWidth("Power: "+text)+30)
//                    10
                    ,
//                    height/5
                    (int)(height*1.1)
            )
            ;

            g2.dispose();
        }
    }
}
