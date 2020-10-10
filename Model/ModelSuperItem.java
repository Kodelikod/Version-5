package Model;

import java.util.ArrayList;

public class ModelSuperItem {

    //The totalRentFee calculation for returning a specific game should be in the game and not in the controller.
    //The game object has the information of its daily price, so it should be calculated in the Game object.
    //I suggest adjusting that in your GameController class. This argument also applies to Employee and the calculation
    //of its netSalary in the EmployeeController.

        // Attributes in Common (Album/Game)
        // <ID> : <Title> (<genre>). <daily rent>. Status: <rent status> (Ratings)
        private int Id;
        private String title;
        private double dailyRentFee;
        private boolean available = true;
        private int timesRented;
        public ArrayList<ModelRating> ratings = new ArrayList<>(); // MAKE PRIVATEEEEEEEE
        private ArrayList<ModelSuperItem> allItems = new ArrayList<>();

        //Recall to fix the visibility of your attributes in your GameController, some of the attributes
        // (input and totalRent) are not private. Also, consider adding Constructors to your controllers as
        // a way to initialize the variable.

        // Super class constructor:

        public ModelSuperItem(int id, String title, double dailyRentFee, boolean available, int timesRented
                              ArrayList<ModelRating> ratings, ArrayList<ModelSuperItem> allItems) {
            this.Id = id;
            this.title = title;
            this.dailyRentFee = dailyRentFee;
            this.available = available;
            this.timesRented = timesRented;
            this.ratings = ratings;
            this.allItems = allItems;

        }
        // Super class Setters && Getters:

        public int getId() { return Id; }
        public void setId(int id) { Id = id; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public double getDailyRentFee() { return dailyRentFee; }
        public void setDailyRentFee(double dailyRentFee) { this.dailyRentFee = dailyRentFee; }
        public boolean getAvailable() { return available; }
        public void setAvailable(boolean available) { this.available = available; }
        public int getRatings() {return ratings;}
        public void setRatings (int rating) {this.ratings = ratings;}
        public int getTimesRented() { return timesRented; }
        public void setTimesRented(int timesRented) { this.timesRented = timesRented; }

        public ArrayList<ModelSuperItem> getAllItems() { return allItems; }
        public void setAllItems(ArrayList<ModelSuperItem> allItems) { this.allItems = allItems; }
        /*  public void retrieveAverageRating (){

            public int ratings (String ratings){
                if(this.getMembership().equals("silver")){
                    return 1;

                } else if(this.getMembership().equals("gold")){
                    return 2;

                } else if(this.getMembership().equals("platinum")){
                    return 3;

                } else {
                    return 0;

                }
            }

        } */

        public double averageRating(ArrayList<ModelRating> ratings) {
            int sum;
            for(int i=0; i<this.ratings.size(); i++) {
                int number = ratings.get(i).getNumber();
                sum = sum + number;
            }
            double mean = ((double)sum) / (this.ratings.size()); // Källa: Lecture3_ 0909
            return mean;
        }

        public void searchItems(){

        }


        // Super class toString:

        @Override   // SKA DENNA ENS HA EN TOSTRING? VI KOMMER JU ALDRIG ANVÄNDA DEN?
        public String toString() {
            return "Item{" +
                    "Id=" + Id +
                    ", title='" + title + '\'' +
                    ", dailyRentFee=" + dailyRentFee +
                    ", available=" + available +
                    ", timesRented=" + timesRented + " times." +
                    ", ratings =" + getRatings() +
                    '}';
        }




}

