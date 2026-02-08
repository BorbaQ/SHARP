package MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow extends JFrame implements ActionListener {
    JPanel currentPanel = new JPanel();
    JButton Options;
    Boolean fullscreen = false;
    public Game game;
    public MainWindow() throws IOException, FontFormatException {
//        base window shit
        this.setSize(1920, 1080);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setResizable(false);
        this.setIconImage(new ImageIcon("src/imgs/randomBS/blowMe.png").getImage());
//      IMPORTANT IMPORTANT!!!!! CHANGE TO MENU AFTER DEVELEOPING GAME
        currentPanel = new Menu();
        this.add(currentPanel);

        this.setVisible(true);
    }
    public void reloadPanel(JPanel panel) {
        this.remove(currentPanel);
        currentPanel = panel;
        this.add(currentPanel);
        this.revalidate();
        this.repaint();
    }
    public void setFullAndRes(int[] res){
        this.setSize(res[0],res[1]);
    }
    public void setFullAndRes(int[] res, boolean full){
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        if (full) {
            this.dispose();
            this.setUndecorated(true);
            this.setResizable(false);
            gd.setFullScreenWindow(this);
        } else {
            gd.setFullScreenWindow(null);
            this.dispose();
            this.setUndecorated(false);
            this.setSize(res[0], res[1]);
            this.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
