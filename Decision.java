/* Aurni, Bodhana, Mary
 * Decision Object Class
 * 5/29/23
 */
package reimagined;

public class Decision {

    //Attributes
    private String imagePath;
    private String description;
    //Initialize options (text and points)
    private String[] options = new String[4];
    private int[] exPOptions = new int[4];
    //Number of options each Decision has
    private final int numOfOptions[] = {1, 3, 2, 2, 2, 4, 2, 2, 2, 2};
    //Actual choices
    private String userChoice;
    private int exPEarned;

    /**
     * Primary constructor sets default values for all attributes
     */
    public Decision() {
        imagePath = "";
        description = "";
        //Options
        for (int i = 0; i < options.length; i++) {
            options[i] = "Option " + (i + 1); //Load array with Strings (placeholders)
            exPOptions[i] = 0;
        }
        //Actual choices user makes
        userChoice = "";
        exPEarned = 0;
    }

    /**
     * Secondary constructor
     *
     * @param imagePath file path to display image
     * @param description background info on decision to be made (narration)
     * @param options array of possible options user can take (including none if
     * a bad ending occurs)
     * @param exPOptions array of possible EXP user can earn
     * @param userChoice the option the user picks
     * @param exPEarned the number of EXP the user wins
     */
    public Decision(String imagePath, String description, String[] options, int[] exPOptions, String userChoice, int exPEarned) {
        this(); //constructor chaining
        this.imagePath = imagePath;
        this.description = description;
        this.options = options;
        this.exPOptions = exPOptions;
        this.userChoice = userChoice;
        this.exPEarned = exPEarned;
    }

    /**
     * Mutator for the file path to display image
     *
     * @param imagePath file path
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * Mutator for the description of the decision
     *
     * @param description narration leading up to decision
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Mutator for the array of possible options
     *
     * @param i index of option (0 to 3)
     * @param option description of option
     */
    public void setOption(int i, String option) {
        options[i] = option;
    }

    /**
     * Mutator for the array of possible EXP user can win
     *
     * @param i index of option (0 to 3)
     * @param exp points user can win
     */
    public void setExPOption(int i, int exp) {
        exPOptions[i] = exp;
    }

    /**
     * Mutator for first option available to the user
     *
     * @param optionOne
     */
    public void setOptionOne(String optionOne) {
        options[0] = optionOne;
    }

    /**
     * Mutator for second option available to the user
     *
     * @param optionTwo
     */
    public void setOptionTwo(String optionTwo) {
        options[1] = optionTwo;
    }

    /**
     * Mutator for third option available to the user
     *
     * @param optionThree
     */
    public void setOptionThree(String optionThree) {
        options[2] = optionThree;
    }

    /**
     * Mutator for fourth option available to the user
     *
     * @param optionFour
     */
    public void setOptionFour(String optionFour) {
        options[3] = optionFour;
    }

    /**
     * Mutator for the EXP earned by selecting first option
     *
     * @param exPOptionOne points for Option #1
     */
    public void setExPOptionOne(int exPOptionOne) {
        exPOptions[0] = exPOptionOne;
    }

    /**
     * Mutator for the EXP earned by selecting second option
     *
     * @param exPOptionTwo points for Option #2
     */
    public void setExPOptionTwo(int exPOptionTwo) {
        exPOptions[1] = exPOptionTwo;
    }

    /**
     * Mutator for the EXP earned by selecting third option
     *
     * @param exPOptionThree points for Option #3
     */
    public void setExPOptionThree(int exPOptionThree) {
        exPOptions[2] = exPOptionThree;
    }

    /**
     * Mutator for the EXP earned by selecting fourth option
     *
     * @param exPOptionFour points for Option #4
     */
    public void setExPOptionFour(int exPOptionFour) {
        exPOptions[3] = exPOptionFour;
    }

    /**
     * Mutator for the option selects
     *
     * @param userChoice
     */
    public void setUserChoice(String userChoice) {
        this.userChoice = userChoice;
    }

    /**
     * Mutator for the EXP the user earns
     *
     * @param exPEarned
     */
    public void setExPEarned(int exPEarned) {
        this.exPEarned = exPEarned;
    }

    /**
     * Accessor for the file path to display image
     *
     * @return file path
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Accessor for the description of the decision
     *
     * @return narration leading up to decision
     */
    public String getDescription() {
        return description;
    }

    /**
     * Accessor for the array of possible options
     *
     * @return array of options
     */
    public String[] getOptions() {
        return options;
    }

    /**
     * Accessor for the array of possible EXP user can win
     *
     * @return array of EXP user can win
     */
    public int[] getExPOptions() {
        return exPOptions;
    }

    /**
     * Accessor for the number of options each decision has
     *
     * @param i decision number
     * @return number of options
     */
    public int getNumOfOptions(int i) {
        return numOfOptions[i];
    }

    /**
     * Accessor for the first option available to the user
     *
     * @return Option #1
     */
    public String getOptionOne() {
        return options[0];
    }

    /**
     * Accessor for the second option available to the user
     *
     * @return Option #2
     */
    public String getOptionTwo() {
        return options[1];
    }

    /**
     * Accessor for the third option available to the user
     *
     * @return Option #3
     */
    public String getOptionThree() {
        return options[2];
    }

    /**
     * Accessor for the fourth option available to the user
     *
     * @return Option #4
     */
    public String getOptionFour() {
        return options[3];
    }

    /**
     * Accessor for the EXP earned by selecting first option
     *
     * @return points for Option #1
     */
    public int getExPOptionOne() {
        return exPOptions[0];
    }

    /**
     * Accessor for the EXP earned by selecting second option
     *
     * @return points for Option #2
     */
    public int getExPOptionTwo() {
        return exPOptions[1];
    }

    /**
     * Accessor for the EXP earned by selecting third option
     *
     * @return points for Option #3
     */
    public int getExPOptionThree() {
        return exPOptions[2];
    }

    /**
     * Accessor for the EXP earned by selecting fourth option
     *
     * @return points for Option #4
     */
    public int getExPOptionFour() {
        return exPOptions[3];
    }

    /**
     * Accessor for the option selects
     *
     * @return option chosen by user
     */
    public String getUserChoice() {
        return userChoice;
    }

    /**
     * Accessor for the EXP the user earns
     *
     * @return points earned
     */
    public int getExPEarned() {
        return exPEarned;
    }

    /**
     * Get all the info about the decision and user selection
     *
     * @return a string representation of the decision
     */
    public String toString() {
        String decisionInfo;
        decisionInfo = "Image Path: " + imagePath
                + "\nDescription: " + description
                + "\nOption 1: " + options[0]
                + "\nOption 1 Points:" + exPOptions[0]
                + "\nOption 2: " + options[1]
                + "\nOption 2 Points:" + exPOptions[1]
                + "\nOption 3: " + options[2]
                + "\nOption 3 Points:" + exPOptions[2]
                + "\nOption 4: " + options[3]
                + "\nOption 4 Points:" + exPOptions[3]
                + "\nUser Choice: " + userChoice
                + "\nExperience Points: " + exPEarned;
        return decisionInfo;
    }

    /**
     * Confirms if two decisions are equal to each other based on their
     * attributes
     *
     * @param other the other decision that is being compared
     * @return true if the decisions are equal or false otherwise
     */
    public boolean equals(Decision other) {
        //Compare each Decision's attributes to each other to check for equality
        return imagePath.equals(other.getImagePath())
                && description.equals(other.getDescription())
                && options[0].equals(other.getOptionOne())
                && exPOptions[0] == other.getExPOptionOne()
                && options[1].equals(other.getOptionTwo())
                && exPOptions[1] == other.getExPOptionTwo()
                && options[2].equals(other.getOptionThree())
                && exPOptions[2] == other.getExPOptionThree()
                && options[3].equals(other.getOptionFour())
                && exPOptions[3] == other.getExPOptionFour()
                && userChoice.equals(other.getUserChoice())
                && exPEarned == other.getExPEarned();
    }

    /**
     * Makes a clone of a decision by giving the clone the same values as the
     * original decision
     *
     * @return the copy of the decision
     */
    public Decision clone() {
        //Declare and instantiate new decision with matching attributes
        Decision clone = new Decision(imagePath, description, options, exPOptions, userChoice, exPEarned);
        return clone;
    }
}
