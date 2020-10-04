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
                System.out.println("Employee Screen - Type one of the options below:");
                System.out.println(
                        "1. Register a game"+"\n"+
                                "2. Remove a game"+"\n"+
                                "3. Register a customer"+"\n"+
                                "4. Remove a customer"+"\n"+
                                "5. Show total rent profit"+"\n" +
                                "6. View all games"+"\n"+
                                "7. Return to Main Menu");
                //maybe add message of current amount of membership requests, and add an option to view them?

                int employeeOptionDigit = Scan.ScanInt();

                switch (employeeOptionDigit) {
                    case 1: controllerEmployee.registerGame();
                    break;
                    case 2: controllerEmployee.removeGame();
                    break;
                    case 3: controllerEmployee.registerCustomer();
                    break;
                    case 4: controllerEmployee.removeCustomer();
                    break;
                    case 5: controllerEmployee.printTotalRentProfit();
                    break;
                    case 6: controllerEmployee.viewGameList();
                    break;
                    case 7: viewMain.mainMenu(controllerEmployee, controllerManager, controllerCustomer);
                    break;
                    default: System.out.println("Your inserted option's number is not valid, please insert " +
                            "a number between 1 - 7.");
                }

            }else {
                System.out.println("Invalid Password");
                viewMain.mainMenu(controllerEmployee,controllerManager,controllerCustomer);
            }

        }

    }

