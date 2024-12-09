import java.util.Arrays;
import java.util.Scanner;



public class OddReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string");
        String str1=sc.nextLine();
        String last = getReverse(str1);
        System.out.println(last);

    }
    public static String getReverse(String str1){
        //int length = str1.length();
        String[] words=str1.split("\\s+");
        for(int i=0;i< words.length;i++){
            if(words[i].length() %2!=0){
                words[i]=new StringBuilder(words[i]).reverse().toString();
            }
        }
        String result = String.join(" ", words);
        return result ;
    }
}
