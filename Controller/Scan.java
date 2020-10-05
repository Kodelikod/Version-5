package Controller;
import java.util.Scanner;


public class Scan {

    static Scanner scan = new Scanner(System.in);

    // Methods for reading input without printing
    public static String Scan() {
        return scan.next();
    }

    public static String ScanLine() {
        return scan.nextLine();
    }

    public static int ScanInt() {
        return scan.nextInt();
    }

    public static double ScanDouble() {
        return scan.nextDouble();
    }

    public static long ScanLong() {
        return scan.nextLong();
    }

    // Method for reading user input and printing at the same time
    public static String readLine(String output) {
        System.out.print(output);
        return scan.nextLine();
    }

    public static int readInt(String output) {
        System.out.println(output);  //shouldn't there be a nextLine after nextInt bc if user input an int and naturally presses enter and all that?
        return scan.nextInt();
    }

    public static double readDouble(String output) {
        System.out.println(output);
        return scan.nextDouble();
    }

    public static String EOL(){ //END OF LINE separator
        return System.lineSeparator();
    }

    public static void closeScanner() {
        scan.close();
    }
}


