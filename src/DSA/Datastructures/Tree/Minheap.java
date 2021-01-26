package DSA.Datastructures.Tree;

public class Minheap implements Heap {
    int max_size;
    int size = 0;
    int[] minheap;

    /***
    public Minheap(int[] array) {
        max_size = array.length + 1;
        size = array.length;
        minheap = new int[max_size];
        minheap[0] = Integer.MIN_VALUE;
        System.arraycopy(array, 0, minheap, 1, size);
    }
     ***/

    public Minheap(int n) {
        //size=0;
        this.max_size = n + 1;
        minheap = new int[max_size];
        minheap[0] = Integer.MIN_VALUE;
    }

    public int getMinimum() {
        return minheap[1];
    }


    public int left_Child(int pos) {
        return 2 * pos;
    }

    public int right_Child(int pos) {
        return 2 * pos + 1;
    }

    public boolean isLeaf(int pos) {
        boolean leaf = (left_Child(pos) <= size || right_Child(pos) <= size) ? false : true;
        return leaf;
    }

    public int findParent(int pos) {
        int parent = (pos / 2);
        return parent;
    }

    public void BuildMinHeap() {
        for (int i = size/2; i >= 1; i--) {
            heapifydown(i);
        }
    }

    public void heapifydown(int pos) {

        int left_child = left_Child(pos);
        int right_child = right_Child(pos);
        if (!isLeaf(pos)) {
            if (minheap[left_child] < minheap[pos] || minheap[right_child] < minheap[pos]) {

                if (minheap[left_child] < minheap[right_child]) {
                    swap(pos, left_child);
                    heapifydown(left_child);

                } else {
                    swap(pos, right_child);
                    heapifydown(right_child);
                }

            }

        }
    }

    public void swap(int pos1, int pos2) {
        int temp = minheap[pos1];
        minheap[pos1] = minheap[pos2];
        minheap[pos2] = temp;

    }

    public void Heapify_Up() {
        int current = size;
        while (minheap[current] < minheap[findParent(current)]) {
            swap(current, findParent(current));
            current = findParent(current);
        }
    }

    public void Insert(int key) {

        if (size + 1 == max_size) {
            max_size++;
            int[] tmp = new int[max_size];
            System.arraycopy(minheap, 1, tmp, 1, size);
            minheap = tmp;
        }

        size++;
        minheap[size] = key;
        Heapify_Up();
    }

    public int Delete() {
        int root_key = minheap[1];
        minheap[1] = minheap[size];
        size--;
        BuildMinHeap();
        //Heapify_Up();
        return root_key;

    }

    public void heapify_arr(int [] keys){
        for(int i=0;i<keys.length;i++){
            Insert(keys[i]);
        }
        //Ascending_sort();
    }
    public void Ascending_sort() {

        while (size != 0) {
            int key = Delete();
            System.out.print(key + " - ");

        }
    }

    public String toString() {
        String output = "";
        for (int i = 1; i <= size; i++) {
            output += String.format("%d ", minheap[i]);
        }
        return output;

    }

    public static void main(String[] args) {
        int[] abc = {4, 5, 10, 12, 3, 2, 1};
        int [] keys = {10,1,4,15,50,12};
        //int [] keys = {50,15,12,10};
        Minheap h1 = new Minheap(keys.length);
        h1.heapify_arr(keys);
        //h1.Delete();
        //h1.Delete();
        //h1.Heapify_Up();
        System.out.println(h1 + String.format("\nMax size: %d\nSize: %d", h1.max_size, h1.size));

        //h1.Insert(51);
        //h1.BuildMinHeap();

        //System.out.println(h1 + String.format("\nMax size: %d\nSize: %d", h1.max_size, h1.size));

        //h1.Delete();
        //System.out.println(h1 + String.format("\nMax size: %d\nSize: %d", h1.max_size, h1.size));
       // h1.Delete();
        //System.out.println(h1 + String.format("\nMax size: %d\nSize: %d", h1.max_size, h1.size));
       // h1.Delete();
        //System.out.println(h1 + String.format("\nMax size: %d\nSize: %d", h1.max_size, h1.size));



        h1.Ascending_sort();


    }
}
