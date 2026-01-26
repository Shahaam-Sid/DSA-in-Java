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
}
