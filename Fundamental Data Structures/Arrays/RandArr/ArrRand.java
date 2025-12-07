import java.util.Arrays;
import java.util.Random;

public class ArrRand {
    public static void main(String[] arg) {
        int[] data = new int[10];
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        for (int i = 0; i < 10; i++) {
            data[i] = random.nextInt(100);
        }

        int[] orig = Arrays.copyOf(data, data.length);
        
        System.out.println("Array Equal before sorting: " + Arrays.equals(data, orig));

        Arrays.sort(data);

        System.out.println("Array Equal after sorting: " + Arrays.equals(data, orig));

        System.out.println("orig = " + Arrays.toString(orig));

        System.out.println("data = " + Arrays.toString(data));
    }
}
