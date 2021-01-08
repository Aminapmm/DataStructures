package Datastrucures.Tree;

import java.lang.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public interface Heap {
    public  void heapify(int [] arr,int i);
    public int [] swap(int []arr ,int pos1,int pos2);
    public void Insert(int key);
    public void delete();
    public int left_Child(int pos);
    public int right_Child(int pos);

}
class Minheap{
    int max_size;
    int size=0;
    int [] minheap;

    public Minheap(int [] array){
        max_size = array.length+1;
        size= array.length;
        minheap = new int[max_size];
        minheap[0]=Integer.MIN_VALUE;
        System.arraycopy(array,0,minheap,1,size);

    }

    public Minheap(int n){
        this.max_size =n+1;
        minheap = new int[max_size];
        minheap[0]=Integer.MIN_VALUE;
    }

    public int getMinimum(){
        return minheap[1];
    }

    public int left_Child(int pos){
        return 2*pos;
    }

    public int right_Child(int pos){
        return 2*pos+1;
    }

    public boolean isLeaf(int pos){
        boolean leaf = (left_Child(pos)<=size||right_Child(pos)<=size)?false:true;
        return leaf;
    }

    public int findParent(int pos){
        int parent = (pos/2);
        return parent;
    }

    public void BuildMinHeap(){
        int start_index = size /2;
        for(int i=start_index;i>=1;i--){
            heapify(i);
        }
    }

    public void heapify(int pos) {

        int left_child =left_Child(pos);
        int right_child = right_Child(pos);
        if (!isLeaf(pos)) {
            if (minheap[left_child] < minheap[pos] || minheap[right_child] < minheap[pos]) {

                if (minheap[left_child] < minheap[right_child] || minheap[right_child]==Integer.MIN_VALUE) {
                    swap(pos,left_child);
                    pos = left_child;
                }
                else {
                    swap(pos,right_child);
                    pos = right_child;
                }
                heapify(pos);
            }

        }
    }
    public void swap(int pos1, int pos2){
        int temp = minheap[pos1];
        minheap[pos1] = minheap[pos2];
        minheap[pos2]=temp;
    }

    public void Heapify_Up(){
        int current =size;
        while(minheap[current]<minheap[findParent(current)]){
            swap(current,findParent(current));
            current = findParent(current);
        }
    }

    public void Insert(int key){
        if(size+1==max_size){
            max_size++;
            int[] tmp = new int[max_size];
            System.arraycopy(minheap,1,tmp,1,size);
            minheap = tmp;
        }
        size++;
        minheap[size]=key;
        Heapify_Up();
    }

    public int Delete(){
        int root_key = minheap[1];
        minheap[1]=minheap[size];
        size--;
        BuildMinHeap();
        return root_key;

    }

    public void Ascending_sort(){
        while(size!=0){
            int key = Delete();
            System.out.print(key+" - ");

        }
    }

    public String toString(){
        String output="";
        for(int i=1;i<=size; i++){
            output+=String.format("%d ",minheap[i]);
        }
        return output;

    }

    public static void main(String[] args) {
        int [] abc = {4,5,10,12,3,2,1};
        Minheap h1 = new Minheap(abc);
        System.out.println(h1+String.format("\nMax size: %d\nSize: %d",h1.max_size,h1.size));

        //h1.Insert(51);
        h1.BuildMinHeap();

        System.out.println(h1+String.format("\nMax size: %d\nSize: %d",h1.max_size,h1.size));

        h1.Delete();
        System.out.println(h1+String.format("\nMax size: %d\nSize: %d",h1.max_size,h1.size));
        h1.Ascending_sort();



    }
}

class Maxheap {
    int size;
    int [] arr;


    public Maxheap(int [] numbers){
        arr = numbers;
        size = numbers.length;
    }

    public int getMaximum(){
        return arr[0];
    }

    public void sort(){

        //first we heapify the array
        buildMaxHeap();

        for(int i=size-1;i>0;i--){
            swap(i,0);
            heapify(i,0);
        }

    }


    public void swap(int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2]=temp;
    }

    public void heapify(int n,int i) {



            int largest = i;
            int left_child = 2*i + 1;
            int right_child = 2*i + 2;

            if(left_child<n&&arr[left_child]>arr[largest]){
                largest=left_child;
            }

            if(right_child<n&&arr[right_child]>arr[largest]){
                largest = right_child;
            }

            if(largest!=i){
                swap(largest,i);
                heapify(n,largest);
            }



    }

    public void buildMaxHeap(){
        int start_index = (arr.length/2)-1;
        for(int i=start_index;i>=0;i--){
            heapify(arr.length,i);
        }
    }
    public void insert(int n){
        size++;
        int [] temp = new int[size];
        for(int i=0;i<size-1;i++){
            temp[i]=arr[i];
        }
        temp[size-1]=n;
        arr=temp;
        buildMaxHeap();
    }

    public int delete(){
        int deleted_element = arr[0];
        swap(0,size-1);
        size--;
        int [] temp_arr = new int[size];
        for(int i=0;i<size;i++){
            temp_arr[i]=arr[i];
        }
        arr = temp_arr;
        heapify(size,0);
        return deleted_element;

    }

    public String toString(){
        String output="";
        for(int i:arr){
            output+=String.format("%d ",i);
        }
        return output;

    }

    public static void main(String[] args) {
        int [] arr = {36,746,0,34,2,5};
        Maxheap h1 = new Maxheap(arr);
        //h1.buildMaxHeap();
        h1.buildMaxHeap();
        System.out.println(h1);
        h1.insert(1000);
        System.out.println(h1);



    }
}
