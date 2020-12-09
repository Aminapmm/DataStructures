package Datastrucures;

interface Queue{
    public boolean isEmpty();
    public boolean isFull();
    public void add(String s);
    public String remove();
}

 class LinearQueue implements Queue {

     int size;
     private int front = 0;
     private int rear = -1;
     private String[] Qarr;

     public LinearQueue(int n) {
         this.size = n;
         this.Qarr = new String[this.size];
     }

     public boolean isEmpty() {
         return (rear < front);
     }

     public boolean isFull() {

         return (rear + 1 >= size);
     }

     public void add(String s) {
         if (!isFull()) {
             Qarr[++rear] = s;
         } else {
             throw new ArrayIndexOutOfBoundsException("Datastrucures.Datastrucures.LinkedList.StackQueue.Queue is Full");
         }
     }

     public String remove() {
         if (!isEmpty()) {
             front++;
             return Qarr[front - 1];
         } else {
             System.out.print("Datastrucures.Datastrucures.LinkedList.StackQueue.Queue is Empty.");
             return null;
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
         LinearQueue q1 = new LinearQueue(4);
         q1.add("amin");
         q1.add("ali");
         //q1.remove();
         q1.add("mehdi");
         q1.add("sajad");
         //q1.add("reza");

         System.out.println(q1);
         //System.out.println(q1.isFull());
     }
 }

    class CircleQueue implements Queue{

        int size = 0;
        private int rear;
        private int front;
        private String [] Q_array;

        public CircleQueue(int n){
            size=n;
            Q_array = new String[size];
        }

        @Override
        public boolean isEmpty() {
            return rear + 1 == front || rear == -1 && front == 0;
        }

        @Override
        public boolean isFull() {
            return (rear+2==front);
        }

        @Override
        public void add(String s) {
            if(!isFull()){
                rear = (rear+1)%size;
                Q_array[rear]=s;
            }

            else {
                throw new ArrayIndexOutOfBoundsException("Datastrucures.Datastrucures.LinkedList.StackQueue.Queue is Full");
            }
        }

        @Override
        public String remove() {
            String str;

            if(!isEmpty()){
                str = Q_array[front];
                front = (front+1)%size;
            }
            else{
                str = "Datastrucures.Datastrucures.LinkedList.StackQueue.Queue is Empty.";
            }
            return str;

        }
    }

