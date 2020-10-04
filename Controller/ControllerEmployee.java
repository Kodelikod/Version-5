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
    private ModelCustomer newCustomer = new ModelCustomer("", 0);
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
        Scan.output("The total rent profit is currently: " + totalRent + " SEK");
    }

    ////////////////////////   CUSTOMER  ////////////////////////////

    public void registerCustomer() { //A customer has a unique id and a name

        Scan.output("Registering new customer \nEnter name of the customer: ");
        newCustomer.setUserId(idGenerator());
        Scan.output("ID: " + newCustomer.getUserId());
        Scan.output("Name: ");
        newCustomer.setName(Scan.ScanLine());
        allCustomers.add(newCustomer);
        Scan.output("You have successfully added a new customer:\n" + newCustomer.toString());
    }



    public void removeCustomer(){
        Scan.output("Removing employee account \nEnter employee ID: ");
        int idRemoval = Scan.ScanInt();
        Scan.ScanLine();

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
            Scan.output("Employee with ID " + idRemoval + " not found");

        }
    }

    ////////////////////////   GAMES  ////////////////////////////

    public void viewGameList() {
        for (int i = 0; i < getAllGames().size(); i++) {
            Scan.output(getAllGames().get(i).toString());
        }

    }
    // Method Register Game

    //<ID> : <Title> - by <artist>. Released in <release year>. Price:  <daily rent> SEK. Status:
    // <rent status>
    public void registerGame() {
        int gameId = getAllGames().size() + 1;  //ID Generator.
        Scan.output("Creating a Game. Please type the game’s:");
        Scan.output("ID:" + gameId);
        Scan.output("Title:");
        String title = Scan.ScanLine();
        Scan.output("Genre:");
        String genre = Scan.ScanLine();
        Scan.output("Daily Rent Fee (SEK): ");
        double dailyRentFee = Scan.ScanDouble();//assigns ID to the number of the arraylist size
        // + 1, and adds it to ArrayList ids
        allGames.add(newGame);
        //allItems.add(allGames);
        Scan.output("You have successfully added:" + "\n" + newGame.toString());
        Scan.ScanLine();
    }
    public void removeGame() {
        Scan.output("Removing game  \nEnter game ID: ");
        int idRemoval = Scan.ScanInt();
        Scan.ScanLine();

        boolean isTargetIdFound = false;

        for (int i = 0; i < getAllGames().size() && !isTargetIdFound; i++) { //search though arraylist for...
            if (getAllGames().get(i).getId() == idRemoval) { //...account with same userID as the one
                // given by user
                allGames.remove(i); // remove when found
                Scan.output("Gme with ID " + idRemoval + " successfully removed.");//... then its removed, let the user know
                isTargetIdFound = true;
            }
        }
        if (!isTargetIdFound) {
            Scan.output("Game with ID " + idRemoval + " not found");
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
        return null;
    }

    ////////////////////////   ALBUMS  ////////////////////////////

    public void viewAlbumList() {
        for (int i = 0; i < getAllAlbum().size(); i++) {
            Scan.output(getAllAlbum().get(i).toString());
        }

   }
    public void addSongs() {
        int albumId = getAllAlbum().size() + 1;  //ID Generator.
        Scan.output("Adding songs to the album. Please type the song's:");
        Scan.output("ID:" + albumId);
        Scan.output("Title:");
        String title = Scan.ScanLine();
        newSongAlbum.add(newSong);
        Scan.output("You have successfully added:" + "\n" + newAlbum.toString());
        Scan.ScanLine();
    }

    public void registerAlbum() {
        int albumId = getAllAlbum().size() + 1;  //ID Generator.
        Scan.output("Creating a Album. Please type the Album's:");
        Scan.output("ID:" + albumId);
        Scan.output("Title:");
        String title = Scan.ScanLine();
        Scan.output("Artist:");
        String artist = Scan.ScanLine();
        Scan.output("Genre:");
        String genre = Scan.ScanLine();
        Scan.output("Released:");
        String releasedYear = Scan.ScanLine();
        Scan.output("Price: ");
        double price = Scan.ScanDouble();
        Scan.output("Daily Rent Fee (SEK): ");
        double dailyRentFee = Scan.ScanDouble();//assigns ID to the number of the arraylist size
        // + 1, and adds it to ArrayList ids
        addSongs();
        allAlbum.add(newAlbum);
        //allItems.add(allAlbum);
        Scan.output("You have successfully added:" + "\n" + newAlbum.toString());
        Scan.ScanLine();
    }




    public void removeAlbum() {
        Scan.output("Removing Album  \nEnter Album ID: ");
        int idRemoval = Scan.ScanInt();
        Scan.ScanLine();

        boolean isTargetIdFound = false;

        for (int i = 0; i < getAllAlbum().size() && !isTargetIdFound; i++) { //search though arraylist
            // for...
            if (getAllAlbum().get(i).getId() == idRemoval) { //...account with same userID as the one
                // given by user
                allAlbum.remove(i); // remove when found
                Scan.output("Album with ID " + idRemoval + " successfully removed.");//... then its
                // removed, let the user know
                isTargetIdFound = true;
            }
        }
        if (!isTargetIdFound) {
            Scan.output("Album with ID " + idRemoval + " not found");
        }
    }

    public ModelAlbum findAlbumById() {
        Scan.output("Enter the ID of the album you wish to return:");
        int id = Scan.ScanInt();  // Read user input of id

        for (ModelAlbum album : this.allAlbum) {
            if (album.getId() == id) {
                return album;
            }
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




