package datastructs;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStack<T> {
    LinkedList<T> stack  = new LinkedList<>();

    MyStack(T elem){
        push(elem);
    }

    public int size(){
        return stack.size();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void push(T elem){
        stack.add(elem);
    }

    public T pop(){
        if(isEmpty()) throw new EmptyStackException();
        return stack.removeLast();
    }
}
