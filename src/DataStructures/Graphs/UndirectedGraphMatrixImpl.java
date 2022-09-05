package DataStructures.Graphs;

public class UndirectedGraphMatrixImpl {

    private int vertices;
    private int edges;
    private int[][] matrix;

    public UndirectedGraphMatrixImpl(int nodes){
        vertices=nodes;
        edges=0;
        matrix= new int[nodes][nodes];
    }

    public void setEdges(int u, int v){
        matrix[u][v]=1;
        matrix[v][u]=1;
        edges++;
    }

    public String toString(){
        String s=vertices+" vertices, "+edges+" edges \n";
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                s+=matrix[i][j]+" ";
            }
            s+="\n";
        }
        return s;
    }

    public static void main(String[] args) {
        UndirectedGraphMatrixImpl graphMatrix =new UndirectedGraphMatrixImpl(4);
        graphMatrix.setEdges(0, 1);
        graphMatrix.setEdges(1, 2);
        graphMatrix.setEdges(2, 3);
        graphMatrix.setEdges(3, 0);
        System.out.println(graphMatrix);
    }

}
