import java.util.Arrays;

public class CloningArrays{
    public static int[][] deepClone(int[][] original) {
        int[][] backup = new int[original.length][];
        for (int k = 0; k < original.length; k++) {
            backup[k] = original[k].clone();
        }
        return backup;
    }
    public static void main(String[] args) {
       

        int[] arr1 = {1, 2, 4, 9};
        int[] refArr1 = arr1;
        int[] shallowCopyArr1 = arr1.clone();

        arr1[0] = 10;

        System.out.println("Original: " + Arrays.toString(arr1));
        System.out.println("Reference: " + Arrays.toString(refArr1));
        System.out.println("Shallow: " + Arrays.toString(shallowCopyArr1));


        int[][] arr2 = {{1, 2}, {3, 4}, {9, 8}};
        int[][] refArr2 = arr2;
        int[][] shallowCopyArr2 = arr2.clone();
        int[][] deepCopyArr2 = deepClone(refArr2);

        arr2[0][0] = 10;

        System.out.println("Original: " + Arrays.deepToString(arr2));
        System.out.println("Reference: " + Arrays.deepToString(refArr2));
        System.out.println("Shallow: " + Arrays.deepToString(shallowCopyArr2));
        System.out.println("Deep: " + Arrays.deepToString(deepCopyArr2));        
    }
}