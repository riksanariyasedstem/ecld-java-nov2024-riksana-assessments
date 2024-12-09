import java.util.Scanner;

public class Challenge {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the first number");
        int a=sc.nextInt();
        System.out.println("enter the second number");
        int b=sc.nextInt();
        System.out.println("enter the third number");
        int c=sc.nextInt();
        int result = solutions(a, b, c);
        System.out.println("the number of solutions:"+result);

    }
    public static int solutions(int a, int b, int c) {
        int descriminate = b*b-4*a*c ;
        int res;
        if(descriminate>0){
            res=2;
        }
        else if(descriminate==0){
            res=1;
        }
        else{
            res= 0;
        }
        return res;
    }
}
