import java.util.Arrays;

public class EquivalenceTesingArrays {
    public static void main(String[] args) {
        
        /* Reference Equality
        *   Compares Memory Address for Objects
        *   For Primitives checks Actual Values
        */

        int i = 8;
        int j = 8;

        String s = new String("equal?");
        String str = new String("equal?");

        System.out.println(i == j); //output: true
        System.out.println(s == str); // output: false

        /* Content Equality
        *   Method define in Object class
        *   Default implements "=="
        *   Most classes Override it
        *   for Example String class compares each char
        */

        System.out.println(s.equals(str)); // output: true

        /* Shallow Array Comparision
        *   Compares array one level deep
        *   For primitive array compares actual values
        *   For object implements equals() for each value
        *   Does not work with multi-dimensions array
        */
        
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{1, 2}, {3, 4}};

        System.out.println("" + Arrays.equals(arr1, arr2)); // output: true
        System.out.println("" + Arrays.equals(matrix1, matrix2)); // output: false

        /* Deep Array Comparision
        *   Recursively compares nested array
        *   Works for nested array
        *   Compares content at all levels
        */

        Object[] complex1 = {new int[]{1, 2}, "test"};
        Object[] complex2 = {new int[]{1, 2}, "test"};

        System.out.println("" + Arrays.equals(arr1, arr2)); // output: true
        System.out.println(Arrays.deepEquals(matrix1, matrix2)); // output: true
        System.out.println(Arrays.deepEquals(complex1, complex2)); // output: true

    }
}
