package Project;

public class Sort {

    public static int [] InsertionSort(int [] array){
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

    public static int [] BubbleSort(int [] array){

        for(int i=0;i<array.length;i++){
            for(int j=0;j< array.length-i-1;j++){
                int temp;
                if(array[j+1]<array[j]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j]=temp;
                }
            }
        }
        return array;
    }

}
