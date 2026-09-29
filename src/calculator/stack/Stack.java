package calculator.stack;

import java.util.EmptyStackException;

public class Stack<T> {
    private Object[] stack;
    private int top;

    public Stack() {
        this.top = -1;
        this.stack = new Object[10];
    }

    public Stack (int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("A capacidade deve ser maior que zero: " + capacity);
        }
        this.top = -1;
        this.stack = new Object[capacity];
    }

    public void push (T item){
        if(this.top == this.stack.length - 1) this.stack = expandStack(this.stack);
        this.stack[++this.top] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if(this.top == -1) throw new EmptyStackException();
        T item = (T) this.stack[this.top];
        this.stack[this.top--] = null;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if(this.top == -1) throw new EmptyStackException();
        return (T) this.stack[this.top];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    private Object[] expandStack(Object[] currentStack){
        int newCapacity = currentStack.length > 1 ? (int) (currentStack.length * 1.5) : 2;
        Object[] newStack = new Object[newCapacity];
        System.arraycopy(currentStack, 0, newStack, 0, currentStack.length);
        return newStack;
    }
}
