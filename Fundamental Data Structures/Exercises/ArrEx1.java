import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class ArrEx1 {
    // R-3.2
    protected static <T> T[] emptyArrayRand(T[] arr) {
        Random random = new Random();

        int length = arr.length;

        System.out.println("Original: " + Arrays.toString(arr));
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(0, length - i);

            arr = removeElement(arr, index);

            System.out.println("" + Arrays.toString(arr));
        }
        return arr;
    }
    // C-3.17
    protected static int checkForOneRepeat(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                 return arr[i];
                }
            }
        }
        throw new NoSuchElementException("No Repeated Value Found");
    }
    // C-3.18
    protected static int[] checkForFiveRepeat(int[] arr) {

        int[] num = new int[5];
        int count = 0;

        for (int j = 0; j < arr.length && count < 5; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                if (arr[k] > 0) {
                   if (arr[j] == arr[k]) {
                        num[count] = arr[j];
                        count++;
                        arr[j] = 0;
                        break;
                    }
                }
            }
        }
        
        if (count == 5) {
            return num;
        } else {
            throw new NoSuchElementException("Less Then 5 Values repeated: " + Arrays.toString(num));
        }
    }
    // C-3.24
    protected static int[][][] threeDegreeAddition (int[][][] arr1, int[][][] arr2) {

        int[][][] sum;

        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays not Equal in Dimensions");
        }

        sum = new int[arr1.length][][];

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i].length != arr2[i].length) {
                throw new IllegalArgumentException("Arrays not Equal in Dimensions");
            }

            sum[i] = new int[arr1[i].length][];

            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j].length != arr2[i][j].length) {
                    throw new IllegalArgumentException("Arrays not Equal in Dimensions");
                }

                sum[i][j] = new int[arr1[i][j].length];

                for (int k = 0; k < arr1[i][j].length; k++) {
                    sum[i][j][k] = arr1[i][j][k] + arr2[i][j][k];
                }
            }
        }
        return sum;
    }
    



    
    private static <T> T[] removeElement(T[] arr, int index) {
        if (index >= arr.length) {
            throw new IndexOutOfBoundsException("Index " + index + " doesnot exist for this list");
        }
        T[] newArr = (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length - 1);

        for (int k = 0; k < index; k++) {
            newArr[k] = arr[k];
        }
        for(int k = index; k < arr.length - 1; k++) {
            newArr[k] = arr[k + 1];
        }

        return newArr;
    }





    public static void main(String[] args) {

        int[][][] arr1 = {
            {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
            {{13, 14, 15, 16}, {17, 18, 19, 20}, {21, 22, 23, 24}}
        };

        int[][][] arr2 = {
            {{100, 100, 100, 100}, {200, 200, 200, 200}, {300, 300, 300, 300}},
            {{400, 400, 400, 400}, {500, 500, 500, 500}, {600, 600, 600, 600}}
        };

        int[][][] ans = threeDegreeAddition(arr1, arr2);

        System.out.println(Arrays.deepToString(ans));

        //Incomplete
    }
    
}
