import java.util.Arrays;
import java.util.Scanner;

public class Streches {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size");
        int size= sc.nextInt();
        int[] numbers=new int[size];
        System.out.println("enter the values");
        for(int i=0;i<size;i++){
            numbers[i]=sc.nextInt();
            System.out.println(" ");
        }
        int last = largestGap(numbers);
        System.out.println(last);
    }
    public static int largestGap(int[] numbers) {
        int[]difference = new int[numbers.length];
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-1;i++){
            difference[i]=numbers[i+1]-numbers[i];


        }
        Arrays.sort(difference);
        int result = difference[difference.length-1];
        return result;

    }
}

