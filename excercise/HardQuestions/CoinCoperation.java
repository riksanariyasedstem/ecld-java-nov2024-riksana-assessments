import java.util.Arrays;
import java.util.Scanner;



public class CoinCoperation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the first person action");
        String str1= sc.nextLine();
        System.out.println("enter the second person action");
        String str2= sc.nextLine();
        int[]res = getBalance(str1,str2);
        System.out.println(Arrays.toString(res));
sc.close();

    }

    public static int[] getBalance(String str1, String str2) {
        int[] balance = new int[2];
        if (str1.equals("share")) {
            balance[0] -= 1;
            balance[1] += 3;

        }
        else if (str1.equals("steal")) {
            balance[0] += 3;
            balance[1] -= 1;

        }

        if (str2.equals("share")) {
            balance[1] -= 1;
            balance[0] += 3;

        }  else if (str2.equals("steal")) {
            balance[0] -= 1;
            balance[1] += 3;


        }
        return balance;
    }
}
