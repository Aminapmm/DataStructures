package DSA.Datastructures.Graph;

import DSA.Datastructures.LinkedList.*;
import DSA.Datastructures.Queue;

public class graph_L implements Graph {
    int number_of_vertices;
    LinkedList ll;
    LinkedList[] graph;
    boolean isDirected=false;
    boolean [] visited;


    public graph_L(int n) {
        number_of_vertices = n;
        visited = new boolean[number_of_vertices];
        graph = new LinkedList[number_of_vertices];
        for (int i = 0; i < number_of_vertices; i++) {
            graph[i] = new LinkedList();
            visited[i]=false;
        }
    }

    public graph_L(int n,boolean isDirected){
        this(n);
        this.isDirected=isDirected;
    }

    public void addEdge(int source, int destination) {

        if (source >= number_of_vertices || destination >= number_of_vertices) {
            return;
        }
        graph[source].add(destination);
        if(!isDirected) {
            graph[destination].add(source);
        }
    }

    public void removeEdge(int source, int destination) {
        if (source >= number_of_vertices || destination >= number_of_vertices) {
            return;
        }
        graph[source].Delete(destination);
        //System.out.println(graph[source]);
        if(!isDirected) {
            graph[destination].Delete(source);
        }
    }

    public boolean hasEdge(int source, int destination) {
        if (source >= number_of_vertices || destination >= number_of_vertices) {
            return false;
        }
        return graph[source].Contains(destination);
    }

    public void DFS(int vertex){
        visited[vertex]=true;
        System.out.print(vertex+" ");
        LinkedList.Node curr_node =graph[vertex].getHead();
        for(int i=0;i<graph[vertex].getSize();i++){
            if(!visited[curr_node.getData()]){
                DFS(curr_node.getData());
            }
            curr_node = curr_node.getNext();
         }
    }

    public void dfs_drive(){
        for(int i=0;i<number_of_vertices;i++){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    /***
     * Breadth First Search Algorithm
     * Start by putting any one of the graph's vertices at the back of a queue.
     * Take the front item of the queue and add it to the visited list.
     * Create a list of that vertex's adjacent nodes. Add the ones which aren't in the visited list to the back of the queue.
     * Keep repeating steps 2 and 3 until the queue is empty.
     * @param vertex
     */
    public void BFS(int vertex){
        Queue q = new Queue(number_of_vertices);
        visited[vertex]=true;
        q.add(vertex);
        while(!q.isEmpty()){
             vertex =q.poll();
            int size = graph[vertex].getSize();
            System.out.print(vertex+" ");
            LinkedList.Node currentNode = graph[vertex].getHead();
            //System.out.println(graph[vertex].getSize());
            for(int i=0;i<size;i++){
                //System.out.println("Round:"+i);
                vertex = currentNode.getData();
                if(!visited[vertex]){
                    visited[vertex]=true;
                    q.add(vertex);
                }
                currentNode = currentNode.getNext();

            }
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < number_of_vertices; i++) {
            output += String.format("%d is Connected to these %s\n", i, graph[i].toString());
        }
        return output;

    }

    public static void main(String[] args) {
        graph_L g = new graph_L(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,4);
        g.addEdge(4,5);
        g.addEdge(2,5);
        g.addEdge(3,5);

        System.out.println(g);
        System.out.println("=======");
       // System.out.println(g2.hasEdge(0, 2));
        System.out.println("=======");
       // g2.removeEdge(0, 2);
        // g2.removeEdge(1,0);
        //System.out.println(g);
        g.BFS(0);
    }

}
