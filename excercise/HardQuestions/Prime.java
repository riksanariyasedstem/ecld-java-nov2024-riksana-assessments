import java.util.Arrays;
import java.util.Scanner;



public class Prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number up  to which you need the prime numbers");
        int num = sc.nextInt();
        int[] res = getprime(num);
        System.out.println(Arrays.toString(res));
    }
    public static int[] getprime(int num){
        int[]arr=new int[num];
        int count =0;
        if(num<2)
        {  return new int [0] ;
        }
        else{
            for(int i=2;i<=num;i++){
                boolean  isPrime = true;
                for(int j=2;j<=Math.sqrt(i);j++){
                    if(i%j==0){
                        isPrime=false;
                        break ;
                    }
                }
                if(isPrime){
                    arr[count]=i;
                    count++;
                }


            }

        }
        return Arrays.copyOf(arr,count);
    }
}
