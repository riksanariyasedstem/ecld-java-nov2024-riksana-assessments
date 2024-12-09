import java.util.Scanner;

public class BinaryConversion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the binary code");
        String bin = sc.nextLine();
        String result = binaryConversion(bin);
        System.out.println(result);

    }
    public static String binaryConversion(String bin) {
        if(bin.length() > 8 || !bin.matches("[01]+")){
            return "Not Valid ";
        }
        if(!bin.contains("0")||!bin.contains("1")){
            return "Not valid ";
        }
        int tempInt = Integer.parseInt(bin,2);
        char temchar =(char)tempInt ;
        return Character.toString(temchar);

    }
}
