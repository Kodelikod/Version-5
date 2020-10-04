package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;
import Controller.Scan;

import java.text.ParseException;
import java.util.Scanner;

    public class ViewMain {
        private ViewManager viewManager = new ViewManager();
        private ViewEmployee viewEmployee = new ViewEmployee();
        private ViewCustomer viewCustomer = new ViewCustomer();

        private boolean running = true;

        public void welcome(ControllerEmployee controllerEmployee, ControllerManager controllerManager, ControllerCustomer controllerCustomer) throws ParseException {
            Scan.output("Main Menu:");
            Scan.output("Welcome to DART, your good old game rental system. The competition has no steam to keep up");
            mainMenu(controllerEmployee, controllerManager, controllerCustomer);
        }

        public void mainMenu(ControllerEmployee controllerEmployee, ControllerManager controllerManager, ControllerCustomer controllerCustomer) throws ParseException {
            while(running){
                Scan.output("\nPlease specify your role by entering one of the options given:");
                Scan.output ("1. Enter M for Manager");
                Scan.output ("2. Enter E for Employee");
                Scan.output ("3. Enter C for Customer");
                Scan.output ("4. Enter X to exit system");

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
                        running = false;
                        break;
                    default:
                        Scan.output("Invalid input, please try again.");
                        mainMenu(controllerEmployee, controllerManager, controllerCustomer);
                        break;
                }
            }
        }
    }



