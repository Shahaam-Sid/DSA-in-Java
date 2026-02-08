/**
 * Interface for Positional Lists
 * @author Muhammad Shahaam Siddiqui
 */
public interface PositionalLists<E> {

    /**
     * Returns size of list
     * @return number of elements
     */
    int size();

    /**
     * Checks if List is Empty or not
     * @return true if list is empty, false if not
     */
    boolean isEmpty();
    
    /**
     * Returns the first position in the list or null if empty
     * @return position of First Element
     */
    Position<E> first();

    /**
     * Returns the last position in the list or null if empty
     * @return  position if Last Element
     */
    Position<E> last();

    /**
     * Returns the position immediately before Position p or null if p is first
     * @param p reference position
     * @return position before p
     * @throws IllegalArgumentException if reference position doesn't exist
     */
    Position<E> before(Position<E> p) throws IllegalArgumentException;

    /**
     * Returns the position immediately after Position p or null if p is first
     * @param p reference position
     * @return position after p
     * @throws IllegalArgumentException if reference position doesn't exist
     */
    Position<E> after(Position<E> p) throws IllegalArgumentException;

    /**
     * Adds element in front of the list and returns it position
     * @param e element to be inserted
     * @return position of new element
     */
    Position<E> addFirst(E e);

    /**
     * Adds element in the end of the list and returns it position
     * @param e element to be inserted
     * @return position of new element
     */
    Position<E> addLast(E e);

    /**
     * Inserts element immedietly before position p and return its nre position
     * @param p position of reference
     * @param e element to be inserted
     * @return position of inserted element
     * @throws IllegalArgumentException if Position p doesn't exist in the list
     */
    Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Inserts element immedietly after position p and return its nre position
     * @param p position of reference
     * @param e element to be inserted
     * @return position of inserted element
     * @throws IllegalArgumentException if position p doesn't exist in the list
     */
    Position<E> addAfter(Position<E> p, E e)  throws IllegalArgumentException;

    /**
     * Replaces the element at position p and returns the replaced element
     * @param p position to be replaced
     * @param e element to repplace
     * @return replaced element
     * @throws IllegalArgumentException if position p doesn't exist in the list
     */
    E set(Position<E> p, E e) throws IllegalArgumentException;

    /**
     * Removes the element stored at position p and returns it
     * @param p Position to be removed
     * @return Element to be removed
     * @throws IllegalArgumentException if position p doesn't exist in the list
     */
    E remove(Position<E> p) throws IllegalArgumentException;
}