public class BinaryRecursion {
    public static int sumBinary(int[] arr, int low, int high) {
        if (low > high) return 0;
        else if (low == high) return arr[low];
        else {
            int mid = (low + high) / 2;
            return sumBinary(arr, low, mid) + sumBinary(arr, mid + 1, high);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 0};
        System.out.println("" + sumBinary(nums, 0, nums.length - 1));
    }
}
