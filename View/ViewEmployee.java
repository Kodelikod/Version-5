package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;
import Controller.Scan;

import java.text.ParseException;
import java.util.Scanner;

public class ViewEmployee {

        public void employeeMenu(ControllerEmployee controllerEmployee, ControllerManager controllerManager,
                                 ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {

            String password = Scan.readLine("Please insert your password: ");

            if(password.equals("password123")){

                int inputEmployeeMenu = Scan.readInt("Employee Screen - Type one of the options below:" +
                        System.lineSeparator() + "1. Register a game" + System.lineSeparator() + "2. Register an song album" +
                        System.lineSeparator() + "3. Remove item" + System.lineSeparator() + "4. Register customer"+
                        System.lineSeparator() + "5. Assign and modify membership" + System.lineSeparator() + "6. Remove customer" +
                        System.lineSeparator() + "7. Show total rent profit" + System.lineSeparator() +
                        "8. View all items" + "9. Return to Main menu");

                switch (inputEmployeeMenu) {
                    case 1: controllerEmployee.registerGame();
                    break;
                    case 2: ControllerEmployee.registerAlbum();
                    break;
                    case 3: controllerEmployee.removeGame(); // Change to remove item
                    break;
                    case 4: controllerEmployee.registerCustomer();
                    break;
                    case 5: controllerEmployee.assignMembership();
                    break;
                    case 6: controllerEmployee.removeCustomer();
                    break;
                    case 7: controllerEmployee.printTotalRentProfit();
                        break;
                    case 8: controllerEmployee.viewGameList(); // Change to items list
                        break;
                    case 9: viewMain.mainMenu(controllerEmployee, controllerManager, controllerCustomer);
                    break;
                    default: System.out.println("Your inserted option's number is not valid, please insert " +
                            "a number between 1 - 9.");

                }

            }else {
                System.out.println("Invalid Password");
                viewMain.mainMenu(controllerEmployee,controllerManager,controllerCustomer);
            }

        }

    }

