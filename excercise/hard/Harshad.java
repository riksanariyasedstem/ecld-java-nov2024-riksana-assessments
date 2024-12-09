import java.util.Arrays;
import java.util.Scanner;



public class Harshad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number ");
        int n= sc.nextInt();
        boolean result = isHarshad(n);
        System.out.println("the number is HARSHAD or NOT:"+result);


    }
    public static boolean isHarshad(int n) {
        int hundereds = n / 100;
        int tens = (n / 10)%10;
        int ones = n % 10;
        int sum = hundereds + tens + ones;
        if (sum!=0 && n % sum == 0) {
            return true;
        } else {
            return false;
        }
    }

}

