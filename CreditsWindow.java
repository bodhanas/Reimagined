/* Aurni, Bodhana, Mary
 * Credits Window
 * 6/13/23
 */
package reimagined;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreditsWindow extends javax.swing.JFrame {
    
    //Declare all windows it connects to
    MainWindow mW;

    public CreditsWindow(MainWindow m) {
        initComponents();
        //Connect to main menu
        mW = m;
        //Set up window (color and size)
        Color lavendar = new Color(179, 179, 230);
        getContentPane().setBackground(lavendar);
        setSize(525, 725);
        loadCredits(); //Load the credits
    }

    /**
     * Read the contributions each team member made from a file and display to user
     */
    public void loadCredits() {
        String lines = ""; //Initialize an empty String to add lines to
        try {
            File f = new File("src/reimagined/Credits.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) { //Run until there are no lines left in file and append to String
                lines += s.nextLine() + "\n";
            }
            //Update GUI by adding String to text area
            txtArea.setText(lines);
            txtArea.setLineWrap(true);
            //Scroll to top of text box
            txtArea.setSelectionStart(0);
            txtArea.setSelectionEnd(0);
        } catch (FileNotFoundException e) {
            System.out.println("Error " + e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        mainMenuJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleJLabel.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        titleJLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleJLabel.setText("The Team");

        mainMenuJButton.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        mainMenuJButton.setText("Back to Menu");
        mainMenuJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMenuJButtonActionPerformed(evt);
            }
        });

        txtArea.setEditable(false);
        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainMenuJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(mainMenuJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mainMenuJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMenuJButtonActionPerformed
        mW.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mainMenuJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton mainMenuJButton;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}
