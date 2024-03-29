/* Aurni, Bodhana, Mary
 * Game Window
 * 6/11/23
 */
package reimagined;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GameWindow extends javax.swing.JFrame {

    //Declare connecting window
    DecisionWindow dW;

    private final static int NUMOFSWEEPSTOWIN = 300; //To win
    private final static ImageIcon graphic1 = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/Game2.1.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)); //Sprite 1 of Ella
    private final static ImageIcon graphic2 = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/Game2.2.jpg").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)); //Sprite 2 of Ella (horizontally flipped)

    public GameWindow(DecisionWindow d) {
        initComponents();
        //Connect to main menu
        dW = d;
        //Set up window (color and size)
        Color lavendar = new Color(179, 179, 230);
        getContentPane().setBackground(lavendar);
        setSize(525, 725);
        //Set up game
        setGame();
    }

    public void setGame() {
        Game miniGame;
        if (MainWindow.cinderella.getDecisionThree().getExPEarned() == 0) { //If the user chose to have Ella clean on her own (0 EXP earned for the decision)
            miniGame = new Game("Help Ella clean the château to go to the ball before the 1-minute timer runs out! Click the sweep button until you hit " + NUMOFSWEEPSTOWIN + " or go for the high score by clicking on until time runs out.", graphic1, graphic2, 60, 0, 0);
        } else { //If the user chose to have the animals help Ella
            miniGame = new Game("+10 EXP! Help Ella clean the château to go to the ball before the 2-minute timer runs out! Click the sweep button until you hit " + NUMOFSWEEPSTOWIN + " or go for the high score by clicking on until time runs out.", graphic1, graphic2, 120, 0, 0);
        }
        MainWindow.cinderella.setGame(miniGame); //Update Story Object with Game
        //Add instructions to window
        description.setText(miniGame.getGameRules());
        description.setLineWrap(true);
        //Add starting sprite to window
        visual.setText("");
        visual.setIcon(graphic1);
        //Initialize Timer and start it
        Timer countdown = new Timer();
        Thread t = new Thread(countdown);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        visual = new javax.swing.JLabel();
        sweepBtn = new javax.swing.JButton();
        sweeps = new javax.swing.JLabel();
        timer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        description.setEditable(false);
        description.setColumns(20);
        description.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        description.setRows(10);
        description.setWrapStyleWord(true);
        jScrollPane1.setViewportView(description);

        visual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visual.setText("Visual");

        sweepBtn.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        sweepBtn.setText("Sweep!");
        sweepBtn.setToolTipText("");
        sweepBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sweepBtnActionPerformed(evt);
            }
        });

        sweeps.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        sweeps.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sweeps.setText("Number of Sweeps: 0");

        timer.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        timer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        timer.setText("Time in Seconds: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(timer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visual, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sweepBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sweeps, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(visual)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(timer, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sweepBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sweeps, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(248, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Increments number of sweeps on window and done by user
     *
     * @param evt
     */
    private void sweepBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sweepBtnActionPerformed
        int numOfClicks = MainWindow.cinderella.getGame().getTotalSweeps(); //Get number of sweeps; the number of clicks on last iteration or 0 if first time through
        numOfClicks++; //Increment to account for the last click of the button
        MainWindow.cinderella.getGame().setTotalSweeps(numOfClicks); //Reassign number of sweeps to Game object
        sweeps.setText("Number of Sweeps: " + Integer.toString(numOfClicks)); //Update GUI every time button is clicked
        //Flip image horizontally with every click of button (basic animation)
        if (visual.getIcon().equals(graphic1)) {
            visual.setIcon(graphic2);
        } else {
            visual.setIcon(graphic1);
        }
    }//GEN-LAST:event_sweepBtnActionPerformed

    public class Timer implements Runnable {

        //Attributes
        private int delta;

        /**
         * Constructor that sets default value for seconds that have passed
         */
        public Timer() {
            delta = 0;
        }

        /**
         * Runs as a thread (continuously as rest of the program runs)
         */
        public void run() {
            Decision dFour = null;
            Game miniGame = MainWindow.cinderella.getGame();
            //Run timer for duration specified in Game object
            while (delta < miniGame.getTotalTime()) {
                delta = miniGame.timeProgress(delta, miniGame.getTotalTime()); //1 second passes
                timer.setText("Time in Seconds: " + Integer.toString(delta)); //Update window with time
            }
            MainWindow.cinderella.setGame(miniGame); //Assign updated game back to Story object
            //AFTER TIME IS UP
            //Load next decision based on whether user wins and update Decision window before it opens
            if (miniGame.getTotalSweeps() >= NUMOFSWEEPSTOWIN) {
                miniGame.setExPointsEarned(10);
                dFour = dW.loadNewDecision(3, 0);
            } else { //3BEND
                dFour = dW.loadNewDecision(3, 1);
                MainWindow.current.setAchievementTwo(true); //Achievement Unlocked
            }
            //Update Story Object with Decision #4
            MainWindow.cinderella.setDecisionFour(dFour);
            //Open Decision window and close Game window
            dW.setVisible(true);
            GameWindow.this.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea description;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton sweepBtn;
    private javax.swing.JLabel sweeps;
    private javax.swing.JLabel timer;
    private javax.swing.JLabel visual;
    // End of variables declaration//GEN-END:variables
}
