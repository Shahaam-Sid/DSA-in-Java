/**
 * Interface for double ended queues, that can insert and remove at both ends
 * simplified version of java.util.Deque
 * @author Muhammad Shahaam Siddiqui
 */
public interface Deque<E>
{   
    /**
     * Returns size of deque
     * @return number or elements
     */
    int size();

    /**
     * checks if deque is empty or not
     * @return true if empty, false if not
     */
    boolean isEmpty();

    /**
     * returns the first element w/o removing it
     * @return first element
     */
    E first();
    
    /**
     * return the last element w/o removing it
     * @return last element
     */
    E last();

    /**
     * adds Element at the start
     * @param e element to be inserted
     */
    void addFirst(E e);

    /**
     * adds Element at the end
     * @param e element to be insrted
     */
    void addLast(E e);

    /**
     * remove and returns the first element
     * @return first element
     */
    E removeFirst();

    /**
     * remove and returns the last element
     * @return last element
     */
    E removeLast();
}