package DSA.Datastructures;


class CircleQueue{

        int size = 0;
        private int rear;
        private int front;
        private String [] Q_array;

        public CircleQueue(int n){
            size=n;
            Q_array = new String[size];
        }


        public boolean isEmpty() {
            return rear + 1 == front || rear == -1 && front == 0;
        }

        public boolean isFull() {
            return (rear+2==front);
        }

        public void add(String s) {
            if(!isFull()){
                rear = (rear+1)%size;
                Q_array[rear]=s;
            }

            else {
                throw new ArrayIndexOutOfBoundsException("Datastrucures.Datastrucures.LinkedList.StackQueue.Queue is Full");
            }
        }

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

