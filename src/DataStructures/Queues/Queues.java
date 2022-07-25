package DataStructures.Queues;

import java.lang.constant.ConstantDesc;
import java.util.EmptyStackException;

public class Queues <T extends ConstantDesc> {
    private Node head;
    private Node tail;

    private class Node <T> {
        private Node prev;
        private T value;
        private Node next;

        public Node(){
        }

        public Node(T node){
            this.value=node;
        }
        public String toString(){
            return value.toString();
        }
    }

    public Queues(){
        this.head=null;
    }

    public Queues(T element){
        this.head= new Node(element);
    }

    public void queue(T element){
        if(head.next==null) {
             head.next = new Node(element);
            return;
        }
        Node currNode = head;
        while (currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next= new Node(element);
    }

    public String dequeue(){
        String msg = head.value.toString();
        this.head=head.next;
        return msg;
    }

    public T peek (){
        if(head==null) throw new EmptyStackException();
        return (T) this.head.value;
    }

    public String toString(){
        if(this.head==null) return "[]";
        if(head.next==null) return "["+head.value.toString()+"]";
        String currText= head.value.toString();
        Node currNode = head;
        while (currNode.next!=null){
            currText= currText+" , "+currNode.next.value;
            currNode=currNode.next;
        }
        return "["+currText+"]";
    }

    public int size(){
        if(this.head==null) return 0;
        Node currNode=head;
        int counter = 1;
        while (currNode.next!=null){
            currNode=currNode.next;
            counter++;
        }
        return counter;
    }

}
