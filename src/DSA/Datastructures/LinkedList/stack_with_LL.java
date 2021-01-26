package DSA.Datastructures.LinkedList;

public class stack_with_LL{

    LinkedList s_ll = new LinkedList();


    public void push(int data) {

        s_ll.add(data);
    }

    public int pop() {

        int data = 0;
        if (s_ll.getHead() != null) {
            data = s_ll.getHead().getData();
            s_ll.Remove(0);
        }


        return data;
    }

    public boolean isEmpty() {
        return (s_ll.getHead() == null);
    }

    public boolean isFull() {
        return false;
    }

    public String toString() {
        return s_ll.toString();
    }

    public static void main(String[] args) {
        stack_with_LL sll = new stack_with_LL();
        sll.push(4);
        sll.push(10);
        sll.push(15);
        System.out.println(sll);
    }
}
