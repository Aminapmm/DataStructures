package Datastrucures.Tree;
import java.util.*;

class Node{
    int data;
    Node left,right;

    public Node(int data){
        this.data = data;
        left=right=null;
    }

    public String toString() {
        return Integer.toString(data);
    }
}

/***
 * Pre_Order Traverse(
 * 1- print the current node
 * 2- push it to stack
 * 3- point to the left node of current node(do step 1,2)
 * 4- if it's null , pop from stack and point to right child of current node
 * 5- ...
 */
public class BinaryTree {

    Node root;

    public void Insert(Node temp,int data){
        Queue<Node> q = new LinkedList<Node>();

        if(temp==null){
            temp = new Node(data);
            return;
        }

        q.add(temp);

        while(!q.isEmpty()){
            temp = q.poll();

            if(temp.left==null){
                temp.left = new Node(data);
                break;
            }

            else{
                q.add(temp.left);
            }

            if(temp.right==null){
                temp.right = new Node(data);
                break;
            }

            else{
                q.add(temp.right);
            }

        }
    }

    static void deleteDeepest(Node root,int key)
    {
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        Node temp = null;

        // Do level order traversal until last node
        while (!q.isEmpty())
        {
            temp = q.peek();
            q.remove();

            if (temp.data == key)
            {
                temp = null;
                return;

            }
            if (temp.right!=null)
            {
                if (temp.right.data == key)
                {
                    temp.right = null;
                    return;
                }
                else
                    q.add(temp.right);
            }

            if (temp.left != null)
            {
                if (temp.left.data == key)
                {
                    temp.left = null;
                    return;
                }
                else
                    q.add(temp.left);
            }
        }
    }
    public static int find_deepest(Node root){

        //PriorityQueue<Node> q = new PriorityQueue<Node>();
        Queue<Node> q = new LinkedList<Node>();

        if(root==null){
            return -1;
        }

        q.add(root);
        Node temp = null;

        while(!q.isEmpty()){


            temp = q.poll();


            if(temp.left!=null){
                q.add(temp.left);
            }

            if(temp.right!=null){
                q.add(temp.right);
            }

        }
        return temp.data;


    }



    public void postorder(){
        Stack<Node> stack = new Stack<Node>();
        Stack<Node> reverse_pre_order = new Stack<Node>();
        Node curr=root;

        if(root==null){
            return;
        }
        stack.push(curr);
        while(stack.size()!=0){
            curr = stack.pop();
            reverse_pre_order.push(curr);

            if(curr.left!=null){
                stack.push(curr.left);
            }

            if(curr.right!=null){
                stack.push(curr.right);
            }
        }

        while(reverse_pre_order.size()!=0){
            System.out.print(reverse_pre_order.pop()+" ");
        }


    }

    public void preorder(){
        Stack<Node> stack = new Stack<Node>();
        Node curr=root;

        if(root==null){
            return;
        }

        while(curr!=null || stack.size()!=0){

            while(curr!=null){
                System.out.print(curr+" ");
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }

    }

    public void inorder(){
        Stack<Node> stack = new Stack<Node>();
        Node curr=root;

        if(root==null){
            return;
        }
        while(curr!=null || stack.size()!=0){

            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr+" ");
            curr = curr.right;
        }
        System.out.println("");
    }

    public void rec_inorder(){}

    public static void main(String[] args) {


        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.Insert(tree.root, 8);
        tree.inorder();
    }

}
