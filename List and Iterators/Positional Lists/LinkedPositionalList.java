import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalLists<E>, Iterable<E> {

    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }
        
        @Override
        public E getElement() throws IllegalStateException {
            if (next == null) throw new IllegalStateException("Position no longer valid");
            return element;
        }
        public Node<E> getPrev() {
            return prev;
        }
        public Node<E> getNext() {
            return next;
        }
        public void setElement(E e) {
            element = e;
        }
        public void setPrev(Node<E> p) {
            prev = p;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }
     


    /** Nested Position Iterator Class */
    private class PositionIterator implements Iterator<Position<E>> {
        private Position<E> cursor = first();
        private Position<E> recent = null;
        
        /** Tests whether an iterator has a next object */
        @Override
        public boolean hasNext() {return cursor != null;}

        /** Returns the next position in the iterator. */
        @Override
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) throw new NoSuchElementException("Nothing left");
            recent = cursor;
            cursor = after(cursor);
            return recent;
        }

        /** Removes the element returned by most recent call to next. */
        @Override
        public void remove() throws IllegalStateException {
            if (recent == null) throw new IllegalStateException("Nothing to remove");
            LinkedPositionalList.this.remove(cursor);
            recent = null;
        }
    }


    /** Nested Position iterable class */
    private class PositionIteratable implements Iterable<Position<E>> {
        @Override
       public Iterator<Position<E>> iterator() {return new PositionIterator();} 
    }


    /** nested ElementIterator class */
    private class ElementIterator implements Iterator<E> {
        Iterator<Position<E>> posIterator = new PositionIterator();
        @Override
        public boolean hasNext() {return posIterator.hasNext();}
        @Override
        public E next() {return posIterator.next().getElement();}
        @Override
        public void remove() {posIterator.remove();}
    }



    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");

        Node<E> node = (Node<E>) p;
        if (node.getNext() == null) throw new IllegalArgumentException("p is no longer in the list");

        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) return null;

        return node;
    }

    @Override
    public int size() {return size;}
    @Override
    public boolean isEmpty() {return size == 0;}
    @Override
    public Position<E> first() {return header.getNext();}
    @Override
    public Position<E> last() {return trailer.getPrev();}
    @Override
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getPrev());
    }
    @Override
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }


    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }

    @Override
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext());
    }
    @Override
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer);
    }
    @Override
    public Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }
    @Override
    public Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }
    @Override
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }
    @Override
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setNext(predecessor);
        size--;
        E answer = node.getElement();
        node.setElement(null);
        node.setPrev(null);
        node.setNext(null);
        return answer;
    }
    /** Returns an iterable representation of the list's positions. */
    public Iterable<Position<E>> positions() {
        return new PositionIteratable();
    }
    /** Returns an iterator of the elements stored in the list. */
    @Override
    public Iterator<E> iterator() {return new ElementIterator();}

    /** Insertion-sort of a positional list of integers into nondecreasing order */
    public static void insertionSort(PositionalLists<Integer> list) {
        Position<Integer> marker = list.first();
        while (marker != list.last()) {
            Position<Integer> pivot = list.after(marker);
            int value = pivot.getElement();
            if (value > marker.getElement())
                marker = pivot;
            else {
                Position<Integer> walk = marker;
                while (walk != list.first() && list.before(walk).getElement() > value)
                    walk = list.before(walk);
                list.remove(pivot);
                list.addBefore(walk, value);
            }
        }
    }
}