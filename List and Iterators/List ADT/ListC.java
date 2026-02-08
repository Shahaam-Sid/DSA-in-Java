/**
 * Custom List Interface, like java.uitls.List
 * @author Muhammad Shahaam Siddiqui
 */
public interface ListC<E> {
    /**
     * Returns the Size of List
     * @return number of elements
     */
    int size();
    /**
     * Checks if List is Empty or Not
     * @return true if empty, false if not
     */
    boolean isEmpty();
    /**
     * returns the Element at Index i, doesn't remove it
     * @param i index
     * @return Element at that index
     * @throws IndexOutOfBoundsException if index is not in available range
     */
    E get(int i) throws IndexOutOfBoundsException;
    /**
     * Sets the Element e given at Index i
     * @param i Index to set the element at
     * @param e Element to be set
     * @return  Current Element at that index
     * @throws IndexOutOfBoundsException if index is not in available range
     */
    E set(int i, E e) throws IndexOutOfBoundsException;
    /**
     * Adds new element at the index, shifting current and next indexes to right
     * @param i Index to add
     * @param e Element to be added
     * @throws IndexOutOfBoundsException if index is not in available range
     */
    void add(int i, E e) throws IndexOutOfBoundsException;
    /**
     * Removes the Element at given index and returns it
     * @param i index to be removes
     * @return element present at that index
     * @throws IndexOutOfBoundsException if index is not in available range
     */
    E remove(int i) throws IndexOutOfBoundsException;
}
