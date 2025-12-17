package MainMenu;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Menu extends JPanel implements ActionListener {
    JButton StartGame;
    JButton Settings;
    JButton Exit;
    Menu() throws IOException, FontFormatException {
        if (Main.mainWindow == null) {
            this.setBounds(0, 0, 1920, 1080);
        }else{
            this.setBounds(0,0,Main.mainWindow.getWidth(),Main.mainWindow.getHeight());
        }
//        this.setLayout(null);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));


        JLabel BgImage = new JLabel(new ImageIcon("src/imgs/mainMenu2.png"));
        BgImage.setBounds(0,0,this.getWidth(),this.getHeight());

        Font Jap = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fonts/YOZAKURA-Regular.otf"));
        Jap = Jap.deriveFont((float)(this.getWidth()/10));

        JPanel fgPanel = new JPanel();
        fgPanel.setBounds(0,0,this.getWidth(),this.getHeight());
        fgPanel.setOpaque(false);
        fgPanel.setLayout(new BoxLayout(fgPanel,BoxLayout.Y_AXIS));


//        fgPanel.add(Box.createVerticalStrut((int)(this.getHeight() * 0.25)));
        this.add(Box.createVerticalStrut((int)(this.getHeight() * 0.25)));

        JLabel label = new JLabel(" SKY HIGH AMBITION RIP-OFF ");
        label.setPreferredSize(new Dimension(100,100));
        label.setFont(Jap);
//        label.setForeground(new Color(207,0,183));
        label.setBackground(new Color(0,241,245,150));
        label.setOpaque(true);
//        label.out
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
//        fgPanel.add(label);
        this.add(label);

        this.add(Box.createVerticalStrut((int)(this.getHeight() /20)));
//        fgPanel.add(Box.createVerticalStrut((int)(this.getHeight() /20)));

        Font Jap2 = Jap.deriveFont((float)(this.getWidth()/20));

        StartGame = new JButton("Start Game");
        StartGame.setPreferredSize(new Dimension(100,50));
        StartGame.setAlignmentX(Component.CENTER_ALIGNMENT);
//        StartGame.setForeground(new Color(207,0,183));
        StartGame.setBackground(new Color(0,241,245,100));
        StartGame.setOpaque(true);
        StartGame.addActionListener(this);
        StartGame.setFont(Jap2);
//        fgPanel.add(StartGame);


        this.add(StartGame);

//        fgPanel.add(Box.createVerticalStrut((int)(this.getHeight() /30)));
        this.add(Box.createVerticalStrut((int)(this.getHeight() /30)));

        Settings = new JButton("Settings");
        Settings.setPreferredSize(new Dimension(100,50));
        Settings.setAlignmentX(Component.CENTER_ALIGNMENT);
//        Settings.setForeground(new Color(207,0,183));
        Settings.setBackground(new Color(0,241,245,100));
        Settings.setOpaque(true);
        Settings.setFont(Jap2);
        Settings.addActionListener(this);
//        fgPanel.add(Settings);
        this.add(Settings);

//        fgPanel.add(Box.createVerticalStrut((int)(this.getHeight() /20)));
        this.add(Box.createVerticalStrut((int)(this.getHeight() /20)));

        Exit = new JButton("Quit");
        Exit.setPreferredSize(new Dimension(100,50));
        Exit.setAlignmentX(Component.CENTER_ALIGNMENT);
//        Exit.setForeground(new Color(207,0,183));
        Exit.setBackground(new Color(0,241,245,100));
        Exit.setOpaque(true);
        Exit.setFont(Jap2);
        Exit.addActionListener(this);
        this.add(Exit);
//        fgPanel.add(Exit);

//        this.add(fgPanel);
//        this.add(BgImage);


        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Exit){
            System.exit(0);
        }else if (e.getSource()==StartGame){
            try {
                Main.mainWindow.game = new Game();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            } catch (InvocationTargetException ex) {
                throw new RuntimeException(ex);
            } catch (NoSuchMethodException ex) {
                throw new RuntimeException(ex);
            } catch (InstantiationException ex) {
                throw new RuntimeException(ex);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
            Main.mainWindow.reloadPanel(Main.mainWindow.game);
        }else if (e.getSource()==Settings){
            try {
                Main.mainWindow.reloadPanel(new Options());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    ImageIcon bg = new ImageIcon("src/imgs/mainMenu2.png");
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

}
