/* Aurni, Bodhana, Mary 
 * Story Object Class
 * 5/30/23
 */
package reimagined;

public class Story {

    //Attributes 
    private String storyTitle;
    private Decision[] decisions = new Decision[10];
    private Game miniGame;

    /**
     * Primary constructor accepts values for Story title and sets default
     * values for remaining attributes
     *
     * @param storyTitle the title
     */
    public Story(String storyTitle) {
        this.storyTitle = storyTitle; //Story must have a title to exist
        for (int i = 0; i < decisions.length; i++) { //Load array with Decision objects 
            decisions[i] = new Decision();
        }
        miniGame = new Game("");
    }

    /**
     * Secondary constructor
     *
     * @param storyTitle the title of the story
     * @param decisions array of decisions user can take
     * @param miniGame the game that corresponds with the story the user is
     */
    public Story(String storyTitle, Decision[] decisions, Game miniGame) {
        this(storyTitle); //constructor chaining
        this.decisions = decisions;
        this.miniGame = miniGame;
    }

    /**
     * Mutator for the story title
     *
     * @param storyTitle the title of the story
     */
    public void setStoryTitle(String storyTitle) {
        this.storyTitle = storyTitle;
    }

    /**
     * Mutator for the array containing all decisions
     *
     * @param decisions array of decisions
     */
    public void setArrayOfDecisions(Decision[] decisions) {
        this.decisions = decisions;
    }

    /**
     * Mutator for the user's first decision in the game
     *
     * @param dOne Decision #1
     */
    public void setDecisionOne(Decision dOne) {
        this.decisions[0] = dOne;
    }

    /**
     * Mutator for the user's second decision in the game
     *
     * @param dTwo Decision #2
     */
    public void setDecisionTwo(Decision dTwo) {
        this.decisions[1] = dTwo;
    }

    /**
     * Mutator for the user's third decision in the game
     *
     * @param dThree Decision #3
     */
    public void setDecisionThree(Decision dThree) {
        this.decisions[2] = dThree;
    }

    /**
     * Mutator for the user's fourth decision in the game
     *
     * @param dFour Decision #4
     */
    public void setDecisionFour(Decision dFour) {
        this.decisions[3] = dFour;
    }

    /**
     * Mutator for the user's fifth decision in the game
     *
     * @param dFive Decision #5
     */
    public void setDecisionFive(Decision dFive) {
        this.decisions[4] = dFive;
    }

    /**
     * Mutator for the user's six decision in the game
     *
     * @param dSix Decision #6
     */
    public void setDecisionSix(Decision dSix) {
        this.decisions[5] = dSix;
    }

    /**
     * Mutator for the user's seven decision in the game
     *
     * @param dSeven Decision #7
     */
    public void setDecisionSeven(Decision dSeven) {
        this.decisions[6] = dSeven;
    }

    /**
     * Mutator for the user's eighth decision in the game
     *
     * @param dEight Decision #8
     */
    public void setDecisionEight(Decision dEight) {
        this.decisions[7] = dEight;
    }

    /**
     * Mutator for the user's nine decision in the game
     *
     * @param dNine Decision #9
     */
    public void setDecisionNine(Decision dNine) {
        this.decisions[8] = dNine;
    }

    /**
     * Mutator for the user's tenth decision in the game
     *
     * @param dTen Decision #10
     */
    public void setDecisionTen(Decision dTen) {
        this.decisions[9] = dTen;
    }

    /**
     * Mutator for the mini game generated during the interactive story
     *
     * @param miniGame the story's mini game
     */
    public void setGame(Game miniGame) {
        this.miniGame = miniGame;
    }

    /**
     * Accessor for the story title
     *
     * @return the story title
     */
    public String getStoryTitle() {
        return storyTitle;
    }

    /**
     * Accessor for the array containing all decisions
     *
     * @return array of decisions
     */
    public Decision[] getArrayOfDecisions() {
        return decisions;
    }

    /**
     * Accessor for the user's first decision in the game
     *
     * @return Decision #1
     */
    public Decision getDecisionOne() {
        return decisions[0];
    }

    /**
     * Accessor for the user's second decision in the game
     *
     * @return Decision #2
     */
    public Decision getDecisionTwo() {
        return decisions[1];
    }

    /**
     * Accessor for the user's third decision in the game
     *
     * @return Decision #3
     */
    public Decision getDecisionThree() {
        return decisions[2];
    }

    /**
     * Accessor for the user's fourth decision in the game
     *
     * @return Decision #4
     */
    public Decision getDecisionFour() {
        return decisions[3];
    }

    /**
     * Accessor for the user's fifth decision in the game
     *
     * @return Decision #5
     */
    public Decision getDecisionFive() {
        return decisions[4];
    }

    /**
     * Accessor for the user's sixth decision in the game
     *
     * @return Decision #6
     */
    public Decision getDecisionSix() {
        return decisions[5];
    }

    /**
     * Accessor for the user's seventh decision in the game
     *
     * @return Decision #7
     */
    public Decision getDecisionSeven() {
        return decisions[6];
    }

    /**
     * Accessor for the user's eighth decision in the game
     *
     * @return Decision #8
     */
    public Decision getDecisionEight() {
        return decisions[7];
    }

    /**
     * Accessor for the user's ninth decision in the game
     *
     * @return Decision #9
     */
    public Decision getDecisionNine() {
        return decisions[8];
    }

    /**
     * Accessor for the user's tenth decision in the game
     *
     * @return Decision #10
     */
    public Decision getDecisionTen() {
        return decisions[9];
    }

    /**
     * Accessor for the mini game generated during the interactive story
     *
     * @return the story's mini game
     */
    public Game getGame() {
        return miniGame;
    }

    /**
     * Get all the info about the story and the user's pathway
     *
     * @return a string representation of the story
     */
    public String toString() {
        String str = "Story Title: " + storyTitle + "\n" + "Decision One: " + decisions[0].getUserChoice() + "\n"
                + "Decision Two: " + decisions[1].getUserChoice() + "\n"
                + "Decision Three: " + decisions[2].getUserChoice() + "\n"
                + "Decision Four: " + decisions[3].getUserChoice() + "\n"
                + "Decision Five: " + decisions[4].getUserChoice() + "\n"
                + "Decision Six: " + decisions[5].getUserChoice() + "\n"
                + "Decision Seven: " + decisions[6].getUserChoice() + "\n"
                + "Decision Eight: " + decisions[7].getUserChoice() + "\n"
                + "Decision Nine: " + decisions[8].getUserChoice() + "\n"
                + "Decision Ten: " + decisions[9].getUserChoice() + "\n";
        if (miniGame != null) {
            str = str + "Mini Game: " + miniGame.getGameRules() + "\n";
        }
        return str;
    }

    /**
     * Confirms if two stories are equal to each other based on their attributes
     *
     * @param other the other story that is being compared
     * @return true if the stories are equal or false otherwise
     */
    public boolean equals(Story other) {
        return storyTitle.equals(other.getStoryTitle())
                && decisions[0].equals(other.getDecisionOne())
                && decisions[1].equals(other.getDecisionTwo())
                && decisions[2].equals(other.getDecisionThree())
                && decisions[3].equals(other.getDecisionFour())
                && decisions[4].equals(other.getDecisionFive())
                && decisions[5].equals(other.getDecisionSix())
                && decisions[6].equals(other.getDecisionSeven())
                && decisions[7].equals(other.getDecisionEight())
                && decisions[8].equals(other.getDecisionNine())
                && decisions[9].equals(other.getDecisionTen())
                && miniGame.equals(other.getGame());
    }

    /**
     * Makes a clone of a story by giving the clone the same values as the
     * original story
     *
     * @return the copy of the story
     */
    public Story clone() {
        //Declare and instantiate new decision with matching attributes
        Story clone = new Story(storyTitle, decisions, miniGame);
        return clone;
    }

    /**
     * Method to calculate the total EXP the user won
     *
     * @return the experience points
     */
    public int exPointsEarned() {
        int points = 0;
        for (int i = 0; i < decisions.length; i++) { //Accumulate the number of points earned across all the decisions
            points = points + decisions[i].getExPEarned();
        }
        if (miniGame != null) { //If miniGame object is initialized
            points = points + miniGame.getExPointsEarned(); //Add on the points earned during the game
        }
        return points;
    }
}
