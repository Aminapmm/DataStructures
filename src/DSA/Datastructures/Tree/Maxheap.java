package DSA.Datastructures.Tree;

public class Maxheap implements Heap {
    int size = 0;
    int[] maxheap;
    int max_size;

    public Maxheap(int n) {
        max_size = n;
        maxheap = new int[max_size + 1];
        maxheap[0] = Integer.MIN_VALUE;
    }

    public boolean isLeaf(int pos) {
        return (left_Child(pos) <= size || right_Child(pos) <= size ? false : true);
    }

    public int getParent(int pos) {
        return pos / 2;
    }

    public int left_Child(int pos) {
        return 2 * pos;
    }

    public int right_Child(int pos) {
        return 2 * pos + 1;
    }

    public int getMaximum() {
        return maxheap[1];
    }


    public void swap(int fpos, int spos) {
        int temp = maxheap[fpos];
        maxheap[fpos] = maxheap[spos];
        maxheap[spos] = temp;
    }

    public void heapifydown(int pos) {

        int left_child = left_Child(pos);
        int right_child = right_Child(pos);

        if (!isLeaf(pos)) {
            if (maxheap[pos] < maxheap[left_child] || maxheap[pos] < maxheap[right_child]) {
                if (maxheap[left_child] > maxheap[right_child]) {
                    swap(pos, left_child);
                    pos = left_child;
                    heapifydown(pos);
                } else {
                    swap(pos, right_child);
                    pos = right_child;
                    heapifydown(pos);
                }

            }
        }

    }

    public void heapifyUp(int pos) {
        int temp = maxheap[pos];

        while (pos > 0 && temp > maxheap[getParent(pos)] && getParent(pos) > 0) {
            maxheap[pos] = maxheap[getParent(pos)];
            pos = getParent(pos);
        }
        maxheap[pos] = temp;
    }

    public void buildMaxHeap() {
        int start_index = (size / 2);
        for (int i = start_index; i >= 1; i--) {
            heapifydown(i);
        }
    }

    public void Insert(int key) {

        if (max_size == size) {
            max_size++;
            size++;
            int[] tmp = new int[max_size];
            tmp[0] = Integer.MIN_VALUE;
            System.arraycopy(maxheap, 1, tmp, 1, size);
            tmp[size] = key;
            maxheap = new int[max_size];
            System.arraycopy(tmp, 1, maxheap, 1, size);
            return;
        } else {
            size++;
            maxheap[size] = key;
            heapifyUp(size);
        }
    }

    public int Delete() {
        int max = maxheap[1];
        maxheap[1] = maxheap[size];
        size--;
        heapifydown(1);
        return max;
    }

    public void heapify_from_arr(int [] keys){
        for(int i=0;i<keys.length;i++) {
            this.Insert(keys[i]);
        }
    }


    public void Descending_order(){
        ///int [] sorted_keys= new int[size];
        while(size!=0) {
            System.out.print(Delete() + " ");
        }

        //return sorted_keys;
    }

    public String toString() {
        String output = "";
        for (int i = 1; i <= size; i++) {
            output += String.format("%d ", maxheap[i]);
        }
        return output;

    }

    public static void main(String[] args) {
        //int[] arr = {36, 746, 800, 34, 1000, 5,16151,55,112};

        Maxheap h1 = new Maxheap(7);
        h1.Insert(30);
        h1.Insert(5);
        h1.Insert(6);
        h1.Insert(50);
        h1.Insert(45);
        h1.Insert(100);
        h1.buildMaxHeap();
        h1.Delete();
        //h1.heapify_from_arr(arr);
        System.out.println(h1 + " Size: " + h1.size);

        //h1.Descending_order();
       // h1.Delete();
       // System.out.println(h1 + " Size: " + h1.size);

       // h1.Delete();
       // System.out.println(h1 + " Size: " + h1.size);
       // h1.Insert(20);
       // System.out.println(h1 + " Size: " + h1.size);


        //h1.buildMaxHeap();
        //System.out.println(h1.Delete());
        //System.out.println(h1.Delete());
        //System.out.println(h1.Delete());
        //h1.Insert(1000);
        //System.out.println(h1);


    }
}
