package View;
import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;
import Controller.Scan;
import java.text.ParseException;


public class ViewCustomer {

        public void customerMenu(ControllerEmployee controllerEmployee, ControllerManager controllerManager,
                                 ControllerCustomer controllerCustomer, ViewMain viewMain) throws ParseException {

        int inputCustomerMenu = Scan.readInt("Customer Screen - Type one of the options below:" +
                System.lineSeparator() + "1. Rent an item" + System.lineSeparator() + "2. Return an item" +
                System.lineSeparator() + "3. Upgrade membership" + System.lineSeparator() + "4. Search games and songs"+
                System.lineSeparator() + "5. View sorted items" + System.lineSeparator() + "6. Return to Main Menu");

            switch (inputCustomerMenu) {
                case 1:
                    int chooseItem = Scan.readInt("Press 1 for Game or press 2 for Album"); //
                    if (chooseItem == 1){
                        controllerCustomer.rentItem(null);
                    } else if (chooseItem == 2) {
                        controllerCustomer.rentItem(null);
                    } else {
                    System.out.println("Invalid input, please try again.");
                    customerMenu(controllerEmployee,controllerManager, controllerCustomer, viewMain);
                    }
                break;

                case 2:
                    int returnItem = Scan.readInt("Press 1 for return Game or press 2 for return Album");
                    if (returnItem == 1){
                        controllerCustomer.returnGame(null);
                    } else if (returnItem == 2){
                        controllerCustomer.returnGame(null);
                     } else {
                    System.out.println("Invalid input, please try again.");
                    customerMenu(controllerEmployee, controllerManager, controllerCustomer, viewMain);
                    }
                break;

                 case 3:
                     controllerCustomer.upgradeMembership();
                 break;

                case 4:
                    //Method search games and songs
                break;

                case 5:
                    //Show sorted items

                case 6:
                    viewMain.mainMenu(controllerEmployee, controllerManager, controllerCustomer);
                break;

                default:
                    System.out.println("Invalid input, please try again.");
                break;
        }
    }
}
