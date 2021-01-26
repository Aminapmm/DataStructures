package DSA.Project;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.*;
import DSA.Datastructures.LinkedList.LinkedList;

public class Sort {

    public static void InsertionSort(int [] array){
        int key;

        for(int i=1;i<array.length;i++){
            key = array[i];
            int j=i-1;

            while(j>=0&&array[j]>key){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=key;
        }

        System.out.print("Insertion Sort: ");
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    //String keys Overrided.

    public static void InsertionSort(String [] keys){
        String key;

        for(int i=1;i<keys.length;i++){
            key=keys[i];
            int j=i-1;
            while(j>=0&&keys[j].compareToIgnoreCase(key)>0){
                keys[j+1]=keys[j];
                j--;
            }
            keys[j+1]=key;
        }


        System.out.print("Insertion Sort: ");
        for(String i:keys){
            System.out.print(i+" ");
        }
        System.out.println("");

    }

    public static void BubbleSort(String [] keys){


        for(int i=0;i<keys.length;i++){
            for(int j=0;j<keys.length-i-1;j++){
                if(keys[j].compareToIgnoreCase(keys[j+1])>0){
                    String tmp = keys[j];
                    keys[j]=keys[j+1];
                    keys[j+1]=tmp;
                }
            }
        }
        System.out.print("Bubble Sort: ");
        for(String i:keys){
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    //Optimized Version
    public static void BubbleSort(int [] array){

        for(int i=0;i<array.length;i++){
            boolean swapped=false;
            for(int j=0;j< array.length-i-1;j++){
                int temp;
                if(array[j+1]<array[j]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j]=temp;
                }
            }
            if(swapped==true){
               break;
            }
        }

        System.out.print("Bubble Sort: ");
        for(int i:array){
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    //String Version of MaxHeapify
    public static void maxheapify(String[]heap,int size,int pos){
        int left_child = 2*pos+1;
        int right_child = 2*pos+2;
        int largest = pos;

        if(left_child<size&&heap[largest].compareToIgnoreCase(heap[left_child])<0){
            largest = left_child;
        }

        if(right_child<size&& heap[largest].compareToIgnoreCase(heap[right_child])<0){
            largest = right_child;
        }

        if(largest!=pos){
            String temp = heap[pos];
            heap[pos]=heap[largest];
            heap[largest]=temp;
            maxheapify(heap,size,largest);
        }
    }

    //Increasing Order String max_heap
    public static void maxheapsort(String [] arr){
        int n = arr.length;

        for(int i=n/2-1;i>=0;i--){
            maxheapify(arr,n,i);
        }

        for(int i=n-1;i>=0;i--){
            String temp =arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxheapify(arr,i,0);
        }

        System.out.print("Maxheap Sort: ");
        for(int i=0;i<arr.length;++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");

    }



    //int version of Max_Heap
    public static void maxheapify(int [] heap,int size,int pos){
        int left_child = 2*pos+1;
        int right_child = 2*pos+2;
        int largest = pos;

        if(left_child<size&&heap[largest]<heap[left_child]){
            largest = left_child;
        }

        if(right_child<size&& heap[largest] < heap[right_child]){
            largest = right_child;
        }

        if(largest!=pos){
            int temp = heap[pos];
            heap[pos]=heap[largest];
            heap[largest]=temp;
            maxheapify(heap,size,largest);
        }
    }

    //Increasing Order int max_heap
    public static void maxheapsort(int [] arr){
        int n = arr.length;

        for(int i=n/2-1;i>=0;i--){
            maxheapify(arr,n,i);
        }

        for(int i=n-1;i>0;i--){
            int temp =arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxheapify(arr,i,0);
        }

        System.out.print("Maxheap Sort: ");
        for(int i=0;i<arr.length;++i){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");

    }

    //String version of minheapify
    public static void minheapify(String [] heap,int size,int pos){
        int left_child = 2*pos+1;
        int right_child = 2*pos+2;
        int smallest = pos;

        if(left_child<size && heap[smallest].compareToIgnoreCase(heap[left_child])>0){
            smallest = left_child;
        }

        if (right_child < size && heap[smallest].compareToIgnoreCase(heap[right_child])>0) {
            smallest = right_child;
        }

        if(smallest!=pos){
            String temp=heap[pos];
            heap[pos]=heap[smallest];
            heap[smallest]=temp;
            minheapify(heap, size, smallest);
        }
    }

    //Decreasing Order for String min_heap sort
    public static void minheapsort(String[]arr){
        int n = arr.length;

        for(int i=n/2-1;i>=0;i--){
            minheapify(arr,n,i);
        }

        for(int i=n-1;i>0;i--){
            String temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            minheapify(arr,i,0);
        }

        System.out.print("Minheap Sort: ");
        for(String i:arr){
            System.out.print(i+" ");
        }
        System.out.println("");

    }


    //Integer Version of Min Heapify
    public static void minheapify(int [] heap,int size,int pos){
        int left_child = 2*pos+1;
        int right_child = 2*pos+2;
        int smallest = pos;

        if(left_child<size && heap[smallest] > heap[left_child]){
            smallest = left_child;
        }

        if (right_child < size && heap[smallest] > heap[right_child]) {
            smallest = right_child;
        }

        if(smallest!=pos){
            int temp=heap[pos];
            heap[pos]=heap[smallest];
            heap[smallest]=temp;
            minheapify(heap, size, smallest);
        }
    }

    //Decreasing Order for integer min heap sort
    public static void minheapsort(int [] arr){
        int n = arr.length;

        for(int i=n/2-1;i>=0;i--){
            minheapify(arr,n,i);
        }

        for(int i=n-1;i>0;i--){
            int temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            minheapify(arr,i,0);
        }

        System.out.print("Minheap Sort: ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println("");


    }

    public static void Userinterface(int [] numbers){
        Instant start;
        Instant end;
        Duration execution_time;


        Scanner input = new Scanner(System.in);
        System.out.println("Specify Your Sorting Algorithm:\n" +
                "1)Insertion Sort\n" +
                "2)Bubble Sort\n" +
                "3)Heap\n"+
                "4)All\n");
        int choice = input.nextInt();
        switch(choice){
            case(1):
                start = Instant.now();
                InsertionSort(numbers);
                end = Instant.now();
                execution_time=Duration.between(start,end);
                System.out.println("\nExecution time in Nano seconds: " +
                        execution_time.getNano());
                break;

            case(2):
                start = Instant.now();
                BubbleSort(numbers);
                end = Instant.now();
                execution_time=Duration.between(start,end);
                System.out.println("\nExecution time in Nano seconds: " +
                        execution_time.getNano());
                break;

            case(3):
                System.out.println("1)Min Heap\n2)Max Heap");
                int get_keys_method = input.nextInt();
                switch(get_keys_method){

                    case(1):
                        start = Instant.now();
                        minheapsort(numbers);
                        end = Instant.now();
                        execution_time=Duration.between(start,end);
                        System.out.println("\nExecution time in Nano seconds: " +
                                execution_time.getNano());

                        break;

                    case(2):
                        start = Instant.now();
                        maxheapsort(numbers);
                        end = Instant.now();
                        execution_time=Duration.between(start,end);
                        System.out.println("\nExecution time in Nano seconds: " +
                                execution_time.getNano());
                        break;
                }
                break;

            case(4):

                InsertionSort(numbers);
                System.out.println("=====================================");

                BubbleSort(numbers);
                System.out.println("=====================================");

                maxheapsort(numbers);
                System.out.println("=====================================");

                minheapsort(numbers);
                System.out.println("=====================================");
                break;
        }
    }


    public static void Userinterface(String [] keys){
        Instant start;
        Instant end;
        Duration execution_time;


        Scanner input = new Scanner(System.in);
        System.out.println("Specify Your Sorting Algorithm:\n" +
                "1)Insertion Sort\n" +
                "2)Bubble Sort\n" +
                "3)Heap\n"+
                "4)All\n");
        int choice = input.nextInt();
        switch(choice){
            case(1):
                start = Instant.now();
                InsertionSort(keys);
                end = Instant.now();
                execution_time=Duration.between(start,end);
                System.out.println("\nExecution time in Nano seconds: " +
                        execution_time.getNano());
                break;

            case(2):
                start = Instant.now();
                BubbleSort(keys);
                end = Instant.now();
                execution_time=Duration.between(start,end);
                System.out.println("\nExecution time in Nano seconds: " +
                        execution_time.getNano());
                break;

            case(3):
                System.out.println("1)Min Heap\n2)Max Heap");
                int get_keys_method = input.nextInt();
                switch(get_keys_method){

                    case(1):
                        start = Instant.now();
                        minheapsort(keys);
                        end = Instant.now();
                        execution_time=Duration.between(start,end);
                        System.out.println("\nExecution time in Nano seconds: " +
                                execution_time.getNano());

                        break;

                    case(2):
                        start = Instant.now();
                        maxheapsort(keys);
                        end = Instant.now();
                        execution_time=Duration.between(start,end);
                        System.out.println("\nExecution time in Nano seconds: " +
                                execution_time.getNano());
                        break;
                }
                break;

            case(4):

                InsertionSort(keys);
                System.out.println("=====================================");

                BubbleSort(keys);
                System.out.println("=====================================");

                maxheapsort(keys);
                System.out.println("=====================================");

                minheapsort(keys);
                System.out.println("=====================================");


                break;
        }
    }

    public static void main(String[] args) {
        int [] keys = {2,3,-1,0,0,0};
        //String [] keys = {};
        Userinterface(keys);

    }
}
