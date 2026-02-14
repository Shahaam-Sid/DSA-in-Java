import java.util.ArrayList;
import java.util.List;

/** An abstract base class providing some functionality of the BinaryTree interface.*/
public abstract class AbstractBinaryTreeC<E> extends AbstractTreeC<E> implements BinaryTreeC<E>{

    /** Returns the Position of p's sibling (or null if no sibling exists). */
    @Override
    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if(parent == null) return null;
        
        if(p == left(parent)) return right(parent);
        else return left(parent);
    }

    /** Returns the number of children of Position p. */
    @Override
    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) count++;
        if(right(p) != null) count ++;
        return count;
    }
    /** Returns an iterable collection of the Positions representing p's children. */
    @Override
    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2);
        if (left(p) != null) snapshot.add(left(p));
        if (right(p) != null) snapshot.add(right(p));
        return snapshot;
    }
}