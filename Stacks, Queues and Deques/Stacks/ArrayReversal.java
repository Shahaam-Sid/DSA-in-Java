
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
}
