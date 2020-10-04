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


    private double totalRent; //?? total rent of what??
    private ArrayList<ModelGame> allGames = new ArrayList<ModelGame>();
    private ArrayList<ModelAlbum> allAlbum = new ArrayList<>();

  //  public ControllerCustomer(double totalRent, ArrayList<ModelGame> allGames,
  //                            ArrayList<ModelAlbum> allAlbum) {
  //      this.allGames = allGames;
  //      this.allAlbum = allAlbum;
  //      this.totalRent = totalRent;
  //  }

    public ArrayList<ModelGame> getAllGames() { return allGames; }
    public void setAllGames(ArrayList<ModelGame> allGames) { this.allGames = allGames; }
    public ArrayList<ModelAlbum> getAllAlbum() { return allAlbum; }
    public void setAllAlbum(ArrayList<ModelAlbum> allAlbum) { this.allAlbum = allAlbum; }


    public void viewGameList() {
        for (int i = 0; i < getAllGames().size(); i++) {
            Scan.output(getAllGames().get(i).toString());
        }
    }

 //public void rentingItem() {
 //    viewGameList();
 //
 //
 //    Scan.output("Please insert the game ID for the game you want to rent: ");
 //    int gameSearchID = Scan.ScanInt();
 //    Scan.ScanLine();
 //
 //    for (int i = 0; i < getAllGames().size(); i++) {
 //        if (gameSearchID == getAllGames().get(i).getId() && !getAllGames().get(i).getAvailable()) {
 //            Scan.output("Game with ID " + gameSearchID + " is already rented");
 //
 //        } else if (getAllGames().get(i).getAvailable()) {
 //            Scan.output("Would you like to rent the game " + gameSearchID + " ? Please enter y/n");
 //            String answer = Scan.ScanLine();
 //
 //            if (answer.toLowerCase().equals("y")) {
 //                getAllGames().get(i).setAvailable(false);
 //                Scan.output("You have successfully rented the game!");
 //
 //            } else {
 //                rentingItem(); // vad som händer om man väljer >>NO? :
 //            }
 //        } else {
 //            Scan.output("Game with ID" + gameSearchID + " not found");
 //        }
 //    }
 //}

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
        Scan.output("Enter the date of when you rented the game dd/MM/yyyy:");
        String dateReturn = Scan.ScanLine();
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateReturn);
        long interval = new Date().getTime() - date.getTime();
        return TimeUnit.DAYS.convert(interval, TimeUnit.MILLISECONDS);
    }

    private double totalRentFee(long daysBetween, double dailyRentFee) { //what is this method for?
        double totalRentFee = daysBetween * dailyRentFee;

       // Scan.output("You must pay: " + totalRentFee + "SEK");
        return totalRentFee;
    }

    // Method for calculating total rent, used for calculating rent profit
    public void returnGame(ModelCustomer customer) throws ParseException { //Parse is used in this method to convert a string to long
        long days = daysBetween();

        ModelGame game = findGameById();
        game.setAvailable(true); //update game status

        customer.setRentingNow(-1); //update renting now
        customer.setCredits( +customer.credits(customer.getMembership())); //update customers credit status

        totalRent = days * game.getDailyRentFee();

        if (customer.getCredits() >= 5){
            totalRent = 0;
            customer.setCredits(-5);
            Scan.output("Congratulations! You have enough credits to rent this item for free!");

        } else {
            totalRent = totalRent + (days * game.getDailyRentFee()) * (customer.discount(customer.getMembership())); //hard to read?
            Scan.output("You must pay: " + totalRent + "SEK");

        }

    }

    ///////////////////// Albums /////////////////////

    public void viewAlbumList() {
        for (int i = 0; i < getAllAlbum().size(); i++) {
            Scan.output(getAllAlbum().get(i).toString());
        }

    }

 //  public void rentingItem() {            //commented bc there are three rent methods?? with the same name??
 //
 //      // View All the Items function: Means we gonna have an array list for all Items:
 //      // Items must be sorted with ID's.
 //
 //      Scan.output("Please insert the  ID for the Item you want to rent: ");
 //      int searchID = Scan.ScanInt();
 //      Scan.ScanLine();
 //
 //      for (int i = 0; i < allItems().size(); i++) {
 //          if (searchID == getAllGames().get(i).getId() && !getAllGames().get(i).getAvailable()) {
 //              Scan.output("Item with ID " + searchID + " is already rented");
 //
 //          } else if (getAllGames().get(i).getAvailable()) {
 //              Scan.output("Would you like to rent the item " + searchID + " ? Please enter y/n");
 //              String answer = Scan.ScanLine();
 //
 //              if (answer.toLowerCase().equals("y")) {
 //                  getAllGames().get(i).setAvailable(false);
 //                  Scan.output("You have successfully rented the item!");
 //
 //              } else {
 //                  rentingItem(); // vad händer om man väljer >>NO :
 //              }
 //          } else {
 //              Scan.output("Item with ID" + searchID + " not found");
 //          }
 //      }
 //  }
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

    public void rentItem(ModelCustomer customer) { //fix repeated code in this method??

        // View All the Items function: Means we gonna have an array list for all Items:
        // Items must be sorted with ID's.

        // haven't figured out how to implement this:
        // public void rentedAmountMembership (ModelCustomer) {
        //
        //        askForMembershipStatus();
        //
        //        if (membership.equals("regular")){
        //            set.BorrowedItems = +1;
        //        } else if (membership.equals("Silver") && get.BorrowedItems <=2)){ // hu skriva så att den ser rätt id på borrowed?? // this id equals
        //            set.BorrowedItems =+1;// Hur skriva på samma id??
        //        } else if (membership.equals("Gold") && (get.BorrowedItems <=4 ) ){ // hur skriva??
        //            set.BorrowedItems =+1;// Hur skriva??
        //        } else if (membership.equals("Premium") && (get.BorrowedItems <=7 ) ){ // hur skriva??
        //            set.BorrowedItems =+1;// Hur skriva??
        //        } else {
        //            Scan.output("Sorry, you have rented above your membership level. You need to return an item before you can rent more.");
        //        } return null;
        //    }

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
                        if (ModelCustomer.rentingLimit(customer.getMembership()) > customer.getRentingNow()){ //don't understand why its complaining about static??

                        getAllGames().get(i).setAvailable(false);
                        Scan.output("You have successfully rented the game!");
                        customer.setRentingNow(+1);
                        customer.setTotalRents(+1);


                        } else {
                            Scan.output("You have reached renting limit of your membership level, please return before renting");
                            //call method here to take the user back to customer view
                        }

                    } else {
                        rentItem(customer); // vad händer om man väljer >>NO :   // take user to customer menu?? instead?
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
                        if (ModelCustomer.rentingLimit(customer.getMembership()) > customer.getRentingNow()){ //don't understand why its complaining about static??
                            getAllAlbum().get(i).setAvailable(false);
                            Scan.output("You have successfully rented the album!");
                            customer.setRentingNow(+1);
                            customer.setTotalRents(+1);

                        } else {
                            Scan.output("You have reached renting limit of your membership level, please return before renting");
                            //take user back to customer menu or login start page?
                        }
                    } else {
                        rentItem(customer);; // vad händer om man väljer >>NO :
                    }
                } else {
                    Scan.output("album with ID" + albumSearchID + " not found");
                }
            }

        }
    }

  //  public void askForMembershipStatus () { //fråga om id och ta upp vilket membership kunden har
  //      Scan.output("Please enter your ID:");
  //      int userId = input.nextInt();
  //
  //      for (int i = 0; i < customerList.size(); i++){ // varför funkar inte länk mellan klasserna?
  //          Scan.output(customerList.get(i).membership); // ta upp membership status för den kunden
  //      }
  //      Scan.output("You have not entered your  id correctly, please try again.");
  //      askForMembershipStatus();
  //  }
  //      return null;
  //
  //  //  for (ModelCustomer customer : this.customerList) {
  //  //    if (customer.getMembership() == userId) {
  //  //     return membership;
  //  //    Scan.output("Please enter your membership status: ");
  //  //  String membershipStatus = input.nextLine();
















}





