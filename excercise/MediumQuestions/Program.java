import java.util.*;

public class Program {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the length of the array");
        int length=sc.nextInt();
        System.out.println("enther the number whose multiple you need as output");
        int num=sc.nextInt();
        int [] result =arrayOfMultiples(num,length);
        System.out.println("the final result:"+Arrays.toString(result));
        sc.close();

    }
    public static int[] arrayOfMultiples(int num, int length) {
        int[] arr=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=num*(i+1);
        }
        return arr;

    }
}

