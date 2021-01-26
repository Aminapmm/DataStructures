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

