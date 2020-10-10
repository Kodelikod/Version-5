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


        String passwordM = Scan.readLine("Please enter your password:");


        if (passwordM.equals("admin1234")) {

            int inputManagerMenu = Scan.readInt("Manager Screen - Type one of the options below:" +
                System.lineSeparator() + "1. Add an employee" + System.lineSeparator() + "2. Remove an employee" +
                System.lineSeparator() + "3. View all employees" + System.lineSeparator() +
                "4. Calculate employee net salary"+ System.lineSeparator() + "5. Calculate employee salary bonus" +
                System.lineSeparator() + "6. Return to Main Menu");

        switch (inputManagerMenu) {
            case 1:
                controllerManager.registerEmployee();
                break;
            case 2:
                controllerManager.removeEmployee();
                break;
            case 3:
                controllerManager.viewEmployeeList();
                break;
            case 4:
                controllerManager.employeeNetSalary();
                break;
            case 5:
                controllerManager.employeeBonus();

            case 6:
                viewMain.mainMenu(controllerEmployee, controllerManager, controllerCustomer);
                break;

            default:
                System.out.println("Invalid input, please try again.");
                managerMenu(controllerEmployee, controllerManager, controllerCustomer, viewMain);
                break;
        }
        } else {
        System.out.println("Invalid Password");
        viewMain.mainMenu(controllerEmployee,controllerManager,controllerCustomer);

    }
}

