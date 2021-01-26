package DSA.Datastructures.Graph;

import DSA.Datastructures.LinkedList.Stack;

//this class Implemented with adjancecy Matrix
public class Graph_matrix implements Graph {
    int number_of_vertices;
    boolean is_weighted;
    boolean is_directed;
    boolean[][] simple_matrix;
    int[][] weights;
    boolean[]visited;

    public Graph_matrix(int n) {
        is_weighted = false;
        is_directed = false;
        number_of_vertices = n;
        simple_matrix = new boolean[number_of_vertices][number_of_vertices];
        weights = new int[number_of_vertices][number_of_vertices];

    }

    public Graph_matrix(int n, boolean is_weighted, boolean is_directed) {
        this.is_weighted = is_weighted;
        this.is_directed = is_directed;
        number_of_vertices = n;
        simple_matrix = new boolean[number_of_vertices][number_of_vertices];
        weights = new int[number_of_vertices][number_of_vertices];
    }

    public void addEdge(int source, int destination) {

        simple_matrix[source][destination] = true;
        weights[source][destination] = 0;

        if (!is_directed) {
            simple_matrix[destination][source] = true;
            weights[destination][source] = 0;

        } else {
            simple_matrix[destination][source] = false;
        }
    }

    public void addEdge(int source, int destination, int weight) {
        if (!is_weighted) {
            return;
        }
        simple_matrix[source][destination] = true;
        weights[source][destination] = weight;
        if (!is_directed) {
            simple_matrix[destination][source] = true;
            weights[destination][source] = weight;
        } else {
            simple_matrix[destination][source] = false;
            weights[destination][source] = 0;
        }

    }

    public void removeEdge(int source, int destination) {
        if (simple_matrix[source][destination]) {

            simple_matrix[source][destination] = false;

            if (is_weighted) {
                weights[source][destination] = 0;
            }

            if (!is_directed) {
                simple_matrix[destination][source] = false;
                weights[source][destination] = 0;
            }
        }
    }

    public boolean hasEdge(int source, int destination) {
        return (simple_matrix[source][destination]);
    }

    public int getWeight(int source, int destination) {
        if (!is_weighted) {
            return 0;
        }
        return weights[source][destination];
    }

    public void DFS(int vertex){
        Stack s = new Stack(number_of_vertices);
        visited = new boolean[number_of_vertices];
        int v;
        for(int i=0;i<number_of_vertices;i++){
            visited[i]=false;
        }
        //System.out.println()
        s.push(vertex);
        while(!s.isEmpty()){
             v= s.pop();
             if(!visited[v]){
                 System.out.print(v+" ");
                 visited[v]=true;
             }
             for(int i=0;i<number_of_vertices;i++){
                 boolean adj_v=simple_matrix[v][i];
                 if(adj_v&&!visited[i]){
                     s.push(i);
                 }
             }

        }
    }
    public String toString() {
        String output = "";
        for (int i = 0; i < number_of_vertices; i++) {
            for (int j = 0; j < number_of_vertices; j++) {
                if (simple_matrix[i][j]) {
                    output += String.format("\nFrom %d To %d\n", i, j);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Graph_matrix g1 = new Graph_matrix(3,false,true);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        System.out.println(g1);
        System.out.println("================");
        g1.DFS(0);
        System.out.println(g1);
    }

}
