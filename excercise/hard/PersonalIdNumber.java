import java.util.Scanner;

public class PersonalIdNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the pin");
        String pin =sc.nextLine();
        boolean result = validate(pin);
        System.out.println(result);
    }
    public static boolean validate(String pin) {
        if(pin.contains(" ")){
            return false;
        }
        if(pin.matches(".*[a-zA-Z].*")){
            return false;
        }
        int[]arr = new int[6];
        for(int i=0;i<=arr.length-1;i++){
            if(arr.length>=6 || arr[i]<0 || arr[i]>9  ){
                return false;
            }else{
                return true;
            }
        }
        return false;


    }
}

