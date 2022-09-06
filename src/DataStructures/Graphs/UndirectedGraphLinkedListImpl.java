package DataStructures.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UndirectedGraphLinkedListImpl {

    private int vertices;
    private int edges;
    private LinkedList<Integer>[] list;

    public UndirectedGraphLinkedListImpl(int nodes){
        vertices=nodes;
        edges=0;
        list = new LinkedList[nodes];
        for (int i = 0; i < nodes; i++) {
            list[i]=new LinkedList<Integer>();
        }
    }

    public void addEdge(int u,int v){
            list[u].add(v);
            list[v].add(u);
            edges++;
    }

    public String toString(){
        String s = vertices+" vertices, "+ edges+" edges \n";
        for (int i = 0; i < vertices; i++) {
            s+= list[i]+"\n";
        }
        return s;
    }

    public void bfs(int start){
        boolean[] visited = new boolean[vertices];
        visited[start]=true;
        Queue queue = new LinkedList();
        queue.offer(start);

        while (!queue.isEmpty()){
            int u = (int) queue.poll();
            System.out.println(u+ " ");
            for (int i = 0; i < list[u].size(); i++) {
                int v = list[u].get(i);
                if(!visited[v]){
                    visited[v]=true;
                    queue.offer(v);
                }
            }
        }
    }

    public void dfs (int start){
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.empty()){
            int curr = stack.pop();

            if(!visited[curr]) {
                visited[curr]=true;
                System.out.println(curr);

                for (int i = 0; i < list[curr].size(); i++) {
                    int currNode = list[curr].get(i);
                    if (!visited[currNode]) {
                        stack.push(currNode);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        UndirectedGraphLinkedListImpl graphLinkedList = new UndirectedGraphLinkedListImpl(5);
        graphLinkedList.addEdge(0,1);
        graphLinkedList.addEdge(1,2);
        graphLinkedList.addEdge(2,3);
        graphLinkedList.addEdge(3,0);
        graphLinkedList.addEdge(2,4);
        System.out.println(graphLinkedList);
        graphLinkedList.dfs(0);
    }

}
