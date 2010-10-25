package euchre.gui;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JOptionPane;

import euchre.game.Team;
import euchre.gui.pictures.PictureManager;
import euchre.player.Card;
import euchre.player.GameManager;
import euchre.player.Human;
import euchre.player.Player;

/**
 * The GUI that displays the euchre game to the user and allows them to play it.
 * 
 * @author Neil MacBay (nmmacbay)
 * @author sdwilke
 */
public class GameBoard extends javax.swing.JFrame {
	private Card[] hand = new Card[5];
	private Human humanPlayer;
	private PictureManager picManager = new PictureManager();
	private static final long serialVersionUID = 1L;
	private GameManager GM;
	private Player topPlayer;
	private Player leftPlayer;
	private Player rightPlayer;
	
	/** 
	 * Creates new form GameBoard
	 * @param player the human player object being controlled from the game board
	 */
    public GameBoard(){
        initComponents();
        centerScreen();
        heartsButton.setVisible(false);
        clubsButton.setVisible(false);
        diamondsButton.setVisible(false);
        spadesButton.setVisible(false);
        suitPassButton.setVisible(false);
    }
    
    /**
     * resets the board to start a new round
     */
    public void newRound(){
    	YourPlayed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/empty.png")));
        RPlayed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/empty.png")));
        LPlayed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/empty.png")));
        UPlayed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/empty.png")));
        UCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png")));
        UCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png")));
        UCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png")));
        UCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png")));
        UCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png")));
        LCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        LCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        LCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        LCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        LCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        RCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        RCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        RCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        RCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        RCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png")));
        jButtonPass.setVisible(true);
		jButtonPickUp.setVisible(true);
		TurnedCard.setVisible(true);
		jLabelDealer.setVisible(true);
		jButtonYourCard1.setIcon(picManager.getPicture(humanPlayer.getHand()[0].getSuit(), humanPlayer.getHand()[0].getCardValue()));
        jButtonYourCard2.setIcon(picManager.getPicture(humanPlayer.getHand()[1].getSuit(), humanPlayer.getHand()[1].getCardValue()));
        jButtonYourCard3.setIcon(picManager.getPicture(humanPlayer.getHand()[2].getSuit(), humanPlayer.getHand()[2].getCardValue()));
        jButtonYourCard4.setIcon(picManager.getPicture(humanPlayer.getHand()[3].getSuit(), humanPlayer.getHand()[3].getCardValue()));
        jButtonYourCard5.setIcon(picManager.getPicture(humanPlayer.getHand()[4].getSuit(), humanPlayer.getHand()[4].getCardValue()));
    }
    
    /**
     * sets which player is using the gameboard
     * 
     * @param n player number
     */
    public void setPlayerNumber(int n){
    	
    }
    
    
    /**
     * sets the game manager so gameboard can have access to the players
     * 
     * @param gm the game manager
     */
    public void setGameManager(GameManager gm){
    	GM = gm;
    	humanPlayer = (Human) GM.getPlayerIAm();
    	if(humanPlayer.getTeam() == 1){
    		if(gm.getTeamOne().getPlayerOne().getNumber() != humanPlayer.getNumber()){
    			topPlayer = gm.getTeamOne().getPlayerOne();
    		}else{
    			topPlayer = gm.getTeamOne().getPlayerTwo();
    		}
    		leftPlayer = gm.getTeamTwo().getPlayerOne();
    		rightPlayer = gm.getTeamTwo().getPlayerTwo();
    		setWeTeam(gm.getTeamOne());
    		setTheyTeam(gm.getTeamTwo());
    	}else{
    		if(gm.getTeamTwo().getPlayerOne().getNumber() != humanPlayer.getNumber()){
    			topPlayer = gm.getTeamTwo().getPlayerOne();
    		}else{
    			topPlayer = gm.getTeamTwo().getPlayerTwo();
    		}
    		leftPlayer = gm.getTeamOne().getPlayerOne();
    		rightPlayer = gm.getTeamOne().getPlayerTwo();
    		setWeTeam(gm.getTeamTwo());
    		setTheyTeam(gm.getTeamOne());
    	}
    	setTopPlayer(topPlayer);
    	setLeftPlayer(leftPlayer);
    	setRightPlayer(rightPlayer);
    	setBottomPlayer(humanPlayer);
    }
    
    private void setTopPlayer(Player player){
    	jLabelUPlayerName.setText(player.getName());
    }
    
	private void setBottomPlayer(Player player){
		jLabelYourName.setText(player.getName());
		setCard(player.getHand()[0], 0);
		setCard(player.getHand()[1], 1);
		setCard(player.getHand()[2], 2);
		setCard(player.getHand()[3], 3);
		setCard(player.getHand()[4], 4);
	}
	
	private void setLeftPlayer(Player player){
		jLabelLPlayerName.setText(player.getName());
	}
	
	private void setRightPlayer(Player player){
		jLabelRPlayerName.setText(player.getName());
	}
    
	public void setWeTeam(Team team){
		weTeamNumberLabel.setText("" + team.getTeamNumber());
	}
	
	public void setTheyTeam(Team team){
		theyTeamNumberLabel.setText("" + team.getTeamNumber());
	}
	
    /**
     * Moves the jFrame to the center of the screen
     */
    private void centerScreen(){
        int xCenter = Toolkit.getDefaultToolkit().getScreenSize().width/2;
        int yCenter = Toolkit.getDefaultToolkit().getScreenSize().height/2;
        int xSize = this.getSize().width;
        int ySize = this.getSize().height;
        Point p = new Point();
        p.setLocation(xCenter - xSize/2, yCenter - ySize/2);
        this.setLocation(p);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonYourCard1 = new javax.swing.JButton();
        jButtonYourCard2 = new javax.swing.JButton();
        jButtonYourCard4 = new javax.swing.JButton();
        jButtonYourCard5 = new javax.swing.JButton();
        jButtonYourCard3 = new javax.swing.JButton();
        jLabelUPlayerName = new javax.swing.JLabel();
        jLabelLPlayerName = new javax.swing.JLabel();
        jLabelRPlayerName = new javax.swing.JLabel();
        jLabelYTeamPoints = new javax.swing.JLabel();
        weTricksLabel = new javax.swing.JLabel();
        jLabelYTeamTricks = new javax.swing.JLabel();
        wePointsLabel = new javax.swing.JLabel();
        theyPointsLabel = new javax.swing.JLabel();
        jLabelOTeamPoints = new javax.swing.JLabel();
        theyTricksLabel = new javax.swing.JLabel();
        jLabelOTeamTricks = new javax.swing.JLabel();
        jButtonPass = new javax.swing.JButton();
        jButtonPickUp = new javax.swing.JButton();
        jLabelYourName = new javax.swing.JLabel();
        jLabelDealer = new javax.swing.JLabel();
        jLabelPassInfo = new javax.swing.JLabel();
        theyLabel = new javax.swing.JLabel();
        weLabel = new javax.swing.JLabel();
        theyTeamNumberLabel = new javax.swing.JLabel();
        weTeamNumberLabel = new javax.swing.JLabel();
        heartsButton = new javax.swing.JButton();
        clubsButton = new javax.swing.JButton();
        diamondsButton = new javax.swing.JButton();
        spadesButton = new javax.swing.JButton();
        suitPassButton = new javax.swing.JButton();
        UPlayed = new javax.swing.JLabel();
        LPlayed = new javax.swing.JLabel();
        YourPlayed = new javax.swing.JLabel();
        TurnedCard = new javax.swing.JLabel();
        RCard1 = new javax.swing.JLabel();
        RCard2 = new javax.swing.JLabel();
        RCard3 = new javax.swing.JLabel();
        RCard4 = new javax.swing.JLabel();
        RCard5 = new javax.swing.JLabel();
        LCard4 = new javax.swing.JLabel();
        LCard3 = new javax.swing.JLabel();
        LCard2 = new javax.swing.JLabel();
        LCard1 = new javax.swing.JLabel();
        LCard5 = new javax.swing.JLabel();
        UCard1 = new javax.swing.JLabel();
        UCard2 = new javax.swing.JLabel();
        UCard3 = new javax.swing.JLabel();
        UCard4 = new javax.swing.JLabel();
        UCard5 = new javax.swing.JLabel();
        RPlayed = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Euchre Game Board");
        setBackground(java.awt.Color.lightGray);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.lightGray);
        setResizable(false);

        jButtonYourCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N
        jButtonYourCard1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card1Clicked(evt);
            }
        });

        jButtonYourCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N
        jButtonYourCard2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card2Clicked(evt);
            }
        });

        jButtonYourCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N
        jButtonYourCard4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card4Clicked(evt);
            }
        });

        jButtonYourCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N
        jButtonYourCard5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card5Clicked(evt);
            }
        });

        jButtonYourCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N
        jButtonYourCard3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                card3Clicked(evt);
            }
        });

        jLabelUPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUPlayerName.setText("Player name");

        jLabelLPlayerName.setText("Player name");

        jLabelRPlayerName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRPlayerName.setText("Player name");

        jLabelYTeamPoints.setText("0");

        weTricksLabel.setText("Tricks:");

        jLabelYTeamTricks.setText("0");

        wePointsLabel.setText("Points:");

        theyPointsLabel.setText("Points:");

        jLabelOTeamPoints.setText("0");

        theyTricksLabel.setText("Tricks:");

        jLabelOTeamTricks.setText("0");

        jButtonPass.setText("Pass");
        jButtonPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passButtonClicked(evt);
            }
        });

        jButtonPickUp.setText("Pick it up");
        jButtonPickUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pickItUpButtonClicked(evt);
            }
        });

        jLabelYourName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelYourName.setText("Player name");

        jLabelDealer.setText("Your Deal:");

        jLabelPassInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPassInfo.setText("(Player) passed, Your call");

        theyLabel.setText("Team:");

        weLabel.setText("Team:");

        theyTeamNumberLabel.setText("1");

        weTeamNumberLabel.setText("2");

        heartsButton.setText("Hearts");
        heartsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                heartsListener(evt);
            }
        });

        clubsButton.setText("Clubs");
        clubsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clubsListener(evt);
            }
        });

        diamondsButton.setText("Diamonds");
        diamondsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                diamondsListener(evt);
            }
        });

        spadesButton.setText("Spades");
        spadesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spadesListener(evt);
            }
        });

        suitPassButton.setText("Pass");
        suitPassButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suitPassListener(evt);
            }
        });

        UPlayed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        LPlayed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        YourPlayed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        TurnedCard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        RCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        RCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        RCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        RCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        RCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        LCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        LCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        LCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        LCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        LCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back_sideways.png"))); // NOI18N

        UCard1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        UCard2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        UCard3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        UCard4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        UCard5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        RPlayed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/euchre/gui/pictures/back.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(theyLabel)
                                .addComponent(theyPointsLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LCard1)
                                .addComponent(LCard2)
                                .addComponent(LCard3)
                                .addComponent(LCard4)
                                .addComponent(LCard5)
                                .addComponent(theyTricksLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelOTeamTricks)
                            .addComponent(jLabelOTeamPoints)
                            .addComponent(theyTeamNumberLabel)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelLPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelRPlayerName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(heartsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(diamondsButton))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(clubsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(spadesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(14, 14, 14)
                                            .addComponent(LPlayed)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(YourPlayed)
                                                .addComponent(UPlayed))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(RPlayed)
                                            .addGap(48, 48, 48)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabelDealer)
                                                .addComponent(TurnedCard))))
                                    .addGap(66, 66, 66))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(UCard1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(UCard2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(UCard3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(UCard4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(UCard5)
                                    .addGap(48, 48, 48))
                                .addComponent(jLabelUPlayerName, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonYourCard1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(suitPassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonPass, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButtonPickUp, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonYourCard2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonYourCard3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonYourCard4))
                                    .addComponent(jLabelPassInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonYourCard5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(RCard1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(83, 83, 83)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(weTricksLabel)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(weLabel)
                                                .addComponent(wePointsLabel)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelYTeamTricks)
                                            .addComponent(jLabelYTeamPoints)
                                            .addComponent(weTeamNumberLabel)))
                                    .addComponent(RCard2)
                                    .addComponent(RCard3)
                                    .addComponent(RCard4)
                                    .addComponent(RCard5)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLabelYourName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(UCard1)
                                .addComponent(UCard2)
                                .addComponent(UCard3)
                                .addComponent(UCard4)
                                .addComponent(UCard5))
                            .addGap(24, 24, 24)
                            .addComponent(jLabelUPlayerName)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(UPlayed)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(YourPlayed))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(52, 52, 52)
                                                    .addComponent(LPlayed)))
                                            .addGap(42, 42, 42)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(heartsButton)
                                                .addComponent(clubsButton))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(diamondsButton)
                                                .addComponent(spadesButton))
                                            .addGap(18, 18, 18))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabelDealer)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(TurnedCard)
                                            .addGap(78, 78, 78))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(150, 150, 150)
                                    .addComponent(RPlayed)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelPassInfo)
                                .addComponent(suitPassButton))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonPass)
                                .addComponent(jButtonPickUp))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonYourCard5)
                                .addComponent(jButtonYourCard4)
                                .addComponent(jButtonYourCard3)
                                .addComponent(jButtonYourCard2)
                                .addComponent(jButtonYourCard1)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(89, 89, 89)
                            .addComponent(RCard1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RCard2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RCard3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RCard4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(RCard5)
                            .addGap(48, 48, 48)
                            .addComponent(jLabelRPlayerName)
                            .addGap(28, 28, 28)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(weLabel)
                                .addComponent(weTeamNumberLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelYTeamPoints)
                                .addComponent(wePointsLabel))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(weTricksLabel)
                                .addComponent(jLabelYTeamTricks))
                            .addGap(7, 7, 7)
                            .addComponent(jLabelYourName)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(theyLabel)
                            .addComponent(theyTeamNumberLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(theyPointsLabel)
                            .addComponent(jLabelOTeamPoints))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(theyTricksLabel)
                            .addComponent(jLabelOTeamTricks))
                        .addGap(29, 29, 29)
                        .addComponent(LCard1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LCard2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LCard3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LCard4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LCard5)
                        .addGap(88, 88, 88)
                        .addComponent(jLabelLPlayerName)))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setBottomPlayedCard(Card c){
    	YourPlayed.setIcon(picManager.getPicture(c.getSuit(), c.getCardValue()));
    }
    
    public void setUpperPlayedCard(Card c){
    	UPlayed.setIcon(picManager.getPicture(c.getSuit(), c.getCardValue()));
    }

    public void setLeftPlayedCard(Card c){
    	LPlayed.setIcon(picManager.getPicture(c.getSuit(), c.getCardValue()));
    }

    public void setRightPlayedCard(Card c){
    	RPlayed.setIcon(picManager.getPicture(c.getSuit(), c.getCardValue()));
    }
    
    public void setTurnedCard(Card c){
    	TurnedCard.setIcon(picManager.getPicture(c.getSuit(), c.getSuit()));
    }
    
    
    private void card1Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card1Clicked
    	if(humanPlayer.isTurn()){
    		humanPlayer.setActiveCard(hand[0]);
    		jButtonYourCard1.setIcon(picManager.getPicture('e', 'a'));
    	}
    	
    }//GEN-LAST:event_card1Clicked

    private void card2Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card2Clicked
    	if(humanPlayer.isTurn()){
    		humanPlayer.setActiveCard(hand[1]);
    		jButtonYourCard2.setIcon(picManager.getPicture('e', 'a'));
    	}
    	
    }//GEN-LAST:event_card2Clicked

    private void card3Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card3Clicked
    	if(humanPlayer.isTurn()){
    		humanPlayer.setActiveCard(hand[2]);
    		jButtonYourCard3.setIcon(picManager.getPicture('e', 'a'));
    	}
    	
    }//GEN-LAST:event_card3Clicked

    private void card4Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card4Clicked
    	if(humanPlayer.isTurn()){
    		humanPlayer.setActiveCard(hand[3]);
    		jButtonYourCard4.setIcon(picManager.getPicture('e', 'a'));
    	}

    }//GEN-LAST:event_card4Clicked
    
    private void card5Clicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_card5Clicked
    	if(humanPlayer.isTurn()){
    		humanPlayer.setActiveCard(hand[4]);
    		jButtonYourCard5.setIcon(picManager.getPicture('e', 'a'));
    	}

    }//GEN-LAST:event_card5Clicked

    private void passButtonClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passButtonClicked
    	if(humanPlayer.isTurn()){
    		humanPlayer.setOrderUp(false);
    		
    	}
    }//GEN-LAST:event_passButtonClicked

    private void pickItUpButtonClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pickItUpButtonClicked
    	if(humanPlayer.isTurn()){
	    	this.hideTrumpButtons();
    		heartsButton.setVisible(true);
            clubsButton.setVisible(true);
            diamondsButton.setVisible(true);
            spadesButton.setVisible(true);
            suitPassButton.setVisible(true);
    		humanPlayer.setOrderUp(true);
    	}

    }//GEN-LAST:event_pickItUpButtonClicked

    private void heartsListener(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heartsListener
    	if(humanPlayer.isTurn()){
    		 humanPlayer.setCallSuit('h');
    		 heartsButton.setVisible(false);
    		 clubsButton.setVisible(false);
    		 diamondsButton.setVisible(false);
    		 spadesButton.setVisible(false);
    		 suitPassButton.setVisible(false);
    	}
    }//GEN-LAST:event_heartsListener

    private void clubsListener(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clubsListener
    	if(humanPlayer.isTurn()){
    		humanPlayer.setCallSuit('c');
    		heartsButton.setVisible(false);
            clubsButton.setVisible(false);
            diamondsButton.setVisible(false);
            spadesButton.setVisible(false);
            suitPassButton.setVisible(false);
    	}
    }//GEN-LAST:event_clubsListener

    private void diamondsListener(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_diamondsListener
    	if(humanPlayer.isTurn()){
    		humanPlayer.setCallSuit('d');
    		heartsButton.setVisible(false);
            clubsButton.setVisible(false);
            diamondsButton.setVisible(false);
            spadesButton.setVisible(false);
            suitPassButton.setVisible(false);
    	}
    }//GEN-LAST:event_diamondsListener

    private void spadesListener(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spadesListener
    	if(humanPlayer.isTurn()){
    		humanPlayer.setCallSuit('s');
    		heartsButton.setVisible(false);
            clubsButton.setVisible(false);
            diamondsButton.setVisible(false);
            spadesButton.setVisible(false);
            suitPassButton.setVisible(false);
    	}
    }//GEN-LAST:event_spadesListener

    private void suitPassListener(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suitPassListener
    	if(humanPlayer.isTurn()){
    		if(GM.getDealer() == humanPlayer){
    			JOptionPane.showMessageDialog(null, "Please select a suit", "Stick the Dealer", JOptionPane.ERROR_MESSAGE);
    			suitPassButton.setVisible(false);
    		}
    		else{
    			humanPlayer.setCallSuit('x');
    		}    		
    	}
    }//GEN-LAST:event_suitPassListener
    
    /**
     * hides the buttons used during trump selection
     */
    public void hideTrumpButtons(){
    	jButtonPass.setVisible(false);
    	jButtonPickUp.setVisible(false);
    	TurnedCard.setVisible(false);
    	jLabelDealer.setVisible(false);
    }
    
    public void setWeTricks(int tricks){
    	jLabelYTeamTricks.setText("" + tricks);
    }
    
    public void setTheyTricks(int tricks){
    	jLabelOTeamTricks.setText("" + tricks);
    }
    
    public void setWePoints(int points){
    	jLabelYTeamPoints.setText("" + points);
    }
    
    public void setTheyPoints(int points){
    	jLabelOTeamPoints.setText("" + points);
    }
    
    /**
     * used to display the players hand to the GUI
     * 
     * @param card the card to be set to the specified button
     * @param cardNumber the button to set to the specified card
     */
    public void setCard(Card card, int cardNumber){
    	hand[cardNumber] = card;
    	handButtons[cardNumber].setIcon(picManager.getPicture(card.getSuit(), card.getCardValue()));
    }    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LCard1;
    private javax.swing.JLabel LCard2;
    private javax.swing.JLabel LCard3;
    private javax.swing.JLabel LCard4;
    private javax.swing.JLabel LCard5;
    private javax.swing.JLabel LPlayed;
    private javax.swing.JLabel RCard1;
    private javax.swing.JLabel RCard2;
    private javax.swing.JLabel RCard3;
    private javax.swing.JLabel RCard4;
    private javax.swing.JLabel RCard5;
    private javax.swing.JLabel RPlayed;
    private javax.swing.JLabel TurnedCard;
    private javax.swing.JLabel UCard1;
    private javax.swing.JLabel UCard2;
    private javax.swing.JLabel UCard3;
    private javax.swing.JLabel UCard4;
    private javax.swing.JLabel UCard5;
    private javax.swing.JLabel UPlayed;
    private javax.swing.JLabel YourPlayed;
    private javax.swing.JButton clubsButton;
    private javax.swing.JButton diamondsButton;
    private javax.swing.JButton heartsButton;
    private javax.swing.JButton jButtonPass;
    private javax.swing.JButton jButtonPickUp;
    private javax.swing.JButton jButtonYourCard1;
    private javax.swing.JButton jButtonYourCard2;
    private javax.swing.JButton jButtonYourCard3;
    private javax.swing.JButton jButtonYourCard4;
    private javax.swing.JButton jButtonYourCard5;
    private javax.swing.JLabel jLabelDealer;
    private javax.swing.JLabel jLabelLPlayerName;
    private javax.swing.JLabel jLabelOTeamPoints;
    private javax.swing.JLabel jLabelOTeamTricks;
    private javax.swing.JLabel jLabelPassInfo;
    private javax.swing.JLabel jLabelRPlayerName;
    private javax.swing.JLabel jLabelUPlayerName;
    private javax.swing.JLabel jLabelYTeamPoints;
    private javax.swing.JLabel jLabelYTeamTricks;
    private javax.swing.JLabel jLabelYourName;
    private javax.swing.JButton spadesButton;
    private javax.swing.JButton suitPassButton;
    private javax.swing.JLabel theyLabel;
    private javax.swing.JLabel theyPointsLabel;
    private javax.swing.JLabel theyTeamNumberLabel;
    private javax.swing.JLabel theyTricksLabel;
    private javax.swing.JLabel weLabel;
    private javax.swing.JLabel wePointsLabel;
    private javax.swing.JLabel weTeamNumberLabel;
    private javax.swing.JLabel weTricksLabel;
    // End of variables declaration//GEN-END:variables
    private javax.swing.JButton[] handButtons = {jButtonYourCard1, jButtonYourCard2, jButtonYourCard3, jButtonYourCard4, jButtonYourCard5};

}
