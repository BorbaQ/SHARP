package MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Options extends JPanel implements ActionListener {
    JComboBox<String> resolutionDropdown;
    JLabel selectedLabel;
    Font Jap;
    JButton goBackButton;
    JCheckBox fullscreenCheckbox;
    Options() throws IOException, FontFormatException {
        if (Main.mainWindow == null) {
            this.setBounds(0, 0, 1920, 1080);
        }else{
            this.setBounds(0,0,Main.mainWindow.getWidth(),Main.mainWindow.getHeight());
        }
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        Jap = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fonts/YOZAKURA-Regular.otf"));
        Jap = Jap.deriveFont((float)(this.getWidth()/40));

        this.add(Box.createVerticalStrut((int)(this.getHeight() * 0.3)));

        JPanel OptionHolder = new JPanel();
        OptionHolder.setMaximumSize(new Dimension( (int)(this.getWidth()*0.7), (int)(this.getHeight()*0.7)));
        OptionHolder.setBackground(new Color(0,241,245,150));
        OptionHolder.setLayout(new BoxLayout(OptionHolder,BoxLayout.Y_AXIS));
        OptionHolder.setOpaque(false);
        this.add(OptionHolder);

//        resolution Start

        JPanel ResolutionHolder = new JPanel();
        ResolutionHolder.setLayout(new BoxLayout(ResolutionHolder,BoxLayout.X_AXIS));
        ResolutionHolder.setMaximumSize(new Dimension( (int)(this.getWidth()*0.7), (int)(this.getHeight()*0.1)));
        ResolutionHolder.setBackground(new Color(0,241,245,150));
        ResolutionHolder.setOpaque(true);
        OptionHolder.add(ResolutionHolder);

        JLabel Reslabel = new JLabel(" Choose Resolution ");
        Reslabel.setPreferredSize(new Dimension(100,100));
        Reslabel.setFont(Jap);
        Reslabel.setBackground(new Color(0,241,245,0));
        Reslabel.setOpaque(true);
        Reslabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ResolutionHolder.add(Reslabel);


        String[] resolutions = {
                "800 x 600",
                "1024 x 768",
                "1280 x 720",
                "1920 x 1080",
                "2560 x 1440",
                "3840 x 2160"
        };

        FontMetrics labelSize = Reslabel.getFontMetrics(Reslabel.getFont());

        resolutionDropdown = new JComboBox<>(resolutions);
        resolutionDropdown.setSelectedIndex(3);
        resolutionDropdown.setFont(Jap);
        resolutionDropdown.setMaximumSize(new Dimension(
                (int)((this.getWidth()*0.7)-labelSize.stringWidth(" Choose Resolution ")-2),(int)(this.getHeight()*0.1)));
        ResolutionHolder.add(resolutionDropdown);
        resolutionDropdown.addActionListener(this);

//        Resolution End
//        FullScreen Start

        JPanel FullscreenHolder = new JPanel();
        FullscreenHolder.setLayout(new BoxLayout(FullscreenHolder,BoxLayout.X_AXIS));
        FullscreenHolder.setMaximumSize(new Dimension( (int)(this.getWidth()*0.7), (int)(this.getHeight()*0.1)));
        FullscreenHolder.setBackground(new Color(0,241,245,150));
        FullscreenHolder.setOpaque(true);
        OptionHolder.add(FullscreenHolder);

        JLabel FullLabel = new JLabel(" Fullscreen? ");
        FullLabel.setPreferredSize(new Dimension(100,100));
        FullLabel.setFont(Jap);
        FullLabel.setBackground(new Color(0,241,245,0));
        FullLabel.setOpaque(true);
        FullLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        FullscreenHolder.add(FullLabel);

        fullscreenCheckbox = new JCheckBox();
        fullscreenCheckbox.setOpaque(false);
        fullscreenCheckbox.addActionListener(this);
        if (Main.mainWindow != null) {
            fullscreenCheckbox.setSelected(Main.mainWindow.fullscreen);
        }
        ImageIcon yesico1 = new ImageIcon("src/imgs/fullcheck.png");
        ImageIcon noIco1 = new ImageIcon("src/imgs/emptyCheck.png");
        Image yesico2 = yesico1.getImage().getScaledInstance((int)(this.getWidth()/40),(int)(this.getWidth()/40),Image.SCALE_SMOOTH);
        Image noico2 = noIco1.getImage().getScaledInstance((int)(this.getWidth()/40),(int)(this.getWidth()/40),Image.SCALE_SMOOTH);
        fullscreenCheckbox.setSelectedIcon(new ImageIcon(yesico2));
        fullscreenCheckbox.setIcon(new ImageIcon(noico2));
        FullscreenHolder.add(fullscreenCheckbox);

//        Fullscree END
//        GO BACK
        JPanel GoBackHolder = new JPanel();
        GoBackHolder.setLayout(new BoxLayout(GoBackHolder,BoxLayout.X_AXIS));
        GoBackHolder.setMaximumSize(new Dimension( (int)(this.getWidth()*0.7), (int)(this.getHeight()*0.1)));
        GoBackHolder.setBackground(new Color(0,241,245,150));
        GoBackHolder.setOpaque(true);
        OptionHolder.add(GoBackHolder);


        goBackButton = new JButton(" Go Back ");
        goBackButton.setOpaque(true);
        goBackButton.setBackground(new Color(0,241,245,0));
        goBackButton.addActionListener(this);
        goBackButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        goBackButton.setFont(Jap);
        setMaximumSize(new Dimension(100,100));
        GoBackHolder.add(Box.createHorizontalStrut((int)((this.getWidth()*0.35)- (double) labelSize.stringWidth(" Go Back ") /2)));
        GoBackHolder.add(goBackButton);


        this.setVisible(true);
    }
    ImageIcon bg = new ImageIcon("src/imgs/randomBS/loading_CG.jpg");
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==resolutionDropdown){
            Main.mainWindow.fullscreen = false;
            System.out.println("dic");
            switch (resolutionDropdown.getSelectedIndex()){
                case 0:
                    System.out.println("balls");
                    Main.mainWindow.setFullAndRes(new int[] {800,600},false);

                    break;
                case 1:
                    Main.mainWindow.setFullAndRes(new int[] {1024,768},false);
                    break;
                case 2:
                    Main.mainWindow.setFullAndRes(new int[] {1280,720},false);
                    break;
                case 3:
                    Main.mainWindow.setFullAndRes(new int[] {1920,1080},false);
                    break;
                case 4:
                    Main.mainWindow.setFullAndRes(new int[] {2560,1440},false);
                    break;
                case 5:
                    Main.mainWindow.setFullAndRes(new int[] {3840,2160},false);
                    break;
            }
            try {
                Main.mainWindow.reloadPanel(new Options());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource()==fullscreenCheckbox) {
            Main.mainWindow.fullscreen = fullscreenCheckbox.isSelected();
            switch (resolutionDropdown.getSelectedIndex()){
                case 0:
                    System.out.println("nimger");
                    Main.mainWindow.setFullAndRes(new int[] {800,600},fullscreenCheckbox.isSelected());

                    break;
                case 1:
                    Main.mainWindow.setFullAndRes(new int[] {1024,768},fullscreenCheckbox.isSelected());
                    break;
                case 2:
                    Main.mainWindow.setFullAndRes(new int[] {1280,720},fullscreenCheckbox.isSelected());
                    break;
                case 3:
                    Main.mainWindow.setFullAndRes(new int[] {1920,1080},fullscreenCheckbox.isSelected());
                    break;
                case 4:
                    Main.mainWindow.setFullAndRes(new int[] {2560,1440},fullscreenCheckbox.isSelected());
                    break;
                case 5:
                    Main.mainWindow.setFullAndRes(new int[] {3840,2160},fullscreenCheckbox.isSelected());
                    break;
            }
            try {
                Main.mainWindow.reloadPanel(new Options());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            }
        }
        else if (e.getSource()==goBackButton) {
            try {
                Main.mainWindow.reloadPanel(new Menu());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
