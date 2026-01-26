import java.util.NoSuchElementException;

// STARRED: This is Used in LLQueue class
//          Primarily not a part of this Package

public class SInglyLinkedList<E> implements Cloneable {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {return element;}
        public Node<E> getNext() {return next;}
        public void setNext(Node<E> n) {next = n;}
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size;

    public SInglyLinkedList() {}

    public int getSize() {return size;}
    public boolean isEmpty() {return size == 0;}
    public E first() {
        if (isEmpty()) {return null;}

        return head.getElement();
    }
    public E last() {
        if (isEmpty()) {return null;}

        return tail.getElement();
    }
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0) {tail = head;}

        size++;
    }
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);

        if (isEmpty()) {head = newest;}
        else {tail.setNext(newest);}

        tail = newest;
        size++;
    }
    public E removeFirst() {
        if (isEmpty()) {return null;}

        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {tail = null;}

    return answer;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {return false;}
        if(getClass() != o.getClass()) {return false;}
        SInglyLinkedList<E> other = (SInglyLinkedList<E>) o;
        if (size != other.size) {return false;}

        Node<E> walkA = head;
        Node<E> walkB = other.head;

        while (walkA != null) {
            if (!(walkA.getElement().equals(walkB.getElement()))) {return false;}
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }

        return true;
    }
    @Override
    public SInglyLinkedList<E> clone() throws CloneNotSupportedException {

        SInglyLinkedList<E> other = (SInglyLinkedList<E>) super.clone();
        if (size > 0) {
            other.head = new Node<>(head.getElement(), null);
            Node<E> walk = head.getNext();
            Node<E> otherTail = other.head;
            while (walk != null) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                otherTail.setNext(newest);
                otherTail = newest;
                walk = walk.getNext();
            }
        }
        return other;
    }

    // Exercises
    // R-3.6
    public E getSecondLast() {
        if (size < 2) {
            throw new IndexOutOfBoundsException("Linked List contains less then 2 Nodes");
        }
        Node<E> curr = head;
        Node<E> then = curr.getNext();

        for (int i = 0; i < getSize() - 2; i++) {
            if (then.getNext() ==  null) {
                break;
            }
            else {
                curr = curr.getNext();
                then = then.getNext();
            }
        }
        E sl = curr.getElement();

        return sl;
    }
    // R-3.12
    public void rotate() {
        if (size < 2) {throw new NoSuchElementException("Insufficient Number of Nodes");}

        tail.setNext(head);
        head = head.getNext();
        tail = tail.getNext();
        tail.setNext(null);
    }
    // C-3.25
    public static <E> SInglyLinkedList<E> concat(SInglyLinkedList<E> u,
        SInglyLinkedList<E> v) throws CloneNotSupportedException {

        if ((u == null) || v == null) {throw new IllegalArgumentException("List cannot be Null");}

        u = u.clone();
        v = v.clone();

        if (u.isEmpty()) {return v;}
        if (v.isEmpty()) {return u;}

        u.tail.setNext(v.head);
        u.tail = v.tail;
        u.size = u.size + v.size;

        return u;
    }
}