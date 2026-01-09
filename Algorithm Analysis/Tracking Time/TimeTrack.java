public class TimeTrack {
    public static String repeatConcat(char c, int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += c;
        }
        return s;
    }
    public static String repeatBuilder(char c, int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(c);
        }
        return s.toString();
    }
    public static void main(String[] args) {
        long startTime, endTime, elapsedOne, elapsedTwo;
    
        int i = 1000000;
    
        startTime = System.currentTimeMillis();

        repeatConcat('*', i);

        endTime = System.currentTimeMillis();

        elapsedOne = endTime - startTime;

        startTime = System.currentTimeMillis();

        repeatBuilder('*', i);

        endTime = System.currentTimeMillis();

        elapsedTwo = endTime - startTime;

        System.err.print("Stars: " + i + '\t');
        System.err.print("Concat Method Time: " + elapsedOne + "   ");
        System.err.println("Builder Method Time: " + elapsedTwo);
    }
}