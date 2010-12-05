package euchre.gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.JOptionPane;
import euchre.player.GameManager;

/**
 * The Game Lobby from the hosts perspective where they can monitor the status of other client players, decide teams, choose AI difficulties. And start the game.
 *
 * @author sdwilke
 * @author Neil MacBay(nmmacbay)
 */
public class GameLobby extends javax.swing.JFrame{
	
	private static final long serialVersionUID = 1L;
	
	HostDifficultyChange myAIManager;
	private GameManager myManager;
	private int numberOfAI;
    private char player2Difficulty = 'x';
    private char player3Difficulty = 'x';
	private int connectionsMade = 0;
	private boolean setupComplete = false;
	private String ip;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Player1Status;
    private javax.swing.JLabel Player2Status;
    private javax.swing.JLabel Player3Status;
    private javax.swing.JLabel Player4Status;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton changeComputerDifficulty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioBPlayer1Team1;
    private javax.swing.JRadioButton jRadioBPlayer1Team2;
    private javax.swing.JRadioButton jRadioBPlayer2Team1;
    private javax.swing.JRadioButton jRadioBPlayer2Team2;
    private javax.swing.JRadioButton jRadioBPlayer3Team1;
    private javax.swing.JRadioButton jRadioBPlayer3Team2;
    private javax.swing.JRadioButton jRadioBPlayer4Team1;
    private javax.swing.JRadioButton jRadioBPlayer4Team2;
    private javax.swing.JButton startGame;
    // End of variables declaration//GEN-END:variables


	/** 
     * Creates new form GameLobby 
     * 
     * @param numberOfPlayers the number of additional human players
     * @param hostName the name of the host player
     * @param inManager the Game Manager object for the game
     */
    public GameLobby(int numberOfPlayers, String hostName, GameManager inManager){
        initComponents();
        centerScreen();
        myManager = inManager;
        if (numberOfPlayers == 1){
        	player2Difficulty = 'm';
        	player3Difficulty = 'm';
        	numberOfAI = 2;
        }else if (numberOfPlayers == 2){
        	player2Difficulty = 'm';
        	numberOfAI = 1;
        }else{ //Number of players == 3
        	changeComputerDifficulty.setVisible(false);
        	this.setSize(new Dimension(688,220));
        	numberOfAI = 0;
        }
        //connectionsMade = 3 - numberOfPlayers; //adjust probably not needed, computers connect
        startGame.setEnabled(false);
		
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		Player1Status.setText(hostName + "...Your Host Address: \"" + ip + "\"");
    }
 
    /**
     * sets the AI difficulty for player 2
     * @param difficulty e for easy, m for medium, h for hard
     */
    public void setplayer2Difficulty(char difficulty){
       if (difficulty == 'e'){
    	   player2Difficulty = 'e';
    	   Player2Status.setText("Comp One: Difficulty: Easy");
       }else if (difficulty == 'm'){
    	   player2Difficulty = 'm';
    	   Player2Status.setText("Comp One: Difficulty: Medium");
       }else if (difficulty == 'h'){
    	   player2Difficulty = 'h';
    	   Player2Status.setText("Comp One: Difficulty: Hard");
       }
    }

    /**
     * sets the AI difficulty for player 4
     * @param difficulty e for easy, m for medium, h for hard
     */
    public void setPlayer3Difficulty(char difficulty){
    	if (difficulty == 'e'){
     	   player3Difficulty = 'e';
     	  Player3Status.setText("Comp Two: Difficulty: Easy");
        }else if (difficulty == 'm'){
     	   player3Difficulty = 'm';
     	   Player3Status.setText("Comp Two: Difficulty: Medium");
        }else if (difficulty == 'h'){
     	   player3Difficulty = 'h';
     	  Player3Status.setText("Comp Two: Difficulty: Hard");
        }
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        startGame = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Player2Status = new javax.swing.JLabel();
        Player3Status = new javax.swing.JLabel();
        Player4Status = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioBPlayer1Team1 = new javax.swing.JRadioButton();
        jRadioBPlayer2Team1 = new javax.swing.JRadioButton();
        jRadioBPlayer3Team1 = new javax.swing.JRadioButton();
        jRadioBPlayer4Team1 = new javax.swing.JRadioButton();
        jRadioBPlayer1Team2 = new javax.swing.JRadioButton();
        jRadioBPlayer2Team2 = new javax.swing.JRadioButton();
        jRadioBPlayer3Team2 = new javax.swing.JRadioButton();
        jRadioBPlayer4Team2 = new javax.swing.JRadioButton();
        Player1Status = new javax.swing.JLabel();
        changeComputerDifficulty = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Lobby");
        setResizable(false);

        startGame.setText("Start Game");
        startGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                startGame(evt);
            }
        });

        jLabel3.setText("Player 1:");

        jLabel4.setText("Player 2:");

        jLabel5.setText("Player 3:");

        jLabel6.setText("Player 4:");

        Player2Status.setText("...waiting");

        Player3Status.setText("...waiting");

        Player4Status.setText("...waiting");

        jLabel1.setText("Team:");

        jLabel2.setText("Team:");

        jLabel7.setText("Team:");

        jLabel8.setText("Team:");

        buttonGroup1.add(jRadioBPlayer1Team1);
        jRadioBPlayer1Team1.setSelected(true);
        jRadioBPlayer1Team1.setText("1");

        buttonGroup2.add(jRadioBPlayer2Team1);
        jRadioBPlayer2Team1.setText("1");

        buttonGroup3.add(jRadioBPlayer3Team1);
        jRadioBPlayer3Team1.setSelected(true);
        jRadioBPlayer3Team1.setText("1");

        buttonGroup4.add(jRadioBPlayer4Team1);
        jRadioBPlayer4Team1.setText("1");

        buttonGroup1.add(jRadioBPlayer1Team2);
        jRadioBPlayer1Team2.setText("2");

        buttonGroup2.add(jRadioBPlayer2Team2);
        jRadioBPlayer2Team2.setSelected(true);
        jRadioBPlayer2Team2.setText("2");

        buttonGroup3.add(jRadioBPlayer3Team2);
        jRadioBPlayer3Team2.setText("2");

        buttonGroup4.add(jRadioBPlayer4Team2);
        jRadioBPlayer4Team2.setSelected(true);
        jRadioBPlayer4Team2.setText("2");

        Player1Status.setText("Player 1");

        changeComputerDifficulty.setText("Change AI Difficulty Level");
        changeComputerDifficulty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                changeAIDifficulty(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player2Status, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Player1Status, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player3Status, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Player4Status, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioBPlayer1Team1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBPlayer1Team2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioBPlayer2Team1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBPlayer2Team2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioBPlayer3Team1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBPlayer3Team2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jRadioBPlayer4Team1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioBPlayer4Team2)))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(216, 216, 216)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(startGame, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(changeComputerDifficulty, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addGap(208, 208, 208))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(jRadioBPlayer1Team1)
                    .addComponent(jRadioBPlayer1Team2)
                    .addComponent(Player1Status))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Player2Status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioBPlayer2Team1)
                    .addComponent(jRadioBPlayer2Team2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Player3Status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jRadioBPlayer3Team1)
                    .addComponent(jRadioBPlayer3Team2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Player4Status, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioBPlayer4Team1)
                    .addComponent(jRadioBPlayer4Team2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeComputerDifficulty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startGame)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Starts the game if everyone is connected and ready. And teams are valid(two players per team).
     * 
     * @param evt The button-click that starts the event.
     */
    private void startGame(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartGame
    	//Figure out the number of players selected for each team.
        int team1Players = 0;
        int team2Players = 0;
        if (!startGame.isEnabled()){
        	return;
        }
        if(connectionsMade >= 3){
	        if(jRadioBPlayer1Team1.isSelected()){
	        	team1Players++;
	        }else{
	        	team2Players++;
	        }
	        if(jRadioBPlayer2Team1.isSelected()){
	        	team1Players++;
	        }else{
	        	team2Players++;
	        }
	        if(jRadioBPlayer3Team1.isSelected()){
	        	team1Players++;
	        }else{
	        	team2Players++;
	        }
	        if(jRadioBPlayer4Team1.isSelected()){
	        	team1Players++;
	        }else{
	        	team2Players++;
	        }
	        if(team1Players == team2Players){ //Teams are valid.
	        	//set teams in game manager.
	        	if(jRadioBPlayer1Team1.isSelected()){
	        		myManager.setTeam(1, 1);
	        		myManager.getServerNetworkManager().toClients("SetTeam,1,1");
	        	}else{
	        		myManager.setTeam(1, 2);
	        		myManager.getServerNetworkManager().toClients("SetTeam,1,2");
	        	}
	        	if(jRadioBPlayer2Team1.isSelected()){
	        		myManager.setTeam(2, 1);
	        		myManager.getServerNetworkManager().toClients("SetTeam,2,1");
	        	}else{
	        		myManager.setTeam(2, 2);
	        		myManager.getServerNetworkManager().toClients("SetTeam,2,2");
	        	}
	        	if(jRadioBPlayer3Team1.isSelected()){
	        		myManager.setTeam(3, 1);
	        		myManager.getServerNetworkManager().toClients("SetTeam,3,1");
	        	}else{
	        		myManager.setTeam(3, 2);
	        		myManager.getServerNetworkManager().toClients("SetTeam,3,2");
	        	}
	        	if(jRadioBPlayer4Team1.isSelected()){
	        		myManager.setTeam(4, 1);
	        		myManager.getServerNetworkManager().toClients("SetTeam,4,1");
	        	}else{
	        		myManager.setTeam(4, 2);
	        		myManager.getServerNetworkManager().toClients("SetTeam,4,2");
	        	}
	        	if (myAIManager != null){
	        		myAIManager.setVisible(false);
	        		myAIManager.dispose();
	        	}
	        	setupComplete = true;
	        	this.setVisible(false);
	        }
	        else{
	        	 JOptionPane.showMessageDialog(null, "Invalid Team Assignments.  Please set two players to each team", "Error", JOptionPane.ERROR_MESSAGE);
	        }
        }
        else{
        	JOptionPane.showMessageDialog(null, "Please wait until all players have connected", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_StartGame

    /**
     * Starts the form to change the difficulty of the AI's.
     * 
     * @param evt The button-click that starts the event.
     */
    private void changeAIDifficulty(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changeAIDifficulty
        myAIManager = new HostDifficultyChange(this, numberOfAI);
        myAIManager.setVisible(true);
    }//GEN-LAST:event_changeAIDifficulty

    /**
     * Sets the status of player two and how they appear to host.
     * Examples:
     * ...waiting
     * ...connected...not ready
     * ...connected...ready
     * 
     * @param status The string to display as the players status.
     */
    public void setPlayer2Status(String status){
        Player2Status.setText(status);
        connectionsMade++;
        if (status == "Comp One"){
        	setplayer2Difficulty('m');
        }
        if(connectionsMade >= 3){
        	startGame.setEnabled(true);
        }
    }

    /**
     * Sets the status of player three and how they appear to host.
     * Examples:
     * ...waiting
     * ...connected...not ready
     * ...connected...ready
     * 
     * @param status The string to display as the players status.
     */
    public void setPlayer3Status(String status){
        Player3Status.setText(status);
        connectionsMade++;
        if (status == "Comp One"){
        	setPlayer3Difficulty('m');
        }
        if(connectionsMade >= 3){
        	startGame.setEnabled(true);
        }
    }

    /**
     * Sets the status of player four and how they appear to host.
     * Examples:
     * ...waiting
     * ...connected...not ready
     * ...connected...ready
     * 
     * @param status The string to display as the players status.
     */
    public void setPlayer4Status(String status){
        Player4Status.setText(status);
        connectionsMade++;
        if(connectionsMade >= 3){
        	startGame.setEnabled(true);
        }
    }
      
    public boolean setupComplete(){
		return setupComplete;
	}

    public String getHostName(){
    	return Player1Status.getText();
    }
    
    public int getNumberOfAIPlayers(){
    	return numberOfAI;
    }
    
    public char getplayer2Difficulty(){
        return player2Difficulty;
    }
    
    public char getplayer3Difficulty(){
        return player3Difficulty;
    }
}
