package MainMenu;

import MainMenu.Talismans.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class Game extends JPanel implements ActionListener {
//    <editor-fold desc="variable fuckery">
    //    <editor-fold desc="SHIZOFRENIA>
public static Map<String, Class<? extends TalismanA>> talismansAlles =
        new HashMap<>(Map.ofEntries(
//                <editor-fold desc="Common whores">
                Map.entry("1-36", TTest.class), Map.entry("0-0", T0_1.class),   Map.entry("0-2", T0_3.class),   Map.entry("0-4",T0_5.class),    Map.entry("0-6", T0_7.class),
                Map.entry("0-8", T0_9.class),   Map.entry("0-10", T0_11.class), Map.entry("0-12", T0_13.class), Map.entry("0-14", T0_15.class), Map.entry("0-16", T0_17.class),
                Map.entry("0-18", T0_19.class), Map.entry("0-20", T0_21.class), Map.entry("0-22", T0_23.class), Map.entry("0-24", T0_25.class), Map.entry("0-26", T0_27.class),
                Map.entry("0-28", T0_29.class), Map.entry("0-30", T0_31.class), Map.entry("0-32", T0_33.class), Map.entry("0-34", T0_35.class), Map.entry("0-36", T0_37.class),
                Map.entry("0-38", T0_39.class), Map.entry("0-40", T0_41.class), Map.entry("0-42", T0_43.class), Map.entry("0-44", T0_45.class), Map.entry("0-46", T0_47.class),
                Map.entry("0-48", T0_49.class), Map.entry("0-50", T0_51.class), Map.entry("0-52", T0_53.class), Map.entry("0-54", T0_55.class), Map.entry("0-56", T0_57.class),
                Map.entry("0-58", T0_59.class), Map.entry("0-60", T0_61.class), Map.entry("0-62", T0_63.class), Map.entry("0-64", T0_65.class), Map.entry("0-66", T0_67.class),
                Map.entry("0-68", T0_69.class), Map.entry("0-70", T0_71.class), Map.entry("0-72", T0_73.class), Map.entry("0-74", T0_75.class), Map.entry("0-76", T0_77.class),
                Map.entry("0-78", T0_79.class), Map.entry("0-80", T0_81.class), Map.entry("0-82", T0_83.class)
//                </editor-fold>
//                <editor-fold desc="rare streetwalkers">

//                </editor-fold>
//                <editor-fold desc="legendary escorts">

//                </editor-fold>
//                <editor-fold desc="mythical courtesans">


        ));

    public TalismanA[] talismansAct = new TalismanA[8];
    //    </editor-fold>
    Random rand = new Random();

    Font Jap;
    public  Shop shop;
    public JPanel currentGamePanel;
    public int Money = 100000;
    public int SoulShopBought =0;
    public ArrayList<Integer> SoulTiles = new ArrayList<>();
    public int OpenShopBought = 0;
    public int OpenTiles =3;
    public int DoraShopBought =0;
    public int DoraNum =1;
    public ArrayList<Integer> DoraTiles = new ArrayList<>();
    public Deck deck = new Deck();
    public int moneySpentOnReloads = 0;

    public int talismansSold =0;

    public int scalp=0;


    public ArrayList<Integer> soulBufforList = new ArrayList<>(Arrays.asList(21,22,23,24,25,26,27,28,29,31,32,33,34,35,36,37,38,39,41,42,43,44,45,46,47,48,49,51,52,53,54,55,56,57));
    int[][] upgradeCost = {
            {4,6,9,15,25,40,60,90,120,0},
            {2,4,6,8,10,15,20,25,30,40,50,70,90,100,120,140,150,160,0},
            {10,15,20,30,45,60,90,120,150,200,0}};
    public int SoulShopLimit = upgradeCost[0].length-1;
    public int OpenShopLimit = upgradeCost[1].length-1;
    public int DoraShopLimit = upgradeCost[2].length-1;
    JButton startGameButton;
    public int currentLevel =0;
    public int[][] talismans = new int[8][2];
    public int numTalismans = 0;
    boolean twotalismans = false;
    JLayeredPane layeredPane;
    JPanel[] talismansPanels = new JPanel[3];
    JButton showTalismansButton;
    JButton SkipTalismansButton;
    FontMetrics labelSize;
    JPanel ChooseTalisman;

    public int[] fuval = {
            10,10,10,10,10,10,10,
            5,5,5,5,5,5,5,5,5,
            5,5,5,5,5,5,5,5,5,
            5,5,5,5,5,5,5,5,5
    };

    public boolean isShop = false;
    public int bargain = 0;
    public int freeRefresh =0;

    public int locked = 0;

//</editor-fold>
    Game() throws IOException, FontFormatException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Money = 15;
        if (Main.mainWindow == null) {
            this.setBounds(0, 0, 1920, 1080);
        }else{
            this.setBounds(0,0,Main.mainWindow.getWidth(),Main.mainWindow.getHeight());
        }
        TalismanA t = new TTest(this, (GameGame) null);
        System.out.println("Final power: " + t.power);


        talismans[0] = new int[] {0,6};
        talismansAct[0] = talismansAlles.get("0-6").getDeclaredConstructor(Game.class , GameGame.class).newInstance(this,null);
        talismans[1] = new int[] {1,36};
        talismansAct[1] = talismansAlles.get("1-36").getDeclaredConstructor(Game.class , GameGame.class).newInstance(this,null);
        talismans[2] = new int[] {0,14};
        talismansAct[2] = talismansAlles.get("0-14").getDeclaredConstructor(Game.class , GameGame.class).newInstance(this,null);
        System.out.println(talismansAct[2]+ "Mikan is one big fanservice");
        talismans[3] = null;
        talismans[4] = null;
        talismans[5] = null;
        talismans[6] = null;
        talismans[7] = null;
        numTalismans = 2;

        this.setLayout(new BorderLayout());
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(getWidth(), getHeight()));
        this.add(layeredPane, BorderLayout.CENTER);

        Jap = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fonts/YOZAKURA-Regular.otf"));
        Jap = Jap.deriveFont((float)(this.getWidth()/40));

        JLabel FontMetricsLabel = new JLabel();
        FontMetricsLabel.setFont(Jap);

        labelSize = FontMetricsLabel.getFontMetrics(FontMetricsLabel.getFont());

        startGameButton = new JButton("Start Game");
        startGameButton.addActionListener(this);
        startGameButton.setBounds(this.getWidth()/2-50,this.getHeight()/2,100,50);
        layeredPane.add(startGameButton, JLayeredPane.PALETTE_LAYER);

        this.setVisible(true);
    }

    ImageIcon bg = new ImageIcon("src/imgs/randomBS/Game.jpg");
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
    public void reloadPanel(JPanel panel) {
        layeredPane.remove(currentGamePanel);
        currentGamePanel = panel;
        layeredPane.add(currentGamePanel);
        layeredPane.revalidate();
        layeredPane.repaint();
    }
    public int getUpgradeCost(String type){
        switch (type){
            case "Soul":
                return upgradeCost[0][SoulShopBought];
            case "Open":
                return upgradeCost[1][OpenShopBought];
            case "Dora":
                return upgradeCost[2][DoraShopBought];
        }
        return 0;
    }
    public Boolean addTalisman(int category,int index) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        for (int i =0; i < talismans.length;i++){
            if (Arrays.equals(talismans[i], new int[]{category, index})){
                talismans[i] = new int[]{0,0};
                talismans[i][0] = category;
                talismans[i][1] = index+1;
                talismansAct[i].handleUpgrade();
                System.out.println("Addin "+ category + "  "+index+"  "+i);
                return true;
            }
//  todo         here so i kind of added upgrading talismans and talismans functionality core
//  todo         before you can test it all out you should add all talismans even place holders cause of this shitty line
//  todo         good luck and remember its better to cum in the sink than to sink in the cum
        }
        for (int i =0; i < talismans.length;i++){
            if (talismans[i] == null){
                System.out.println("Addin "+ category + "  "+index+"  "+i);
                talismans[i] = new int[]{0,0};
                talismans[i][0] = category;
                talismans[i][1] = index;
                talismansAct[i] = talismansAlles.get(category+"-"+index).getDeclaredConstructor(Game.class , GameGame.class).newInstance(this,null);// shitty line
                numTalismans++;
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startGameButton) {
            layeredPane.remove(startGameButton);
            try {
                isShop = true;
                bargain = 0;
                for (TalismanA tali : talismansAct){
                    if (tali!=null){tali.TakeEffect();}
                }
                shop = new Shop();
                currentGamePanel = shop;
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            currentGamePanel.setBounds(0, 0, getWidth(), getHeight());
            layeredPane.add(currentGamePanel, JLayeredPane.DEFAULT_LAYER);
            layeredPane.revalidate();
            layeredPane.repaint();
        } else if (e.getSource() == showTalismansButton) {
            showTalismans();
        }else if (e.getSource() == SkipTalismansButton) {
            layeredPane.remove(ChooseTalisman);
            layeredPane.revalidate();
            layeredPane.repaint();
        }
    }

    public void getrandomTalismans(int category){
//        <editor-fold desc="fold1">
        int talismanNum = 3;
        double space = (this.getWidth()*0.7/4/4);
        if (twotalismans){
            talismanNum = 2;
            space = (this.getWidth()*0.7/2/3);
        }
        System.out.println("Kutas Kutas Dupa Cipa");

        ChooseTalisman = new JPanel();
        ChooseTalisman.setLayout(new BoxLayout(ChooseTalisman, BoxLayout.Y_AXIS));
        ChooseTalisman.setBackground(new Color(163, 136, 44,0));;
        ChooseTalisman.setBounds(
                (int) (this.getWidth()*0.15),
                (int) (this.getHeight()*0.15),
                (int) (this.getWidth()*0.7),
                (int) (this.getHeight()*0.7));

        JPanel talismanPanel = new JPanel();
        talismanPanel.setLayout(new BoxLayout(talismanPanel, BoxLayout.X_AXIS));
        talismanPanel.setBackground(new Color(122, 102, 52,240));;
        talismanPanel.setMaximumSize(new Dimension(
                (int) (this.getWidth()*0.7),
                (int) (this.getHeight()*0.7*0.8)));

//        ChooseTalisman.add(Box.createVerticalStrut((int)(this.getHeight() /20)));
//        ChooseTalisman.add(Box.createVerticalStrut(200));

//        talismanPanel.add(Box.createHorizontalStrut((int) space));
        ChooseTalisman.add(talismanPanel);
//        </editor-fold>
//        <editor-fold desc="for">
        for (int i =0;i < talismanNum;i++){
            talismansPanels[i] =new JPanel();
            talismansPanels[i].setLayout(new BoxLayout(talismansPanels[i],BoxLayout.Y_AXIS));
            talismansPanels[i].setOpaque(true);
            talismansPanels[i].setBackground(new Color(255,255,255,0));
            talismansPanels[i].setPreferredSize(new Dimension((int)((this.getWidth()*0.7)/4),(int)((this.getHeight()*0.7*0.8))));

            //        <editor-fold desc="img getting">

            ImageIcon icon = new ImageIcon("src/imgs/blowMe.jpeg");

            int talismanCategory =0;

            switch (category){
//                <editor-fold desc="common">
                case 0:
                    if (rand.nextInt(1000)==0){
                        talismanCategory = 3;
                    } else if (rand.nextInt(100)==0) {
                        talismanCategory = 2;
                    }else if (rand.nextInt(10)==0) {
                        talismanCategory = 1;
                    }else {
                        talismanCategory = 0;
                    }
                    break;
                //        </editor-fold>
//                <editor-fold desc="rare">
                case 1:
                    if (rand.nextInt(100)==0) {
                        talismanCategory = 3;
                    }else if (rand.nextInt(10)==0) {
                        talismanCategory = 2;
                    }else {
                        talismanCategory = 1;
                    }
                    break;
//                    </editor-fold>
//                <editor-fold desc="legendary">
                case 2:
                    if (rand.nextInt(10)==0) {
                        talismanCategory = 3;
                    }else {
                        talismanCategory = 2;
                    }
                    break;
//                    </editor-fold>
            }
            String imgDir = "Common";
            int talismanIndex = 0;
            switch (talismanCategory){
                case 0:
                    talismanIndex = rand.nextInt(41)*2;
                    imgDir = "Common";
                    break;
                case 1:
                    talismanIndex = rand.nextInt(44)*2;
                    imgDir = "Rare";
                    break;
                case 2:
                    talismanIndex = rand.nextInt(26)*2;
                    imgDir = "Legendary";
                    break;
                case 3:
                    talismanIndex = rand.nextInt(6)*2;
                    imgDir = "mythical";
                    break;

            }
            System.out.println(" "+talismanIndex+" Zaciagam sie petem gaz w podloge gniete ");
            if (talismanIndex<10) {
                icon = new ImageIcon("src/imgs/talismans/" + imgDir + "/talisman00" + talismanIndex + ".png");
            }else {
                icon = new ImageIcon("src/imgs/talismans/" + imgDir + "/talisman0" + talismanIndex + ".png");
            }
            Image image = icon.getImage();

            Image scaledImage = image.getScaledInstance((int)((this.getWidth()*0.7)/4),(int)((this.getHeight()*0.7*0.8*0.8)), Image.SCALE_SMOOTH);
            //        </editor-fold>

            JLabel label = new JLabel(new ImageIcon(scaledImage));
            talismansPanels[i].add(label);
            talismansPanels[i].setAlignmentY(Component.TOP_ALIGNMENT);

            talismansPanels[i].setMaximumSize(new Dimension(Integer.MAX_VALUE, talismansPanels[i].getPreferredSize().height+10));
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            JButton takeButton = new JButton();
            takeButton.setText(" Take ");
            takeButton.setActionCommand("t" + talismanIndex);
            takeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            takeButton.setOpaque(true);

            talismansPanels[i].setBackground(new Color(245, 205, 105,100));;
            takeButton.setBackground(new Color(245, 205, 105,255));;
            takeButton.setFont(Jap);
            int finalTalismanCategory = talismanCategory;
            int finalTalismanIndex = talismanIndex;
            int finalI = i;
            takeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if (addTalisman(finalTalismanCategory, finalTalismanIndex)) {
                            layeredPane.remove(ChooseTalisman);
                            showTalismansButton.setText(" Show Talismans "+numTalismans+"/8 ");
                            layeredPane.revalidate();
                            layeredPane.repaint();

                        }
                    } catch (NoSuchMethodException ex) {
                        throw new RuntimeException(ex);
                    } catch (InvocationTargetException ex) {
                        throw new RuntimeException(ex);
                    } catch (InstantiationException ex) {
                        throw new RuntimeException(ex);
                    } catch (IllegalAccessException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
            talismansPanels[i].add(takeButton);
//
            talismanPanel.add(talismansPanels[i]);
//            TalismanHolder.add(PacksHolder[i]);
            talismansPanels[i].add(Box.createVerticalGlue());
            revalidate();
            repaint();
        }
        //        </editor-fold>

        layeredPane.add(ChooseTalisman, JLayeredPane.PALETTE_LAYER);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.setBackground(new Color(122, 102, 51,240));;
        buttonsPanel.setMaximumSize(new Dimension(
                (int) (this.getWidth()*0.7),
                (int) (this.getHeight()*0.7*0.2)));

        ChooseTalisman.add(buttonsPanel);

        JLabel FontMetricsLabel = new JLabel();
        FontMetricsLabel.setFont(Jap);

        labelSize = FontMetricsLabel.getFontMetrics(FontMetricsLabel.getFont());


        buttonsPanel.add(Box.createHorizontalStrut((int) (this.getWidth()*0.7/6)));

        showTalismansButton = new JButton();
        showTalismansButton.setText(" Show Talismans "+numTalismans+"/8 ");
        showTalismansButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        showTalismansButton.setOpaque(true);
        showTalismansButton.setBackground(new Color(245, 205, 105,255));;
        showTalismansButton.setFont(Jap);
        showTalismansButton.addActionListener(this);

        buttonsPanel.add(showTalismansButton);

        int space2 = (int)(this.getWidth()*0.7 - labelSize.stringWidth(" Show Talismans "+numTalismans+"/8 ") -64- ((this.getWidth()*0.7)/3) - labelSize.stringWidth(" Skip ") );
        buttonsPanel.add(Box.createHorizontalStrut(space2));

        SkipTalismansButton = new JButton();
        SkipTalismansButton.setText(" Skip ");
        SkipTalismansButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        SkipTalismansButton.setOpaque(true);
        SkipTalismansButton.setBackground(new Color(245, 205, 105,255));;
        SkipTalismansButton.setFont(Jap);
        SkipTalismansButton.addActionListener(this);

        buttonsPanel.add(SkipTalismansButton);

        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public void SwitchTalismans(int startIndex,int endIndex){

        int[] buffor = talismans[startIndex];
        TalismanA buffor2 = talismansAct[startIndex];
        talismans[startIndex] = talismans[endIndex];
        talismansAct[startIndex] = talismansAct[endIndex];
        talismans[endIndex] = buffor;
        talismansAct[endIndex] = buffor2;
    }
    public void sellTalisman(int talismanIndex){
        switch(talismans[talismanIndex][0] ){
            case 0:
                Money+=3;
                break;
            case 1:
                Money+=6;
                break;
            case 2:
                Money+=9;
                break;
            case 3:
                Money+=12;
                break;
        }
        numTalismans-=1;
        talismansSold++;
        talismans[talismanIndex] = null;
        talismansAct[talismanIndex] = null;
    }

    public void showTalismans(){
//        TODO REMOVE THE FUCKING SET TALISMANS LINE
//        <editor-fold desc="main panel fuckery">
        JPanel talismansPanel = new JPanel();
        talismansPanel.setLayout(new BoxLayout(talismansPanel, BoxLayout.Y_AXIS));
        talismansPanel.setBackground(new Color(117, 95, 27, 250));
//        talismansPanel.setBackground(new Color(163, 136, 44,255));;
        talismansPanel.setBounds(
                (int) (this.getWidth()*0.05),
                (int) (this.getHeight()*0.15),
                (int) (this.getWidth()*0.9),
                (int) (this.getHeight()*0.7)
        );
        layeredPane.add(talismansPanel, JLayeredPane.POPUP_LAYER);

        JPanel talismansPanel2 = new JPanel();
        talismansPanel2.setLayout(new BoxLayout(talismansPanel2, BoxLayout.X_AXIS));
        talismansPanel2.setBackground(new Color(0, 136, 0,0));;
        talismansPanel2.setMaximumSize(new Dimension(
                (int) (this.getWidth()*0.9),
                (int) (this.getHeight()*0.7*0.8)
        ));

        talismansPanel.add(talismansPanel2);
//        </editor-fold>
//<editor-fold desc="talisman Showing Fuckery">


        if (numTalismans==0){
            talismansPanel2.add(Box.createHorizontalStrut((int) (this.getWidth()*0.9)));
        }else {
            for (int i = 0; i < talismans.length; i++) {
                if (talismans[i] == null) {
                    continue;
                }else {

                    JPanel talisman3 = new JPanel();
                    talisman3.setLayout(new BoxLayout(talisman3, BoxLayout.Y_AXIS));
                    talisman3.setOpaque(true);
                    talisman3.setBackground(new Color(255, 0, 0, 0));
                    talisman3.setPreferredSize(new Dimension((int) ((this.getWidth() * 0.9) / 8), (int) ((this.getHeight() * 0.7 * 0.8))));

                    talisman3.add(Box.createVerticalStrut((int) (this.getWidth() * 0.7 / 20)));

                    //        <editor-fold desc="img getting">
                    ImageIcon icon;

                    int talismanCategory = talismans[i][0];

                    String imgDir = "Common";
                    int talismanIndex = 0;
                    switch (talismanCategory) {
                        case 0:
                            imgDir = "Common";
                            break;
                        case 1:
                            imgDir = "Rare";
                            break;
                        case 2:
                            imgDir = "Legendary";
                            break;
                        case 3:
                            imgDir = "mythical";
                            break;
                    }
                    talismanIndex = talismans[i][1];
                    System.out.println(" "+i + "  " + talismanIndex + " Ene due rike fake weź tego śmierdziela w łape ");
                    if (talismanIndex < 10) {
                        icon = new ImageIcon("src/imgs/talismans/" + imgDir + "/talisman00" + talismanIndex + ".png");
                    } else {
                        icon = new ImageIcon("src/imgs/talismans/" + imgDir + "/talisman0" + talismanIndex + ".png");
                    }
                    Image image = icon.getImage();

                    Image scaledImage = image.getScaledInstance((int) ((this.getWidth() * 0.9) / 8), (int) ((this.getHeight() * 0.7 * 0.8 * 0.5)), Image.SCALE_SMOOTH);
                    //        </editor-fold>

                    JLabel label = new JLabel(new ImageIcon(scaledImage));
                    label.add(new JavowyUpominek( String.valueOf(Main.mainWindow.game.talismansAct[i].power),this.getWidth(),this.getHeight() ));
                    talisman3.add(label);
                    talisman3.setAlignmentY(Component.TOP_ALIGNMENT);

                    talisman3.setMaximumSize(new Dimension(Integer.MAX_VALUE, talisman3.getPreferredSize().height + 10));
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);

                    JButton takeButton = new JButton();
                    takeButton.setText(" Sell ");
                    takeButton.setActionCommand("s" + i);
                    takeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                    takeButton.setOpaque(true);
                    talisman3.setBackground(new Color(245, 205, 105, 100));
                    takeButton.setBackground(new Color(245, 205, 105, 255));
                    takeButton.setFont(Jap);
                    int finalI = i;
                    takeButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            System.out.println(finalI + " Programista za niecałe 300 a dokładnie za 200 jak z faktura to drożej");
                            sellTalisman(finalI);
                            layeredPane.remove(talismansPanel);
                            showTalismans();
                            Main.mainWindow.game.shop.moneyLabel.setText(" Money: "+Main.mainWindow.game.Money+" Dong ");
                            showTalismansButton.setText(" Show Talismans "+numTalismans+"/8 ");
                            layeredPane.revalidate();
                            layeredPane.repaint();
                        }
                    });
                    System.out.println("show "+Main.mainWindow.game.talismansAct[i].power);
                    talisman3.add(takeButton);

// COMBO box i argumenty do metofdy to action code comboboxa i wybrana liczba

                    String[] fruits = {"1", "2", "3", "4", "5", "6", "7", "8"};
                    JComboBox<String> comboBox = new JComboBox<>(fruits);
                    comboBox.setFont(Jap);
                    comboBox.setSelectedIndex(i);
                    comboBox.setMaximumSize(new Dimension((int) (labelSize.stringWidth("    ") + 32), (int) (labelSize.getHeight() + 32)));


                    comboBox.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String selected = (String) comboBox.getSelectedItem();
                            System.out.println(selected + " Pije pale konia wale");
                            SwitchTalismans(finalI, Integer.parseInt(selected) - 1);
                            layeredPane.remove(talismansPanel);
                            showTalismans();
                            layeredPane.revalidate();
                            layeredPane.repaint();
                        }
                    });

                    talisman3.add(comboBox);


//
                    talismansPanel2.add(talisman3);
//            TalismanHolder.add(PacksHolder[i]);
                    talisman3.add(Box.createVerticalGlue());
                    revalidate();
                    repaint();
                }
            }
        }
//        </editor-fold>
//<editor-fold desc="Go bak fuckery">
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.setBackground(new Color(245, 0, 0,0));
        buttonsPanel.setMaximumSize(new Dimension(
                (int) (this.getWidth()*0.9),
                (int) (this.getHeight()*0.7*0.2)));

        talismansPanel.add(buttonsPanel);

        int space2 = (int)((this.getWidth()*0.9)*0.5 - labelSize.stringWidth(" Go Back ") + 64);
        buttonsPanel.add(Box.createHorizontalStrut(space2));

        JButton Goback = new  JButton(" Go Back ");
        Goback.setBackground(new Color(245, 205, 105,255));
        Goback.setFont(Jap);
        Goback.addActionListener(new  ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layeredPane.remove(talismansPanel);
                layeredPane.revalidate();
                layeredPane.repaint();

            }
        });
        buttonsPanel.add(Goback);
//        </editor-fold>

        layeredPane.revalidate();
        layeredPane.repaint();
    }
    public void addSoulTile(){
//        TODO MAKE THIS FUCKING FUNCTION
        int randmsth = rand.nextInt(soulBufforList.size());
        SoulTiles.add(soulBufforList.get(randmsth));
        soulBufforList.remove(randmsth);
//        TODO FUCK YOU I MADE THIS FUNCTION
    }
    public void addDoraTiles(){
        DoraTiles.clear();
        for (int i =0; i < DoraNum;i++){
            DoraTiles.add(deck.getRandomTile());
        }
        DoraTiles = Sorthand(DoraTiles);
    }
    public ArrayList<Integer> ThrumpSim(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0; i < 36;i++){
            list.add(deck.getRandomTile());
        }
        list.add(null);
        return list;
    }
    public int[] initialisationOfZeHandZe(){
        int[] list = new int[14];
        for (int i =0; i < 13;i++){
            list[i] = deck.getRandomTile();
            System.out.println(list[i] + " init");
        }
        list[13] =0;
        for (int i =0; i < 14;i++){
            System.out.println(list[i] + " init");
        }
        list = new int[]{11, 11, 12, 12, 13, 13, 14, 14, 15, 15, 16, 16, 17, 0};
        return list;
    }

    public ArrayList<Integer> Sorthand(ArrayList<Integer> list){
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                int a = list.get(j);
                int b = list.get(j + 1);
                int valA = (a > 100) ? a / 10 : a;
                int valB = (b > 100) ? b / 10 : b;
                if (valA > valB) {
                    list.set(j, b);
                    list.set(j + 1, a);
                }
            }
        }
        ArrayList<Integer> sorted = new ArrayList<>();
        for (Integer i : list) {
            if (i / 10 != 1 && i != 0) {
                sorted.add(i);
            }
        }
        for (Integer i : list) {
            if (i / 10 == 1) {
                sorted.add(i);
            }
        }
        for (Integer i : list) {
            if (i == 0) {
                sorted.add(i);
            }
        }
        return sorted;
    }
    public int[] Sorthand(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) {
            System.out.println(i);
            list.add(i);
        }
        list = Sorthand(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);

        }

        return arr;
    }
}
