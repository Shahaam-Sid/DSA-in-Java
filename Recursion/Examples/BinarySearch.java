public class BinarySearch {
    public static int search(int[] numbers, int target, int low, int high) {
    
        int mid = (low + high) / 2;
        int i;

        if (low > high) {
            return -1;
        }
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] < target) {
            i = search(numbers, target, mid + 1, high);
        } else {
            i = search(numbers, target, low, mid - 1);
        }
        return i;
    }
}
