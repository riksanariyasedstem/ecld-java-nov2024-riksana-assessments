import java.util.Scanner;

public class CarryDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first number");
        int n1=sc.nextInt();
        System.out.println("enter the second number");
        int n2=sc.nextInt();
        int res=carryDigits(n1,n2);
        System.out.println(res);


    }
    public static int carryDigits(int n1, int n2) {
        int first =0;
        int second =0;
        int count =0;
        int sum =0;
        while(n1>0 && n2>0){
            first = n1%10;
            second = n2%10;
            sum = first+second ;
            if(first+second+count>=10){
                 count++;
            }
            n1=n1/10;
            n2 = n2/10;

        }
        return count;
    }
}
