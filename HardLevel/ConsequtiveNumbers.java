import java.util.Arrays;
import java.util.Scanner;

public class ConsequtiveNumbers {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("enter the number of elements");
        int size= sc.nextInt();
        int[] arr=new int[size];
        System.out.println("enter the elements");
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
boolean result =check(arr);
        System.out.println("the result is"+result);
    }
    public static boolean check(int[]arr){
        if (arr.length <= 1) return true;
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1] || arr[i+1]!=arr[i]+1){
                return false;
            }
        }
        return true;
    }
}
