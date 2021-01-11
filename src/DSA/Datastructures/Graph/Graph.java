package DSA.Datastructures.Graph;
import DSA.Datastructures.LinkedList.SinglyLinkedList;

public interface Graph {
    public void addEdge();
    public void hasEdge();
    public void removeEdge();
}

//this class Implemented with adjancecy Matrix
class graph{
    int number_of_vertices;
    boolean is_weighted;
    boolean is_directed;
    boolean [][] simple_matrix;
    int [][] weights;

    public graph(int n){
        is_weighted=false;
        is_directed=false;
        number_of_vertices = n;
        simple_matrix = new boolean[number_of_vertices][number_of_vertices];
        weights = new int[number_of_vertices][number_of_vertices];

    }

    public graph(int n,boolean is_weighted,boolean is_directed){
        this.is_weighted=is_weighted;
        this.is_directed=is_directed;
        number_of_vertices = n;
        simple_matrix = new boolean[number_of_vertices][number_of_vertices];
        weights = new int[number_of_vertices][number_of_vertices];
    }

    public void addEdge(int source,int destination){

        simple_matrix[source][destination]=true;
        weights[source][destination] = 0;

        if(!is_directed){
            simple_matrix[destination][source]=true;
            weights[destination][source] = 0;

        }
        else{
            simple_matrix[destination][source]=false;
        }
    }

    public void addEdge(int source,int destination,int weight){
        if(!is_weighted){
            return;
        }
        simple_matrix[source][destination]=true;
        weights[source][destination]=weight;
        if(!is_directed){
            simple_matrix[destination][source]=true;
            weights[destination][source]=weight;
        }
        else{
            simple_matrix[destination][source]=false;
            weights[destination][source]=0;
        }

    }

    public void removeEdge(int source,int destination){
        if(simple_matrix[source][destination]) {

            simple_matrix[source][destination] = false;

            if(is_weighted){
                weights[source][destination]=0;
            }

            if (!is_directed) {
                simple_matrix[destination][source] = false;
                weights[source][destination]=0;
            }
        }
    }

    public boolean hasEdge(int source,int destination){
        return(simple_matrix[source][destination]);
    }

    public int getWeight(int source,int destination){
        if(!is_weighted){
            return 0;
        }
        return weights[source][destination];
    }

    public String toString(){
        String output="";
        for(int i=0;i<number_of_vertices;i++){
            for(int j=0;j<number_of_vertices;j++){
                if(simple_matrix[i][j]) {
                    output += String.format("From %d To %d\n",i,j);
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        graph g1 = new graph(3);
        g1.addEdge(0,1);
        g1.addEdge(0,2);
        g1.addEdge(1,2);
        System.out.println(g1);
        System.out.println("================");
        g1.removeEdge(0,2);
        System.out.println(g1);
    }

}

class graph_L{
    int number_of_vertices;
    SinglyLinkedList ll;
    SinglyLinkedList [] graph;


    public graph_L(int n){
        number_of_vertices=n;
        graph = new SinglyLinkedList[number_of_vertices];
        for(int i=0;i<number_of_vertices;i++){
            graph[i]=new SinglyLinkedList();
        }

    }
    
    public void addEdge(int source,int destination){
        if(source>=number_of_vertices||destination>=number_of_vertices){
            return;
        }
        graph[source].add(Integer.toString(destination));
        graph[destination].add(Integer.toString(source));
    }

    public void removeEdge(int source,int destination){
        if(source>=number_of_vertices||destination>=number_of_vertices){
            return;
        }
        graph[source].Delete(Integer.toString(destination));
        graph[destination].Delete(Integer.toString(source));
    }

    public boolean hasEdge(int source,int destination){
        if(source>=number_of_vertices||destination>=number_of_vertices){
            return false;
        }
        return graph[source].Contains(Integer.toString(destination));
    }

    public String toString(){
        String output="";
        for(int i=0;i<number_of_vertices;i++){
            output+=String.format("%d is Connected to these %s\n",i,graph[i].toString());
        }
        return output;

    }

    public static void main(String[] args) {
        graph_L g2 = new graph_L(4);
        g2.addEdge(0,1);
        g2.addEdge(3,2);
        g2.addEdge(1,3);
        g2.addEdge(0,2);
        g2.addEdge(0,3);
        System.out.println(g2);
        System.out.println("=======");
        System.out.println(g2.hasEdge(1,2));
        System.out.println("=======");
        g2.removeEdge(0,2);
       // g2.removeEdge(1,0);
        System.out.println(g2);
    }

}
