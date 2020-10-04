package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;

import java.text.ParseException;
import java.util.Scanner;

public class ViewCustomer {

        public void customerMenu(ControllerEmployee controllerEmployee, ControllerGame controllerGame,
                                 ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {
            Scanner input = new Scanner(System.in);


                System.out.println("Customer Screen - Type one of the options below:");
                System.out.println("1. Rent a game");
                System.out.println("2. Return a game");
                System.out.println("3. Return to Main Menu");

                int userOption = input.nextInt();

                if (userOption == 1) {
                    controllerGame.rentingFeature();
                } else if (userOption == 2) {
                    controllerGame.returnGame();
                } else if (userOption == 3) {
                    viewMain.mainMenu(controllerEmployee, controllerGame, controllerCustomer);
                } else {
                    System.out.println("Invalid input.");

                    input.close();
                }
            }

        }
