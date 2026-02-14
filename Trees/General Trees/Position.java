// this file is here to aid TreeC class, this is not primarily a part of this

/**
 * Interface for Positions. Used for Positional Lists
 * @author Muhammad Shahaam Siddiqui
 */
public interface Position<E> {

    /**
     * Returns the element stored at this position
     * @return the stored element
     * @throws IllegalStateException if position no longer valid
     */
    E getElement() throws IllegalStateException;
}