package Controller;
import java.util.Scanner;







public class Scan {

    static Scanner scan = new Scanner(System.in);

    // Methods for reading input without printing
    public static String Scan(){
        return scan.next();
    }

    public static String ScanLine(){
        return scan.nextLine();
    }

    public static int ScanInt(){
    //    scan.nextInt();
    //    scan.nextLine();
        return scan.nextInt();
    }
    public static double ScanDouble(){
    //    scan.nextDouble();
    //    scan.nextLine();

        return scan.nextDouble();
    }

    public static long ScanLong(){
    //    scan.nextLong();
    //    scan.nextLine();
        return scan.nextLong();

    }

    // Method for reading user input and printing at the same time
    public static String readLine (String output){
        System.out.print(output);
        return scan.nextLine();
    }

    public static int readInt (String output){
        System.out.println(output);
        return scan.nextInt();
    }

    public static double readDouble (String output){
        System.out.println(output);
        return scan.nextDouble();
    }
  // public static double readDouble (String output){
  //     System.out.println(output);
    // double input = scan.nextDouble;
    // scan.nextLine();
  //     return input;
  // }
}
