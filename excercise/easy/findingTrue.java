import java.util.Scanner;

public class findingTrue {
    public static void main(String[]args){

        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size");
        int size=sc.nextInt();
        boolean[] arr = new boolean[size];
        for(int i=0;i<size;i++) {
            System.out.println("enter the boolean values " + (i + 1) +" (true/false):");

            arr[i] = sc.nextBoolean();

        }
        sc.close();
        int trueCount = countTrue(arr);
        System.out.println("Number of true values: " + trueCount);
    }

    public static int countTrue(boolean[] arr) {
        int count =0;
        for(boolean el:arr){
            if(el==true){
                count++ ;
            }
            else if(el==false){
                count=count;
            }else{
                count=0;
            }

        }
        return count ;
    }
}
