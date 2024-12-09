import java.util.Scanner;
public class PositiveDominant {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the size of the array");
        int size= sc.nextInt();
        System.out.println("enter the elements in the array");
        int[]n=new int[size];
        for(int i=0;i<n.length;i++){
            n[i]=sc.nextInt();
        }
        boolean res = isPositiveDominant(n);
        System.out.println(res);
        sc.close();
    }
    public static boolean isPositiveDominant(int[] n) {
        int positivecount =0;
        int negativecount=0;
        for(int i=0;i<n.length;i++){
            if(n[i]>0){
                positivecount++ ;

            }else if (n[i]<0){
                negativecount++ ;
            }
        }
        boolean isSet = true;
        if(positivecount>negativecount){
            isSet = true;
        }
        else{
            isSet=false;
        }

        return isSet;
    }
}

