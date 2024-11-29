import java.util.Scanner;

public class Returnnext {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number");
        int number = sc.nextInt();
        System.out.println(returnInteger(number));
    }
    public static int returnInteger(int number){
        number++ ;
        return number;
    }
}
