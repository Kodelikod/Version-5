package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;

import java.text.ParseException;
import java.util.Scanner;

public class ViewCustomer {

        public void customerMenu(ControllerEmployee controllerEmployee, ControllerManager controllerManager,
                                 ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {
            Scanner input = new Scanner(System.in);

            //change customer menu so that first options are login and view selection?? and return to main menu of course
                System.out.println("Customer Screen - Type one of the options below:");
                System.out.println("1. Rent a game");
                System.out.println("2. Return a game");
                System.out.println("3. Return to Main Menu");
                // on first page after login options should be view return rent review etc

                int userOption = input.nextInt();

                if (userOption == 1) { //change to switch bc this will be more than 3 menu options
                    controllerCustomer.rentItem(/*customer*/);
                } else if (userOption == 2) {
                    controllerCustomer.returnGame(/*customer*/);
                } else if (userOption == 3) {
                    viewMain.mainMenu(controllerEmployee, controllerManager, controllerCustomer);
                } else {
                    System.out.println("Invalid input.");

                    input.close();
                }
            }

        }
