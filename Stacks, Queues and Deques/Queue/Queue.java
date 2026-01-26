/**
 * Collection of Objects similar to stack
 * but is FIFO
 * 
 * @author Muhammad Shahaam Siddiqui
 */
public interface Queue<E> {
    /**
     * Returns Size of stack
     * @return Numbers of element
     */
    int size();

    /**
     * Checks if Empty
     * @return True if Empty, False if not
     */
    boolean isEmpty();
    
    /**
     * Inserts element in the last
     * @param e the element to be inserted
     */
    void enqueue(E e);

    /**
     * Returns only the element at the top
     * @return top element (null if empty)
     */
    E first();

    /**
     * Returns the first element and removes it from the list
     * @return the first element
     */
    E dequeue();
}
