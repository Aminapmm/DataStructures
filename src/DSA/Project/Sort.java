package DSA.Project;

import java.util.Scanner;
import DSA.Datastructures.Tree.*;

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

    public void Userinterface(int [] keys){

        Scanner input = new Scanner(System.in);
        System.out.println("Specify Your Sorting Algorithm:\n" +
                "1)Insertion Sort\n" +
                "2)Bubble Sort\n" +
                "3)Heap");
        int choice = input.nextInt();
        switch(choice){
            case(1):
                for(int i:InsertionSort(keys)){
                    System.out.println(i+" ");
                }
                break;

            case(2):

                for(int i:BubbleSort(keys)){
                    System.out.println(i+" ");
                }
                break;

            case(3):

                break;
        }
    }

    public static void main(String[] args) {

    }
}
