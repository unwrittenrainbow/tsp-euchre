package euchre.gui;

import java.awt.Point;
import java.awt.Toolkit;

/**
 * The GUI that displays the euchre game to the user and allows them to play it.
 * 
 * @author Neil MacBay (nmmacbay)
 *
 */
public class GameBoard extends javax.swing.JFrame {

    /** Creates new form GameBoard */
    public GameBoard() {
        initComponents();
        centerScreen();
    }
    
    /**
     * Moves the jFrame to the center of the screen
     */
    private void centerScreen(){
        int xCenter;
        int yCenter;
        int xSize;
        int ySize;
        Point p = new Point();
        xSize = this.getSize().width;
        ySize = this.getSize().height;
        xCenter = Toolkit.getDefaultToolkit().getScreenSize().width/2;
        yCenter = Toolkit.getDefaultToolkit().getScreenSize().height/2;
        p.setLocation(xCenter - xSize/2, yCenter - ySize/2);
        this.setLocation(p);
        return;
    }
    
    /**
	 * Display the winner of the Euchre game.
	 */
	private void displayWinner(){
		
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 806, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
