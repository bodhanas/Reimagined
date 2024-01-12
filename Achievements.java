/* Aurni, Bodhana, Mary
 * Achievements Window
 * 6/9/23
 */
package reimagined;

import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Achievements extends javax.swing.JFrame {

    //Declare all windows it connects to
    MainWindow mW;

    public Achievements(MainWindow m) {
        initComponents();
        //Connect to main menu
        mW = m;
        //Set up window (color and size)
        Color lavendar = new Color(179, 179, 230);
        getContentPane().setBackground(lavendar);
        setSize(525, 725);
    }

    /**
     * Updates the Achievement Window when button clicked on Main Menu
     */
    public void updateAchievements() {
        //If the current User "unlocked" any achievement from 1 to 8 (boolean value of attribute is true), add graphic and update name of ending
        if (MainWindow.current.getUsername().equals("")) {
            resetAchievements();
        } else {
            if (MainWindow.current.getAchievementOne()) {
                starvellaJLabel.setText("");
                ImageIcon graphic = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/2BEND.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT)); //Adjust image to be smaller
                starvellaJLabel.setIcon(graphic);
                badEnding1JLabel.setText("Starvella - BAD ENDING");
            }
            if (MainWindow.current.getAchievementTwo()) {
                fashionablyLateJLabel.setText("");
                ImageIcon graphic = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/3BEND.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                fashionablyLateJLabel.setIcon(graphic);
                badEnding2JLabel.setText("Fashionably Late - BAD ENDING");
            }
            if (MainWindow.current.getAchievementThree()) {
                shesEllaNotElsaJLabel.setText("");
                ImageIcon graphic = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/4AEnd.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                shesEllaNotElsaJLabel.setIcon(graphic);
                badEnding3JLabel.setText("She is Ella, not Elsa - BAD ENDING");
            }
            if (MainWindow.current.getAchievementFour()) {
                unfitForAPrincessJLabel.setText("");
                ImageIcon graphic = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/5BEnd.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                unfitForAPrincessJLabel.setIcon(graphic);
                badEnding4JLabel.setText("Unfit for a Princess - BAD ENDING");
            }
            if (MainWindow.current.getAchievementFive()) {
                trappedJLabel.setText("");
                ImageIcon graphic = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/6AEnd.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                trappedJLabel.setIcon(graphic);
                badEnding5JLabel.setText("Trapped - BAD ENDING");
            }
            if (MainWindow.current.getAchievementSix()) {
                theEvilWitchJLabel.setText("");
                ImageIcon graphic = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/8AEnd.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                theEvilWitchJLabel.setIcon(graphic);
                badEnding6JLabel.setText("The Evil Witch - BAD ENDING");
            }
            if (MainWindow.current.getAchievementSeven()) {
                backToOnceUponATimeJLabel.setText("");
                ImageIcon graphic = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/9AEnd.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                backToOnceUponATimeJLabel.setIcon(graphic);
                normalEndingJLabel.setText("Back to Once Upon A Time - NORMAL ENDING");
            }
            if (MainWindow.current.getAchievementEight()) {
                happilyEverAfterJLabel.setText("");
                ImageIcon graphic = new ImageIcon(new ImageIcon("src/reimagined/AI-Generated Graphic Art/9B.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
                happilyEverAfterJLabel.setIcon(graphic);
                trueEndingJLabel.setText("Happily Ever After - GOOD ENDING");
            }
        }
    }

    public void resetAchievements() {
        starvellaJLabel.setText("???");
        starvellaJLabel.setIcon(null);
        badEnding1JLabel.setText("Unlock Starvella");
        fashionablyLateJLabel.setText("???");
        fashionablyLateJLabel.setIcon(null);
        badEnding2JLabel.setText("Unlock Fashionably Late");
        shesEllaNotElsaJLabel.setText("???");
        shesEllaNotElsaJLabel.setIcon(null);
        badEnding3JLabel.setText("Unlock She is Ella, not Elsa");
        unfitForAPrincessJLabel.setText("???");
        unfitForAPrincessJLabel.setIcon(null);
        badEnding4JLabel.setText("Unlock Unfit for a Princess");
        trappedJLabel.setText("???");
        trappedJLabel.setIcon(null);
        badEnding5JLabel.setText("Unlock Trapped");
        theEvilWitchJLabel.setText("???");
        theEvilWitchJLabel.setIcon(null);
        badEnding6JLabel.setText("Unlock The Evil Witch");
        backToOnceUponATimeJLabel.setText("???");
        backToOnceUponATimeJLabel.setIcon(null);
        normalEndingJLabel.setText("Unlock Back to Once Upon A Time");
        happilyEverAfterJLabel.setText("???");
        happilyEverAfterJLabel.setIcon(null);
        trueEndingJLabel.setText("Unlock Happily Ever After");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        achivementsJLabel = new javax.swing.JLabel();
        starvellaJLabel = new javax.swing.JLabel();
        fashionablyLateJLabel = new javax.swing.JLabel();
        shesEllaNotElsaJLabel = new javax.swing.JLabel();
        unfitForAPrincessJLabel = new javax.swing.JLabel();
        trappedJLabel = new javax.swing.JLabel();
        theEvilWitchJLabel = new javax.swing.JLabel();
        backToOnceUponATimeJLabel = new javax.swing.JLabel();
        happilyEverAfterJLabel = new javax.swing.JLabel();
        badEnding1JLabel = new javax.swing.JLabel();
        badEnding2JLabel = new javax.swing.JLabel();
        badEnding3JLabel = new javax.swing.JLabel();
        badEnding4JLabel = new javax.swing.JLabel();
        badEnding5JLabel = new javax.swing.JLabel();
        badEnding6JLabel = new javax.swing.JLabel();
        normalEndingJLabel = new javax.swing.JLabel();
        trueEndingJLabel = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        achivementsJLabel.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        achivementsJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        achivementsJLabel.setText("Achievements");

        starvellaJLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        starvellaJLabel.setText("???");

        fashionablyLateJLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        fashionablyLateJLabel.setText("???");

        shesEllaNotElsaJLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        shesEllaNotElsaJLabel.setText("???");

        unfitForAPrincessJLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        unfitForAPrincessJLabel.setText("???");

        trappedJLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        trappedJLabel.setText("???");

        theEvilWitchJLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        theEvilWitchJLabel.setText("???");

        backToOnceUponATimeJLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        backToOnceUponATimeJLabel.setText("???");

        happilyEverAfterJLabel.setFont(new java.awt.Font("SimSun-ExtB", 1, 18)); // NOI18N
        happilyEverAfterJLabel.setText("???");

        badEnding1JLabel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        badEnding1JLabel.setText("Unlock Starvella");

        badEnding2JLabel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        badEnding2JLabel.setText("Unlock Fashionably Late");

        badEnding3JLabel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        badEnding3JLabel.setText("Unlock She's Ella, Not Elsa");

        badEnding4JLabel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        badEnding4JLabel.setText("Unlock Unfit for a Princess");

        badEnding5JLabel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        badEnding5JLabel.setText("Unlock Trapped");

        badEnding6JLabel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        badEnding6JLabel.setText("Unlock The Evil Witch");

        normalEndingJLabel.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        normalEndingJLabel.setText("Unlock Back to Once Upon A Time");

        trueEndingJLabel.setFont(new java.awt.Font("Courier New", 1, 12)); // NOI18N
        trueEndingJLabel.setText("Unlock Happily Ever After");

        backBtn.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        backBtn.setText("Back to Menu");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(achivementsJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(starvellaJLabel)
                            .addComponent(badEnding4JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fashionablyLateJLabel)
                            .addComponent(shesEllaNotElsaJLabel)
                            .addComponent(unfitForAPrincessJLabel)
                            .addComponent(badEnding3JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(badEnding2JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(badEnding1JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(badEnding5JLabel)
                            .addComponent(trappedJLabel)
                            .addComponent(theEvilWitchJLabel)
                            .addComponent(backToOnceUponATimeJLabel)
                            .addComponent(happilyEverAfterJLabel)
                            .addComponent(badEnding6JLabel)
                            .addComponent(normalEndingJLabel)
                            .addComponent(trueEndingJLabel))))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(achivementsJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(trappedJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(badEnding5JLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(badEnding6JLabel))
                            .addComponent(theEvilWitchJLabel))
                        .addGap(18, 18, 18)
                        .addComponent(backToOnceUponATimeJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(normalEndingJLabel)
                        .addGap(18, 18, 18)
                        .addComponent(happilyEverAfterJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trueEndingJLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(starvellaJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(badEnding1JLabel)
                            .addGap(18, 18, 18)
                            .addComponent(fashionablyLateJLabel)
                            .addGap(3, 3, 3)
                            .addComponent(badEnding2JLabel)
                            .addGap(20, 20, 20)
                            .addComponent(shesEllaNotElsaJLabel)
                            .addGap(1, 1, 1)
                            .addComponent(badEnding3JLabel)
                            .addGap(57, 57, 57))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(unfitForAPrincessJLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(badEnding4JLabel))))
                .addGap(37, 37, 37)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        mW.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_backBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel achivementsJLabel;
    private javax.swing.JButton backBtn;
    private javax.swing.JLabel backToOnceUponATimeJLabel;
    private javax.swing.JLabel badEnding1JLabel;
    private javax.swing.JLabel badEnding2JLabel;
    private javax.swing.JLabel badEnding3JLabel;
    private javax.swing.JLabel badEnding4JLabel;
    private javax.swing.JLabel badEnding5JLabel;
    private javax.swing.JLabel badEnding6JLabel;
    private javax.swing.JLabel fashionablyLateJLabel;
    private javax.swing.JLabel happilyEverAfterJLabel;
    private javax.swing.JLabel normalEndingJLabel;
    private javax.swing.JLabel shesEllaNotElsaJLabel;
    private javax.swing.JLabel starvellaJLabel;
    private javax.swing.JLabel theEvilWitchJLabel;
    private javax.swing.JLabel trappedJLabel;
    private javax.swing.JLabel trueEndingJLabel;
    private javax.swing.JLabel unfitForAPrincessJLabel;
    // End of variables declaration//GEN-END:variables
}
