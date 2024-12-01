import java.util.Arrays;
import java.util.Scanner;

public class repeat {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("enter the  integer array size");
        int size=sc.nextInt();
        int[]nums=new int[size] ;
        System.out.println("enter the integer elements");
        for(int i=0;i<nums.length;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("enter the size of the  string array");
        int strsize=sc.nextInt();
        String[] str=new String[strsize];
        System.out.println("enter the string  elements");
        for(int i=0;i<str.length;i++){
            str[i]=sc.nextLine();
        }
        int[] result = removeDups(nums);
        System.out.println(Arrays.toString(result));
        String[] last=removeDups(str);
        System.out.println(Arrays.toString(last));
    }
    public static int[] removeDups(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1])
            {for(int j=i+1;j<nums.length-1;j++){
                nums[j]=nums[j+1];
            }
                nums[nums.length-1]=0;
            }

        }
        return nums ;
    }

    public static String[] removeDups(String[] str) {
        for(int i=0;i<str.length-1;i++){
            String temp =str[i];
            for(int j=i+1;j<str.length-1;j++){
                if(temp.equals(str[j])){
                    for(int k=j;k<str.length-1;k++){
                        str[k]=str[k+1];
                    }
                    str[str.length - 1] = null;
                }

            }

        }
        return str ;
    }
}
