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

public class Shop extends JPanel implements ActionListener {
    Random rand = new Random();

    Font Jap;
    JButton buySoul;
    JButton buyOpen;
    JButton buyDora;
    JButton RefreshButton;
    JButton Nextlevel;
    public JLabel moneyLabel;
    JLabel OpenCounter;
    JLabel soulCounter;
    JLabel DoraCounter;
    JPanel TalismanHolder;
    FontMetrics labelSize;
    JPanel[] Packs = new JPanel[5];
    JButton[] buyTalisman = new JButton[5];
    JPanel[] PacksHolder = new JPanel[5];

    int RefreshCost = 5;
    Boolean minNor= false;

    Shop() throws IOException, FontFormatException {
        if (Main.mainWindow == null) {
            this.setBounds(0, 0, 1920, 1080);
        }else{
            this.setBounds(0,0,Main.mainWindow.getWidth(),Main.mainWindow.getHeight());
        }
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        Main.mainWindow.game.Money += 100000000;

        Main.mainWindow.game.Money += Main.mainWindow.game.currentLevel*5;

        Jap = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fonts/YOZAKURA-Regular.otf"));
        Jap = Jap.deriveFont((float)(this.getWidth()/45));

        this.add(Box.createVerticalStrut((int)(this.getHeight() /30)));

        JPanel MoneyPusherPanel = new JPanel();
        MoneyPusherPanel.setLayout(new BoxLayout(MoneyPusherPanel,BoxLayout.X_AXIS));
        MoneyPusherPanel.setMaximumSize(new Dimension (this.getWidth(), this.getHeight()/20));
        MoneyPusherPanel.setOpaque(false);
        MoneyPusherPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, this.getWidth()/20));
//        <editor-fold desc="fold1">


        moneyLabel = new JLabel(" Money: "+Main.mainWindow.game.Money+" Dong ");
        MoneyPusherPanel.add(Box.createHorizontalGlue());
        moneyLabel.setBackground(new Color(245, 205, 105,150));
        moneyLabel.setOpaque(true);
        moneyLabel.setFont(Jap);
        MoneyPusherPanel.add(moneyLabel);
        this.add(MoneyPusherPanel);

        this.add(Box.createVerticalStrut((int)(this.getHeight() /5)));

        labelSize = moneyLabel.getFontMetrics(moneyLabel.getFont());


        JPanel MainShopHolder = new JPanel();
        MainShopHolder.setLayout(new BoxLayout(MainShopHolder,BoxLayout.X_AXIS));
        MainShopHolder.setBackground(new Color(147, 116, 39,240));;
        MainShopHolder.setOpaque(true);
        MainShopHolder.setAlignmentX((float)(Component.CENTER_ALIGNMENT));
//        MainShopHolder.setAlignmentX((float)(-((this.getWidth()/2)-(this.getWidth()*0.7)/2)/this.getWidth()));
        MainShopHolder.setMaximumSize(new Dimension((int)(this.getWidth()*0.8),(int)(this.getHeight()*0.5)));
        this.add(MainShopHolder);
//<editor-fold desc="upgrades">
        JPanel UpgradesPanel = new JPanel();
        UpgradesPanel.setLayout(new BoxLayout(UpgradesPanel,BoxLayout.Y_AXIS));
        UpgradesPanel.setBackground(new Color(255,0,0,0));
        UpgradesPanel.setOpaque(true);
        UpgradesPanel.setAlignmentX((float)(Component.CENTER_ALIGNMENT));
//        MainShopHolder.setAlignmentX((float)(-((this.getWidth()/2)-(this.getWidth()*0.7)/2)/this.getWidth()));
        UpgradesPanel.setMinimumSize(new Dimension((int)((this.getWidth()*0.8)*0.3),(int)(this.getHeight()*0.5)));
        MainShopHolder.add(UpgradesPanel);

//        <editor-fold desc="Soul Upgrade">

        JPanel SoulPanel = new JPanel();
        SoulPanel.setLayout(new BoxLayout(SoulPanel,BoxLayout.Y_AXIS));
        SoulPanel.setBackground(new Color(245, 205, 105,150));
        SoulPanel.setOpaque(true);
        SoulPanel.setMaximumSize(new Dimension((int)((this.getWidth()*0.8)*0.3),(int)(this.getHeight()*0.5/3)));
        SoulPanel.setMinimumSize(new Dimension((int)((this.getWidth()*0.8)*0.3),(int)(this.getHeight()*0.5)));
        UpgradesPanel.add(SoulPanel);


        JLabel soulLabel = new JLabel("    Added Soul Tile ");
        soulLabel.setOpaque(false);
        soulLabel.setFont(Jap);
        SoulPanel.add(soulLabel);
        soulCounter = new JLabel("               "+Main.mainWindow.game.SoulShopBought+"/"+Main.mainWindow.game.SoulShopLimit+" ");

        soulCounter.setFont(Jap);
        SoulPanel.add(soulCounter);


        JPanel buySoulButtonHolder = new JPanel();
        buySoulButtonHolder.setLayout(null);
        buySoulButtonHolder.setMaximumSize(new Dimension ((int)((this.getWidth()*0.8)), (int)((this.getHeight()*0.5)) /10));
        buySoulButtonHolder.setOpaque(true);
        buySoulButtonHolder.setBackground(new Color(255,255,255,0));

        if (Main.mainWindow.game.getUpgradeCost("Soul")==0) {
            buySoul = new JButton(" Max level");
        }else {
            buySoul = new JButton("Add Soul tile " + Main.mainWindow.game.getUpgradeCost("Soul") + " Dong");

        }
        buySoul.setFont(Jap);
        buySoul.setOpaque(true);
        buySoul.setBackground(new Color(245, 205, 105));
        buySoul.setBounds((int)((this.getWidth()*0.7)*0.3*0.1),0,(int)((this.getWidth()*0.8)*0.3*0.8),(int)((this.getWidth()*0.8)*0.3/10) );
        SoulPanel.add(buySoulButtonHolder);
        buySoul.addActionListener(this);
        buySoulButtonHolder.add(buySoul);
        //        </editor-fold>

//        <editor-fold desc="Open Upgrade">
        JPanel Openpanel = new JPanel();
        Openpanel.setLayout(new BoxLayout(Openpanel,BoxLayout.Y_AXIS));
        Openpanel.setBackground(new Color(145, 105, 5,150));
        Openpanel.setOpaque(true);
        Openpanel.setMaximumSize(new Dimension((int)((this.getWidth()*0.8)*0.3),(int)(this.getHeight()*0.5/3)));
        UpgradesPanel.add(Openpanel);

        JLabel openLabel = new JLabel("    Added Open Tiles ");
        openLabel.setOpaque(false);
        openLabel.setFont(Jap);
        Openpanel.add(openLabel);
        OpenCounter = new JLabel("               "+Main.mainWindow.game.OpenShopBought+"/"+Main.mainWindow.game.OpenShopLimit+" ");

        OpenCounter.setFont(Jap);
        Openpanel.add(OpenCounter);


        JPanel openButtonHolder = new JPanel();
        openButtonHolder.setLayout(null);
        openButtonHolder.setMaximumSize(new Dimension ((int)((this.getWidth()*0.8)), (int)((this.getHeight()*0.5)) /10));
        openButtonHolder.setOpaque(true);
        openButtonHolder.setBackground(new Color(255,255,255,0));


        buyOpen = new JButton("Add Open tile "+Main.mainWindow.game.getUpgradeCost("Open")+" Dong");
        buyOpen.setFont(Jap);
        buyOpen.setOpaque(true);
        buyOpen.setBackground(new Color(245, 205, 105));
        buyOpen.setBounds((int)((this.getWidth()*0.8)*0.3*0.1),0,(int)((this.getWidth()*0.8)*0.3*0.8),(int)((this.getWidth()*0.8)*0.3/10) );
        buyOpen.addActionListener(this);
        Openpanel.add(openButtonHolder);
        openButtonHolder.add(buyOpen);
        //        </editor-fold>

//        <editor-fold desc="Dora Upgrade">
        JPanel DoraPanel = new JPanel();
        DoraPanel.setLayout(new BoxLayout(DoraPanel,BoxLayout.Y_AXIS));
        DoraPanel.setBackground(new Color(245, 205, 105,150));
        DoraPanel.setOpaque(true);
        DoraPanel.setMaximumSize(new Dimension((int)((this.getWidth()*0.8)*0.3),(int)(this.getHeight()*0.5/3)));
        UpgradesPanel.add(DoraPanel);

        JLabel DoraLabel = new JLabel("    Added Dora Tiles ");
        DoraLabel.setOpaque(false);
        DoraLabel.setFont(Jap);
        DoraPanel.add(DoraLabel);
        DoraCounter = new JLabel("               "+Main.mainWindow.game.DoraShopBought+"/"+Main.mainWindow.game.DoraShopLimit+" ");

        DoraCounter.setFont(Jap);
        DoraPanel.add(DoraCounter);


        JPanel doraButtonHolder = new JPanel();
        doraButtonHolder.setLayout(null);
        doraButtonHolder.setMaximumSize(new Dimension ((int)((this.getWidth()*0.8)), (int)((this.getHeight()*0.5)) /10));
        doraButtonHolder.setOpaque(true);
        doraButtonHolder.setBackground(new Color(255,255,255,0));


        buyDora = new JButton("Add Dora tile "+Main.mainWindow.game.getUpgradeCost("Dora")+" Dong");
        buyDora.setFont(Jap);
        buyDora.setOpaque(true);
        buyDora.addActionListener(this);
        buyDora.setBackground(new Color(245, 205, 105));
        buyDora.setBounds((int)((this.getWidth()*0.8)*0.3*0.1),0,(int)((this.getWidth()*0.8)*0.3*0.8),(int)((this.getWidth()*0.8)*0.3/10) );
        DoraPanel.add(doraButtonHolder);
        doraButtonHolder.add(buyDora);
//        </editor-fold>
//</editor-fold>

        JPanel ShopPanel = new JPanel();
        ShopPanel.setLayout(new BoxLayout(ShopPanel,BoxLayout.Y_AXIS));
        ShopPanel.setBackground(new Color(255,0,0,0));
        ShopPanel.setOpaque(true);
//        MainShopHolder.setAlignmentX((float)(-((this.getWidth()/2)-(this.getWidth()*0.7)/2)/this.getWidth()));
        ShopPanel.setPreferredSize(new Dimension((int)((this.getWidth()*0.8)*0.7),(int)(this.getHeight()*0.5)));
        ShopPanel.setMaximumSize(new Dimension((int)((this.getWidth()*0.8)*0.7),(int)(this.getHeight()*0.5)));
        MainShopHolder.add(ShopPanel);
        System.out.println((this.getWidth()*0.8)*0.7);

        TalismanHolder = new JPanel();
        TalismanHolder.setLayout(new BoxLayout(TalismanHolder,BoxLayout.X_AXIS));
        TalismanHolder.setBackground(new Color(0,0,255,0));
        TalismanHolder.setOpaque(true);
//        MainShopHolder.setAlignmentX((float)(-((this.getWidth()/2)-(this.getWidth()*0.7)/2)/this.getWidth()));
        TalismanHolder.setPreferredSize(new Dimension((int)((this.getWidth()*0.8)*0.7),(int)(this.getHeight()*0.5*0.7)));
        TalismanHolder.setMaximumSize(new Dimension((int)((this.getWidth()*0.8)*0.7),(int)(this.getHeight()*0.5*0.7)));
        ShopPanel.add(TalismanHolder);

//        <editor-fold desc="Generate Talismans TODO= make it a Fucking Function, and so it was made a fucking function">
        reloadTalismans();

//    </editor-fold>

        JPanel ButoonPanel = new JPanel();
        ButoonPanel.setLayout(new BoxLayout(ButoonPanel,BoxLayout.X_AXIS));
        ButoonPanel.setBackground(new Color(0,0,255,0));
        ButoonPanel.setOpaque(true);
//        MainShopHolder.setAlignmentX((float)(-((this.getWidth()/2)-(this.getWidth()*0.7)/2)/this.getWidth()));
        ButoonPanel.setPreferredSize(new Dimension((int)((this.getWidth()*0.8)*0.7),(int)(this.getHeight()*0.5*0.3)));
        ButoonPanel.setMaximumSize(new Dimension((int)((this.getWidth()*0.8)*0.7),(int)(this.getHeight()*0.5*0.3)));
        ShopPanel.add(ButoonPanel);

        RefreshButton = new JButton(" Refresh "+RefreshCost+" Dong ");
        RefreshButton.setOpaque(true);
        RefreshButton.setBackground(new Color(245, 205, 105,255));;
        RefreshButton.setFont(Jap);
        RefreshButton.addActionListener(this);

        JButton showTalismans = new JButton(" Talismans ");
        showTalismans.setOpaque(true);
        showTalismans.setBackground(new Color(245, 205, 105,255));;
        showTalismans.setFont(Jap);
        showTalismans.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.mainWindow.game.showTalismans();
            }
        });

        ButoonPanel.add(Box.createHorizontalStrut((int)((this.getWidth()*0.8)*0.7*0.1)));
        ButoonPanel.add(RefreshButton);
        ButoonPanel.add(Box.createHorizontalStrut((int)(  ( (this.getWidth()*0.8)*0.7*0.8) -(labelSize.stringWidth(" Refresh "+RefreshCost+" Dong ")) - (labelSize.stringWidth(" Next Level ")) )/2 -34- labelSize.stringWidth(" Show Talismans ")/2 ));
        ButoonPanel.add(showTalismans);
        ButoonPanel.add(Box.createHorizontalStrut((int)(  (( (this.getWidth()*0.8)*0.7*0.8) -(labelSize.stringWidth(" Refresh "+RefreshCost+" Dong ")) - (labelSize.stringWidth(" Next Level ")) ) - labelSize.stringWidth(" Show Talismans ") )/2 ));


        Nextlevel = new JButton(" Next Level ");
        Nextlevel.setOpaque(true);
        Nextlevel.setBackground(new Color(245, 205, 105,255));;
        Nextlevel.setFont(Jap);
        Nextlevel.addActionListener(this);

        ButoonPanel.add(Nextlevel);



        this.setVisible(true);
    }
    ImageIcon bg = new ImageIcon("src/imgs/Shop.jpg");
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buyOpen) {
            System.out.println("Dupa");
            if(Main.mainWindow.game.OpenShopBought<Main.mainWindow.game.OpenShopLimit){
                if(Main.mainWindow.game.getUpgradeCost("Open")<=Main.mainWindow.game.Money){
                    System.out.println("Bingo");
                    Main.mainWindow.game.Money -= Main.mainWindow.game.getUpgradeCost("Open");
                    Main.mainWindow.game.OpenShopBought++;
                    Main.mainWindow.game.OpenTiles++;
                    moneyLabel.setText(" Money: "+Main.mainWindow.game.Money+" Dong ");
                    if (Main.mainWindow.game.getUpgradeCost("Open")==0) {
                        buyOpen.setText(" Max level");
                    }else {
                        buyOpen.setText("Add Open tile " + Main.mainWindow.game.getUpgradeCost("Open") + " Dong");
                    }
                    OpenCounter.setText("               "+Main.mainWindow.game.OpenShopBought+"/"+Main.mainWindow.game.OpenShopLimit+" ");
                    revalidate();
                    repaint();
                }
            }
        }else
        if (e.getSource() == buySoul) {
            System.out.println("Dupa");
            if(Main.mainWindow.game.SoulShopBought<Main.mainWindow.game.SoulShopLimit){
                if(Main.mainWindow.game.getUpgradeCost("Soul")<=Main.mainWindow.game.Money) {
                    System.out.println("Bingo");
                    Main.mainWindow.game.Money -= Main.mainWindow.game.getUpgradeCost("Soul");
                    Main.mainWindow.game.SoulShopBought++;
                    Main.mainWindow.game.addSoulTile();
                    moneyLabel.setText(" Money: " + Main.mainWindow.game.Money + " Dong ");
                    if (Main.mainWindow.game.getUpgradeCost("Soul")==0) {
                        buySoul.setText(" Max level");
                    }else {
                        buySoul.setText("Add Soul tile " + Main.mainWindow.game.getUpgradeCost("Soul") + " Dong");
                    }
                    soulCounter.setText("               " + Main.mainWindow.game.SoulShopBought + "/" + Main.mainWindow.game.SoulShopLimit + " ");
                    revalidate();
                    repaint();
                }
            }
        }else
        if (e.getSource() == buyDora) {
            System.out.println("Dupa");
            if (Main.mainWindow.game.DoraShopBought<Main.mainWindow.game.DoraShopLimit) {
                if (Main.mainWindow.game.getUpgradeCost("Dora") <= Main.mainWindow.game.Money ){
                    System.out.println("Bingo");
                    Main.mainWindow.game.Money -= Main.mainWindow.game.getUpgradeCost("Dora");
                    Main.mainWindow.game.DoraShopBought++;
                    moneyLabel.setText(" Money: " + Main.mainWindow.game.Money + " Dong ");
                    if (Main.mainWindow.game.getUpgradeCost("Dora")==0) {
                        buyDora.setText(" Max level");
                    }else {
                        buyDora.setText("Add Dora tile " + Main.mainWindow.game.getUpgradeCost("Dora") + " Dong");
                    }
                    DoraCounter.setText("               " + Main.mainWindow.game.DoraShopBought + "/" + Main.mainWindow.game.DoraShopLimit + " ");
                    revalidate();
                    repaint();
                }
            }
    }else
        if (e.getSource()==RefreshButton){
            if (Main.mainWindow.game.Money >= RefreshCost) {
                reloadTalismans();
                Main.mainWindow.game.Money-=RefreshCost;
                RefreshCost+=5;;
                RefreshButton.setText(" Refresh "+RefreshCost+" Dong ");
                moneyLabel.setText(" Money: "+Main.mainWindow.game.Money+" Dong ");
            }
        } else
        if (e.getSource()==Nextlevel) {
        System.out.println("Dupa Dupsko");
        Main.mainWindow.game.deck.initializeDeck();
        try {
            Main.mainWindow.game.reloadPanel(new GameGame());
            Main.mainWindow.game.currentLevel++;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        Main.mainWindow.game.currentGamePanel.setBounds(0, 0, getWidth(), getHeight());
        Main.mainWindow.game.layeredPane.removeAll();
        Main.mainWindow.game.layeredPane.add(Main.mainWindow.game.currentGamePanel, JLayeredPane.DEFAULT_LAYER);
        Main.mainWindow.game.layeredPane.revalidate();
        Main.mainWindow.game.layeredPane.repaint();

        } else
        {
            String btnString = e.getActionCommand();
            btnString = btnString.substring(1,2);
            int value = 0;
            try {
                value = Integer.parseInt(btnString);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number: " + btnString);
                return;
            }
            int buttonIndex = value;
            try {
                value = Integer.parseInt(buyTalisman[value].getText().substring(1,3).trim());
            } catch (NumberFormatException ex) {
                System.out.println("Invalid number: " + buyTalisman[value].getText().substring(1,3));
                return;
            }
            Main.mainWindow.game.Money -= value;
            moneyLabel.setText(" Money: "+Main.mainWindow.game.Money+" Dong ");
            switch (value) {
                case 5:
                    value = 0;
                    break;
                case 10:
                    value = 1;
                    break;
                case 15:
                    value = 2;
                    break;
            }
            System.out.println(value);
            Main.mainWindow.game.getrandomTalismans(value);
            setBought(buttonIndex);

        }
    }

    int getTalismanCategory(){
        if (minNor){
            if (rand.nextInt(9)==0){
                return 2;
            }else{
                return 1;
            }
        }else {
            if (rand.nextInt(9)==0){
                return 2;
            }else if (rand.nextInt(2)==0){
                return 1;
            }else{
                return 0;
            }
        }
    }
    void reloadTalismans(){
        TalismanHolder.removeAll();
        for (int i =0;i<=4;i++){
            PacksHolder[i] = new JPanel();
            PacksHolder[i].setLayout(new BoxLayout(PacksHolder[i],BoxLayout.Y_AXIS));
            PacksHolder[i].setPreferredSize(new Dimension((int)((this.getWidth()*0.8)*0.7*0.2),(int)(this.getHeight()*0.5*0.7)));
            PacksHolder[i].setAlignmentY(Component.TOP_ALIGNMENT);
            PacksHolder[i].setBackground(new Color(255,0,0,0));
            PacksHolder[i].setOpaque(true);

            System.out.println("kutas");
            if (i%2!=0) {
                PacksHolder[i].add(Box.createVerticalStrut((int)(this.getHeight() /20)-10));
            }
            Packs[i] =new JPanel();
            Packs[i].setLayout(new BoxLayout(Packs[i],BoxLayout.Y_AXIS));
            Packs[i].setOpaque(true);
            Packs[i].setBackground(new Color(255,255,255,0));
            Packs[i].setPreferredSize(new Dimension((int)((this.getWidth()*0.8)*0.7*0.2),(int)((this.getHeight()*0.5*0.7)- (double) this.getHeight() /20)+10));
            int talismanCategory = getTalismanCategory();
            System.out.println(talismanCategory);
            ImageIcon icon = new ImageIcon("src/imgs/blowMe.jpeg");
            switch (talismanCategory) {
                case 0:
                    icon = new ImageIcon("src/imgs/categories/common.png");
                    break;
                case 1:
                    icon = new ImageIcon("src/imgs/categories/rare.png");
                    break;
                case 2:
                    icon = new ImageIcon("src/imgs/categories/legendary.png");
                    break;
            }



            Image image = icon.getImage();


            Image scaledImage = image.getScaledInstance((int)((this.getWidth()*0.8)*0.7*0.2), (int)(((this.getHeight()*0.5*0.7)-((double) this.getHeight() /20) - labelSize.getHeight())), Image.SCALE_SMOOTH);

            JLabel label = new JLabel(new ImageIcon(scaledImage));
            Packs[i].add(label);
            Packs[i].setAlignmentY(Component.TOP_ALIGNMENT);

            Packs[i].setMaximumSize(new Dimension(Integer.MAX_VALUE, Packs[i].getPreferredSize().height+10));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            buyTalisman[i] = new JButton();
            buyTalisman[i].setActionCommand("b" + i);

            buyTalisman[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            switch (talismanCategory){
                case 0:
                    buyTalisman[i].setText(" 5 Dong ");
                    break;
                case 1:
                    buyTalisman[i].setText(" 10 Dong ");
                    break;
                case 2:
                    buyTalisman[i].setText(" 15 Dong ");
                    break;
            }
            buyTalisman[i].setOpaque(true);
            Packs[i].setBackground(new Color(245, 205, 105,100));;
            buyTalisman[i].setBackground(new Color(245, 205, 105,255));;
            buyTalisman[i].setFont(Jap);
            buyTalisman[i].addActionListener(this);

            Packs[i].add(buyTalisman[i]);

            PacksHolder[i].add(Packs[i]);
            TalismanHolder.add(PacksHolder[i]);
            PacksHolder[i].add(Box.createVerticalGlue());
            revalidate();
            repaint();

        }
    }
    void setBought(int packIndex){
        Packs[packIndex].removeAll();
        System.out.println("Removin "+packIndex);
        revalidate();
        repaint();
    }
}
