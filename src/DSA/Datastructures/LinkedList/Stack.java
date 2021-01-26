package DSA.Datastructures.LinkedList;

public class Stack {

  int size;
  private int top=-1;
  private int [] stackarr;

  public Stack(int n){
      this.size = n;
      this.stackarr = new int[this.size];
  }

  public void push(int data){

      if(!isFull()) {
          this.stackarr[++top] = data;
      }
  }

  public int pop() {
      if (!isEmpty()) {
          return stackarr[this.top--];
      } else {
          return -1;
      }
  }

  public int peek(){
      return((!isEmpty())?stackarr[top]:-1);
  }

  public boolean isEmpty(){
     return(top==-1);
  }

  public boolean isFull(){
      return (top>=size);
  }

  public String toString(){

      String output = "";
      for(int i=top;i>=0;i--){
          output+=stackarr[i]+"\n";
      }

      return output;
      }


  public static void main(String[] args) {

  }
}
