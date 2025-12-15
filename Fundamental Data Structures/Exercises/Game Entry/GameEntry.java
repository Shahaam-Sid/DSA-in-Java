public class GameEntry {
    private String name;
    private int score;

    public GameEntry(String n, int s) {

        checkNotNull(n, "Name");
        checkStringIsAlpha(n);
        checkStringLength(n);

        checkNegativeInt(s, "Score");


        name = n;
        score = s;
    }
    public String getName() {return name;}
    public int getScore() {return score;}

    
    public void setName(String n) {
        checkNotNull(n, "Name");
        checkStringIsAlpha(n);
        checkStringLength(n);
        name = n;
    }
    public void setScore(int s) {
        checkNegativeInt(s, "Score");
        score = s;
    }
    @Override
    public String toString() {
        return name + " :: " + score;
    }


    private static void checkStringLength(String n) {
        if (n.length() < 3 || n.length() > 25) {
            throw new IllegalArgumentException( "name must be between 3-25 characters");
        }
    }
    private static void checkStringIsAlpha(String n) {
        if (!(n.matches("[a-zA-Z ]+"))) {
            throw new IllegalArgumentException("Name must contain Alphabets and Spaces only");
        }
    }
    private static void checkNotNull(String value, String fieldName) {
    if (value == null) {
        throw new IllegalArgumentException(fieldName + " cannot be null");
        }
    }
    private static void checkNegativeInt(int n, String fieldName) {
        if (n < 0) {
            throw new IllegalArgumentException(fieldName + " cannot be negative");
        }
    }
}