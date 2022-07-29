package DataStructures.PriorityQueue;

import java.util.*;

public class PriorityQueue<T extends Comparator>{

    private int heapSize;

    private int heapCapacity;

    List<T> heap = null;

    Map<T,TreeSet<Integer>> map = new HashMap<>();

    public PriorityQueue (){
        this(1);
    }

    public PriorityQueue(int initialCapacity) {
        heap = new ArrayList<>(initialCapacity);
        this.heapCapacity = initialCapacity;
    }

    public PriorityQueue(T[] elements){
        heapCapacity = heapSize = elements.length;

        for (int i = 0; i < heapSize; i++) {
            heap.add(elements[i]);
//            mapAdd(elements[i],i );
        }

        for (int i = Math.max(0, (heapSize/2)-1); i >=0 ; i--) {
//            sink(i);
        }
    }

    public PriorityQueue(Collection<T> elements){
        this(elements.size());
        for (T elem: elements) {
//            add(elements);
        }
    }

    public boolean isEmpty(){
        return heapSize==0;
    }

    public void clear(){
        for (int i = 0; i < heapCapacity; i++) {
            heap.set(i,null);
            heapSize=0;
            map.clear();
        }
        heapCapacity=0;
    }
}
