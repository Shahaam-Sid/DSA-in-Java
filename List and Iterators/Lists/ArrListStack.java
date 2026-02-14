// R-7.2
public class ArrListStack<E> implements Stack<E> {
    
    private DynamicArrayListC<E> list;

    public ArrListStack() {
        list = new DynamicArrayListC<>();
    }
    public ArrListStack(int capacity) {
        list = new DynamicArrayListC<>(capacity);
    }

    @Override
    public int size() {return list.size();}
    @Override
    public boolean isEmpty() {return list.isEmpty();}
    @Override
    public void push(E e) {list.add(0, e);}
    @Override
    public E top() {return list.get(0);}
    @Override
    public E pop() {return list.remove(0);}
}
