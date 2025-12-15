public class DoublyLinkedList<E> implements Cloneable{
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

    private Node<E> header;
    private Node<E> trailer;
    private int size;

    public DoublyLinkedList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.setNext(trailer);
    }

    
    public int getSize() {return size;}
    public boolean isEmpty() {return size == 0;}
    public E first() {
        if (isEmpty()) {return null;}

        return header.getNext().getElement();
    }
    public E last() {
        if (isEmpty()) {return null;}

        return trailer.getPrev().getElement();
    }
    public void addFirst(E e) {
        addBetween(e, header, header.getNext());
    }
    public void addLast(E e) {
        addBetween(e, trailer.getPrev(), trailer);
    }
    public E removeFirst() {
        if (isEmpty()) {return null;}

        return remove(header.getNext());
    }
    public E removeLast() {
        if (isEmpty()) {return null;}

        return remove(trailer.getPrev());
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

    // Exercise
    // R-3.16
    @Override
    public boolean equals(Object o) {
        if (o == null) {return false;}
        if (getClass() != o.getClass()) {return false;}
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) o;
        if (size != other.size) {return false;}

        Node<E> walkA = header.getNext();
        Node<E> walkB = other.header.getNext();
        
        while (walkA != trailer) {
            if (walkA.getElement() == null) {
                if (walkB.getElement() != null) {return false;}
            } else {
                if (!(walkA.getElement().equals(walkB.getElement()))) {return false;}
            }
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        
        return true;
    }
    // C-3.35
    @Override
    public DoublyLinkedList<E> clone() throws CloneNotSupportedException {
        
        DoublyLinkedList<E> other = (DoublyLinkedList<E>) super.clone();
        
        if (size > 0) {
            
            other.header = new Node<>(null, null, null);
            other.trailer = new Node<>(null, other.header, null);
            other.header.setNext(other.trailer);
            
            Node<E> walk = header.getNext();
            Node<E> otherPrev = other.header;
            
            while (walk != trailer) {
                
                Node<E> newest = new Node<>(walk.getElement(), otherPrev, null);
                otherPrev.setNext(newest);
                otherPrev = newest;
                walk = walk.getNext();
            }
            
            otherPrev.setNext(other.trailer);
            other.trailer.setPrev(otherPrev);
        }
        
        return other;
    }
    // C-3.26
    public static <E> DoublyLinkedList<E> concat(DoublyLinkedList<E> u,
        DoublyLinkedList<E> v) throws CloneNotSupportedException {

            if ((u == null) || (v == null)) {throw new IllegalArgumentException("List cannot be Null");}

            u = u.clone();
            v = v.clone();
            if (u.isEmpty()) {return v;}
            if (v.isEmpty()) {return u;}

            u.size += v.size;

            u.trailer.getPrev().setNext(v.header.getNext());
            v.header.getNext().setPrev(u.trailer.getPrev());

            u.trailer = v.trailer;

            return u;
    }
}