package DataStructures.Stacks;

import java.util.*;
import java.util.function.Consumer;

public class Stacks <T> implements Iterable<T> {

    public Stacks(){
    }

    public Stacks(T firstElement){
        this.list.addLast(firstElement);
    }

    private LinkedList<T> list = new LinkedList<>();

    public int size(){
        return list.size();
    }

    public boolean isEmpty(){
        return list.size()==0;
    }

    public void push(T element){
        list.addLast(element);
    }

    public T pop(){
        if(this.isEmpty()) throw new IllegalCallerException("element contains no items");
        return list.removeLast();
    }

    public T peek(){
        if(isEmpty()) throw new EmptyStackException();
        return list.peekLast();
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return Iterable.super.spliterator();
    }
}
