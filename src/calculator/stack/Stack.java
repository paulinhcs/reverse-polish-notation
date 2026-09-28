package calculator.stack;

public class Stack<T> {
    private Object[] stack;
    private int top;

    public Stack() {
        this.top = -1;
        this.stack = new Object[10];
    }

    public Stack (int capacity) {
        this.top = -1;
        this.stack = new Object[capacity];
    }

    public void push (T item){
        if(this.top == this.stack.length - 1) this.stack = expandStack(this.stack);
        this.stack[++this.top] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if(this.top == -1) return null;
        T item = (T) this.stack[this.top];
        this.stack[this.top--] = null;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek(){
        if(this.top == -1) return null;
        return (T) this.stack[this.top];
    }

    public boolean isEmpty(){
        return this.top == -1;
    }

    public Object[] expandStack(Object[] currentStack){
        Object[] newStack = new Object[currentStack.length > 1 ? (int) (currentStack.length * 1.5) : 2];
        for(int i = 0; i < newStack.length; i++){
            newStack[i] = currentStack[i];
        }
        return newStack;
    }
}
