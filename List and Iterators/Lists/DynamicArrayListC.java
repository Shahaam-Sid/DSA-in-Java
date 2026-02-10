import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArrayListC<E> implements ListC<E>, Iterable<E> {

    /**
     * A (nonstatic) inner class. Note well that each instance contains an implicit
     * reference to the containing list, allowing it to access the list's members.
     */
    private class ArrayIterator implements Iterator<E> {
        private int j = 0;
        private boolean removable = false;

        /**
         * Tests whether the iterator has a next object.
         * @return true if there are further objects, false otherwise
         */
        @Override
        public boolean hasNext() {return j < size;}

        /**
         * Returns the next object in the iterator.
         * 
         * @return next object
         * @throws NoSuchElementException if there are no further elements
         */
        @Override
        public E next() throws NoSuchElementException {
            if (j == size) throw new NoSuchElementException("No next element");
            removable = true;
            return data[j++];
        }
        
        /**
         * Removes the element returned by most recent call to next.
         * 
         * @throws IllegalStateException if next has not yet been called
         * @throws IllegalStateException if remove was already called since recent next
         */
        @Override
        public void remove() throws IllegalStateException
        {
            if (!removable) throw new IllegalStateException("Nothing to remove");
            DynamicArrayListC.this.remove(j - 1);
            j--;
            removable = false;
        }
    }


    public static final int CAPACITY = 16;
    private E[] data;
    private int size = 0;

    public DynamicArrayListC() {this(CAPACITY);}
    public DynamicArrayListC(int capacity) {
        data = (E[]) new Object[capacity];
    }
    @Override
    public int size() {return size;}
    @Override
    public boolean isEmpty() {return size == 0;}
    @Override
    public E get(int i) {
        checkIndex(i, size);
        return data[i];
    }
    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException{
        checkIndex(i, size);
        E output = data[i];
        data[i] = e;
        return output;
    }
    
    @Override
    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
        checkIndex(i, size + 1);
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int k = size - 1; k >= i; k--) {
            data[k + 1] = data[k];
        }
        data[i] = e;
        size++;
    }
    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) {
            data[k] = data[k + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }
    /**Returns an iterator of the elements stored in the list. */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }
    protected void resize(int capacity) {
        E[] temp = (E[]) new Object[capacity];
        for (int k = 0; k < size; k++) {
            temp[k] = data[k];
        }
        data = temp;
    }
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) throw new IndexOutOfBoundsException("Illegal Index: " + i);
    }
}