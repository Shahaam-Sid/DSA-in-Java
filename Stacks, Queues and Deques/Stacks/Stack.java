/**
 * Collection of Objects that are inserted removed
 * according to LIFO, Similar to java.util.stack
 * 
 * @author Muhammad Shahaam Siddiqui
 */
public interface Stack<E> {

    /**
     * Return size of stack
     * @return number of element in stack
     */
    int size();

    /**
     * Tests whether Stack is empty
     * @return True if Empty, False of not
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack
     * @param e the element to be inserted
     */
    void push(E e);

    /**
     * returns only the element at the top of the stack
     * @return top element (null if empty)
     */
    E top();

    /**
     * returns and remove top elemnt
     * @return top element (null if empty)
     */
    E pop();
}
