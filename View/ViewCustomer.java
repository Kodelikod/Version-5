package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;
import Controller.Scan;

import java.text.ParseException;
import java.util.Scanner;

public class ViewCustomer {

        public void customerMenu(ControllerEmployee controllerEmployee, ControllerManager controllerManager,
                                 ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {

            //change customer menu so that first options are login and view selection?? and return to main menu of course
                Scan.output("Customer Screen - Type one of the options below:");
                Scan.output("1. Rent a game");
                Scan.output("2. Return a game");
                Scan.output("3. Return to Main Menu");
                // on first page after login options should be view return rent review etc

                int userOption = Scan.ScanInt();

                if (userOption == 1) { //change to switch bc this will be more than 3 menu options
                    controllerCustomer.rentItem(/*customer*/);
                } else if (userOption == 2) {
                    controllerCustomer.returnGame(/*customer*/);
                } else if (userOption == 3) {
                    viewMain.mainMenu(controllerEmployee, controllerManager, controllerCustomer);
                } else {
                    Scan.output("Invalid input.");
                }
            }

        }
