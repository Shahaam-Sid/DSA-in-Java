/*
 => Array based Stack is Inefficient
    As it alots memory proir, which may not be used
    It also limits user to memory reserved
*/

public class ArrayStack<E> implements Stack<E>, Cloneable {
    public static final int CAPACITY = 1000;
    private E[] data;
    private int t = -1;

    public ArrayStack() {this(CAPACITY);}
    public ArrayStack(int capacity) {
        data = (E[]) new Object[capacity];
    }
    @Override
    public int size() {return t + 1;}
    @Override
    public boolean isEmpty() {return (t == -1);}
    @Override
    public void push(E e) throws IllegalStateException {
        if (size() == data.length) {throw new IllegalStateException("Stack is full");}

        data[++t] = e;
    }
    @Override
    public E top() {
        if (isEmpty()) return null;

        return data[t];
    }
    @Override
    public E pop() {
        if (isEmpty()) return null;

        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }
    // C-6.27
    @Override
    public ArrayStack<E> clone() throws CloneNotSupportedException {
        ArrayStack<E> newStack = (ArrayStack<E>) super.clone();
        
        newStack.data = data.clone();
        
        return newStack;
    }
}