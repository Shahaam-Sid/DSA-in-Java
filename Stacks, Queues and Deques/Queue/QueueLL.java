public class QueueLL<E> implements Queue<E> {
    private SInglyLinkedList<E> list = new SInglyLinkedList<>();
    public QueueLL() {}
    @Override
    public int size() {return list.getSize();}
    @Override
    public boolean isEmpty() {return list.isEmpty();}
    @Override
    public void enqueue(E e) {list.addLast(e);}
    @Override
    public E first() {return list.first();}
    @Override
    public E dequeue() {return list.removeFirst();}

    // C-6.29
    public void concat(QueueLL<E> Q2) {
        if (Q2.isEmpty()) {}

        int sz = Q2.size();
        for (int i = 0; i < sz; i++) {
            enqueue(Q2.dequeue());
        }
    }
}
