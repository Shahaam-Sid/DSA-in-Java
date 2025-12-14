import java.util.Arrays;

public class ArrEx2 { // P-3.36
    private int[][] arr1, arr2;
    
    public ArrEx2(int[][] array) {this(array, array);}
    public ArrEx2(int[][] array1, int[][] array2) {
        if (array1.length != array2.length) {
            throw new IllegalArgumentException("Arrays not Equal in Dimensions");
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != array2[i].length) {
                throw new IllegalArgumentException("Arrays not Equal in Dimensions");
            }
        }

        arr1 = array1;
        arr2 = array2;
    }

    public int[][] addition() {

        int [][] ans = new int[arr1.length][];
        for (int i = 0; i < arr1.length; i++) {
            ans[i] = new int[arr1[i].length];
        }
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                ans[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        return ans;
    }

    // Multiplication Method

    
    public static void main(String[] args) {
        int[][] a = {
            {1, 2},
            {3, 4}
        };
        int[][] b = {
            {5, 6},
            {7, 8}
        };

        ArrEx2 z = new ArrEx2(a, b);

        int[][] add = z.addition();

        System.out.println(Arrays.deepToString(add));
    }
}
