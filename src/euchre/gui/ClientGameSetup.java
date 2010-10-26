package euchre.gui;

import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import euchre.player.GameManager;
import euchre.player.Human;
import euchre.player.Player;

/**
 * The game setup forms for the client. You input your name then signal that your ready.
 *
 * @author sdwilke
 * @author Neil MacBay(nmmacbay)
 */
public class ClientGameSetup extends javax.swing.JFrame{
	private static final long serialVersionUID = 1L;
	private GameManager myManager;
	private GameBoard GB;
	private boolean gottenInput = false;
	
    /** 
     * Creates new form ClientGameSetup
     * @param player the client player being set up
     */
    public ClientGameSetup(){
        initComponents();
        centerScreen();
        jLabelWaitingStatus.setVisible(false);
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

        jLabel1 = new javax.swing.JLabel();
        playerName = new javax.swing.JTextField();
        StartButton = new javax.swing.JButton();
        jLabelWaitingStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        serverIP = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Game Setup");
        setResizable(false);

        jLabel1.setText("Player Name:");

        StartButton.setText("Start");
        StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ready(evt);
            }
        });

        jLabelWaitingStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWaitingStatus.setText("Waiting for other Players...");

        jLabel2.setText("Server IP:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelWaitingStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(serverIP, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(StartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(serverIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(playerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabelWaitingStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StartButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Sends the message that this client is ready to play the game. Does nothing however if inputed name is not valid(empty field or all whitespace characters).
     * 
     * @param evt The button-click that initiates this event.
     */
    private void ready(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ready
    	if (playerName.getText().isEmpty() || playerName.getText().trim().isEmpty()){ //Invalid input (whitespace only)
			JOptionPane.showMessageDialog(null, "Please enter a player name", "Error", JOptionPane.ERROR_MESSAGE);    		
		}else if(contains(playerName.getText().trim(), ',')){
			JOptionPane.showMessageDialog(null, "Please enter a player name without commas.", "Error", JOptionPane.ERROR_MESSAGE); 
		}else{ //Valid input, maybe
			
			if(playerName.getText().trim().isEmpty() == false)
				gottenInput = true;
			jLabelWaitingStatus.setVisible(true);
			StartButton.setVisible(false);
			playerName.setEditable(false);
			serverIP.setEditable(false);
        }
    }//GEN-LAST:event_ready
    
    /**
     * Checks the given string for the given character.
     * 
     * @param string The string to look for the character in.
     * @param look The character to look for in the string.
     * @return True if the character was found in the string.
     */
    private boolean contains(String string, char look){
		boolean wasFound = false;
		for (int i=0; i < string.length(); i++){
				if (string.charAt(i) == look){
					wasFound = true;
				}
		}
    	return wasFound;	
    }
    
    /**
     * Returns whether or not this client is waiting on other players and is ready to start the game.
     * 
     * @return True if the client is waiting.
     */
    public boolean isWaiting(){
    	return jLabelWaitingStatus.isVisible();
    }
    
    /**
     * Returns whether or not we have gotten valid input from this setup window yet
     * 
     * @return true if there is input, false if it is still waiting
     */
    public boolean hasInput(){
    	
    	return gottenInput;
    }
    
    /**
     * Gets the current input(trimmed of whitespace) of the text plain for the client to enter their name in.
     * 
     * @return The clients inputed name
     */
    public String getClientName(){
    	return playerName.getText().trim();
    }
    
    public String getIP(){
    	if(serverIP.getText().trim().isEmpty())
    		return "localhost";
    	return serverIP.getText().trim();
    }
    
    
    
    /**
     * Pass reference to the GameManager in 
     * 
     * @author mdhelgen
     * @param GM
     */
    public void setGameManager(GameManager GM){
    	myManager = GM;
    }

//    /**
//    * @param args the command line arguments
//    */
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ClientGameSetup().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton StartButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelWaitingStatus;
    private javax.swing.JTextField playerName;
    private javax.swing.JTextField serverIP;
    // End of variables declaration//GEN-END:variables

}
