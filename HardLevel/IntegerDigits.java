import java.util.Scanner;

public class IntegerDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 100;
        int[] arr = new int[size];
        System.out.println("Enter the numbers without spaces:");

        // Reading a number as a single integer, not individual digits
        String number = sc.nextLine();  // Read input as a single string
        
        // Convert the number's characters into array elements
        for (int i = 0; i < number.length(); i++) {
            arr[i] = Character.getNumericValue(number.charAt(i));
        }

        int result = returncount(number.length(), arr);
        System.out.println("The number of digits in your entered value: " + result);
    }

    public static int returncount(int size, int[] arr) {
        int count = 0;
        for (int i = 0; i < size; i++) { // Loop up to actual input length
            count++;
        }
        return count;
    }
}


