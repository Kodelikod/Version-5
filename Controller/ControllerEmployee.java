package Controller;
import Model.*;
import Controller.*;

import java.util.ArrayList;

public class ControllerEmployee {


// Attributes:

    private double totalRent;
    private ArrayList<ModelSuperItem> allItems = new ArrayList<>();
    private ArrayList<ModelGame> allGames = new ArrayList<>();
    private ArrayList<ModelAlbum>  allAlbum = new ArrayList<>();
    private ArrayList<ModelSong> newSongAlbum = new ArrayList<>();
    private ArrayList<ModelCustomer> allCustomers = new ArrayList<>();
    private ArrayList<ModelCustomer> membershipQueue = new ArrayList<>(); // create setters & getters
    private ModelCustomer newCustomer = new ModelCustomer("", 0, 0, 0, 0);
    private ModelGame newGame = new ModelGame(0,"","",0,true);
    private ModelSong newSong = new ModelSong("",0);
    private ModelAlbum newAlbum = new ModelAlbum(0,"","",0,true,"","",0,newSong);

     //constructor method is wrong here, all parameters in the constructor
    // method will be expected everytime this controller is called, which causes issues in Main
    // Constructor:
  // public ControllerEmployee(double totalRent,ArrayList<ModelSuperItem> allItems,
  //                           ArrayList<ModelGame> allGames,ArrayList<ModelAlbum> allAlbum,
  //                           ArrayList<ModelSong> newSongAlbum,
  //                           ArrayList<ModelCustomer> allCustomers, ModelCustomer newCustomer,
  //                           ModelGame newGame,ModelSong newSong,ModelAlbum newAlbum) {
  //     this.totalRent = totalRent;
  //     this.allItems = allItems;
  //     this.allGames = allGames;
  //     this.allAlbum = allAlbum;
  //     this.newSongAlbum = newSongAlbum;
  //     this.allCustomers = allCustomers;
  //     this.newCustomer= newCustomer;
  //     this.newGame = newGame;
  //     this.newSong = newSong;
  //     this.newAlbum = newAlbum;
  // }

    //Setters / Getters:

    public ArrayList<ModelGame> getAllGames() { return allGames; }
    public void setAllGames(ArrayList<ModelGame> allGames) { this.allGames = allGames; }
    public ArrayList<ModelAlbum> getAllAlbum() { return allAlbum; }
    public void setAllAlbum(ArrayList<ModelAlbum> allAlbum) { this.allAlbum = allAlbum; }
    public ArrayList<ModelSong> getNewSongAlbum() { return newSongAlbum; }
    public void setNewSongAlbum(ArrayList<ModelSong> newSongAlbum) { this.newSongAlbum = newSongAlbum; }
    public ArrayList<ModelCustomer> getAllCustomers() { return allCustomers; }
    public void setAllCustomers(ArrayList<ModelCustomer> allCustomers) { this.allCustomers = allCustomers; }
    public ModelCustomer getNewCustomer() { return newCustomer; }
    public void setNewCustomer(ModelCustomer newCustomer) { this.newCustomer = newCustomer; }
    public double getTotalRent() { return totalRent; }
    public void setTotalRent(double totalRent) { this.totalRent = totalRent; }



    public int idGenerator() {// to find four-digit number
        int idleId = 2000;
        for (int i = 0; i < getAllCustomers().size(); i++) { //search through entire arraylist of
            // userDatabase
            if (getAllCustomers().get(i).getUserId() == idleId) { //when idleId matches with already existing
                // user in userDatabase
                idleId++;
                i = 0; //start at i=0 with new id number
            } else {
                i++; //next index in arraylist
            }
        }
        return idleId;
    }

    // Method total rent profit

    public void printTotalRentProfit() {
        System.out.println("The total rent profit is currently: " + totalRent + " SEK");
    }

    ////////////////////////   CUSTOMER  ////////////////////////////

    public void registerCustomer() { //A customer has a unique id and a name

        System.out.println("Registering new customer \nEnter name of the customer: ");
        newCustomer.setUserId(idGenerator());
        System.out.println("ID: " + newCustomer.getUserId());
        newCustomer.setName(Scan.readLine("Name: "));
        allCustomers.add(newCustomer);
        System.out.println("You have successfully added a new customer:\n" + newCustomer.toString());
    }

    public void removeCustomer(){
        int idRemoval = Scan.readInt("Removing employee account \nEnter employee ID: ");

        boolean isTargetIdFound = false;

        for (int i = 0; i < getAllCustomers().size() && !isTargetIdFound; i++) { //search though arraylist for...
            if (getAllCustomers().get(i).getUserId() == idRemoval) { //...account with same userID as the one
                // given by user
                allCustomers.remove(i); // remove when found
                System.out.println("User with ID " + idRemoval + " successfully removed."); //... then its removed, let the user know
                isTargetIdFound = true; // here it means stop because we asked to iterate
                // over the array JUST in case that the isTargetFound is true.
            }
        }
        if (!isTargetIdFound){
            System.out.println("Employee with ID " + idRemoval + " not found");

        }
    }

    ////////////////////////   GAMES  ////////////////////////////

    public void viewGameList() {
        for (int i = 0; i < getAllGames().size(); i++) {
            System.out.println(getAllGames().get(i).toString());
        }

    }
    // Method Register Game

    //<ID> : <Title> - by <artist>. Released in <release year>. Price:  <daily rent> SEK. Status:
    // <rent status>
    public void registerGame() {
        int gameId = getAllGames().size() + 1;  //ID Generator.
        System.out.println("Creating a Game. Please type the game’s:");
        System.out.println("ID:" + gameId);
        String title = Scan.readLine("Title:");
        String genre = Scan.readLine("Genre:");
        double dailyRentFee = Scan.readDouble("Daily Rent Fee (SEK): ");//assigns ID to the number of the arraylist size
        // + 1, and adds it to ArrayList ids
        allGames.add(newGame)
        //allItems.add(allGames);
        System.out.println("You have successfully added:" + "\n" + newGame.toString());

    }
    public void removeGame() {
        int idRemoval = Scan.readInt("Removing game  \nEnter game ID: ");

        boolean isTargetIdFound = false;

        for (int i = 0; i < getAllGames().size() && !isTargetIdFound; i++) { //search though arraylist for...
            if (getAllGames().get(i).getId() == idRemoval) { //...account with same userID as the one
                // given by user
                allGames.remove(i); // remove when found
                System.out.println("Gme with ID " + idRemoval + " successfully removed.");//... then its removed, let the user know
                isTargetIdFound = true;
            }
        }
        if (!isTargetIdFound) {
            System.out.println("Game with ID " + idRemoval + " not found");
        }
    }


    //Method for finding dailyRentFee in a game from arraylist in Game.
    public ModelGame findGameById() {
        int id = Scan.readInt("Enter the ID of the game you wish to return:");  // Read user input of id

        for (ModelGame game : this.allGames) {
            if (game.getId() == id) {
                return game;
            }
        }
        return null;
    }

    ////////////////////////   ALBUMS  ////////////////////////////

    public void viewAlbumList() {
        for (int i = 0; i < getAllAlbum().size(); i++) {
            System.out.println(getAllAlbum().get(i).toString());
        }

   }
    public void addSongs() {
        int albumId = getAllAlbum().size() + 1;  //ID Generator.
        System.out.println("Adding songs to the album. Please type the song's:");
        System.out.println("ID:" + albumId);
        String title = Scan.readLine("Title:");
        newSongAlbum.add(newSong);
        System.out.println("You have successfully added:" + "\n" + newAlbum.toString());
    }

    public void registerAlbum() {
        int albumId = getAllAlbum().size() + 1;  //ID Generator.
        System.out.println("Creating a Album. Please type the Album's:");
        System.out.println("ID:" + albumId);
        String title = Scan.readLine("Title:");
        String artist = Scan.readLine("Artist:");
        String genre = Scan.readLine("Genre:");
        String releasedYear = Scan.readLine("Released:");
        double price = Scan.readDouble("Price: ");
        double dailyRentFee = Scan.readDouble("Daily Rent Fee (SEK): ");//assigns ID to the number of the arraylist size
        // + 1, and adds it to ArrayList ids
        addSongs();
        allAlbum.add(newAlbum);
        //allItems.add(allAlbum);
        System.out.println("You have successfully added:" + "\n" + newAlbum.toString());
    }

    public void removeAlbum() {
        int idRemoval = Scan.readInt("Removing Album  \nEnter Album ID: ");

        boolean isTargetIdFound = false;

        for (int i = 0; i < getAllAlbum().size() && !isTargetIdFound; i++) { //search though arraylist
            // for...
            if (getAllAlbum().get(i).getId() == idRemoval) { //...account with same userID as the one
                // given by user
                allAlbum.remove(i); // remove when found
                System.out.println("Album with ID " + idRemoval + " successfully removed.");//... then its
                // removed, let the user know
                isTargetIdFound = true;
            }
        }
        if (!isTargetIdFound) {
            System.out.println("Album with ID " + idRemoval + " not found");
        }
    }

    public ModelAlbum findAlbumById() {
        int id = Scan.readInt("Enter the ID of the album you wish to return:");  // Read user input of id

        for (ModelAlbum album : this.allAlbum)
            if (album.getId() == id) {
                return album;
            }
        return null;
    }



    //method to find customer by userID
    public ModelCustomer findCustomerById(int userId){
        for (int i=0; i<allCustomers.size(); i++){
            if(allCustomers.get(i).getUserId()==userId){
                return allCustomers.get(i);
            }

        }
        return null;
    }
}

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










