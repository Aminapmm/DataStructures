package DSA.Datastructures.LinkedList;


public class LinkedList {

    public class Node{

         int data;
         Node next=null;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public Node getNext(){
            return next;
        }

    }

    private Node head=null;

    public Node getHead() {
        return head;
    }

    public void Insert(int data){
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

    public boolean Contains(int key){
        Node current=head;
        while(current!=null){
            if(current.data==(key)){
                return true;
            }
            current = current.next;
        }
        return false;
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

    public LinkedList reverse(){
        int n = this.getSize();
        Stack stack = new Stack(n);
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

    public boolean equals(LinkedList ll2){
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
    public void add(int data){
        Node new_node = new Node(data);
        if(head==null) {
            head = new_node;
            return;
        }
            Node tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next = new_node;



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

    public LinkedList Delete(int key){

        Node curr_node =head , prev = null;

        if(curr_node!=null&&curr_node.data==(key)){
            head = curr_node.next;
            //System.out.println(key + " found and deleted");
            return this;
        }

        while(curr_node!=null&& !(curr_node.data ==(key))){
            prev = curr_node;
            curr_node = curr_node.next;
        }

        if(curr_node!=null){
            prev.next = curr_node.next;
            //System.out.println(key + " found and deleted");
        }

        if(curr_node==null){
            //System.out.println(key + " not found");
        }
        return this;
    }

    public LinkedList Remove(int position){

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
            //System.out.println(position+ " position element not found");
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
            max = head.data;
            while(curr_node!=null){
                if(curr_node.data>max){
                    max = curr_node.data;
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
            min =head.data;
            while(curr_node!=null){
                if(min>curr_node.data){
                    min = curr_node.data;
                }
                curr_node = curr_node.next;
            }
            return min;
        }
    }

    public LinkedList extend(LinkedList y){
        LinkedList z = new LinkedList();
        int capacity=y.getSize()+this.getSize();
        Node current_this = this.head;
        Node current_y = y.head;
        while(capacity!=0){
            if(current_this.data< current_y.data){
                z.add(current_this.data);
                current_this = current_this.next;
            }
            else{
                z.add(current_y.data);
                current_y = current_y.next;
            }
            capacity--;
        }
        return z;
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        LinkedList y = new LinkedList();

        llist.add(4);
        llist.add(10);
        llist.add(17);
        llist.add(20);
        llist.add(70);

        System.out.println(llist+" Size "+llist.getSize());

        y.add(2);
        y.add(7);
        y.add(12);
        y.add(25);
        y.add(50);

        System.out.println(y);
        LinkedList z = llist.extend(y);

        System.out.println(z);



    }
}
