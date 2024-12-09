import java.util.Scanner;
import java.util.Arrays;

public class SideCheck{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the shortest side");
        int n =sc.nextInt();
        double[] result =SideCheck.otherSides(n);
        System.out.println("the 3 sides of the triangle are:"+Arrays.toString(result));
    }
    public static double[] otherSides(int n) {
        double longerSide=n*Math.sqrt(3);
        double hypotenuse=2*n;
        longerSide=Math.round(longerSide*100.0)/100.0;
        hypotenuse=Math.round(hypotenuse*100.0)/100.0;
        double[] arr = { hypotenuse,longerSide,n};
        //	Arrays.sort(arr);

        return arr;
    }
}
