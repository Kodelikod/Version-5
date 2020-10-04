import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import Controller.ControllerManager;
import View.ViewCustomer;
import View.ViewEmployee;
import View.ViewMain;
import View.ViewManager;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

      //  ControllerAlbum controllerAlbum = new ControllerAlbum();
        ControllerCustomer controllerCustomer = new ControllerCustomer(); //constructor issue
        ControllerEmployee controllerEmployee = new ControllerEmployee(); //this is the issue mentioned in controller employee with the constructor method the parenthesis becomes red
        ControllerManager controllerManager = new ControllerManager(); //constructor issue
      //  ControllerGame controllerGame = new ControllerGame();
        ViewMain viewMain = new ViewMain();
        ViewCustomer viewCustomer = new ViewCustomer();
        ViewManager viewManager = new ViewManager();
        ViewEmployee viewEmployee = new ViewEmployee();

        viewMain.welcome(controllerEmployee, controllerManager, controllerCustomer);


    }
}

