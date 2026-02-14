// This file is here for Exercise, Primarily Not a Part of this Dir

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

    // R-6.4
    public static <E> void transfer(Stack<E> s, Stack<E> t) throws IllegalStateException {
        
        if (s.isEmpty()) {throw new IllegalStateException("Original Stack is Empty");}
        if (!t.isEmpty()) {throw new IllegalStateException("New Stack is not Empty");}

        int size = s.size();
        for (int i = 0; i < size; i++) {
            t.push(s.pop());
        }
    }
    public static <E> void clearStack(Stack<E> s)
    {
        if (s.isEmpty()) {return;}

        s.pop();
        clearStack(s);
    }
}
