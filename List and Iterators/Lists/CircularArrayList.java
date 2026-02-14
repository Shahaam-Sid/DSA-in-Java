// Exercise C-7.25

/**
 * List implementation using Static Circular Array
 * 
 * @author Muhammad Shahaam Siddiqui
 */
public class CircularArrayList<E> {
    private E[] arr;
    private int front = 0;
    private int rear = 0;
    private int size = 0;
    private static final int CAPACITY = 10;

    public CircularArrayList() {this(CAPACITY);}
    public CircularArrayList(int capacity) {
        arr = (E[]) new Object[capacity];
    }

    /**
     * Returns the size of list
     * @return number of elements in the array
     */
    public int getSize() {return size;}

    /**
     * Checks if list is empty or not
     * @return True if size == 0 and False id size == 0
     */
    public boolean isEmpty() {return size == 0;}

    /**
     * Inserts at front of the list
     * @param e element to be inserted
     * @throws IllegalStateException if list is full
     */
    public void insertAtFront(E e) throws IllegalStateException {
        if (size == arr.length) throw new IllegalStateException("List is Full");
        
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + arr.length) % arr.length;
        }
        arr[front] = e;
        size++;
    }
    
    /**
     * Inserts at the rear of the list
     * @param e element to be inserted
     * @throws IllegalStateException if list is full
     */
    public void insertAtRear(E e) throws IllegalStateException {
        if (size == arr.length) throw new IllegalStateException("List is Full");

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % arr.length;
        }
        arr[rear] = e;
        size++;
    }

    /**
     * removes element at front
     * @return element at front
     * @throws IllegalStateException if list is empty
     */
    public E removeAtFront() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");

        E output = arr[front];
        arr[front] = null;
        if (size == 1) {
            front = 0;
            rear = 0;
        } else {
            front = (front + 1) % arr.length;
        }
        size--;
        return output;
    }

    /**
     * removes element at rear
     * @return element at rear
     * @throws IllegalStateException if list is empty
     */
    public E removeAtRear() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("List is Empty");

        E output = arr[rear];
        arr[rear] = null;
        if (size == 1) {
            front = 0;
            rear = 0;
        } else {
            rear = (rear - 1 + arr.length) % arr.length;
        }
        size--;
        return output;
    }

    /**
     * returns element at given index
     * @param index element to return
     * @return element at index
     * @throws IndexOutOfBoundsException if index is out of bounds or null
     */
    public E getElement(int index) throws IndexOutOfBoundsException {
        if (index >= size) throw new IndexOutOfBoundsException("Invalid Index");
        
        return arr[(front + index) % arr.length]; 
    }
}