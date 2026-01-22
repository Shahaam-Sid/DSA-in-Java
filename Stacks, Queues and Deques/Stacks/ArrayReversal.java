import java.util.Arrays;

public class ArrayReversal {
    public static <E> void reverse(E[] arr) {
        ArrayStack<E> buffer = new ArrayStack<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            buffer.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = buffer.pop();
        }
    }
    public static void main(String[] args) {
        Integer[] a = {4, 8, 15, 16, 23, 42}; // autoboxing allows this
        String[] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"};
        
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        System.out.println("Reversing...");
        
        reverse(a);
        reverse(s);
        
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
    }
}
