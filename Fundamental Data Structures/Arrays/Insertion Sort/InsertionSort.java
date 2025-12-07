public class InsertionSort {
    public static char[] sort(char[] data) {
        int n = data.length;
        for (int k = 1; k < n; k++) {
            char cur = data[k];
            int j = k;
            while (j > 0 && data[j - 1] > cur) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = cur;
        }

        return data;
    }
    public static void main(String[] args) {

        char[] c = {'C', 'A', 'L', 'B','D'};
        System.out.println(InsertionSort.sort(c));
    }
}