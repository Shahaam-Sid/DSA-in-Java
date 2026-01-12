 // TODO: Complete this correctly

public class ExOne {
    public static int maxElement(int[] arr, int startIndex, int startValue) {
        
        if (startIndex >= arr.length) {
            int k = maxElement(arr, startIndex + 1, startValue);
        
        
            if (arr[startIndex] > startValue) k = arr[startIndex];
            else k = startValue;
            
            return k;
        }
        return startValue;
    }
    public static void main(String[] args) {
        
        int[] nums = {1, 4, 2, 6, 2, 8, 3};

        int i = maxElement(nums, 0, -1000);

        System.out.println(i);
    }
}