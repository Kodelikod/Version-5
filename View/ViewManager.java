package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;

import java.text.ParseException;
import java.util.Scanner;

public class ViewManager{
    public void managerMenu(ControllerEmployee controllerEmployee, ControllerManager controllerManager,
                            ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {

    Scanner input = new Scanner(System.in);

        System.out.println("Please enter your password:");
        String passwordM = input.nextLine();

        if (passwordM.equals("admin1234")) {
            System.out.println("Manager Screen - Type one of the options below:");
            System.out.println("1. Add an employee");
            System.out.println("2. Remove an employee");
            System.out.println("3. View all employees");
            System.out.println("4. Calculate employee net salary");
            System.out.println("5. Calculate employee salary bonus");
            System.out.println("6. Return to Main Menu");

            int optionM = input.nextInt();
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
                System.out.println("Invalid input, please try again");
                managerMenu(controllerEmployee, controllerManager, controllerCustomer, viewMain);
            }
        } else {
            System.out.println("Invalid password");
        }
    }
}

