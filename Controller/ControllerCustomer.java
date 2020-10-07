package Controller;

import Model.ModelAlbum;
import Model.ModelCustomer;
import Model.ModelGame;
import Model.ModelSuperItem;
import View.ViewMain;
import Controller.Scan;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

//You can also simplify your ID matching on controllers. Notice that you often do: list.get(i).getID() == id.
// Since you do that very often, you can create a method inside each object that has an id. This method would be
// named hasSameID( ID ) or matchID(id) and returns a boolean. Which would make your if statements much shorter to:
// list.get(i).hasSameID( ID ).

public class ControllerCustomer {

   private double totalRent; //?? total rent of what??
   private ArrayList<ModelGame> allGames = new ArrayList<ModelGame>();
   private ArrayList<ModelAlbum> allAlbum = new ArrayList<>();
   private ControllerEmployee controllerEmployee;
   private Scan scan = new Scan();
   private ArrayList<ModelCustomer> allCustomers = new ArrayList<>();
   private ModelMessage newMessage = new ModelMessage(0,0,false,null);
   private ArrayList<ModelMessage> allMessages = new ArrayList<>();
   private ArrayList<ModelSuperItem> allItems = new ArrayList<>();
    ArrayList<ModelMessage> myInbox = new ArrayList<>();

    public ControllerCustomer(double totalRent, ArrayList<ModelGame> allGames,
                              ArrayList<ModelAlbum> allAlbum) {
        this.allGames = allGames;
        this.allAlbum = allAlbum;
        this.totalRent = totalRent;
    }

    public ControllerCustomer (ControllerEmployee controllerEmployee) {
        this.controllerEmployee = controllerEmployee;
    }

    public ArrayList<ModelGame> getAllGames() { return allGames; }
    public void setAllGames(ArrayList<ModelGame> allGames) { this.allGames = allGames; }
    public ArrayList<ModelAlbum> getAllAlbum() { return allAlbum; }
    public void setAllAlbum(ArrayList<ModelAlbum> allAlbum) { this.allAlbum = allAlbum; }

    public void viewGameList() {
        for (int i = 0; i < getAllGames().size(); i++) {
            System.out.println(getAllGames().get(i).toString());
        }
    }

 //public void rentingItem() {
 //    viewGameList();
 //    System.out.println("Please insert the game ID for the game you want to rent: ");
 //    int gameSearchID = Scan.ScanInt();
 //    Scan.ScanLine();
 //
 //    for (int i = 0; i < getAllGames().size(); i++) {
 //        if (gameSearchID == getAllGames().get(i).getId() && !getAllGames().get(i).getAvailable()) {
 //            System.out.println("Game with ID " + gameSearchID + " is already rented");
 //
 //        } else if (getAllGames().get(i).getAvailable()) {
 //            System.out.println("Would you like to rent the game " + gameSearchID + " ? Please enter y/n");
 //            String answer = Scan.ScanLine();
 //
 //            if (answer.toLowerCase().equals("y")) {
 //                getAllGames().get(i).setAvailable(false);
 //                System.out.println("You have successfully rented the game!");
 //
 //            } else {
 //                rentingItem(); // vad som händer om man väljer >>NO? :
 //            }
 //        } else {
 //            System.out.println("Game with ID" + gameSearchID + " not found");
 //        }
 //    }
 //}

    //Notice that in some parts you have for loops with sentinel variables to break the for loops.
    // In this case its best you use a while loop with an iterator to the collection. Your while
    //   condition will check if the iterator.hasNext() and if the object was found based on the
    //   matching ID. Currently it’s a bit hard to read your for loops (e.g., line 81 of ControllerGame).

    //Method for finding dailyRentFee in a game from arraylist in Game.
    public ModelGame findGameById() {
        int id = Scan.readInt("Enter the ID of the game you wish to return:");  // Read user input of id

        for (ModelGame game : this.allGames) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null; // varför null och inte " att det inte finns i systememt. "
    }


    //For the date, try using the LocalDate library in Java. The Date library is difficult to use and was
    // later replaced by LocalDate in newer versions of Java since LocalDate has an implementation that
    // is easier to use.

    //Method for calculating how many days the customer rented a game. Private because this is not used in main.
    private long getDaysBetween() throws ParseException {
        String dateReturn = Scan.readLine("Enter the date of when you rented the game dd/MM/yyyy:");
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateReturn);
        long interval = new Date().getTime() - date.getTime();
        return TimeUnit.DAYS.convert(interval, TimeUnit.MILLISECONDS);
    }

    private double totalRentFee(long getDaysBetween, double dailyRentFee) { //what is this method for?
        double totalRentFee = getDaysBetween * dailyRentFee;

       // System.out.println("You must pay: " + totalRentFee + "SEK");
        return totalRentFee;
    }

    // Method for calculating total rent, used for calculating rent profit
//    public void returnGame(ModelCustomer customer) throws ParseException { //Parse is used in this method to convert a string to long
//        long days = getDaysBetween();
//
//        ModelGame game = findGameById();
//        game.setAvailable(true); //update game status
//
//        customer.setRentingNow(-1); //update renting now
//        customer.setCredits( +customer.credits(customer.getMembership())); //update customers credit status
//
//        totalRent = days * game.getDailyRentFee();
//
//        if (customer.getCredits() >= 5){
//            totalRent = 0;
//            customer.setCredits(-5);
//            System.out.println("Congratulations! You have enough credits to rent this item for free!");
//
//        } else {
//            totalRent = totalRent + (days * game.getDailyRentFee()) * (customer.discount(customer.getMembership())); //hard to read?
//            System.out.println("You must pay: " + totalRent + "SEK");
//
//        }
//
//    }
//
//    ///////////////////// Albums /////////////////////

    public void viewAlbumList() {
        for (int i = 0; i < getAllAlbum().size(); i++) {
            System.out.println(getAllAlbum().get(i).toString());
        }

    }

 //  public void rentingItem() {            //commented bc there are three rent methods?? with the same name??
 //
 //      // View All the Items function: Means we gonna have an array list for all Items:
 //      // Items must be sorted with ID's.
 //
 //      System.out.println("Please insert the  ID for the Item you want to rent: ");
 //      int searchID = Scan.ScanInt();
 //      Scan.ScanLine();
 //
 //      for (int i = 0; i < allItems().size(); i++) {
 //          if (searchID == getAllGames().get(i).getId() && !getAllGames().get(i).getAvailable()) {
 //              System.out.println("Item with ID " + searchID + " is already rented");
 //
 //          } else if (getAllGames().get(i).getAvailable()) {
 //              System.out.println("Would you like to rent the item " + searchID + " ? Please enter y/n");
 //              String answer = Scan.ScanLine();
 //
 //              if (answer.toLowerCase().equals("y")) {
 //                  getAllGames().get(i).setAvailable(false);
 //                  System.out.println("You have successfully rented the item!");
 //
 //              } else {
 //                  rentingItem(); // vad händer om man väljer >>NO :
 //              }
 //          } else {
 //              System.out.println("Item with ID" + searchID + " not found");
 //          }
 //      }
 //  }



    public ModelGame findItemById() {
        int id = Scan.readInt("Enter the ID of the item you wish to return:");  // Read user input of id

        for (ModelSuperItem item : allItems) {
            if (item.getId() == id) {
                return (ModelGame) item;
            }
        }
        return null;
    }

    public ModelSuperItem findItemById (int itemId){

        boolean isTargetIdFound = false;

        for (int i = 0; i < allItems.size() && !isTargetIdFound; i++){
            if (allItems.get(i).getId() == itemId){
                isTargetIdFound = true;
                return allItems.get(i);
            }
        }
        if (!isTargetIdFound) {
            int option = Scan.readInt("Item with ID " + itemId + " not found.");
            //call method here to take back to customer menu
        }
        return null;
    }
    //////////////////////////7 another solution:

    public void rentGame (ModelCustomer customer, int itemId){
        //MAKE CUSTOMER SUBCLASSES FIRST

    }



 //  public void rentItem(ModelCustomer customer) { //fix repeated code in this method??
 //
 //      // View All the Items function: Means we gonna have an array list for all Items:
 //      // Items must be sorted with ID's.
 //
 //      // haven't figured out how to implement this:
 //      // public void rentedAmountMembership (ModelCustomer) {
 //      //
 //      //        askForMembershipStatus();
 //      //
 //      //        if (membership.equals("regular")){
 //      //            set.BorrowedItems = +1;
 //      //        } else if (membership.equals("Silver") && get.BorrowedItems <=2)){ // hu skriva så att den ser rätt id på borrowed?? // this id equals
 //      //            set.BorrowedItems =+1;// Hur skriva på samma id??
 //      //        } else if (membership.equals("Gold") && (get.BorrowedItems <=4 ) ){ // hur skriva??
 //      //            set.BorrowedItems =+1;// Hur skriva??
 //      //        } else if (membership.equals("Premium") && (get.BorrowedItems <=7 ) ){ // hur skriva??
 //      //            set.BorrowedItems =+1;// Hur skriva??
 //      //        } else {
 //      //            System.out.println("Sorry, you have rented above your membership level. You need to return an item before you can rent more.");
 //      //        } return null;
 //      //    }
 //
 //      String answer = Scan.readLine("Please type G for games or A for albums: ");
 //
 //      if (answer.equalsIgnoreCase("G")){
 //          viewGameList();
 //
 //          int gameSearchID = Scan.readInt("Please insert the game ID for the game you want to rent: ");
 //
 //          for (int i = 0; i < getAllGames().size(); i++) {
 //              if (gameSearchID == getAllGames().get(i).getId() && !getAllGames().get(i).getAvailable()) {
 //                  System.out.println("Game with ID " + gameSearchID + " is already rented");
 //
 //              } else if (getAllGames().get(i).getAvailable()) {
 //                  String answerRent = Scan.readLine("Would you like to rent the game " + gameSearchID + " ? Please enter y/n");
 //
 //                  if (answerRent.toLowerCase().equals("y")) {
 //                      if (ModelCustomer.rentingLimit(customer.getMembership()) > customer.getRentingNow()){ //don't understand why its complaining about static??
 //
 //                      getAllGames().get(i).setAvailable(false);
 //                      System.out.println("You have successfully rented the game!");
 //                      customer.setRentingNow(+1);
 //                      customer.setTotalRents(+1);
 //
 //
 //                      } else {
 //                          System.out.println("You have reached renting limit of your membership level, please return before renting");
 //                          //call method here to take the user back to customer view
 //                      }
 //
 //                  } else {
 //                      rentItem(customer); // vad händer om man väljer >>NO :   // take user to customer menu?? instead?
 //                  }
 //              } else {
 //                  System.out.println("Game with ID" + gameSearchID + " not found");
 //              }
 //
 //          }
 //      } else if (answer.equalsIgnoreCase("A")){
 //          viewGameList();
 //
 //          int albumSearchID = Scan.readInt("Please insert the album ID for the game you want to rent: ");
 //
 //          for (int i = 0; i < getAllGames().size(); i++) {
 //              if (albumSearchID == getAllAlbum().get(i).getId() && !getAllAlbum().get(i).getAvailable()) {
 //                  System.out.println("Album with ID " + albumSearchID + " is already rented");
 //
 //              } else if (getAllAlbum().get(i).getAvailable()) {
 //                  String answerRent = Scan.readLine("Would you like to rent the album " + albumSearchID + " ? Please " +
 //                          "enter y/n");
 //
 //
 //                  if (answerRent.toLowerCase().equals("y")) {
 //                      if (ModelCustomer.rentingLimit(customer.getMembership()) > customer.getRentingNow()){ //don't understand why its complaining about static??
 //                          getAllAlbum().get(i).setAvailable(false);
 //                          System.out.println("You have successfully rented the album!");
 //                          customer.setRentingNow(+1);
 //                          customer.setTotalRents(+1);
 //
 //                      } else {
 //                          System.out.println("You have reached renting limit of your membership level, please return before renting");
 //                          //take user back to customer menu or login start page?
 //                      }
 //                  } else {
 //                      rentItem(customer);; // vad händer om man väljer >>NO :
 //                  }
 //              } else {
 //                  System.out.println("album with ID" + albumSearchID + " not found");
 //              }
 //          }
 //
 //      }
 //  }

  //  public void askForMembershipStatus () { //fråga om id och ta upp vilket membership kunden har
  //      int userId = Scan.readInt("Please enter your ID:");
  //
  //      for (int i = 0; i < customerList.size(); i++){ // varför funkar inte länk mellan klasserna?
  //          System.out.println (customerList.get(i).membership); // ta upp membership status för den kunden
  //      }
  //      System.out.println ("You have not entered your  id correctly, please try again.");
  //      askForMembershipStatus();
  //  }
  //      return null;
  //
  //  //  for (ModelCustomer customer : this.customerList) {
  //  //    if (customer.getMembership() == userId) {
  //  //     return membership;
  //  //  String membershipStatus = input.readLine("Please enter your membership status: ");

//Upgrade membership

    ArrayList<ModelCustomer> membershipList = new ArrayList<ModelCustomer>();

    public void upgradeMembership() {
        int userID = Scan.readInt("Please enter your customer ID:");
        ModelCustomer customer = controllerEmployee.findCustomerById(userID);
 //   public void upgradeMembership() {
 //       int userID = Scan.readInt("Please enter your customer ID:");
 //       ModelCustomer customer = controllerEmployee.findCustomerById(userID);
 //
 //       if (customer.getMembership().equals("regular")) {
 //           // add to list for silver membership
 //           System.out.println("You have now applied for a Silver membership.");
 //       } else if (customer.getMembership().equals("silver")){
 //           // add to list for gold membership
 //           System.out.println("You have now applied for a Gold membership.");
 //       } else if (customer.getMembership().equals("gold")){
 //           // add to list for platinum membership
 //           System.out.println("You have now applied for a Platinum membership");
 //       } else {
 //           System.out.println("You can't upgrade your membership.");
 //       }
 //   }

    public void sendMessage (int senderId) {

        int recId = Scan.readInt("Please type the id of the recipient: ");

        String message;
        boolean targetId = false;

        if (customer.getMembership().equals("regular")) {
            membershipList.add(customer);
            System.out.println("You have now applied for a Silver membership.");
        } else if (customer.getMembership().equals("silver")){
            membershipList.add(customer);
            System.out.println("You have now applied for a Gold membership.");
        } else if (customer.getMembership().equals("gold")){
            membershipList.add(customer);
            System.out.println("You have now applied for a Platinum membership");
        } else {
            System.out.println("You can't upgrade your membership.");
        for (int i = 0; i < allCustomers.size() && !targetId; i++) {
            if (allCustomers.get(i).getUserId() == recId) {
                Scan.scanLine(); //this is necessary!!!! DONT REMOVE bc the program ends without it
                message = Scan.readLine("Type your message: ");

                newMessage.setSenderID(senderId);
                newMessage.setRecipientID(recId);
                newMessage.setMessage(message);
                allMessages.add(newMessage);
                targetId = true;
            }
        }
        if (!targetId) {
            int option = Scan.readInt("ID not found. " + Scan.EOL + "Press 1 to try again with valid ID " +
                    "or press 2 to go back to your login page");
            if (option == 1) {
                sendMessage(senderId);
            } else {
                //insert method here that takes user to their own account page
            }
        }
    }

    //method to view all unread/new messages
    public void viewUnMessage (int recId) {
        ArrayList<ModelMessage> unreadInbox = new ArrayList<>();
        int listLine = 1;

        for (int i=0; i<allMessages.size() && allMessages.get(i).getRecipientID() == recId &&   //messages to the right recipient and is also unread
                allMessages.get(i).isRead() == false; i++){
            Scan.print(listLine + ". " + allMessages.get(i).getSenderID() + Scan.EOL);
            unreadInbox.add(allMessages.get(i));
            listLine++;
        }

        int option = Scan.readInt("Enter the number of the message that you want to open: ");
        Scan.print(unreadInbox.get(option - 1).toString());
        unreadInbox.get(option - 1).setRead(true);

        int newOption = Scan.readInt("Press 1 to go back to your inbox, or press 2 to go back to you login page");

        if (newOption == 1){
            viewUnMessage(recId);
        } else {
            //method here that takes the user back to their login page
        }
    }

    public void assignMembership(){
        for (ModelCustomer i : membershipList) {
            System.out.println("You are currently managing the membership of" + i.toString());
            String request = Scan.readLine("Enter 'yes' to approve or 'no' to decline:");
            if (request.toLowerCase().equals("yes")) {
                if (i.getMembership().equals("regular")) {
                    i.setMembership("silver");
                } else if (i.getMembership().equals("silver")) {
                    i.setMembership("gold");
                } else if (i.getMembership().equals("gold")) {
                    i.setMembership("platinum");
                }
            } else if (request.toLowerCase().equals("no")) {
                membershipList.remove(i);
                System.out.println("You have declined the membership request");
            } else {
                System.out.println("Invalid input");
            }
        }

    }

    public void viewMyInbox(int userId){

        int listLine = 1;

        for (int i=0; i<allMessages.size() && allMessages.get(i).getRecipientID()==userId; i++){
            Scan.print(listLine + ". " + allMessages.get(i).getSenderID() + Scan.EOL);
            myInbox.add(allMessages.get(i));
            listLine++;
        }

    }

    //Remove a message: There should be a menu option that allows customers to remove a message from their inbox.
    // When the customer selects the option, all their messages are shown to them as a numbered list.
    // Then, they are asked for the index (message number) that they want to delete. The message on that index
    // should be removed from their inbox. The system should print the message “The message you wanted to remove
    // has been deleted.”. Please be mindful of wrong inputs here, particularly with an index that doesn’t exist.


    public void removeMessage(int userId){
        viewMyInbox(userId);

        int option = Scan.readInt("Enter the number of the message that you want to remove: ");

        myInbox.remove(option-1);

    }

}






