package Datastrucures;
import Datastrucures.Stack_with_array;

public class SinglyLinkedList {

    class Node{

         String data;
         Node next=null;

        public Node(String data) {
            this.data = data;
        }

         public String getData() {
             return data;
         }
     }



    private Node head=null;

    public Node getHead() {
        return head;
    }



    public void Insert(String data){
        Node new_node = new Node(data);
        new_node.data = data;
        if(head==null){
          head = new_node;
          head.next = null;
        }
        else {
            new_node.next = head;
            head = new_node;
        }
    }

    public int getSize(){
        Node curr_node = this.head;
        int size=0;
        while(curr_node!=null){
            size++;
            curr_node = curr_node.next;
        }
        return size;
    }




    public SinglyLinkedList reverse(){
        int n = this.getSize();
        Stack_with_array stack = new Stack_with_array(n);
        Node curr_node = this.head;
        while(curr_node!=null){
            stack.push(curr_node.data);
            curr_node = curr_node.next;
        }
        curr_node = this.head;
        for (int i=0;i<n;i++){
            curr_node.data=stack.pop();
            curr_node = curr_node.next;
        }
        return this;
    }

    public boolean equals(SinglyLinkedList ll2){
        boolean equal=true;

        if(this.head==null || ll2.head == null || this.getSize()!=ll2.getSize()){
            equal=false;
        }
        else {
            Node curr_node = this.head;
            Node ll2_temp = ll2.head;
            for(int i=0;i<this.getSize();i++){
                if(curr_node.data!=ll2_temp.data){
                    equal=false;
                }
                else{
                    continue;
                }
            }

        }
        return equal;
    }
    public void add(String data){
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }

    /***
     * Search the key for its first occurrence in the list
     * Now, Any of the 3 conditions can be there:
     * Case 1: The key is found at head
     * In this case, Change the head of the node to the next node of current head.
     * Case 2: The key is found at in the middle or last, except at head
     * In this case, Find previous node of the node to be deleted.
     * Change the next of previous node to the next node of current node.
     * Case 3: The key is not found in the list
     * In this case, No operation needs to be done.
     */

    public SinglyLinkedList Delete(String key){

        Node curr_node =head , prev = null;

        if(curr_node!=null&&curr_node.data==key){
            head = curr_node.next;
            System.out.println(key + " found and deleted");
            return this;
        }

        while(curr_node!=null&&curr_node.data!=key){
            prev = curr_node;
            curr_node = curr_node.next;
        }

        if(curr_node!=null){
            prev.next = curr_node.next;
            System.out.println(key + " found and deleted");
        }

        if(curr_node==null){
            System.out.println(key + " not found");
        }
        return this;
    }

    public SinglyLinkedList Remove(int position){

        Node curr_node=head,prev = null;

        if(position==0&&curr_node!=null){
            head = curr_node.next;
            return this;
        }

        int counter=0;

        while(curr_node!=null){
            if(counter==position){
                prev.next = curr_node.next;
                break;
            }

            else{
                prev = curr_node;
                curr_node = curr_node.next;
                counter++;
            }
        }

        if(curr_node==null){
            System.out.println(position+ " position element not found");
        }
        return this;
    }

    public String toString(){
        String output="";
        Node curr_node = head;
        while(curr_node!=null){
            output += String.format("| %s | --> ",curr_node.data);
            curr_node = curr_node.next;
        }
        return output;
    }



    public int Max(){
        int max;

        if(head==null){
            return 0;
        }
        else{
            Node curr_node = head;
            max = Integer.parseInt(head.data);
            while(curr_node!=null){
                if(Integer.parseInt(curr_node.data)>max){
                    max = Integer.parseInt(curr_node.data);
                }
                curr_node = curr_node.next;
            }
        }
    return max;
    }

    public int Min(){
        int min=0;
        if(head==null){
            return 0;
        }
        else{
            Node curr_node=head;
            min =Integer.parseInt(head.data);
            while(curr_node!=null){
                if(min>Integer.parseInt(curr_node.data)){
                    min = Integer.parseInt(curr_node.data);
                }
                curr_node = curr_node.next;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList llist = new SinglyLinkedList();
        llist.Insert("4");
        llist.Insert("5");
        llist.Insert("-5");
        llist.Insert("15");



        SinglyLinkedList llist2 = new SinglyLinkedList();
        llist2.Insert("4");
        llist2.Insert("5");
        llist2.Insert("-5");
        llist2.Insert("15");

        System.out.println(llist.equals(llist2));


    }
}
