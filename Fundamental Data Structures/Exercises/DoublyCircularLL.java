// C-3.32
public class DoublyCircularLL<E>{
    public static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {return element;}
        public Node<E> getPrev() {return prev;}
        public Node<E> getNext() {return next;}
        public void setPrev(Node<E> p) {prev = p;}
        public void setNext(Node<E> n) {next = n;}
    }

    private Node<E> tail = null;
    private int size = 0;

    public DoublyCircularLL() {}

    public int getSize() {return size;}
    public boolean isEmpty() {return size == 0;}
    public E first() {
        if (isEmpty()) {return null;}

        return tail.getNext().getElement();
    }
    public E last() {
        if (isEmpty()) {return null;}

        return tail.getElement();
    }
    public void rotate() {
        if (tail != null) {tail = tail.getNext();}
    }
    public void rotateBackwards() {
        if (tail != null) {tail = tail.getPrev();}
    }
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null, null);
            tail.setPrev(tail);
            tail.setNext(tail);
            size++;
        } else {
            addBetween(e, tail, tail.getNext());
        }
    }
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }
    public E removeFirst() {
        if (isEmpty()) {return null;}
        
        Node<E> head = tail.getNext();

        if (head == tail) {
            tail = null;
            size--;
            return head.getElement();
        }
        else {
            E e = remove(head);
            return e;
        }
    }
    public E removeLast() {
        if (isEmpty()) {return null;}

        if (size == 1) {

            E e = tail.getElement();
            tail = null;
            size--;
            return e;
        } else {
            tail = tail.getPrev();
            E e = remove(tail.getNext());
            return e;
        }
    }


    private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
        Node<E> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }
    private E remove(Node<E> node) {
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public static void main(String[] args) {
        
        DoublyCircularLL<String> dcll = new DoublyCircularLL<>();

        dcll.addFirst("Python");
        dcll.addLast("Java");
        dcll.addLast("C++");

        dcll.removeLast();

        System.out.println(dcll.first());
        System.out.println(dcll.last());
    }
}