package DSA.Datastructures.Tree;

import java.lang.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public interface Heap {
    public void heapifydown(int i);
    public void swap(int pos1,int pos2);
    public void Insert(int key);
    public int Delete();
    public int left_Child(int pos);
    public int right_Child(int pos);

}

class Minheap implements Heap{
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

    @Override
    public void heapifydown(int i) {

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

class Maxheap implements Heap {
    int size=0;
    int [] maxheap;
    int max_size;

    public Maxheap(int [] numbers){
       max_size = numbers.length+1;
       size = numbers.length;
       System.arraycopy(numbers, 0,maxheap,1,size);
    }

    public Maxheap(int n){
        max_size = n;
        maxheap = new int[max_size+1];
        maxheap[0]=Integer.MIN_VALUE;
    }

    public boolean isLeaf(int pos){
        return(left_Child(pos)<=size||right_Child(pos)<=size?false:true);
    }

    public int getParent(int pos){ return pos/2;}

    public int left_Child(int pos){
        return 2*pos;
    }

    public int right_Child(int pos){
        return 2*pos+1;
    }

    public int getMaximum(){
        return maxheap[1];
    }

    public void sort(){

        //first we heapify the array
        buildMaxHeap();

        for(int i=size-1;i>0;i--){
            swap(i,0);
            heapifydown(0);
        }

    }


    public void swap(int fpos, int spos){
        int temp = maxheap[fpos];
        maxheap[fpos] = maxheap[spos];
        maxheap[spos]=temp;
    }

    public void heapifydown(int pos) {

        int left_child = left_Child(pos);
        int right_child = right_Child(pos);

        if(!isLeaf(pos)){
            if(maxheap[pos]<maxheap[left_child]||maxheap[pos]<maxheap[right_child]){
                if(maxheap[left_child]>maxheap[right_child]){
                    swap(pos,left_child);
                    heapifydown(left_child);
                    pos = left_child;
                }

                else {
                    swap(pos,right_child);
                    pos = right_child;
                }
                heapifydown(pos);
            }
        }

    }

    public void heapifyUp(int pos){
        int temp = maxheap[pos];

        while(pos>0 && temp > maxheap[getParent(pos)]&&getParent(pos)>0){
            maxheap[pos] = maxheap[getParent(pos)];
            pos = getParent(pos);
        }
        maxheap[pos] = temp;
    }

    public void buildMaxHeap(){
        int start_index = (size/2);
        for(int i=start_index;i>=1;i--){
            heapifydown(i);
        }
    }
    public void Insert(int key){

        if(max_size==size) {
            max_size++;
            size++;
            int[] tmp = new int[max_size];
            tmp[0]=Integer.MIN_VALUE;
            System.arraycopy(maxheap, 1, tmp, 1, size);
            tmp[size] = key;
            maxheap = new int[max_size];
            System.arraycopy(tmp, 1, maxheap, 1, size);
            return;
        }

        else {
            size++;
            maxheap[size] = key;
            heapifyUp(size);
        }
    }

    public int Delete(){
        int max = maxheap[1];
       swap(1,size);
       size--;
       heapifydown(1);
       return max;
    }

    public String toString(){
        String output="";
        for(int i=1;i<=size;i++){
            output+=String.format("%d ",maxheap[i]);
        }
        return output;

    }

    public static void main(String[] args) {
        //int [] arr = {36,746,0,34,2,5};
        Maxheap h1 = new Maxheap(6);
        //h1.Insert(36);
        h1.Insert(36);
        h1.Insert(746);
        h1.Insert(1000);
        h1.Insert(10);
        h1.Insert(15);

        System.out.println(h1);
        h1.Delete();
        System.out.println(h1);
        h1.Delete();
        System.out.println(h1);
        h1.Delete();
        //h1.buildMaxHeap();
        //System.out.println(h1);
        //h1.Insert(1000);
        //System.out.println(h1);



    }
}
