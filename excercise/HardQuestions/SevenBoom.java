import java.util.Scanner;

public class SevenBoom {
    public static void main(String[]args){
        int[] returnedArray = readIntegers();
        String result = sevenBoom(returnedArray);
        System.out.println(result);

    }
    public static int[]readIntegers(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the size of the array");
        int size= sc.nextInt();
        sc.nextLine();
        System.out.println("enter the numbers inside the array within the size seprated by commas");
        String input = sc.nextLine(); //the error I made bcz I skipped this line b4,the use of this line after nextInt is to  it reads the integer value you entered, but it does not consume the newline character (\n) that is left in the input buffer when you press "Enter" after typing the number..
        String[]splits =input.split(",");
        int[]arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=Integer.parseInt(splits[i].trim());
        }
        return arr ;


    }
    public static String sevenBoom(int[] returnedArray) {
        //readIntegers();

     for(int i=0;i< returnedArray.length;i++){
         if(returnedArray[i]==7){
             return "Boom";
         }
     }
     return " NO BOOM";

    }
}
