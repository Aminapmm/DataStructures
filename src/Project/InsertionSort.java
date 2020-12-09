package Project;

public class InsertionSort {

    public static int [] Insertion_Sort(int [] array){
        int value;
        for(int i=1;i<array.length;i++){
            int j=i-1;
            value = array[i];
            while(j>-1&&array[j]>value){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=value;

        }
        return array;
    }

    public static void main(String[] args) {
        int [] a = {4,33,2,10,12,1,5,6};
        //System.out.println(Insertion_Sort(a));
        int [] b = Insertion_Sort(a);
        //System.out.println(b);
        for(int i:b){
            System.out.println(i);
        }
    }
}
