public class ArrayDeque<E> implements Deque<E> {
    private E[] data;
    private int f = 0;
    private int sz = 0;

    public ArrayDeque() {this(1000);}
    public ArrayDeque(int capacity) {
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return sz;
    }
    @Override
    public boolean isEmpty() {
        return sz == 0;
    }
    @Override
    public E first() {
        if (isEmpty()) return null;
        return data[f];
    }
    @Override
    public E last() {
        if (isEmpty()) return null;
        int backIndex = (f + sz - 1) % data.length;
        return data[backIndex];
    }
    @Override
    public void addFirst(E e) {
        if (sz == data.length) {throw new IllegalStateException("Queue is full");}

        f = (f - 1 + data.length) % data.length;
        data[f] = e;
        sz++;
    }
    @Override
    public void addLast(E e) {
        if (sz == data.length) {throw new IllegalStateException("Queue is full");}

        int backIndex = (f + sz) % data.length;
        data[backIndex] = e;
        sz++;

    }
    @Override
    public E removeFirst() {
        if (isEmpty()) return null;

        E e = data[f];
        data[f] = null;
        f = (f + 1) % data.length;
        sz--;

        return e;
    }
    @Override
    public E removeLast() {
        if (isEmpty()) return null;

        int backIndex = (f + sz - 1) % data.length;
        E e = data[backIndex];
        data[backIndex] = null;
        sz--;

        return e;
    }
}
