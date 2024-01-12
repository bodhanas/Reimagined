/* Aurni, Bodhana, Mary
 * User Object Class
 * 5/26/23
 */
package reimagined;

public class User {

    //Attributes
    private String username;
    private String password;
    private int exPointsHighScore;
    private int numOfSweepsHighScore;
    private boolean[] achievements = new boolean[8];

    /**
     * Primary constructor accepts values for username and sets default values
     * for remaining attributes
     *
     * @param username username of User
     */
    public User(String username) {
        this.username = username; //User must have username to exist
        password = "";
        exPointsHighScore = 0;
        numOfSweepsHighScore = 0;
        for (int i = 0; i < 8; i++) {
            achievements[i] = false;
        }

    }

    /**
     * Secondary constructor
     *
     * @param username username of User
     * @param password password of User
     * @param exPoints experience points of User
     * @param numOfSweeps number of User's sweeps
     * @param achievements achievements of User
     */
    public User(String username, String password, int exPoints, int numOfSweeps, boolean[] achievements) {
        this(username); //constructor chaining
        this.password = password;
        this.exPointsHighScore = exPoints;
        this.numOfSweepsHighScore = numOfSweeps;
        this.achievements = achievements;
    }

    /**
     * Mutator for User's username
     *
     * @param username username of User
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Accessor for User's username
     *
     * @return username of User
     */
    public String getUsername() {
        return username;
    }

    /**
     * Mutator for User's password
     *
     * @param password password of User
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Accessor for User's password
     *
     * @return password of User
     */
    public String getPassword() {
        return password;
    }

    /**
     * Mutator for most experience points earned by User
     *
     * @param exPoints experience points of User
     */
    public void setHighScoreExPoints(int exPoints) {
        this.exPointsHighScore = exPoints;
    }

    /**
     * Accessor for most experience points earned by User
     *
     * @return experience points of User
     */
    public int getHighScoreExPoints() {
        return exPointsHighScore;
    }

    /**
     * Mutator for most number of sweeps by User
     *
     * @param numOfSweeps number of sweeps
     */
    public void setHighScoreNumOfSweeps(int numOfSweeps) {
        this.numOfSweepsHighScore = numOfSweeps;
    }

    /**
     * Accessor for most number of sweeps by User
     *
     * @return number of sweeps
     */
    public int getHighScoreNumOfSweeps() {
        return numOfSweepsHighScore;
    }

    /**
     * Mutator for User's achievements
     *
     * @param achievements achievements of User
     */
    public void setAchievements(boolean[] achievements) {
        this.achievements = achievements;
    }

    /**
     * Mutator for whether User earned first achievement
     *
     * @param tOrF true or false
     */
    public void setAchievementOne(boolean tOrF) {
        this.achievements[0] = tOrF;
    }

    /**
     * Mutator for whether User earned second achievement
     *
     * @param tOrF true or false
     */
    public void setAchievementTwo(boolean tOrF) {
        this.achievements[1] = tOrF;
    }

    /**
     * Mutator for whether User earned third achievement
     *
     * @param tOrF true or false
     */
    public void setAchievementThree(boolean tOrF) {
        this.achievements[2] = tOrF;
    }

    /**
     * Mutator for whether User earned fourth achievement
     *
     * @param tOrF true or false
     */
    public void setAchievementFour(boolean tOrF) {
        this.achievements[3] = tOrF;
    }

    /**
     * Mutator for whether User earned fifth achievement
     *
     * @param tOrF true or false
     */
    public void setAchievementFive(boolean tOrF) {
        this.achievements[4] = tOrF;
    }

    /**
     * Mutator for whether User earned sixth achievement
     *
     * @param tOrF true or false
     */
    public void setAchievementSix(boolean tOrF) {
        this.achievements[5] = tOrF;
    }

    /**
     * Mutator for whether User earned seventh achievement
     *
     * @param tOrF true or false
     */
    public void setAchievementSeven(boolean tOrF) {
        this.achievements[6] = tOrF;
    }

    /**
     * Mutator for whether User earned eighth achievement
     *
     * @param tOrF true or false
     */
    public void setAchievementEight(boolean tOrF) {
        this.achievements[7] = tOrF;
    }

    /**
     * Accessor for User's achievements
     *
     * @return achievements of User
     */
    public boolean[] getAchievements() {
        return achievements;
    }

    /**
     * Accessor for whether user earned first achievement
     *
     * @return Achievement #1
     */
    public boolean getAchievementOne() {
        return achievements[0];
    }

    /**
     * Accessor for whether user earned second achievement
     *
     * @return Achievement #2
     */
    public boolean getAchievementTwo() {
        return achievements[1];
    }

    /**
     * Accessor for whether user earned third achievement
     *
     * @return Achievement #3
     */
    public boolean getAchievementThree() {
        return achievements[2];
    }

    /**
     * Accessor for whether user earned fourth achievement
     *
     * @return Achievement #4
     */
    public boolean getAchievementFour() {
        return achievements[3];
    }

    /**
     * Accessor for whether user earned fifth achievement
     *
     * @return Achievement #5
     */
    public boolean getAchievementFive() {
        return achievements[4];
    }

    /**
     * Accessor for whether user earned sixth achievement
     *
     * @return Achievement #6
     */
    public boolean getAchievementSix() {
        return achievements[5];
    }

    /**
     * Accessor for whether user earned seventh achievement
     *
     * @return Achievement #7
     */
    public boolean getAchievementSeven() {
        return achievements[6];
    }

    /**
     * Accessor for whether user earned eighth achievement
     *
     * @return Achievement #8
     */
    public boolean getAchievementEight() {
        return achievements[7];
    }

    /**
     * Converts User's attributes into String
     *
     * @return String list of all User's attributes
     */
    public String toString() {
        String userInfo;
        userInfo = "\nUsername: " + username + "\nPassword: HIDDEN\nExperience Points: "
                + exPointsHighScore + "\nNumber of Sweeps: " + numOfSweepsHighScore
                + "\nAchievements: \nBad Ending #1: " + achievements[0]
                + "\nBad Ending #2: " + achievements[1]
                + "\nBad Ending #3: " + achievements[2]
                + "\nBad Ending #4: " + achievements[3]
                + "\nBad Ending #5: " + achievements[4]
                + "\nBad Ending #6: " + achievements[5]
                + "\nNormal Ending: " + achievements[6]
                + "\nTrue Ending: " + achievements[7];
        return userInfo;
    }

    /**
     * Compare 2 separate Users to determine whether their attributes are
     * identical
     *
     * @param other another User to compare to
     * @return whether User's attributes are identical
     */
    public boolean equals(User other) {
        // compare each User' attributes to each other to check for equality
        return this.username.equals(other.getUsername())
                && this.password.equals(other.getPassword())
                && this.exPointsHighScore == other.getHighScoreExPoints()
                && this.numOfSweepsHighScore == other.getHighScoreNumOfSweeps()
                && this.achievements.equals(other.getAchievements());
    }

    /**
     * Create and instantiate another User with exact same attributes as
     * original
     *
     * @return cloned User
     */
    public User clone() {
        //declare and instantiate new User with matching attributes
        User clonedUser = new User(username, password, exPointsHighScore, numOfSweepsHighScore,
                achievements);
        return clonedUser;
    }
}
