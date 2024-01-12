/* Aurni, Bodhana, Mary
 * Game Object Class
 * 5/29/23
 */
package reimagined;

import javax.swing.ImageIcon;

public class Game {

    //Attributes
    private String gameRules;
    private ImageIcon graphicOne;
    private ImageIcon graphicTwo;
    private int totalTime; //In seconds
    private int totalSweeps; //In clicks
    private int exPointsEarned;

    /**
     * Primary constructor accepts values for Game rules and sets default values
     * for remaining attributes
     *
     * @param gameRules
     */
    public Game(String gameRules) {
        this.gameRules = gameRules; //Game must have rules to exist
        graphicOne = null;
        graphicTwo = null;
        totalTime = 0;
        totalSweeps = 0;
        exPointsEarned = 0;
    }

    /**
     * Secondary constructor
     *
     * @param gameRules rules of game
     * @param graphicOne first sprite pose of Ella
     * @param graphicTwo second sprite pose of Ella
     * @param totalTime time constraint on game
     * @param experiencePoints EXP user wins
     */
    public Game(String gameRules, ImageIcon graphicOne, ImageIcon graphicTwo, int totalTime, int totalSweeps, int exPoints) {
        this(gameRules); //constructor chaining
        this.graphicOne = graphicOne;
        this.graphicTwo = graphicTwo;
        this.totalTime = totalTime;
        this.totalSweeps = totalSweeps;
        this.exPointsEarned = exPoints;
    }

    /**
     * Mutator for Game rules
     *
     * @param gameRules
     */
    public void setGameRules(String gameRules) {
        this.gameRules = gameRules;
    }

    /**
     * Mutator for Ella's first sprite pose sweeping
     *
     * @param graphicOne first sprite pose
     */
    public void setGraphicOne(ImageIcon graphicOne) {
        this.graphicOne = graphicOne;
    }

    /**
     * Mutator for Ella's second sprite pose sweeping (horizontally flipped)
     *
     * @param graphicTwo second sprite pose
     */
    public void setGraphicTwo(ImageIcon graphicTwo) {
        this.graphicTwo = graphicTwo;
    }

    /**
     * Mutator for the total time allotted to play Game
     *
     * @param totalTime time constraint of game
     */
    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    /**
     * Mutator for number of sweeps done by user
     *
     * @param totalSweeps number of clicks by user
     */
    public void setTotalSweeps(int totalSweeps) {
        this.totalSweeps = totalSweeps;
    }

    /**
     * Mutator for the EXP the user earns
     *
     * @param exPoints EXP earned
     */
    public void setExPointsEarned(int exPoints) {
        this.exPointsEarned = exPoints;
    }

    /**
     * Accessor for Game rules
     *
     * @return rules of Game
     */
    public String getGameRules() {
        return gameRules;
    }

    /**
     * Accessor for Ella's first sprite pose sweeping
     *
     * @return first sprite pose
     */
    public ImageIcon getGraphicOne() {
        return graphicOne;
    }

    /**
     * Accessor for Ella's second sprite pose sweeping (horizontally flipped)
     *
     * @return second sprite pose
     */
    public ImageIcon getGraphicTwo() {
        return graphicTwo;
    }

    /**
     * Accessor for the total time allotted to play Game
     *
     * @return time constraint of game
     */
    public int getTotalTime() {
        return totalTime;
    }

    /**
     * Accessor for number of sweeps done by user
     *
     * @return number of clicks by user
     */
    public int getTotalSweeps() {
        return totalSweeps;
    }

    /**
     * Accessor for the EXP the user earns
     *
     * @return EXP earned
     */
    public int getExPointsEarned() {
        return exPointsEarned;
    }

    /**
     * Get all the info about the game and user performance
     *
     * @return a string representation of the game
     */
    public String toString() {
        String gameInfo;
        gameInfo = "Game: " + gameRules
                + "\nTotal Time: " + totalTime
                + "\nExperience Points: " + exPointsEarned
                + "\nTotal Sweeps: " + totalSweeps;
        return gameInfo;
    }

    /**
     * Confirms if two games are equal to each other based on their attributes
     *
     * @param other the other game that is being compared
     * @return true if the games are equal or false otherwise
     */
    public boolean equals(Game other) {
        //Compare each Decision's attributes to each other to check for equality
        return gameRules.equals(other.getGameRules())
                && totalTime == other.getTotalTime()
                && exPointsEarned == other.getExPointsEarned()
                && totalSweeps == other.getTotalSweeps();
    }

    /**
     * Makes a clone of a decision by giving the clone the same values as the
     * original decision
     *
     * @return the copy of the game
     */
    public Game clone() {
        //declare and instantiate new Game with matching attributes
        Game clonedGame = new Game(gameRules, graphicOne, graphicTwo, totalTime, totalSweeps, exPointsEarned);
        return clonedGame;
    }

    /**
     * Timer that calculates the number of seconds that go by
     *
     * @param delta seconds that have passed by
     * @param totalTime time limit to win game
     * @return seconds that have passed by
     */
    public int timeProgress(int delta, int totalTime) {
        try {
            Thread.sleep(1000); //Waits one second before updating counter
            delta++;
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return delta;
    }

}
