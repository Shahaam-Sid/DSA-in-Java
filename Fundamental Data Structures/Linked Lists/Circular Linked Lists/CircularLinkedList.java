public class CircularLinkedList<E> {
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


    private Node<E> tail = null;
    private int size = 0;

    public CircularLinkedList() {}

    public int getSize() {return size;}
    public boolean isEmpty() {return size == 0;}
    public E first() {
        if (isEmpty()) {return  null;}

        return tail.getNext().getElement();
    }
    public E last() {
        if (isEmpty()) {return null;}

        return tail.getElement();
    }
    public void rotate() {
        if (tail != null) {tail = tail.getNext();}
    }
    public void addFirst(E e) {
        if (size == 0) {
            tail = new Node<>(e, null);
            tail.setNext(tail);
        } else {
            Node<E> newest = new Node<>(e, tail.getNext());
            tail.setNext(newest);
        }
        size++;
    }
    public void addLast(E e) {
        addFirst(e);
        tail = tail.getNext();
    }
    public E removeFirst() {
        if(isEmpty()) {return null;}
        Node<E> head = tail.getNext();
        
        if (head == tail) {tail = null;}
        else {tail.setNext(head.getNext());}

        size--;
        return head.getElement();
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {return false;}
        if (getClass() != o.getClass()) {return false;}
        CircularLinkedList<E> other = (CircularLinkedList<E>) o;
        if (size != other.size) {return false;}
        if (size == 0) {return true;}

        Node<E> circleA = tail.getNext();

        for (int i = 0; i < size; i++) {
            Node<E> circleB = other.tail.getNext();
            Node<E> tempA = circleA;
            boolean allMatch = true;

            for (int j = 0; j < size; j++) {
                if (!tempA.getElement().equals(circleB.getElement())) {
                    allMatch = false;
                    break;
                }
                tempA = tempA.getNext();
                circleB = circleB.getNext();
            }
            if (allMatch) return true;
            circleA = circleA.getNext();
        }
        return false;
    }
    @Override
    public CircularLinkedList<E> clone() throws CloneNotSupportedException {
        CircularLinkedList<E> other = (CircularLinkedList<E>) super.clone();
        if (size > 0) {
            other.tail = new Node<>(tail.getElement(), null);
            Node<E> walk = tail.getNext();
            Node<E> temp = other.tail;
            while (walk != temp) {
                Node<E> newest = new Node<>(walk.getElement(), null);
                //Incomplete
            }
        }
    }
}