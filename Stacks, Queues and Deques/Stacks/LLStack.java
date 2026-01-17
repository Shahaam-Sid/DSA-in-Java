public class LLStack<E> implements Stack<E>{
    private SInglyLinkedList<E> list = new SInglyLinkedList<>();
    
    public LLStack() {}

    @Override
    public int size() {return list.getSize();}
    @Override
    public boolean isEmpty() {return list.isEmpty();}
    @Override
    public void push(E element) {list.addFirst(element);}
    @Override
    public E top() {return list.first();}
    @Override
    public E pop() {return list.removeFirst();}

}
