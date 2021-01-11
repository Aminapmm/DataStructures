package DSA.Datastructures.LinkedList;

interface Stack{
    public void push(String data);
    public String pop();
    public boolean isEmpty();
    public boolean isFull();
}


  class Stack_with_array implements Stack {

    int size;
    private int top=-1;
    private String [] stackarr;

    public Stack_with_array(int n){
        this.size = n;
        this.stackarr = new String[this.size];
    }

    public void push(String data){

        if(!isFull()) {
            this.stackarr[++top] = data;
        }
    }

    public String pop() {
        if (!isEmpty()) {
            return stackarr[this.top--];
        }
        else {
            return "Datastrucures.Datastrucures.LinkedList.StackQueue.Stack is Empty.";
        }
    }

    public boolean isEmpty(){
        return (top==-1);
    }

    public boolean isFull(){
        return (top>=size);
    }

    public String toString(){

        String output = "";
        for(int i=top;i>=0;i--){
            output+=stackarr[i]+"\n";
        }

        return output;
        }


    public static void main(String[] args) {
        
    }
}

class stack_with_LL implements Stack{

    SinglyLinkedList s_ll = new SinglyLinkedList();


    @Override
    public void push(String data) {

        s_ll.add(data);
    }

    @Override
    public String pop() {

        String data = "";
        if(s_ll.getHead()!=null){
             data = s_ll.getHead().getData();
            s_ll.Remove(0);
        }


        return data;
    }

    @Override
    public boolean isEmpty() {
        return (s_ll.getHead()==null);
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String toString() {
        return s_ll.toString();
    }

    public static void main(String[] args) {
        stack_with_LL sll = new stack_with_LL();
        sll.push("amin");
        sll.push("ali");
        sll.push("diamond");
        System.out.println(sll);
    }
}
