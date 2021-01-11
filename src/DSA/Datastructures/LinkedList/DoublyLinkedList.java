package DSA.Datastructures.LinkedList;

class DoublyLinkedList{

    private Node head=null;

    private class Node{
        private String data;
        private Node next=null;
        private Node prev=null;
        public Node(String data){
            this.data=data;
        }
    }

    public int getLength(){
        if(head==null){
            return 0;
        }
        else{
            Node curr_node = head;
            int length =0;
            while(curr_node!=null){
                length++;
                curr_node = curr_node.next;
            }
            return length;
        }
    }
    public DoublyLinkedList Insert(String data){
        Node new_node=new Node(data);

        if(head==null){
            head = new_node;
        }

        else{
            new_node.next = head;
            head.prev = new_node;
            head = new_node;
        }

        return this;
    }

    public DoublyLinkedList InsertBefore(Node next_node,String data){

        if (next_node == null) {
            System.out.println("The given previous node cannot be NULL ");
            return this;
        }

        Node new_node = new Node(data);
        new_node.next = next_node;
        new_node.prev = next_node.prev;
        next_node.prev = new_node;
        if(new_node.prev != null) {
            new_node.prev.next = new_node;
        }

        return this;
    }

    public Node find_kth_node(int k) {
        Node curr_node = head;
        if (getLength() < k) {
            throw new IndexOutOfBoundsException("List is smaller than" + k);
        }
        curr_node = head;
        for (int i = 1; i < k; i++) {
            curr_node = curr_node.next;
        }
        return curr_node;
    }

    /**
     * Remove any node by its position
     * @param k
     * @return
     */

    public DoublyLinkedList Remove(int k){

        int size=getLength();

        if(head==null || k<=0){
            return this;
        }

        if(k==1){
            if(head.next!=null){
                head.next.prev = null;
                head = head.next;;
            }
            else{
                head = null;
            }
            return this;
        }
        else if(k>1 && k<=size){
            Node node = find_kth_node(k);
            if(node.next!=null){
                node.next.prev = node.prev;
                node.prev.next = node.next;
            }
            else{
                node.prev.next = null;
            }
        }
        return this;
    }

    /**
     * Insert your Node in position k
     * @param k
     * @param data
     * @return
     */
    public DoublyLinkedList InsertAfter(int k,String data){
        Node prev_node = find_kth_node(k);
        if(prev_node==null) {
            return this;
        }
        Node new_node = new Node(data);
        new_node.next = prev_node.next;
        new_node.prev = prev_node;
        prev_node.next = new_node;
        if(new_node.next != null){
            new_node.next.prev = new_node;
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

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.Insert("dwdad");
        dll.Insert("eqeq");
        dll.Insert("23121");
        //System.out.println(dll);


        dll.InsertAfter(2,"amin");
        System.out.println(dll);

        dll.Remove(1);
        System.out.println(dll);
        dll.Remove(2);
        System.out.println(dll);

    }


}



