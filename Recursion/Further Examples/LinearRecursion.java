public class LinearRecursion {
    public static int sumArray(int[] arr, int lastIndex) {
        
        if (arr.length < lastIndex) {throw new IllegalArgumentException("lastIndex cannot be more then size of array");}
        if (lastIndex == 0) return 0;
        else {
            return sumArray(arr, lastIndex - 1) + arr[lastIndex - 1];
        }
    }
    public static int[] reverseArray(int[] arr, int firstIndex, int lastIndex) {

        int temp;
        
        if ((firstIndex < 0) || (lastIndex >= arr.length)) {throw new IndexOutOfBoundsException("Invalid Index");}
        if (firstIndex >= lastIndex) {return arr;}
    
        if (firstIndex != lastIndex) {
            temp = arr[firstIndex];
            arr[firstIndex] = arr[lastIndex];
            arr[lastIndex] = temp;

            arr = reverseArray(arr, firstIndex + 1, lastIndex - 1);
        }
        return arr;
    }
    public static double powerSlow(double x, int n) {
        // Slower way to Computer power
        if (n < 0) {throw new IllegalArgumentException("Power must to be less then 0");}

        if (n == 0) return 1; else {
            return x * powerSlow(x, n - 1);
        }
    }
    public static double powerFast(double x, int n) {
        // Faster way to Computer power
        if (n < 0) {throw new IllegalArgumentException("Power must to be less then 0");}

        if (n == 0) return 1; else {
            double partial = powerFast(x, n / 2);
            double result = partial * partial;
            if ((n % 2) == 1) result *= x;
            
            return result;
        }
    }
}