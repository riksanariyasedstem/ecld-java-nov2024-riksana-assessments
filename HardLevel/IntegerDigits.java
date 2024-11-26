import java.util.Scanner;

public class IntegerDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       // System.out.println("enter the size");
       // int size=sc.nextInt();
        int size=100;
        int[]arr=new int[size];
        System.out.println("enter the numbers without space");
        for(int i=0;i<size-1;i++){
            arr[i]=sc.nextInt();
        }
        int result=returncount(size,arr);
        System.out.println("is the number of digits in your enterd value"+result);

    }
    public static int returncount(int size,int[]arr){
      //  arr=new int[size];
        int count=0;
        for(int i=0;i<size-1;i++){
            //int count=0;
             count++ ;
        }
        return count;
    }
}
