
    import java.util.Scanner;

    public class Temp {
        public static double celsiusToFahrenheit(double celsius) {

            double Fahrenheit = ((celsius * 9) / 5) + 32;
            System.out.println("Temperature in Fahrenheit is: " + Fahrenheit);
            return Fahrenheit;
        }

        public static double fahrenheitToCelsius(double fahrenheit) {
            double Celsius = ((fahrenheit - 32) * 5) / 9;
            return Celsius;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("enter the celsius temperature");
            double celsius = scanner.nextDouble();
            System.out.println("enter the fahrenheit temperature");
            double fahrenheit = scanner.nextDouble();
            System.out.println(celsiusToFahrenheit(celsius));
            System.out.println(fahrenheitToCelsius(fahrenheit));


        }
    }


