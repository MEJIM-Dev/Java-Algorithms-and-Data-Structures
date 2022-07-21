package DataStructures.LinkedList;

public class Node <T> {
    private T value;
    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
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
        if(this.getNext()!=null) return true;
        return false;
    }
}
