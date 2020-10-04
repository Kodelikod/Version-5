import Controller.ControllerCustomer;
import Controller.ControllerEmployee;
import View.ViewCustomer;
import View.ViewEmployee;
import View.ViewMain;
import View.ViewManager;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        ControllerAlbum controllerAlbum = new ControllerAlbum();
        ControllerCustomer controllerCustomer = new ControllerCustomer();
        ControllerEmployee controllerEmployee = new ControllerEmployee();
        ControllerGame controllerGame = new ControllerGame();
        ViewMain viewMain = new ViewMain();
        ViewCustomer viewCustomer = new ViewCustomer();
        ViewManager viewManager = new ViewManager();
        ViewEmployee viewEmployee = new ViewEmployee();

        viewMain.welcome(controllerEmployee, controllerGame, controllerCustomer);


    }
}

