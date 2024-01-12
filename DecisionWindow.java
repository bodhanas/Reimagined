/* Aurni, Bodhana, Mary
 * Decision Window
 * 5/26/23
 */
package reimagined;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DecisionWindow extends javax.swing.JFrame {

    //Declare all windows it connects to
    MainWindow mW;
    GameWindow gW;

    //Segments code based on the decision user is at (starting at 0)
    int decisionNum = 0;

    public DecisionWindow(MainWindow m) {
        initComponents();
        //Connect to main menu
        mW = m;
        //Set up window (color and size)
        Color lavendar = new Color(179, 179, 230);
        getContentPane().setBackground(lavendar);
        setSize(525, 725);
        //Load and display Decision #1
        Decision n = loadNewDecision(decisionNum, 0);
        MainWindow.cinderella.setDecisionOne(n); //Update Story object with Decision #1
    }

    /**
     * Specifies how to update Decision Window after every decision taken by
     * user
     *
     * @param d Decision object
     */
    public void updateGUI(Decision d) {
        //Set up visual
        visual.setText("");
        ImageIcon graphic = new ImageIcon(new ImageIcon(d.getImagePath()).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)); //Adjust graphic to be an appropriate size
        visual.setIcon(graphic);
        //Set up description
        description.setText(d.getDescription());
        description.setLineWrap(true);
        //Scroll to top of text box
        description.setSelectionStart(0);
        description.setSelectionEnd(0);
        //Set up options
        option1JButton.setText(d.getOptionOne());
        option2JButton.setText(d.getOptionTwo());
        option3JButton.setText(d.getOptionThree());
        option4JButton.setText(d.getOptionFour());
        if (d.getOptionOne().equals("")) {
            option1JButton.setEnabled(false); //Disable button if no option
        }
        if (d.getOptionTwo().equals("")) {
            option2JButton.setEnabled(false); //Disable button if no option
        }
        if (d.getOptionThree().equals("")) {
            option3JButton.setEnabled(false); //Disable button if no option
        } else {
            option3JButton.setEnabled(true); //For Endings when all buttons are disabled
        }
        if (d.getOptionFour().equals("")) {
            option4JButton.setEnabled(false); //Disable button if no option
        } else {
            option4JButton.setEnabled(true);
        }
        //Update Story object and GUI with points earned each decision
        int exPointsEarned = MainWindow.cinderella.exPointsEarned();
        exPoints.setText("EXP: " + Integer.toString(exPointsEarned));
    }

    /**
     * Read from file and load Decision object
     *
     * @param decisionNum decision user is at (0 to 9)
     * @param optionChosen index of option button that user chose (0 to 3)
     * @return Decision object
     */
    public Decision loadNewDecision(int decisionNum, int optionChosen) {
        Decision d = new Decision(); //Instantiate Decision object
        try {
            File f = new File("src/reimagined/Decisions.txt"); //Read file with attributes for all possible Decisions
            Scanner s = new Scanner(f);
            int numOfLoops = 0;
            for (int i = 0; i < decisionNum; i++) { //Calculate number of lines to traverse before data is read into Decision object
                //For all decisions before current one, multiply the number of options the decision has with 10 (since each option takes up 10 lines back to back in file)
                numOfLoops = numOfLoops + d.getNumOfOptions(i) * 10;
            }
            //For current decision, skip over all the options before the one the user chose
            //Total all these lines up for a final number of lines to skip
            numOfLoops = numOfLoops + optionChosen * 10;
            for (int i = 0; i < numOfLoops; i++) {
                s.nextLine(); //Skip the line by not saving the value in the program
            }
            d.setImagePath(s.nextLine()); //IMAGE PATH
            d.setDescription(s.nextLine()); //DESCRIPTION
            //OPTIONS AND RESPECTIVE EXP by looping through length of options array in Decision object
            for (int i = 0; i < d.getOptions().length; i++) {
                d.setOption(i, s.nextLine());
                d.setExPOption(i, Integer.parseInt(s.nextLine()));
            }
            updateGUI(d);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error:" + e);
        }
        return d;
    }

    /**
     * Update data file storing user information
     */
    public void updateUserDatabase() {
        try {
            FileWriter allUsers = new FileWriter("src/reimagined/UsersDatabase.txt"); //Open connection to File
            String usersList = ""; //Initialize empty String to store user information
            for (int i = 0; i < MainWindow.userData.size(); i++) { //Loop through ArrayList of users
                if (MainWindow.current.getUsername().equals(MainWindow.userData.get(i).getUsername())) { //If the username of the current User matches a user from the ArrayList (prev user)
                    if (MainWindow.cinderella.getGame() != null) { //If the user has already played the game
                        if (MainWindow.userData.get(i).getHighScoreNumOfSweeps() < MainWindow.cinderella.getGame().getTotalSweeps()) { //If greater than old score
                            MainWindow.userData.get(i).setHighScoreNumOfSweeps(MainWindow.cinderella.getGame().getTotalSweeps()); //Update User with their MOST CURRENT number of sweeps
                        }
                    }
                    if (MainWindow.userData.get(i).getHighScoreExPoints() < MainWindow.cinderella.exPointsEarned()) { //If greater than old score
                        MainWindow.userData.get(i).setHighScoreExPoints(MainWindow.cinderella.exPointsEarned()); //Update User with their MOST CURRENT EXP they earned
                    }
                    //Achievements updated right in main code
                }
                //Retrieve info of all users from ArrayList and append to String
                usersList = usersList + (MainWindow.userData.get(i)).getUsername()
                        + "\n" + (MainWindow.userData.get(i)).getPassword()
                        + "\n" + (MainWindow.userData.get(i)).getHighScoreExPoints()
                        + "\n" + (MainWindow.userData.get(i)).getHighScoreNumOfSweeps()
                        + "\n" + ((MainWindow.userData.get(i)).getAchievements())[0]
                        + "\n" + ((MainWindow.userData.get(i)).getAchievements())[1]
                        + "\n" + ((MainWindow.userData.get(i)).getAchievements())[2]
                        + "\n" + ((MainWindow.userData.get(i)).getAchievements())[3]
                        + "\n" + ((MainWindow.userData.get(i)).getAchievements())[4]
                        + "\n" + ((MainWindow.userData.get(i)).getAchievements())[5]
                        + "\n" + ((MainWindow.userData.get(i)).getAchievements())[6]
                        + "\n" + ((MainWindow.userData.get(i)).getAchievements())[7]
                        + "\n";
            }
            allUsers.write(usersList); //Write compiled list of user info to file
            allUsers.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    /**
     * Reset Decision Window
     */
    public void reset() {
        if (!MainWindow.current.getUsername().equals("")) { //If not a guest
            updateUserDatabase(); //Write new users, EXP earned, and number of sweeps during game to file
        }
        MainWindow.cinderella = new Story("Cinderella"); //Reset all attributes of Story to defaults
        decisionNum = 0; //Set index of decisions back to 0, so that window is updated appropriately
        //Enable all buttons
        option1JButton.setEnabled(true);
        option2JButton.setEnabled(true);
        option3JButton.setEnabled(true);
        option4JButton.setEnabled(true);
        //Load and display Decision #1
        Decision n = loadNewDecision(decisionNum, 0);
        MainWindow.cinderella.setDecisionOne(n); //Update Story object with Decision #1
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        visual = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        option1JButton = new javax.swing.JButton();
        option3JButton = new javax.swing.JButton();
        option2JButton = new javax.swing.JButton();
        option4JButton = new javax.swing.JButton();
        endBtn = new javax.swing.JButton();
        exPoints = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        visual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        visual.setText("Visual");

        description.setEditable(false);
        description.setColumns(20);
        description.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        description.setLineWrap(true);
        description.setRows(10);
        description.setWrapStyleWord(true);
        jScrollPane1.setViewportView(description);

        option1JButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        option1JButton.setText("Option 1");
        buttonGroup1.add(option1JButton);
        option1JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1JButtonActionPerformed(evt);
            }
        });

        option3JButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        option3JButton.setText("Option 3");
        buttonGroup1.add(option3JButton);
        option3JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3JButtonActionPerformed(evt);
            }
        });

        option2JButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        option2JButton.setText("Option 2");
        buttonGroup1.add(option2JButton);
        option2JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2JButtonActionPerformed(evt);
            }
        });

        option4JButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        option4JButton.setText("Option 4");
        buttonGroup1.add(option4JButton);
        option4JButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4JButtonActionPerformed(evt);
            }
        });

        endBtn.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        endBtn.setText("End Story");
        endBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endBtnActionPerformed(evt);
            }
        });

        exPoints.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        exPoints.setText("EXP: 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(visual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(option1JButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(option2JButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(option3JButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(option4JButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(endBtn)
                .addGap(102, 102, 102)
                .addComponent(exPoints)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(visual)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exPoints))
                .addGap(18, 18, 18)
                .addComponent(option1JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option2JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option3JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(option4JButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void option1JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1JButtonActionPerformed
        int optionChosen = 0; //Index of option chosen by user is the same since the button is the same
        if (decisionNum == 0) { //Index of the Decision user is on
            //Update Decision #1 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionOne();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionOne(l);
            //Load and display Decision #2
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionTwo(n); //Update Story Object with Decision #2
        } else if (decisionNum == 1) {
            //Update Decision #2 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTwo();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionTwo(l);
            //Load and display Decision #3
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionThree(n); //Update Story Object with Decision #3
        } else if (decisionNum == 2) {
            //Update Decision #3 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionThree();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionThree(l);
            decisionNum++;
            //Disable if twig NOT selected in Decision #1
            if (MainWindow.cinderella.getDecisionOne().getExPEarned() == 0) {
                option2JButton.setEnabled(false);
            }
            //Open Game Window and close Decision Window
            if (gW == null) {
                gW = new GameWindow(this); //Create new window if it doesn't exist
            } else {
                gW.setGame(); //Reset game
            }
            gW.setVisible(true);
            this.setVisible(false);
            //Decision #4 loaded and displayed in Game
        } else if (decisionNum == 3) { //4AEND
            //Update Decision #4 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionFour();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionFour(l);
            MainWindow.current.setAchievementThree(true); //Achievement Unlocked
            //Load and display Decision #5
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionFive(n); //Update Story Object with Decision #5
        } else if (decisionNum == 4) { //5AEND
            //Update Decision #5 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionFive();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionFive(l);
            MainWindow.current.setAchievementFour(true); //Achievement Unlocked
            //Load and display Decision #6
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionSix(n); //Update Story Object with Decision #6
        } else if (decisionNum == 5) { //6AEND
            //Update Decision #6 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionSix();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionSix(l);
            MainWindow.current.setAchievementFive(true); //Achievement Unlocked
            //Load and display Decision #7
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionSeven(n); //Update Story Object with Decision #7
        } else if (decisionNum == 6) { //7AEND
            //Update Decision #7 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionSeven();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionSeven(l);
            MainWindow.current.setAchievementSix(true); //Achievement Unlocked
            //Load and display Decision #8
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionEight(n); //Update Story Object with Decision #8
        } else if (decisionNum == 7) { //8AEND
            //Update Decision #8 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionEight();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionEight(l);
            MainWindow.current.setAchievementSix(true); //Achievement Unlocked
            //Load and display Decision #9
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionNine(n); //Update Story Object with Decision #9
        } else if (decisionNum == 8) { //9AEND
            //Update Decision #9 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionNine();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionNine(l);
            MainWindow.current.setAchievementSeven(true); //Achievement Unlocked
            //Load and display Decision #10
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionTen(n); //Update Story Object with Decision #10
        } else if (decisionNum == 9) {
            //Update Decision #10 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTen();
            l.setUserChoice(option1JButton.getText());
            l.setExPEarned(l.getExPOptionOne());
            MainWindow.cinderella.setDecisionTen(l);
            //Update Decision Window with Ending
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
        }
    }//GEN-LAST:event_option1JButtonActionPerformed

    private void option2JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2JButtonActionPerformed
        int optionChosen = 1;
        if (decisionNum == 0) {
            //Update Decision #1 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionOne();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionOne(l);
            //Load and display Decision #2
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionTwo(n); //Update Story Object with Decision #2
        } else if (decisionNum == 1) { //2BEND
            //Update Decision #2 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTwo();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionTwo(l);
            MainWindow.current.setAchievementOne(true); //Achievement Unlocked
            //Load and display Decision #3
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionThree(n); //Update Story Object with Decision #3
        } else if (decisionNum == 2) {
            //Update Decision #3 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionThree();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionThree(l);
            decisionNum++;
            //Disable if twig NOT selected in Decision #1
            if (MainWindow.cinderella.getDecisionOne().getExPEarned() == 0) {
                option2JButton.setEnabled(false);
            }
            //Open Game Window and close Decision Window
            if (gW == null) {
                gW = new GameWindow(this); //Create new window if it doesn't exist
            } else {
                gW.setGame(); //Reset game
            }
            gW.setVisible(true);
            this.setVisible(false);
        } else if (decisionNum == 3) {
            //Update Decision #4 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionFour();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionFour(l);
            //Load and display Decision #5
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionFive(n); //Update Story Object with Decision #5
        } else if (decisionNum == 4) { //5BEND
            //Update Decision #5 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionFive();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionFive(l);
            MainWindow.current.setAchievementFour(true); //Achievement Unlocked
            //Load and display Decision #6
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionSix(n); //Update Story Object with Decision #6
        } else if (decisionNum == 5) {
            //Update Decision #6 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionSix();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionSix(l);
            //Load and display Decision #7
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionSeven(n); //Update Story Object with Decision #7
        } else if (decisionNum == 6) {
            //Update Decision #7 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionSeven();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionSeven(l);
            //Load and display Decision #8
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionEight(n); //Update Story Object with Decision #8
        } else if (decisionNum == 7) {
            //Update Decision #8 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionEight();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionEight(l);
            //Load and display Decision #9
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionNine(n); //Update Story Object with Decision #9
        } else if (decisionNum == 8) { //9BEnd
            //Update Decision #9 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionNine();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionNine(l);
            MainWindow.current.setAchievementEight(true); //Achievement Unlocked
            //Load and display Decision #10
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionTen(n); //Update Story Object with Decision #10
        } else if (decisionNum == 9) {
            //Update Decision #10 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTen();
            l.setUserChoice(option2JButton.getText());
            l.setExPEarned(l.getExPOptionTwo());
            MainWindow.cinderella.setDecisionTen(l);
            //Update Decision Window with Ending
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
        }
    }//GEN-LAST:event_option2JButtonActionPerformed

    private void option3JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3JButtonActionPerformed
        int optionChosen = 2;
        if (decisionNum == 0) {
            //Update Decision #1 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionOne();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionOne(l);
            //Load and display Decision #2
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionTwo(n); //Update Story Object with Decision #2
        } else if (decisionNum == 1) {
            //Update Decision #2 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTwo();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionTwo(l);
            //Load and display Decision #3
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionThree(n); //Update Story Object with Decision #3
        } else if (decisionNum == 2) {
            //Update Decision #3 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTwo();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionThree(l);
            //Load and display Decision #3
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionFour(n); //Update Story Object with Decision #4
        } else if (decisionNum == 3) {
            //Update Decision #4 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionFour();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionFour(l);
            //Load and display Decision #5
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionFive(n); //Update Story Object with Decision #5
        } else if (decisionNum == 4) { //5CEND
            //Update Decision #5 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionFive();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionFive(l);
            MainWindow.current.setAchievementThree(true); //Achievement Unlocked
            //Load and display Decision #6
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionSix(n); //Update Story Object with Decision #6
        } else if (decisionNum == 5) {
            //Update Decision #6 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionSix();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionSix(l);
            //Load and display Decision #7
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionSeven(n); //Update Story Object with Decision #7
        } else if (decisionNum == 6) {
            //Update Decision #7 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionSeven();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionSeven(l);
            //Load and display Decision #8
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionEight(n); //Update Story Object with Decision #8
        } else if (decisionNum == 7) {
            //Update Decision #8 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionEight();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionEight(l);
            //Load and display Decision #9
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionNine(n); //Update Story Object with Decision #9
        } else if (decisionNum == 8) {
            //Update Decision #9 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionNine();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionNine(l);
            //Load and display Decision #10
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionTen(n); //Update Story Object with Decision #10
        } else if (decisionNum == 9) {
            //Update Decision #10 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTen();
            l.setUserChoice(option3JButton.getText());
            l.setExPEarned(l.getExPOptionThree());
            MainWindow.cinderella.setDecisionTen(l);
            //Update Decision Window with Ending
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
        }
    }//GEN-LAST:event_option3JButtonActionPerformed

    private void option4JButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4JButtonActionPerformed
        int optionChosen = 3;
        if (decisionNum == 0) {
            //Update Decision #1 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionOne();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionOne(l);
            //Load and display Decision #2
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionTwo(n); //Update Story Object with Decision #2
        } else if (decisionNum == 1) {
            //Update Decision #2 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTwo();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionTwo(l);
            //Load and display Decision #3
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionThree(n); //Update Story Object with Decision #3
        } else if (decisionNum == 2) {
            //Update Decision #3 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTwo();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionThree(l);
            //Load and display Decision #3
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionFour(n); //Update Story Object with Decision #4
        } else if (decisionNum == 3) {
            //Update Decision #4 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionFour();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionFour(l);
            //Load and display Decision #5
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionFive(n); //Update Story Object with Decision #5
        } else if (decisionNum == 4) {
            //Update Decision #5 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionFive();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionFive(l);
            //Load and display Decision #6
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionSix(n); //Update Story Object with Decision #6
        } else if (decisionNum == 5) {
            //Update Decision #6 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionSix();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionSix(l);
            //Load and display Decision #7
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionSeven(n); //Update Story Object with Decision #7
        } else if (decisionNum == 6) {
            //Update Decision #7 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionSeven();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionSeven(l);
            //Load and display Decision #8
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionEight(n); //Update Story Object with Decision #8
        } else if (decisionNum == 7) {
            //Update Decision #8 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionEight();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionEight(l);
            //Load and display Decision #9
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionNine(n); //Update Story Object with Decision #9
        } else if (decisionNum == 8) {
            //Update Decision #9 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionNine();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionNine(l);
            //Load and display Decision #10
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
            MainWindow.cinderella.setDecisionTen(n); //Update Story Object with Decision #10
        } else if (decisionNum == 9) {
            //Update Decision #10 in Story object based on user choice and the EXP they earned
            Decision l = MainWindow.cinderella.getDecisionTen();
            l.setUserChoice(option4JButton.getText());
            l.setExPEarned(l.getExPOptionFour());
            MainWindow.cinderella.setDecisionTen(l);
            //Update Decision Window with Ending
            decisionNum++;
            Decision n = loadNewDecision(decisionNum, optionChosen);
        }
    }//GEN-LAST:event_option4JButtonActionPerformed

    private void endBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endBtnActionPerformed
        mW.setVisible(true);
        this.setVisible(false);
        reset(); //Close and reset Decision Window
    }//GEN-LAST:event_endBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextArea description;
    private javax.swing.JButton endBtn;
    private javax.swing.JLabel exPoints;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton option1JButton;
    private javax.swing.JButton option2JButton;
    private javax.swing.JButton option3JButton;
    private javax.swing.JButton option4JButton;
    private javax.swing.JLabel visual;
    // End of variables declaration//GEN-END:variables
}
