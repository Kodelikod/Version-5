package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;
import Controller.Scan;

import java.text.ParseException;
import java.util.Scanner;

public class ViewManager{
    public void managerMenu(ControllerEmployee controllerEmployee, ControllerManager controllerManager,
                            ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {



        Scan.output("Please enter your password:");
        String passwordM = Scan.ScanLine();

        if (passwordM.equals("admin1234")) {
            Scan.output("Manager Screen - Type one of the options below:");
            Scan.output("1. Add an employee");
            Scan.output("2. Remove an employee");
            Scan.output("3. View all employees");
            Scan.output("4. Calculate employee net salary");
            Scan.output("5. Calculate employee salary bonus");
            Scan.output("6. Return to Main Menu");

            int optionM = Scan.ScanInt();
            if (optionM == 1) {
                controllerManager.registerEmployee();
            } else if (optionM == 2) {
                controllerManager.removeEmployee();
            } else if (optionM == 3) {
                controllerManager.viewEmployeeList();
            } else if (optionM == 4) {
                controllerManager.employeeNetSalary();
            } else if (optionM == 5) {
                controllerManager.employeeBonus();
            } else if (optionM == 6) {
                viewMain.mainMenu(controllerEmployee, controllerManager, controllerCustomer);
            } else {
                Scan.output("Invalid input, please try again");
                managerMenu(controllerEmployee, controllerManager, controllerCustomer, viewMain);
            }
        } else {
            Scan.output("Invalid password");
        }
    }
}

