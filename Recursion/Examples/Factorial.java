public class Factorial {
    public static int calculate(int n) {
        
        if (n < 0) {
            throw new IllegalArgumentException("Factorial Cannont be Zero");
        } else if (n == 0) {
            return 1;
        } else {
            return n * calculate(n - 1);
        }
    }
}