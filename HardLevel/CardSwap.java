import java.util.Scanner;

public class CardSwap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the first 2-digit number (Player 1): ");
        int x = scanner.nextInt();

        System.out.print("Enter the second 2-digit number (Player 2): ");
        int y = scanner.nextInt();


        boolean result = swapCards(x, y);
        if (result) {
            System.out.println("Player 1 wins after swapping!");
        } else {
            System.out.println("Player 2 wins!");
        }


        scanner.close();
    }
    public static boolean swapCards(int x, int y) {
        boolean result = false;
        int greatestfirst=0;
        int greatestsecond=0;
        int minfirst =0;
        int minsec=0;
        int firstpersonones = x % 10;
        int firstpersonsTens = (x / 10) % 10;
        int secondpersonOnes = y % 10;
        int secondpersonTens = (y / 10) % 10;

        if(firstpersonones<firstpersonsTens){
            minfirst =firstpersonones;
            greatestfirst=firstpersonsTens;
        }else{
            minfirst=firstpersonsTens;
            greatestfirst=firstpersonones;
        }

        if(secondpersonOnes<secondpersonTens){
            minsec=secondpersonOnes;
            greatestsecond=secondpersonTens;
        }else{
            minsec=secondpersonTens;
            greatestsecond=secondpersonOnes;
        }



        if (minfirst < secondpersonTens) {
            x = (secondpersonTens * 10) + firstpersonones;
        } else if (minfirst < secondpersonOnes) {
            x = (firstpersonsTens * 10) + secondpersonOnes;
        }


        if(x>y)
            return true;
        else return false;

    }
}
