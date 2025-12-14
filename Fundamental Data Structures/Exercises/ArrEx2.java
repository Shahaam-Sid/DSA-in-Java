
public class ArrEx2 { // P-3.36
    private int[][] arr1, arr2;
    private int rowArr1, rowArr2, columnArr1, columnArr2;
    
    public ArrEx2(int[][] array) {this(array, array);}
    public ArrEx2(int[][] array1, int[][] array2) {

        rowArr1 = array1.length;
        columnArr1 = array1[0].length;
        rowArr2 = array2.length;
        columnArr2 = array2[0].length;
        
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].length != columnArr1) {
                throw new IllegalArgumentException("Not a Matrix");
            }
        }
        for (int i = 0; i < array2.length; i++) {
            if (array2[i].length != columnArr2) {
                throw new IllegalArgumentException("Not a Matrix");
            }
        }

        arr1 = array1;
        arr2 = array2;
    }

    public int[][] addition() {

        if ((rowArr1 != rowArr2) || (columnArr1 != columnArr2)) {
            throw new IllegalArgumentException("Matrices not equal");
        }

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

    public int[][] multiplication() {

        if (columnArr1 != rowArr2) {
            throw new IllegalArgumentException("Matrices cannot be multiplied as dimensions are not suitable");
        }
         int[][] answer = new int[rowArr1][columnArr2];

            for (int i = 0; i < rowArr1; i++) {
                for (int j = 0; j < columnArr2; j++) {
                    answer[i][j] = 0;
                    for (int k = 0; k < columnArr1; k++) {
                        answer[i][j] += arr1[i][k] * arr2[k][j]; 
                    }
                }
            }
        
        return answer;
    }
}