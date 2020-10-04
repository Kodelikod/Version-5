package Controller;
import java.util.Scanner;


public class Scan {


        static Scanner scan = new Scanner(System.in);
        static String output = "";

    // Methods for inputs:-
    public static String Scan(){ return scan.next(); }
    public static String ScanLine(){ return scan.nextLine(); }
    public static int ScanInt(){ return scan.nextInt();}
    public static double ScanDouble(){ return scan.nextDouble();}
    public static long ScanLong(){  return scan.nextLong();}


    public static String output (String output){
        System.out.print(output);
        return output;
    }


}
