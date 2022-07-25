package DataStructures.Queues;

public class QueuesImpl {
    public static void main(String[] args) {
        Queues<Integer> queues = new Queues<Integer>(9);
//        System.out.println(queues.size());
//        System.out.println(queues.dequeue());
//        System.out.println(queues.peek());
        queues.queue(34);
        queues.queue(2);
        queues.queue(34);
        queues.queue(2);
        System.out.println(queues.dequeue());
        System.out.println(queues.peek());
        System.out.println(queues);
    }
}
