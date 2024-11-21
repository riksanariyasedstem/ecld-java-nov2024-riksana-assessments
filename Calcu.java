import java.util.Scanner;

public class Calcu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("choose your operation");
        System.out.println("1 for addition");
        System.out.println("2 for subtraction");
        System.out.println("3 for multiply");
        System.out.println("4 for division");
        int choose = sc.nextInt() ;
         System.out.println("enter 2 numbers");
         int num1 = sc.nextInt() ;
         int num2 =sc.nextInt() ;

         if(choose==1){
System.out.println("the answer is "+ add(num1,num2));
         } else if (choose==2) {
             System.out.println("the answer is "+ sub(num1,num2));
         } else if (choose==3) {
             System.out.println("the answer is "+ multiplication(num1,num2));
         } else if (choose==4) {
             System.out.println("the answer is "+ division(num1,num2));
         }else{
             System.out.println("invalid option");
         }
    }

    public static int add(int num1, int num2) {
        int result = num1 + num2;
        return result ;
    }
    public static int sub(int num1, int num2) {
        int result = num1 - num2;
        return result ;
    }
    public static int multiplication(int num1, int num2) {
        int result = num1 * num2;
        return result ;
    }
    public static int division(int num1, int num2) {
        int result = num1 / num2;
        return result ;
    }
}
