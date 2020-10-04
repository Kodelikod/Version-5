package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;
import Controller.Scan;

import java.text.ParseException;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;

public class ViewMain {
        private ViewManager viewManager = new ViewManager();
        private ViewEmployee viewEmployee = new ViewEmployee();
        private ViewCustomer viewCustomer = new ViewCustomer();

        private boolean running = true;

        public void welcome(ControllerEmployee controllerEmployee, ControllerManager controllerManager, ControllerCustomer controllerCustomer) throws ParseException {
            System.out.println("Main Menu:");
            System.out.println("Welcome to DART, your good old game rental system. The competition has no steam to keep up");
            mainMenu(controllerEmployee, controllerManager, controllerCustomer);
        }

        public void mainMenu(ControllerEmployee controllerEmployee, ControllerManager controllerManager, ControllerCustomer controllerCustomer) throws ParseException {
            while(running){
                System.out.println("\nPlease specify your role by entering one of the options given:");
                System.out.println ("1. Enter M for Manager");
                System.out.println ("2. Enter E for Employee");
                System.out.println ("3. Enter C for Customer");
                System.out.println ("4. Enter X to exit system");

                String inputMainMenu = Scan.ScanLine();


                switch (inputMainMenu.toUpperCase().trim()) {
                    case "M":
                        viewManager.managerMenu(controllerEmployee, controllerManager, controllerCustomer, this);
                        break;
                    case "E":
                        viewEmployee.employeeMenu(controllerEmployee, controllerManager, controllerCustomer, this);
                        break;
                    case "C":
                        viewCustomer.customerMenu(controllerEmployee, controllerManager, controllerCustomer, this);
                        break;
                    case "X":
                        Scan.closeScanner();
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input, please try again.");
                        break;
                }
            }
        }
    }



