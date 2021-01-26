package DSA.Datastructures;

public class Queue {

    int size;
    private int front = 0;
    private int rear = -1;
    private int[] Qarr;

    public Queue(int n) {
        this.size = n;
        this.Qarr = new int[this.size];
    }

    public boolean isEmpty() {
        return (rear < front);
    }

    public boolean isFull() {

        return (rear + 1 >= size);
    }

    public void add(int s) {
        if (!isFull()) {
            Qarr[++rear] = s;
        }
    }

    public int poll() {
        if (!isEmpty()) {
            front++;
            return Qarr[front - 1];
        } else {
            return -1;
        }
    }

    public String toString() {
        String output = "";
        for (int i = this.front; i <= this.rear; i++) {
            output += Qarr[i] + " ";
        }
        return output;
    }

    public static void main(String[] args) throws ArrayIndexOutOfBoundsException {
       Queue q1 = new Queue(4);

        //q1.add("reza");

        System.out.println(q1);
        //System.out.println(q1.isFull());
    }
}
