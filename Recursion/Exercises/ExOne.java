public class ExOne { // R-5.1
    private static int maxElement(int[] arr, int startIndex, int currMax) {
        if (startIndex >= arr.length) return currMax;

        int k;
        if (arr[startIndex] > currMax) k = arr[startIndex];
        else k = currMax;
        
        return maxElement(arr, startIndex + 1, k);
    }
    public static int maxElement(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array Cannot be Empty");
        
        return maxElement(arr, 0, arr[0]);
    }

    //R-5.9
    public static double powerIterative(double x, int n) {
        if (n < 0) {throw new IllegalArgumentException("Power must to be more then 0");}
        if (n == 0) {return 1;}

        double result = 1.0;
        double base = x;
        int exponent = n;

        while (exponent > 0) {
            if ((exponent & 1) == 1) result *= base;

            base *= base;
            exponent /= 2;
        }
        return result;
    }
}