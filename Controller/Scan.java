package Controller;
import java.util.Scanner;


public class Scan {


    static Scanner scan = new Scanner(System.in);
    public static final String EOL = System.lineSeparator();


    // Methods for reading input without printing
    public static String scan() {
        return scan.next();
    }

    public static String scanLine() {
        return scan.nextLine();
    }

    public static int scanInt() {
        return scan.nextInt();
    }

    public static double ScanDouble() {
        return scan.nextDouble();
    }

    public static long ScanLong() {
        long aLong = scan.nextLong();
        scan.nextLine();
        return aLong;
    }

    // Method for reading user input and printing at the same time
    public static String readLine(String output) {
        System.out.print(output);
        String line = scan.nextLine();
        return line;
    }

    public static int readInt(String output) {
        System.out.println(output);
        int anInt = scan.nextInt();
        scan.nextLine();
        return anInt;
    }

    public static double readDouble(String output) {
        System.out.println(output);
        double aDouble = scan.nextDouble();
        scan.nextLine();
        return aDouble;
    }

    public static void print(String output){
        System.out.println(output);
         // WHAT I*T DO
    }


    public static void closeScanner() {
        scan.close();
    }
}


