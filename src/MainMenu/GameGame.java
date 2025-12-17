package MainMenu;

import MainMenu.Talismans.TalismanA;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class GameGame extends JPanel implements MouseListener, MouseMotionListener,ActionListener {
//    <editor-fold desc="unholy variable monolith">

    YekerMeister_mk_III yekerMeister_mk_III = new YekerMeister_mk_III();

    int[] hand = new int[14];
    Random rand = new Random();
    JLayeredPane layeredPane;
    Font Jap;
    FontMetrics labelSize;
    JLabel Procentaż;
    JPanel pointaż;
    JLabel Punktaż;
    JPanel DoraPanel;
    JPanel KanPanel;
    JPanel TileWall;
    JPanel handWall;
    JPanel kanpenl;
    JPanel tenpaiDisplay;
    JButton Switch;
    JButton Skip;
    JButton kanButton;
    JButton winButton;
    double points = 28;
    int levelIndex= Main.mainWindow.game.currentLevel;
    int Kans =0;
    int switches = 3;
    int wallIndex =0;
    int lastTile =0;
    public int fu;
    public int han;
    public Boolean isWinning = false;
    Boolean phase2 = false;
    int drawNum = 0;
    ArrayList<Integer> KansArray = new ArrayList<>();
    ArrayList<Integer> potentialKansArray = new ArrayList<>();
    ArrayList<Integer> TileWallArray = new ArrayList<>();
    ArrayList<Integer> selectedArray = new ArrayList<>();
    TalismanA[] talismansActual = new TalismanA[8];
    Long[] pointReq = {
            200L, 400L, 600L, 800L, 1000L ,
            1500L, 2000L , 2500L , 3000L, 3500L, 4000L,
            5000L , 7000L, 9000L, 11000L,
            15000L, 20000L, 30000L, 50000L, 75000L, 100000L,
//        EX
            1000000L,10000000L,1000000000L,1000000000000L,1000000000000000L,1000000000000000000L,9223372036854775807L
    };
    int[] openOnes;
    Long pointsReqCurr =0L;
    ArrayList<JLabel> DoraLabels = new ArrayList<>();
    ArrayList<Image> DoraimgsOriginal = new ArrayList<>();
    Timer timer;
//</editor-fold>
    GameGame() throws IOException, FontFormatException {

        for (int[] talisman : Main.mainWindow.game.talismans){
            if (talisman != null){
                if (talisman[1] %2 == 1){

                }
            }
        }
        points = 0;

        //    <editor-fold desc="Initialization">

        if (Main.mainWindow == null) {
            this.setBounds(0, 0, 1920, 1080);
        }else{
            this.setBounds(0,0,Main.mainWindow.getWidth(),Main.mainWindow.getHeight());
        }

        Main.mainWindow.game.deck.initializeDeck();

        this.setLayout(new BorderLayout());
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(getWidth(), getHeight()));
        this.add(layeredPane, BorderLayout.CENTER);

        Jap = Font.createFont(Font.TRUETYPE_FONT,new File("src/Fonts/YOZAKURA-Regular.otf"));
        Jap = Jap.deriveFont((float)(this.getWidth()/40));

        JLabel FontMetricsLabel = new JLabel();
        FontMetricsLabel.setFont(Jap);

        labelSize = FontMetricsLabel.getFontMetrics(FontMetricsLabel.getFont());

        //</editor-fold>

        //    <editor-fold desc="Woltarz 40">

        pointaż = new JPanel();
        pointaż.setLayout(new BoxLayout(pointaż,BoxLayout.X_AXIS));
        pointaż.setBounds(
                (int)(this.getWidth()/2 - this.getWidth()/2/2 +2),
                (int)(this.getHeight()*0.1*0.2 +2),
                (int)(this.getWidth()/2*(Math.min(points/pointReq[levelIndex], 1)) -4),
                (int)(this.getHeight()*0.1*0.7) -4);
        pointaż.setOpaque(true);
        pointaż.setBackground(new Color(255, 58, 0,255));
        System.out.println(this.getWidth()+","+this.getHeight());

        JPanel rameczka = new JPanel();
        rameczka.setBackground(new Color(0,0,0,200));
        rameczka.setOpaque(true);
        rameczka.setBounds(
                (int)(this.getWidth()/2 - this.getWidth()/2/2),
                (int)(this.getHeight()*0.1*0.2),
                this.getWidth()/2,
                (int)(this.getHeight()*0.1*0.7));
        rameczka.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        Punktaż = new JLabel();
        Punktaż.setFont(Jap);
        Punktaż.setBackground(new Color(255,255,255,0));
        Punktaż.setBounds(
                (int)(this.getWidth()/2 - labelSize.stringWidth("("+points+"/" + pointReq[levelIndex] + ")")/2),
                (int)(this.getHeight()*0.1*0.2),
                labelSize.stringWidth("("+points+"/" + pointReq[levelIndex] + ")"),
                (int)(this.getHeight()*0.1*0.7));
        Punktaż.setOpaque(true);
        Punktaż.setText("("+points+"/" + pointReq[levelIndex] + ")");


        layeredPane.add(Punktaż,JLayeredPane.PALETTE_LAYER);


        layeredPane.add(rameczka, JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(pointaż,JLayeredPane.PALETTE_LAYER);

        Procentaż = new JLabel();
        Procentaż.setFont(Jap);
        Procentaż.setBackground(new Color(255,255,255,200));
        Procentaż.setBounds(
                (int)(this.getWidth()/2 - this.getWidth()/2/2 - labelSize.stringWidth("("+points/pointReq[levelIndex]*100 + "%)")),
                (int)(this.getHeight()*0.1*0.2 +2),
                labelSize.stringWidth("("+points/pointReq[levelIndex]*100 + "%)"),
                (int)(this.getHeight()*0.1*0.7 -4));
        Procentaż.setOpaque(true);
        Procentaż.setText("("+points/pointReq[levelIndex]*100 + "%)");


        layeredPane.add(Procentaż,JLayeredPane.DEFAULT_LAYER);

        //</editor-fold>
        //    <editor-fold desc="Poka Dupe">

        JButton ShowTalismans = new JButton( " Show Talismans ");
        ShowTalismans.setBounds(
                (int)(this.getWidth()*0.9 - labelSize.stringWidth(" Show Talismans ") - 64),
                (int)(this.getHeight()*0.1),
                (int)(labelSize.stringWidth(" Show Talismans ") + 64),
                (int)(labelSize.getHeight() + 64)
        );
        ShowTalismans.setOpaque(true);
        ShowTalismans.setBackground(new Color(245, 205, 105, 255));
        ShowTalismans.setFont(Jap);
        ShowTalismans.addActionListener(e -> {
            showTalismans();
        });

        layeredPane.add(ShowTalismans,JLayeredPane.DEFAULT_LAYER);
        //        </editor-fold>
        //    <editor-fold desc="Dora Tiles">
        addDoras();
        //        </editor-fold>
        //        <editor-fold desc="KanDesu">
        addKans(0);
        //        </editor-fold>
        //        <editor-fold desc="TILE WALL">
        TileWallArray = Main.mainWindow.game.ThrumpSim();

        openOnes = new int[Main.mainWindow.game.OpenTiles];
        ArrayList<Integer> wallPositions = new ArrayList<>();
        for (int i =0;i<36;i++){
            wallPositions.add(i,i);
        }
        for (int i = 0; i < openOnes.length; i++) {
            int randSmth = rand.nextInt(wallPositions.size());
            openOnes[i] = wallPositions.get(randSmth);
            wallPositions.remove(randSmth);
        }
        for (int i = 0; i < openOnes.length; i++) {
            System.out.println(openOnes[i]);
        }
        updateWall();
        //        </editor-fold>
        //        <editor-fold desc="hand">
        hand = Main.mainWindow.game.initialisationOfZeHandZe();

        for (int a : hand){
            System.out.println(a+" gamgam init");
        }

        updateHand();
        // </editor-fold>
        //<editor-fold desc="Game game">
//        TODO PHASE 1 DICK
            Switch= new JButton();
            Switch.setFont(Jap);
            Switch.setText(" Switch "+switches+" ");
            Switch.setBounds(
                    (int)(this.getWidth()*0.65 - labelSize.stringWidth(" Switch "+switches+" ") ),
                    (int)(this.getHeight() - this.getHeight()*0.12 - this.getHeight()/7 ),
                    (int)(labelSize.stringWidth(" Switch ") + 80),
                    (int)(labelSize.getHeight())
            );
            Switch.setOpaque(true);
            Switch.setBackground(new Color(245, 205, 105, 255));
            Switch.setFont(Jap);
            Switch.addActionListener(e -> {
    //            TODO ADD FUNCTION DUMBFUCK
                try {
                    switchTM();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
            });
            layeredPane.add(Switch,JLayeredPane.DEFAULT_LAYER);

        Skip= new JButton();;
        Skip.setFont(Jap);
        Skip.setText(" Skip ");
        Skip.setBounds(
                (int)(this.getWidth()*0.75 - labelSize.stringWidth(" Skip ") ),
                (int)(this.getHeight() - this.getHeight()*0.12 - this.getHeight()/7 ),
                (int)(labelSize.stringWidth(" Skip ") + 80),
                (int)(labelSize.getHeight())
        );
        Skip.setOpaque(true);
        Skip.setBackground(new Color(245, 205, 105, 255));
        Skip.setFont(Jap);
        Skip.addActionListener(e -> {
            //            TODO ADD FUNCTION DUMBFUCK v2
            try {
                skip();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            } catch (FontFormatException ex) {
                throw new RuntimeException(ex);
            }
        });
        layeredPane.add(Skip,JLayeredPane.DEFAULT_LAYER);
        //        </editor-fold>
    }
    ImageIcon bg = new ImageIcon("src/imgs/Game.jpg");
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(bg.getImage(), 0, 0, getWidth(), getHeight(), this);
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
        layeredPane.add(talismansPanel, JLayeredPane.MODAL_LAYER);

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


        if (Main.mainWindow.game.numTalismans==0){
            talismansPanel2.add(Box.createHorizontalStrut((int) (this.getWidth()*0.9)));
        }else {
            for (int i = 0; i < Main.mainWindow.game.talismans.length; i++) {
                if (Main.mainWindow.game.talismans[i] == null) {
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

                    int talismanCategory = Main.mainWindow.game.talismans[i][0];

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
                    talismanIndex = Main.mainWindow.game.talismans[i][1];
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
                    talisman3.add(label);
                    talisman3.setAlignmentY(Component.TOP_ALIGNMENT);

                    talisman3.setMaximumSize(new Dimension(Integer.MAX_VALUE, talisman3.getPreferredSize().height + 10));
                    label.setAlignmentX(Component.CENTER_ALIGNMENT);


// COMBO box i argumenty do metofdy to action code comboboxa i wybrana liczba

                    String[] fruits = {"1", "2", "3", "4", "5", "6", "7", "8"};
                    JComboBox<String> comboBox = new JComboBox<>(fruits);
                    comboBox.setFont(Jap);
                    comboBox.setSelectedIndex(i);
                    comboBox.setMaximumSize(new Dimension((int) (labelSize.stringWidth("    ") + 32), (int) (labelSize.getHeight() + 32)));

                    final int finalI = i;
                    comboBox.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            String selected = (String) comboBox.getSelectedItem();
                            System.out.println(selected + " Pije pale konia wale");
                            Main.mainWindow.game.SwitchTalismans(finalI, Integer.parseInt(selected) - 1);
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
    public String interpretTile(int tile){
        String returnString = "Chuj";
        if (tile>100){
            switch ((tile-50)/100){
                case 2:
                    return "Man5-Dora.png";
                case 3:
                    return "Pin5-Dora.png";
                case 4:
                    return "Sou5-Dora.png";
                default:
                    System.out.println("Nie wiem jakim chujem to zaszło interpretacja tile "+tile);
                    return "Nie wiem jakim chujem to zaszło";
            }
        }else {
            switch (tile/10){
                case 2:
                    return "Man" + tile%10 + ".png";
                case 3:
                    return "Pin" + tile%10 + ".png";
                case 4:
                    return "Sou" + tile%10 + ".png";
                case 1:
                    switch (tile%10){
                        case 1:
                            return "Ton.png";
                        case 2:
                            return "Nan.png";
                        case 3:
                            return "Shaa.png";
                        case 4:
                            return "Pei.png";
                        case 5:
                            return "Chun.png";
                        case 6:
                            return "Haku.png";
                        case 7:
                            return "Hatsu.png";
                        default:
                            System.out.println("Kon kurwa Gratulations nie wiem jakim chujem ci sie to udało " + tile);
                    }
                    default:
                        System.out.println(" jak to widzisz to kuźwa gratulacje bo to niemożliwe "+ tile);
            }
        }

        return returnString;
    }
    public void addDoras(){
        DoraPanel = new JPanel();
        DoraPanel = new JPanel();
        DoraPanel.setLayout(new BoxLayout(DoraPanel,BoxLayout.X_AXIS));
        int Doraheight = (int)(this.getHeight()*0.1 -6);
        int Dorawidth = (int)(Doraheight*0.75 );



        DoraPanel.setBounds(
                (int)(this.getWidth()/40),
                (int)(this.getHeight()*0.1),
                (int)(this.getWidth()/4),
                (int)(this.getHeight()*0.1 +6));
        DoraPanel.setOpaque(true);
        DoraPanel.setBackground(new Color(200, 165, 60, 200));
        JScrollPane doraScroll = new JScrollPane(
                DoraPanel,
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        );
        doraScroll.setBounds(
                (int)(this.getWidth()/40),
                (int)(this.getHeight()*0.1),
                (int)(this.getWidth()/4),
                (int)(this.getHeight()*0.1 +6)
        );
        layeredPane.add(doraScroll, JLayeredPane.DEFAULT_LAYER);

        Main.mainWindow.game.addDoraTiles();
        DoraPanel.add(Box.createHorizontalStrut((int)(5)));
        for(int i = 0; i < Main.mainWindow.game.DoraTiles.size(); i++){
            int height = Doraheight;
            int width = (int)(height*0.75 );
            DoraPanel.add(Box.createHorizontalStrut((int)(1)));

            ArrayList<Integer> doras = Main.mainWindow.game.DoraTiles;

            ImageIcon icon = new ImageIcon("src/imgs/Regular/"+interpretTile(doras.get(i)));
            Image image = icon.getImage();


            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            JPanel tile = new JPanel();
            tile.setMaximumSize(new Dimension(width, height));
            tile.setMinimumSize(new Dimension(width, height));
            tile.setBackground(new Color(0,0,0,0));
            tile.setOpaque(true);
            tile.setLayout(null);

            JLabel background = new JLabel();
            background.setBounds(0, 0, width, height);

            ImageIcon icon2 = new ImageIcon("src/imgs/Regular/Front.png");
            Image image2 = icon2.getImage();
            Image scaledImage2 = image2.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            background.setIcon(new ImageIcon(scaledImage2));

            JLabel img = new JLabel();
            img.setIcon(new ImageIcon( scaledImage));
            img.setBounds(0, 0, width, height);

            tile.add(img);
            tile.add(background);
            DoraPanel.add(tile);


        }
        layeredPane.revalidate();
        layeredPane.repaint();
    }
    public void addKans(int kanTile) throws IOException, FontFormatException {
        if (kanTile!=0) {
            Kans++;
            KansArray.add(kanTile);
        }

        if (Kans ==0){}
        else {

            int tileWidth = this.getWidth()/5 /4 - 5*10;
            int tileHeight = tileWidth*4/3;

            KanPanel = new JPanel();
            KanPanel.setLayout(new BoxLayout(KanPanel, BoxLayout.Y_AXIS));
            KanPanel.setBackground(new Color(200, 165, 60, 200));
            KanPanel.setBounds(
                    (int)(this.getWidth() - this.getHeight()/40 - this.getWidth()/5),
                    (int)(this.getHeight()*0.3),
                    this.getWidth()/7,
                    Kans*(tileHeight)+(Kans+1)*10
            );

            for (int i =0; i < Kans;i++) {
                JPanel KanHolder = new JPanel();
                KanHolder.setMaximumSize(new Dimension(this.getWidth()/5, tileHeight+10));
                KanHolder.setBackground(new Color(0,0,255,0));
                KanHolder.setOpaque(true);
                KanHolder.setLayout(new FlowLayout());
                KanPanel.add(KanHolder);

                for (int j = 0; j < 4; j++) {
                    JPanel KanHolder2 = new JPanel();
                    KanHolder2.setMaximumSize(new Dimension(tileWidth +5, tileHeight+5));
                    KanHolder2.setPreferredSize(new Dimension(tileWidth +6, tileHeight+6));
                    KanHolder2.setBackground(new Color(255,0,0,0));
                    KanHolder2.setOpaque(true);
                    KanHolder2.setLayout(null);

                    ImageIcon icon = new ImageIcon("src/imgs/Regular/" + interpretTile(KansArray.get(i)));
                    Image image = icon.getImage();
                    Image scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                    ImageIcon icon2 = new ImageIcon("src/imgs/Regular/Front.png");
                    Image image2 = icon2.getImage();
                    Image scaledImage2 = image2.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                    JLabel tileImg = new JLabel();
                    tileImg.setIcon(new ImageIcon(scaledImage));
                    tileImg.setBounds(3, 3, tileWidth, tileHeight);

                    JLabel tileImg2 = new JLabel();
                    tileImg2.setIcon(new ImageIcon(scaledImage2));
                    tileImg2.setBounds(3, 3, tileWidth, tileHeight);
                    KanHolder2.add(tileImg);
                    KanHolder2.add(tileImg2);

                    KanHolder.add(KanHolder2);
                }
            }
            int emptyslot=-1;
            for (int i = 0; i < hand.length; i++) {
                if (KansArray.contains(hand[i])){
                    hand[i] = 0;
                    if (emptyslot==-1) {
                        emptyslot = i;
                    }
                }
                System.out.println(hand[i] + " kans ");
            }
            switchTile(emptyslot);
            Main.mainWindow.game.Sorthand(hand);

            if (Kans==4){
                endGame();
            }


            layeredPane.add(KanPanel, JLayeredPane.DEFAULT_LAYER);
        }


    }
    public void addKans2(){

    }
    public void updateWall(){
        TileWall = new JPanel();
        int tileHeight = (int)(this.getHeight()/2.5 /4);
        int tileWidth = tileHeight*3/4;
        TileWall.setBounds(
                (int)(this.getWidth()/2 - this.getWidth()/2/2 ),
                (int)(this.getHeight()*0.25 ),
                tileWidth*9+6*9 +60,
                (int)(this.getHeight()/2.5 + 10) + 24
        );
        TileWall.setBackground(new Color(200, 165, 60, 200));
        TileWall.setOpaque(true);
        TileWall.setLayout(new BoxLayout(TileWall, BoxLayout.Y_AXIS));



        int tileIdndex = 0;
        for (int i=0; i < 4; i++) {
            JPanel TileWallHolder = new JPanel();
            TileWallHolder.setMaximumSize(new Dimension((int)(this.getWidth()/2) +60 ,(int)(this.getHeight()/2.5 /4)+6));
            TileWallHolder.setBackground(new Color(0,0,255,0));
            TileWallHolder.setOpaque(true);
            TileWallHolder.setLayout(new BoxLayout(TileWallHolder, BoxLayout.X_AXIS));

            for (int j = 0; j < 9; j++) {
                JPanel TileWallHolder2 = new JPanel();
                TileWallHolder2.setLayout(null);
                TileWallHolder2.setBackground(new Color(255,0,0,0));
                TileWallHolder2.setMaximumSize(new Dimension((this.getWidth()/2)/9 +6, (int)(this.getHeight()/2.5 /4) +6));
                TileWallHolder2.setMinimumSize(new Dimension((this.getWidth()/2)/9 +6, (int)(this.getHeight()/2.5 /4) +6));
                TileWallHolder2.setOpaque(true);

                ImageIcon icon;
                ImageIcon icon2;
                Image scaledImage;
                Image scaledImage2;

                Boolean isOpen = false;
                Boolean isSoul = false;
                Boolean IDCA = false;
                if ((TileWallArray.get(tileIdndex) !=null)){
                    IDCA = true;
                }

                for (int k = 0;k< openOnes.length;k++) {
                    if (openOnes[k] == tileIdndex){
                        isOpen = true;
                    }

                }
                if (!Main.mainWindow.game.SoulTiles.isEmpty()){
                    for (int k = 0;k<Main.mainWindow.game.SoulTiles.size();k++) {
                        if (Main.mainWindow.game.SoulTiles.get(k) == tileIdndex){
                            isSoul = true;
                        }
                    }
                }

                JLabel tileImg = new JLabel();

                if (TileWallArray.get(tileIdndex) ==null) {
                    icon = new ImageIcon("src/imgs/Regular/");
                    Image image = icon.getImage();
                    scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                    icon2 = new ImageIcon("src/imgs/Regular/");
                    Image image2 = icon2.getImage();
                    scaledImage2 = image2.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);
                }else if (isOpen || tileIdndex==wallIndex){
                    icon = new ImageIcon("src/imgs/Regular/" + interpretTile(TileWallArray.get(tileIdndex)));
                    Image image = icon.getImage();
                    scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                    icon2 = new ImageIcon("src/imgs/Regular/Front.png");
                    Image image2 = icon2.getImage();
                    scaledImage2 = image2.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);


                }else{
                    icon = new ImageIcon("src/imgs/Regular/Back.png");
                    Image image = icon.getImage();
                    scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                    icon2 = new ImageIcon("src/imgs/Regular/Front.png");
                    Image image2 = icon2.getImage();
                    scaledImage2 = image2.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);
                }


                tileImg.setIcon(new ImageIcon(scaledImage));
                tileImg.setBounds(3, 3, tileWidth, tileHeight);
                tileImg.setOpaque(false);

                if (isSoul && isOpen && IDCA){
                    tileImg.setBackground(new Color(255, 255, 0,150));
                    tileImg.setOpaque(true);
                }

                JLabel tileImg2 = new JLabel();
                tileImg2.setIcon(new ImageIcon(scaledImage2));
                tileImg2.setBounds(3, 3, tileWidth, tileHeight);
                tileImg2.setOpaque(false);

                TileWallHolder2.add(tileImg);
                TileWallHolder2.add(tileImg2);
                TileWallHolder2.setOpaque(false);

                TileWallHolder.add(TileWallHolder2);
                tileIdndex++;
            }
            TileWall.add(TileWallHolder);

        }

        layeredPane.add(TileWall, JLayeredPane.DEFAULT_LAYER);
    }
    public void updateHand() throws IOException {
        if (kanButton != null) {
            layeredPane.remove(kanButton);
        }
        if (tenpaiDisplay!=null){
            layeredPane.remove(tenpaiDisplay);
        }



        hand = Main.mainWindow.game.Sorthand(hand);
        yekerMeister_mk_III.hand = hand;
        List<List<Integer>> tenpai = yekerMeister_mk_III.TenpaiAllCombined(yekerMeister_mk_III.hand);
        System.out.println("Yeker "+tenpai);
        handWall = new JPanel();
        int tileHeight = (int)(this.getHeight()*0.1 );
        int tileWidth = tileHeight*3/4;
        handWall.setBounds(
                (int)(this.getWidth()/2 - this.getHeight()*0.1*11.5/2 ),
                (int)(this.getHeight() - this.getHeight()*0.12 - this.getHeight()/15 ),
                (int)(this.getHeight()*0.10*11.5),
                (int)(this.getHeight()*0.1) + 24
        );
        handWall.setBackground(new Color(200, 165, 60, 200));
        handWall.setOpaque(true);
        handWall.setLayout(new BoxLayout(handWall, BoxLayout.X_AXIS));

        handWall.add(Box.createHorizontalStrut(10));

        for (int tileIdndex=0; tileIdndex < 14; tileIdndex++) {
            if (hand[tileIdndex] ==0){
                handWall.add(Box.createHorizontalStrut((tileWidth +6)));
            }else {
                System.out.println(hand[tileIdndex]);
                Boolean isSoul = false;
                if (!Main.mainWindow.game.SoulTiles.isEmpty()) {
                    for (int k = 0; k < Main.mainWindow.game.SoulTiles.size(); k++) {
                        if (Main.mainWindow.game.SoulTiles.get(k) == hand[tileIdndex]) {
                            isSoul = true;
                        }
                    }
                }
                Boolean isDora = false;
                if (!Main.mainWindow.game.DoraTiles.isEmpty()) {
                    for (int k = 0; k < Main.mainWindow.game.DoraTiles.size(); k++) {
                        if (Main.mainWindow.game.DoraTiles.get(k) == hand[tileIdndex]) {
                            System.out.println("found one");
                            isDora = true;
                        }
                    }
                }
                Boolean isSwitch = false;
                for (int k = 0; k < selectedArray.size(); k++) {
                    if (selectedArray.get(k) == tileIdndex) {
                        isSwitch = true;
                    }
                }


                JPanel TileWallHolder2 = new JPanel();


                TileWallHolder2.setLayout(null);
                TileWallHolder2.setBackground(new Color(255, 0, 0, 0));
                TileWallHolder2.setMaximumSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));
                TileWallHolder2.setMinimumSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));
                TileWallHolder2.setPreferredSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));


                ImageIcon icon;
                ImageIcon icon2;
                Image scaledImage;
                Image scaledImage2;

                Image image;
                if (hand[tileIdndex] == 0) {
                    icon = new ImageIcon("src/imgs/Regular/");
                    image = icon.getImage();
                    scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                    icon2 = new ImageIcon("src/imgs/Regular/");
                    Image image2 = icon2.getImage();
                    scaledImage2 = image2.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);
                } else {


                    icon = new ImageIcon("src/imgs/Regular/" + interpretTile(hand[tileIdndex]));
                    image = icon.getImage();
                    scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                    icon2 = new ImageIcon("src/imgs/Regular/Front.png");
                    Image image2 = icon2.getImage();
                    scaledImage2 = image2.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                }

                JLabel tileImg = new JLabel();
                tileImg.setIcon(new ImageIcon(scaledImage));
                tileImg.setBounds(3, 3, tileWidth, tileHeight);
                tileImg.setOpaque(false);
                if (isSoul) {
                    tileImg.setBackground(new Color(255, 255, 0, 150));
                    tileImg.setOpaque(true);
                }
                if (true) {

                }

                JLabel tileImg2 = new JLabel();
                tileImg2.setIcon(new ImageIcon(scaledImage2));
                tileImg2.setBounds(3, 3, tileWidth, tileHeight);
                tileImg2.setOpaque(false);


                if (isDora) {
                    TileWallHolder2.add(new PisarzJavy("Dora", this.getWidth(), this.getHeight()));
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }
                if (isSwitch) {
                    TileWallHolder2.add(new JavowePifPaf(this.getWidth(), this.getHeight()));
                    layeredPane.revalidate();
                    layeredPane.repaint();
                }


                if (tenpai.get(tileIdndex).get(0)==0){

                }else{
                    TileWallHolder2.add(new CzyKochalaBysMniebardziejZaJave(this.getWidth(), this.getHeight()));
                    layeredPane.revalidate();
                    layeredPane.repaint();
                    int finalTileIdndex1 = tileIdndex;
                    TileWallHolder2.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseEntered(MouseEvent e) {
                            displayTenpais(TileWallHolder2, tenpai.get(finalTileIdndex1));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            System.out.println("Gej");
                            if (tenpaiDisplay!=null) {
                                System.out.println("Party");
                                layeredPane.remove(tenpaiDisplay);
                                layeredPane.revalidate();
                                layeredPane.repaint();
                            }
                        }
                    });
                }

                TileWallHolder2.add(tileImg);
                TileWallHolder2.add(tileImg2);
                handWall.add(TileWallHolder2);

                int finalTileIdndex = tileIdndex;
                TileWallHolder2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Sex");
                        try {
                            switchTile(finalTileIdndex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (FontFormatException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });
            }


        }
        if (phase2) {
//                <editor-fold desc"kan">
            if (kanButton!=null){
                layeredPane.remove(kanButton);
            }
            potentialKansArray.clear();
            Map<Integer, Integer> countMap = new HashMap<>();

            for (int num : hand) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
            for (int num : countMap.keySet()) {
                if (countMap.get(num) == 4) {
                    potentialKansArray.add(num);
                }
            }
            if (!potentialKansArray.isEmpty()) {
                showKanButton();
            }
//                </editor-fold>
            System.out.println((winButton!=null)+"sex or smth");
            if (winButton!=null){
                layeredPane.remove(winButton);
                winButton = null;
            }
            System.out.println(" nie przeżuje "+(yekerMeister_mk_III.isComplete(hand)));
            if (yekerMeister_mk_III.isComplete(hand)) {
                winButton= new JButton();;
                winButton.setFont(Jap);
                winButton.setText(" Win ");
                winButton.setBounds(
                        (int)(this.getWidth()*0.85 - labelSize.stringWidth(" Win ") ),
                        (int)(this.getHeight() - this.getHeight()*0.12 - this.getHeight()/7 ),
                        (int)(labelSize.stringWidth(" Win ") + 80),
                        (int)(labelSize.getHeight())
                );
                winButton.setOpaque(true);
                winButton.setBackground(new Color(245, 205, 105, 255));
                winButton.setFont(Jap);
                winButton.addActionListener(e -> {
                    //            TODO ADD FUNCTION DUMBFUCK v2
                    if (!isWinning) {
                        win();
                    }
                });
                layeredPane.add(winButton,JLayeredPane.DEFAULT_LAYER);
            }
        }
        layeredPane.revalidate();
        layeredPane.repaint();

        layeredPane.add(handWall, JLayeredPane.DEFAULT_LAYER);
    }
    public void showKanButton() throws IOException {
        kanButton= new JButton();;
        kanButton.setFont(Jap);
        kanButton.setText(" Kan ");
        kanButton.setBounds(
                (int)(this.getWidth()*0.75 - labelSize.stringWidth(" Kan ") ),
                (int)(this.getHeight() - this.getHeight()*0.12 - this.getHeight()/7 ),
                (int)(labelSize.stringWidth(" Kan ") + 80),
                (int)(labelSize.getHeight())
        );
        kanButton.setOpaque(true);
        kanButton.setBackground(new Color(245, 205, 105, 255));
        kanButton.setFont(Jap);
        kanButton.addActionListener(e -> {
            //            TODO ADD FUNCTION DUMBFUCK v2
            if (potentialKansArray.size() > 1) {
                chooseYourKan();
            }else {
                try {
                    addKans(potentialKansArray.get(0));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        layeredPane.add(kanButton,JLayeredPane.DEFAULT_LAYER);
    }
    public void chooseYourKan() {
        int tileWidth = this.getWidth()/20;
        int tileHeight = tileWidth*4/3;
        int kanpanelsize = tileWidth*(potentialKansArray.size()+1) +(potentialKansArray.size()+2)*this.getWidth()/60 ;
        kanpenl = new JPanel();
        kanpenl.setBackground(new Color(245, 205, 105, 255));
        kanpenl.setLayout(new FlowLayout());
        kanpenl.setBounds(
                (int)(this.getWidth()/2 - kanpanelsize/2),
                (int)(this.getHeight()/2 - (tileHeight+120)/2),
                kanpanelsize,
                tileHeight+12
        );

        System.out.println(potentialKansArray);

        for (int tileIdndex=0; tileIdndex < potentialKansArray.size(); tileIdndex++) {
            kanpenl.add(Box.createHorizontalStrut(this.getWidth()/120));
                System.out.println(potentialKansArray.get(tileIdndex));
                JPanel TileWallHolder2 = new JPanel();


                TileWallHolder2.setLayout(null);
                TileWallHolder2.setBackground(new Color(255, 0, 0, 0));
                TileWallHolder2.setMaximumSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));
                TileWallHolder2.setMinimumSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));
                TileWallHolder2.setPreferredSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));


                ImageIcon icon;
                ImageIcon icon2;
                Image scaledImage;
                Image scaledImage2;

                Image image;

                icon = new ImageIcon("src/imgs/Regular/" + interpretTile(potentialKansArray.get(tileIdndex)));
                image = icon.getImage();
                scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                icon2 = new ImageIcon("src/imgs/Regular/Front.png");
                Image image2 = icon2.getImage();
                scaledImage2 = image2.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

                JLabel tileImg = new JLabel();
                tileImg.setIcon(new ImageIcon(scaledImage));
                tileImg.setBounds(3, 3, tileWidth, tileHeight);
                tileImg.setOpaque(false);

                JLabel tileImg2 = new JLabel();
                tileImg2.setIcon(new ImageIcon(scaledImage2));
                tileImg2.setBounds(3, 3, tileWidth, tileHeight);
                tileImg2.setOpaque(false);

                TileWallHolder2.add(tileImg);
                TileWallHolder2.add(tileImg2);


                kanpenl.add(TileWallHolder2);

                int finalTileIdndex = tileIdndex;
                TileWallHolder2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        System.out.println("Sex");
                        try {
                            addKans(potentialKansArray.get(finalTileIdndex));
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        } catch (FontFormatException ex) {
                            throw new RuntimeException(ex);
                        }
                        layeredPane.remove(kanpenl);
                        layeredPane.revalidate();
                        layeredPane.repaint();
                    }
                });
        }
        kanpenl.add(Box.createHorizontalStrut(this.getWidth()/120));
        JPanel TileWallHolder2 = new JPanel();


        TileWallHolder2.setLayout(null);
        TileWallHolder2.setBackground(new Color(255, 0, 0, 0));
        TileWallHolder2.setMaximumSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));
        TileWallHolder2.setMinimumSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));
        TileWallHolder2.setPreferredSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));

        ImageIcon icon;
        Image scaledImage;

        Image image;

        icon = new ImageIcon("src/imgs/Regular/no.png");
        image = icon.getImage();
        scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

        JLabel tileImg = new JLabel();
        tileImg.setIcon(new ImageIcon(scaledImage));
        tileImg.setBounds(3, 3, tileWidth, tileHeight);
        tileImg.setOpaque(false);


        TileWallHolder2.add(tileImg);

        kanpenl.add(TileWallHolder2);
        layeredPane.add(kanpenl,JLayeredPane.MODAL_LAYER);

        TileWallHolder2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Sex 2 ");
                layeredPane.remove(kanpenl);
                System.out.println("Sex 3 ");
                layeredPane.revalidate();
                layeredPane.repaint();
                System.out.println("Sex 4 ");
            }
        });


    }
    public void displayTenpais(JPanel ref, List<Integer> tenpais){
        int tileWidth = this.getWidth()/60;
        int tileHeight = tileWidth*4/3;
        int kanpanelsize = tileWidth*(tenpais.size()+4) +(tenpais.size()+2)*this.getWidth()/120 ;
        tenpaiDisplay = new JPanel();
        tenpaiDisplay.setLayout(null);
//        TODO YOU LAZY FUCK MAKE DISPLAY OF TENPAI PER TILE
        tenpaiDisplay.setBackground(new Color(245, 205, 105, 255));
        tenpaiDisplay.setLayout(new FlowLayout());
        tenpaiDisplay.setBounds(
                (int)(this.getWidth()/2 - kanpanelsize/2),
                (int)(this.getHeight()*0.8 - (tileHeight+120)/2),
                kanpanelsize,
                tileHeight+12
        );

        System.out.println(tenpais);

        for (int tileIdndex=0; tileIdndex < tenpais.size(); tileIdndex++) {
            tenpaiDisplay.add(Box.createHorizontalStrut(this.getWidth()/200));
            System.out.println(tenpais.get(tileIdndex));
            JPanel TileWallHolder2 = new JPanel();


            TileWallHolder2.setLayout(null);
            TileWallHolder2.setBackground(new Color(255, 0, 0, 0));
            TileWallHolder2.setMaximumSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));
            TileWallHolder2.setMinimumSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));
            TileWallHolder2.setPreferredSize(new Dimension((tileWidth + 6), (int) (tileHeight + 6)));


            ImageIcon icon;
            ImageIcon icon2;
            Image scaledImage;
            Image scaledImage2;

            Image image;

            icon = new ImageIcon("src/imgs/Regular/" + interpretTile(tenpais.get(tileIdndex)));
            image = icon.getImage();
            scaledImage = image.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

            icon2 = new ImageIcon("src/imgs/Regular/Front.png");
            Image image2 = icon2.getImage();
            scaledImage2 = image2.getScaledInstance(tileWidth, tileHeight, Image.SCALE_SMOOTH);

            JLabel tileImg = new JLabel();
            tileImg.setIcon(new ImageIcon(scaledImage));
            tileImg.setBounds(3, 3, tileWidth, tileHeight);
            tileImg.setOpaque(false);

            JLabel tileImg2 = new JLabel();
            tileImg2.setIcon(new ImageIcon(scaledImage2));
            tileImg2.setBounds(3, 3, tileWidth, tileHeight);
            tileImg2.setOpaque(false);

            TileWallHolder2.add(tileImg);
            TileWallHolder2.add(tileImg2);


            tenpaiDisplay.add(TileWallHolder2);

        }
        tenpaiDisplay.add(Box.createHorizontalStrut(this.getWidth()/120));

        layeredPane.add(tenpaiDisplay,JLayeredPane.MODAL_LAYER);


    }

    public void switchTile(int tileIdndex) throws IOException, FontFormatException {
        if(wallIndex==35) {
            endGame();
        }else
            System.out.println(" Okrutna");
            if (phase2) {
                drawNum++;
                hand[tileIdndex] = TileWallArray.get(wallIndex);
                lastTile = TileWallArray.get(wallIndex);
                TileWallArray.set(wallIndex, null);
                wallIndex++;
                layeredPane.remove(TileWall);
                layeredPane.remove(handWall);
                updateHand();
                updateWall();
                layeredPane.repaint();
                layeredPane.revalidate();
            }else{
                Boolean isSelected =false;
                int index =0;
                for (int i = 0;i <selectedArray.size();i++) {
                    if (selectedArray.get(i) == tileIdndex) {
                        isSelected = true;
                        index = tileIdndex;
                        break;
                    }
                }
                if (isSelected) {
                    selectedArray.remove((Object)(index));
                }else{
                    selectedArray.add(tileIdndex);
                }

                System.out.println(" BAŁAKNICA");
                layeredPane.remove(handWall);
                updateHand();
                layeredPane.repaint();
                layeredPane.revalidate();
            }

    }

    public void win(){
        if (drawNum==1){
            yekerMeister_mk_III.firstDraw = true;
        }
        if (drawNum==35){
            yekerMeister_mk_III.lastDraw = true;
        }

        Map<String,Object> bullshit = yekerMeister_mk_III.analyzeYakuFull(hand);
        fu = (int)bullshit.get("fu");

        yekerMeister_mk_III.firstDraw = false;
        yekerMeister_mk_III.lastDraw = false;

        isWinning = true;

        // <editor-fold desc="main panel">
        System.out.println("congrats");
        JPanel WinPanel = new JPanel();
        WinPanel.setLayout(new GridLayout(2, 1));

        int panelWidth = (int)(this.getWidth()*0.7);
        int panelHeight = (int)(this.getWidth()*0.4);
        WinPanel.setBounds(
                this.getWidth()/2 - panelWidth/2,
                this.getHeight()/2 - panelHeight/2,
                panelWidth,
                panelHeight
        );
        WinPanel.setBackground(new Color(103,47,22,255));
        layeredPane.add(WinPanel,JLayeredPane.POPUP_LAYER);
        // </editor-fold>

        points = points + (Integer) bullshit.get("points");
        Punktaż.setText("("+points+"/" + pointReq[levelIndex] + ")");
        Procentaż.setText("("+points/pointReq[levelIndex]*100 + "%)");
        Punktaż.setBounds(
                (int)(this.getWidth()/2 - labelSize.stringWidth("("+points+"/" + pointReq[levelIndex] + ")")/2),
                (int)(this.getHeight()*0.1*0.2),
                labelSize.stringWidth("("+points+"/" + pointReq[levelIndex] + ")"),
                (int)(this.getHeight()*0.1*0.7));
        Procentaż.setBounds(
                (int)(this.getWidth()/2 - this.getWidth()/2/2 - labelSize.stringWidth("("+points/pointReq[levelIndex]*100 + "%)")),
                (int)(this.getHeight()*0.1*0.2 +2),
                labelSize.stringWidth("("+points/pointReq[levelIndex]*100 + "%)"),
                (int)(this.getHeight()*0.1*0.7 -4));
        pointaż.setBounds(
                (int)(this.getWidth()/2 - this.getWidth()/2/2 +2),
                (int)(this.getHeight()*0.1*0.2 +2),
                (int)(this.getWidth()/2*(Math.min(points/pointReq[levelIndex], 1)) -4),
                (int)(this.getHeight()*0.1*0.7) -4);


        // <editor-fold desc="Yakus panel">
        List<String> yakus = (List<String>) bullshit.get("yakuList");
        System.out.println(yakus);

        JPanel yakusPanel = new JPanel();
        yakusPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // horizontal and vertical gaps
        yakusPanel.setBackground(new Color(103,47,22,255));
        WinPanel.add(yakusPanel);

        int cellWidth = panelWidth / 4 - 10;
        int cellHeight = (int)((double) panelHeight /4/5.6);

        for (String yaku : yakus){
            JPanel yakuHolder1 = new JPanel();
            yakuHolder1.setLayout(null);
            yakuHolder1.setPreferredSize(new Dimension(cellWidth, cellHeight));
            yakuHolder1.setOpaque(true);
            yakuHolder1.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            yakuHolder1.setBackground(new Color(103,255,22,255));
            yakusPanel.add(yakuHolder1);

            // ... rest of your yaku content code (keep this the same)
            ImageIcon icon;
            Image scaledImage;
            Image image;

            // <editor-fold desc="tier fuckery">
            String rarity= "";
            String buff0 = "";
            Boolean imIn =false;
            for (int i =0;i < yaku.length();i++){
                if (yaku.charAt(i) == '('){
                    imIn=true;
                    continue;
                }
                if (yaku.charAt(i) == ')'){
                    break;
                }
                if (imIn){
                    buff0 = buff0 +  yaku.charAt(i);
                }
            }
            switch(buff0){
                case "1":
                    rarity="common.png";
                    break;
                case "2":
                    rarity="uncommon.png";
                    break;
                case "3":
                    rarity="rare.png";
                    break;
                case "6":
                    rarity="mythical.png";
                    break;
                case "Yakuman":
                    rarity="Legendary.png";
                    break;
                case "Double Yakuman":
                    rarity="Legendary.png";
                    break;
                default:
                    System.out.println("what the fucking sigma  "+buff0);
                    break;
            }
            // </editor-fold>

            icon = new ImageIcon("src/imgs/yakuBG/" + rarity);
            image = icon.getImage();
            scaledImage = image.getScaledInstance(cellWidth, cellHeight, Image.SCALE_SMOOTH);

            JLabel tileImg = new JLabel();
            tileImg.setIcon(new ImageIcon(scaledImage));
            tileImg.setBounds(0, 0, cellWidth, cellHeight);
            tileImg.setOpaque(true);
            tileImg.setBackground(new Color(103,47,22,0));

            JLabel yakuText = new JLabel();
            yakuText.setText(yaku);
            yakuText.setOpaque(true);
            yakuText.setFont(Jap);
            yakuText.setBackground(new Color(103,47,22,0));
            yakuText.setBounds(30, 0, cellWidth, cellHeight);

            yakuHolder1.add(yakuText);
            yakuHolder1.add(tileImg);
        }
// </editor-fold>

        // <editor-fold desc="points n shit">
        JPanel showPanel = new JPanel();
        showPanel.setPreferredSize(new Dimension(panelWidth, panelHeight/2));
        showPanel.setBackground(new Color(153,101,50,255));
        showPanel.setLayout(new BoxLayout(showPanel, BoxLayout.Y_AXIS));
        Font Jap2 = Jap.deriveFont((float)(this.getWidth()/20));

        JLabel calculations = new JLabel();
        calculations.setFont(Jap);
        calculations.setAlignmentX(Component.CENTER_ALIGNMENT);
        calculations.setText(fu + " Fu x "+bullshit.get("totalHan")+"Han");
        showPanel.add(calculations);

        JLabel score = new JLabel();
        score.setFont(Jap2);
        score.setAlignmentX(Component.CENTER_ALIGNMENT);
        score.setText(bullshit.get("points") +"");
        showPanel.add(score);

        JButton close = new JButton("close");
        close.setFont(Jap);
        close.setAlignmentX(Component.RIGHT_ALIGNMENT);
        showPanel.add(close);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layeredPane.remove(WinPanel);
                isWinning = false;
                int tileIndex = 14;
                for (int i =0; i< hand.length-1; i++){
                    if (hand[i] == lastTile){
                        tileIndex = i;
                    }
                }
                try {
                    switchTile(tileIndex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (FontFormatException ex) {
                    throw new RuntimeException(ex);
                }

                System.out.println("U siebie rób jak u siebie");
                System.out.println(Arrays.deepToString(Main.mainWindow.game.talismans));
                layeredPane.revalidate();
                layeredPane.repaint();
            }
        });

//        here TODO go to game you fuck

        WinPanel.add(showPanel);


        // </editor-fold>

        layeredPane.revalidate();
        layeredPane.repaint();
    }

    public void endGame() throws IOException, FontFormatException {
//        TODO YOU LAZY FUCK ADD FAIL/WIN SCREEN n CHECKING WINS
        System.out.println("TO JEST JUSZ KONIEC NIE MA JUSZ NIC");
        if(points < pointReq[levelIndex]){
            System.out.println("TO JEST JUSZ KONIEC NIE MA JUSZ NIC Zwei");
            Main.mainWindow.game.reloadPanel(new Loss());
            return;
        }
        Main.mainWindow.game.reloadPanel(new Shop());
    }
    public void switchTM() throws IOException, FontFormatException {
        System.out.println(" K");
        for (int i = 0; i < selectedArray.size(); i++) {
            hand[selectedArray.get(i)] = Main.mainWindow.game.deck.getRandomTile();
            System.out.println(selectedArray.get(i));
        }
        selectedArray.clear();
        System.out.println(" U");
        layeredPane.remove(handWall);
        updateHand();
        System.out.println(" T");
        switches--;
        Switch.setText(" Switch "+switches+" ");
        if (switches <=0) {
            HRT();
        }
    }
    public void skip() throws IOException, FontFormatException {
        HRT();
    }
    public void HRT() throws IOException, FontFormatException {
        phase2 = true;
        layeredPane.remove(Skip);
        layeredPane.remove(Switch);
        switchTile(13);
    }

//<editor-fold desc="import fuckery">
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }
//    </editor-fold>
}
