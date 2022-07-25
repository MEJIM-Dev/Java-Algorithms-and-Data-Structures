package DataStructures.LinkedList;

public class Node <T> {
    private T value;
    private Node next;
    private Node prev;

    public Node getNext() {
        return next;
    }

    public Node getPrev(){
        return prev;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node element){
        this.prev = element;
    }

    public Node (T value){
        this.value = value;
    }

    public Node () {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean hasNext() {
        return this.getNext()!=null;
    }

    public boolean hasPrev() {
        return this.getPrev()!=null;
    }
}
