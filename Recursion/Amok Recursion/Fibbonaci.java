public class Fibbonaci {
    // Return nth fibonacci number
    // Inefficient version
    public static long badFibonacci(int n) {
        if (n <= 1) return 1;
        else {
            return badFibonacci(n-2) + badFibonacci(n - 1);
        }
    }
    // Efficient Version
    public static long[] goodFibonacci(int n) {
        if (n <= 1) {
            long[] answer = {n, 0};
            return answer;
        } else {
            long[] temp = goodFibonacci(n - 1);
            long[] answer = {temp[0] + temp[1], temp[0]};
            return answer;
        }
    }
}
