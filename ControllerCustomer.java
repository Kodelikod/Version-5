package Controller;
import Model.*;
import Controller.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class ControllerCustomer {


    private double totalRent;
    private ArrayList<ModelGame> allGames = new ArrayList<ModelGame>();
    private ArrayList<ModelAlbum> allAlbum = new ArrayList<>();

    public ControllerCustomer(double totalRent, ArrayList<ModelGame> allGames,
                              ArrayList<ModelAlbum> allAlbum) {
        this.allGames = allGames;
        this.allAlbum = allAlbum;
        this.totalRent = totalRent;
    }

    public ArrayList<ModelGame> getAllGames() { return allGames; }
    public void setAllGames(ArrayList<ModelGame> allGames) { this.allGames = allGames; }
    public ArrayList<ModelAlbum> getAllAlbum() { return allAlbum; }
    public void setAllAlbum(ArrayList<ModelAlbum> allAlbum) { this.allAlbum = allAlbum; }


    public void viewGameList() {
        for (int i = 0; i < getAllGames().size(); i++) {
            Scan.output(getAllGames().get(i).toString());
        }
    }

    public void rentingItem() {
        viewGameList();


        Scan.output("Please insert the game ID for the game you want to rent: ");
        int gameSearchID = Scan.ScanInt();
        Scan.ScanLine();

        for (int i = 0; i < getAllGames().size(); i++) {
            if (gameSearchID == getAllGames().get(i).getId() && !getAllGames().get(i).getAvailable()) {
                Scan.output("Game with ID " + gameSearchID + " is already rented");

            } else if (getAllGames().get(i).getAvailable()) {
                Scan.output("Would you like to rent the game " + gameSearchID + " ? Please enter y/n");
                String answer = Scan.ScanLine();

                if (answer.toLowerCase().equals("y")) {
                    getAllGames().get(i).setAvailable(false);
                    Scan.output("You have successfully rented the game!");

                } else {
                    rentingFeature(); // vad händer om man väljer >>NO :
                }
            } else {
                Scan.output("Game with ID" + gameSearchID + " not found");
            }
        }
    }

    //Method for finding dailyRentFee in a game from arraylist in Game.
    public ModelGame findGameById() {
        Scan.output("Enter the ID of the game you wish to return:");
        int id = Scan.ScanInt();  // Read user input of id

        for (ModelGame game : this.allGames) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null; // varför nll och inte " att det inte finns i systememt. "
    }


    //Method for calculating how many days the customer rented a game. Private because this is not used in main.
    private long daysBetween() throws ParseException {
        Scanner input = new Scanner(System.in);
        Scan.output("Enter the date of when you rented the game dd/MM/yyyy:");
        String dateReturn = input.nextLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateReturn);
        long interval = new Date().getTime() - date.getTime();
        return TimeUnit.DAYS.convert(interval, TimeUnit.MILLISECONDS);
    }

    private void printTotalRentFee(long daysBetween, double dailyRentFee) {
        double totalRentFee = daysBetween * dailyRentFee;

        Scan.output("You must pay: " + totalRentFee + "SEK");

    }

    // Method for calculating total rent, used for calculating rent profit
    public void returnGame() throws ParseException { //Parse is used in this method to convert a string to long
        long days = daysBetween();
        ModelGame game = findGameById();
        game.setAvailable(true);
        printTotalRentFee(days, game.getDailyRentFee());
        totalRent = totalRent + (days * game.getDailyRentFee());
    }

    ///////////////////// Albums /////////////////////

    public void viewAlbumList() {
        for (int i = 0; i < getAllAlbum().size(); i++) {
            Scan.output(getAllAlbum().get(i).toString());
        }

    }

    public void rentingItem() {

        // View All the Items function: Means we gonna have an array list for all Items:
        // Items must be sorted with ID's.

        Scan.output("Please insert the  ID for the Item you want to rent: ");
        int searchID = Scan.ScanInt();
        Scan.ScanLine();

        for (int i = 0; i < allItems().size(); i++) {
            if (searchID == getAllGames().get(i).getId() && !getAllGames().get(i).getAvailable()) {
                Scan.output("Item with ID " + searchID + " is already rented");

            } else if (getAllGames().get(i).getAvailable()) {
                Scan.output("Would you like to rent the item " + searchID + " ? Please enter y/n");
                String answer = Scan.ScanLine();

                if (answer.toLowerCase().equals("y")) {
                    getAllGames().get(i).setAvailable(false);
                    Scan.output("You have successfully rented the item!");

                } else {
                    rentingItem(); // vad händer om man väljer >>NO :
                }
            } else {
                Scan.output("Item with ID" + searchID + " not found");
            }
        }
    }
    public ModelGame findItemById() {
        Scan.output("Enter the ID of the item you wish to return:");
        int id = Scan.ScanInt();  // Read user input of id

        for (ModelSuperItem item : this.allItems) {
            if (item.getId() == id) {
                return (ModelGame) item;
            }
        }
        return null;
    }
    //////////////////////////7 another solution:

    public void rentingItem() {

        // View All the Items function: Means we gonna have an array list for all Items:
        // Items must be sorted with ID's.

        Scan.output("Please type G for games or A for albums: ");
        String answer = Scan.ScanLine();

        if (answer.equalsIgnoreCase("G")){
            viewGameList();


            Scan.output("Please insert the game ID for the game you want to rent: ");
            int gameSearchID = Scan.ScanInt();
            Scan.ScanLine();

            for (int i = 0; i < getAllGames().size(); i++) {
                if (gameSearchID == getAllGames().get(i).getId() && !getAllGames().get(i).getAvailable()) {
                    Scan.output("Game with ID " + gameSearchID + " is already rented");

                } else if (getAllGames().get(i).getAvailable()) {
                    Scan.output("Would you like to rent the game " + gameSearchID + " ? Please enter y/n");
                    String answerRent = Scan.ScanLine();

                    if (answerRent.toLowerCase().equals("y")) {
                        getAllGames().get(i).setAvailable(false);
                        Scan.output("You have successfully rented the game!");

                    } else {
                        rentingItem();; // vad händer om man väljer >>NO :
                    }
                } else {
                    Scan.output("Game with ID" + gameSearchID + " not found");
                }

            }
        } else if (answer.equalsIgnoreCase("A")){
            viewGameList();


            Scan.output("Please insert the album ID for the game you want to rent: ");
            int albumSearchID = Scan.ScanInt();
            Scan.ScanLine();

            for (int i = 0; i < getAllGames().size(); i++) {
                if (albumSearchID == getAllAlbum().get(i).getId() && !getAllAlbum().get(i).getAvailable()) {
                    Scan.output("Album with ID " + albumSearchID + " is already rented");

                } else if (getAllAlbum().get(i).getAvailable()) {
                    Scan.output("Would you like to rent the album " + albumSearchID + " ? Please " +
                            "enter y/n");
                    String answerRent = Scan.ScanLine();

                    if (answerRent.toLowerCase().equals("y")) {
                        getAllAlbum().get(i).setAvailable(false);
                        Scan.output("You have successfully rented the album!");

                    } else {
                        rentingItem();; // vad händer om man väljer >>NO :
                    }
                } else {
                    Scan.output("album with ID" + albumSearchID + " not found");
                }
            }

        }
    }
}





