public class ScoreBoardLL<E extends GameEntry> {
    private static class Node<E extends GameEntry> {
        private final E entry;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            entry = e;
            next = n;
        }

        public E getEntry() {return entry;}
        public Node<E> getNext() {return next;}
        public void setNext(Node<E> n) {next = n;}
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public ScoreBoardLL() {}

    public int getSize() {return size;}
    public boolean isEmpty() {return size == 0;}
    public E getEntry(int standing) {
        if (standing > size) {
            throw new IllegalArgumentException("Standing does not exist");
        }
        Node<E> currNode = head;
        for (int i = 1; i < standing; i++) {
            currNode = currNode.getNext();
        }
        return currNode.getEntry();
    }
    public void addEntry(E e) {
        if (isEmpty()) { // if List is Empty
            head = new Node<>(e, null);
            tail = head;
            size++;
            return;
        }
        int currScore = e.getScore();

        // size is 10 and new Score is less then tail
        if (size >= 10 && currScore < tail.getEntry().getScore()) {
            return;
        }

        // if tail score repeats
        if (currScore == tail.getEntry().getScore()) {
            if (size < 10) {
                tail.setNext(new Node<>(e, null));
                tail = tail.getNext();
                size++;
                return;
            } else {
                return;
            }
        }

        // if new score greater then head
        if (currScore > head.getEntry().getScore()) {
            head = new Node<>(e, head);
            size++;
            return;
        }
        
        Node<E> currNode = head;
        Node<E> nextTemp = currNode.getNext(); // nextTemp is the node next to currNode

        // for middle and tail add
        for (int i = 1; i < size; i++) {
            if (nextTemp.getEntry().getScore() < currScore){
                break;
            }
            currNode = currNode.getNext();
            nextTemp = nextTemp.getNext();
        }
        Node<E> newest = new Node<>(e, nextTemp);
        currNode.setNext(newest);

        if (currScore < tail.getEntry().getScore()) {tail = newest;}
        size++;
    }
    
    public E removeEntry(int standing) {
        if (standing > size) {
            throw new IllegalArgumentException("Standing does not exist");
        }
        if (isEmpty()) {return null;}
        if (size == 1) {
            size--;
            E e = head.getEntry();
            head = null;
            return e;
        }
        if (standing == 1) {
            E e = head.getEntry();
            head = head.getNext();
            size--;
            return e;
        }
        if (standing == size) {
            Node<E> target = head;
            Node<E> tailTemp = tail;
            for (int i = 1; i < standing - 1; i++) {
                target = target.getNext();
            }
            target.setNext(null);
            tail = target;
            size--;
            return tailTemp.getEntry();
        }
        Node<E> target = head.getNext();
        Node<E> prev = head;
        for (int i = 2; i < standing; i++) {
            target = target.getNext();
            prev = prev.getNext();
        }
        prev.setNext(target.getNext());
        size--;
        return target.getEntry();
    }
}
