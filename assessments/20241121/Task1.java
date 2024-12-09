import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first number");
        int num1 = sc.nextInt();
        hello(num1);
        System.out.println("enter the second number");
        int num2 = sc.nextInt();
        System.out.println(analyzeNumber(num2));
        System.out.println("enter the third number");
        int num3 = sc.nextInt();
        System.out.println(analyzeNumber(num3));
        System.out.println("enter the fourth number");
        int num4 = sc.nextInt();
        System.out.println(analyzeNumber(num4));
        System.out.println("enter the fifth number");
        int num5 = sc.nextInt();
        System.out.println(analyzeNumber(num5));
    }


    public static String analyzeNumber(int number) {
        if (number > 0 && number % 2 == 0) {
            return "positive and even";
        } else if (number > 0 && number % 2 == 0 && number % 5 == 0) {

        } else if (number > 0 && number % 2 == 0 && number % 5 == 0) {
            return "positive and even and multiple of 5";
        } else if (number > 0 && number % 2 != 0 && number % 5 == 0) {
            return "positive and odd";
        } else if (number > 0 && number % 2 != 0 && number % 5 != 0) {
            return "positive and odd and not multiple of 5";
        } else if (number < 0 && number % 2 == 0 && number % 5 == 0) {
            return "negative and even and multiple of 5";
        } else if (number < 0 && number % 2 != 0 && number % 5 == 0) {
            return "negative and odd and multiple of 5";
        } else if (number < 0 && number % 2 != 0 && number % 5 != 0) {
            return "negative and odd and not multiple of 5";
        } else {
            return "zero";
        }
        return "";
    }
    public  static  void hello(int number) {
        if (number > 0)
        {
            System.out.println("positive");
    }else{
            System.out.println("negative");}
    }
}