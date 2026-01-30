public class QueueCLL<E> implements QueueCLLIF<E>{
    private CircularLinkedList<E> list = new CircularLinkedList<>();
    public QueueCLL() {}
    @Override
    public  int size() {return list.getSize();}
    @Override
    public boolean isEmpty() {return list.isEmpty();}
    @Override
    public void enqueue(E e) {list.addLast(e);}
    @Override
    public E first() {return list.first();}
    @Override
    public E dequeue() {return list.removeFirst();}
    @Override
    public void rotate() {list.rotate();}
}
