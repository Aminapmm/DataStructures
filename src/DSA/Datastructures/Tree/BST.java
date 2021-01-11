package DSA.Datastructures.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BST {

    Node root;

    public Node findMin(Node root){

        if(root==null){
            return null;
        }
        Node current=root;

        while(current.left!=null){
            current = current.left;
        }
        return current;
    }

    public Node findMax(Node root){
        if(root==null){
            return null;
        }
        if(root.right==null){
            return root;
        }
        return findMax(root.right);
    }
    public boolean contains(Node root,int key){
        if(root==null){
            return false;
        }

        if(key>root.data){
            contains(root.right,key);
        }

        else if(key<root.data){
            contains(root.left,key);
        }
        return true;
    }
    public void insert(int key){
        root =  rec_insert(this.root,key);
    }
    public Node rec_insert(Node root,int key){

        if(root==null){
            root = new Node(key);
            return root;
        }

        if(key>root.data){
            root.right = rec_insert(root.right,key);
        }

        else if(key<root.data){
            root.left = rec_insert(root.left,key);
        }

        return root;
    }
    public Node delete(Node root,int key){
        if(root==null){
            return root;
        }

        if(key>root.data){
            delete(root.right,key);
        }

        else if(key<root.data){
            delete(root.left,key);
        }

        else if(root.left!=null && root.right!=null){
            root.data = findMin(root.right).data;
            root.right = delete(root.right,root.data);
        }

        else {
            root = (root.left != null ? root.left : root.right);
            return root;
        }

        return root;
    }

    public Node find_deepest_leaf(Node root){
        Queue<Node> q = new LinkedList<Node>();

        if(root==null){
            return root;
        }

        q.add(root);
        Node temp;
        while(!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.right != null) {
                q.add(temp.right);
            }

            if (temp.left != null) {
                q.add(temp.left);
            } else if (temp.left == null && temp.right == null) {
                temp = null;
                return root;
            }
        }
        return root;
    }

    public Node remove(Node root){
        int deep = find_deepest_leaf(root).data;
        return delete(root,deep);
    }

    public void inorder(){
        rec_inOrder(this.root);
    }

    public void rec_inOrder(Node root){

        if(root==null){
            return;
        }

        if(root.left!=null) {
            rec_inOrder(root.left);
        }
        System.out.print(root.data+" ");

        if(root.right!=null){
            rec_inOrder(root.right);
        }
    }


    public static void main(String[] args) {

        BST bstree = new BST();

        bstree.insert(1);
        bstree.insert(2);
        bstree.insert(4);
        bstree.insert(7);
        bstree.insert(8);
        bstree.inorder();
        bstree.inorder();


    }
}
