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

    // R-5.9
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

    // C-5.13
    public static int productRecursive(int x, int y) {
        if (y == 1) {return x;}

        return productRecursive(x, y - 1) + x;
    }

    // C-5.17
    public static String reverseStr(String s) {
        char[] sArr = s.toCharArray();

        char[] outputArr = reverseCharArr(sArr, 0, sArr.length - 1);

        StringBuilder sb = new StringBuilder();
        
        for (char c : outputArr) {
            sb.append(c);
        }
        return sb.toString();
    }

    // C-5.22
    public static int[] pairSumCheck(int[] arr, int k, int start) {
        if (start + 1 == arr.length) {
            return new int[]{0};
        }
        if ((arr[start] + arr[start + 1]) == k) {
            return new int[]{start, start + 1};
        }

        return pairSumCheck(arr, k, start + 1);
        
    }

    // helper
    private static char[] reverseCharArr(char[] arr, int firstIndex, int lastIndex) {
        char temp;

        if ((firstIndex < 0) || (lastIndex >= arr.length)) {throw new IndexOutOfBoundsException("Invalid Index");}
        if (firstIndex >= lastIndex) {return arr;}
    
        if (firstIndex != lastIndex) {
            temp = arr[firstIndex];
            arr[firstIndex] = arr[lastIndex];
            arr[lastIndex] = temp;

            arr = reverseCharArr(arr, firstIndex + 1, lastIndex - 1);
        }
        return arr;
    }
}