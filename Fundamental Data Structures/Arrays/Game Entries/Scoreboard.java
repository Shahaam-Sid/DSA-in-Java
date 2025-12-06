public class Scoreboard {
    private int numEntries;
    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }


    public void add(GameEntry e) {
        int newScore = e.getScore();
        // is new entry a high score
        if (numEntries < board.length || newScore > board[numEntries - 1].getScore()) {
            if (numEntries < board.length) {
                numEntries++; // increments only when capacity not full
            }
            int j = numEntries - 1;
            // moves the smaller values to right
            while (j > 0 && board[j - 1].getScore() < newScore) {
                board[j] = board[j - 1];
                j--;
            }
            board[j] = e; // assigns new value
        }
    }
    public GameEntry remove(int i) {
        if (i < 0 || i >= numEntries) {
            throw new IndexOutOfBoundsException("Invalid Index: " + i);
        }
        GameEntry temp = board[i];
        for (int j = i; j < numEntries - 1; j++) {
            board[j] = board[j + 1];
        }
        board[numEntries - 1] = null;
        numEntries--;
        return temp;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int n = 1;
        for (GameEntry entry : board) {
            if (!(entry == null)) {
                String temp = n + ". ";
                sb.append(temp);
                sb.append(entry.toString());
                sb.append("\n");
                n++;
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {

        Scoreboard sb = new Scoreboard(10);

        String[] s = {"Mike", "Rob", "Paul", "Anna", "Rose", "Jack"};
        int[] j = {1105, 750, 720, 660, 590, 510};

        for (int i = 0; i < 6; i++) {
            sb.add(new GameEntry(s[i], j[i]));
        }

        sb.add(new GameEntry("Jill", 740));

        System.out.println(sb.toString());

        System.out.println("\n\n");

        System.out.println(sb.remove(2));

        System.out.println(sb);
        
    }
}
