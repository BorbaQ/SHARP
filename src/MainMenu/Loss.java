package MainMenu;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Loss extends JPanel implements ActionListener {
    Random rand = new Random();

    Font Jap;
    JButton Restart;

    Loss() throws IOException, FontFormatException {
        if (Main.mainWindow == null) {
            this.setBounds(0, 0, 1920, 1080);
        }else{
            this.setBounds(0,0,Main.mainWindow.getWidth(),Main.mainWindow.getHeight());
        }
        this.setLayout(null);

        Jap = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fonts/YOZAKURA-Regular.otf"));
        Jap = Jap.deriveFont((float)(this.getWidth()/45));

        this.add(Box.createVerticalStrut((int)(this.getHeight() /30)));

        JPanel panel = new JPanel();
        panel.setBounds(
                (int)(this.getWidth()/2 - this.getWidth()*3/4/2),
                (int)(this.getHeight()/2 - this.getHeight()*3/4/2),
                (int)(this.getWidth()*3/4),
                (int)(this.getHeight()*3/4));
        panel.setLayout(null);
        panel.setBackground(new Color(245, 205, 105, 120));

        this.add(panel);
        int width1 =  (int)(this.getWidth()*3/4);
        int height1 =  (int)(this.getHeight()*3/4);

        JLabel FontMetricsLabel = new JLabel();
        FontMetricsLabel.setFont(Jap);

        FontMetrics labelSize = FontMetricsLabel.getFontMetrics(FontMetricsLabel.getFont());

        JLabel label = new JLabel(" Sorry Gregory\n Yo ass lost this game \n Restart?");
        label.setBounds(
                width1/2 - labelSize.stringWidth(label.getText())/2,
                height1/2 - labelSize.getHeight(),
                width1,
                (int)(labelSize.getHeight())
        );
        label.setFont(Jap);
        panel.add(label);

        Restart = new JButton("Restart");
        Restart.addActionListener(this);
        Restart.setBounds(
                width1/2 - labelSize.stringWidth("Restart") -100,
                (int)(height1*3/4),
                labelSize.stringWidth("Restart")+100,
                labelSize.getHeight()+60
        );
        panel.add(Restart);
        Restart.setFont(Jap);

        this.setVisible(true);
    }
    ImageIcon bg = new ImageIcon("src/imgs/Loss.jpg");
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Restart) {
            System.out.println("restart");
            try {
                Main.mainWindow.dispose();
                Main.mainWindow = new MainWindow();
                revalidate();
                repaint();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
}
