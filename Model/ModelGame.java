package Model;

public class ModelGame extends ModelSuperItem {

    // Gonna inherit all the attributes from the super class Item:
    public ModelGame(int id, String title, String genre, double dailyRentFee, boolean available) {
        super(id, title, genre, dailyRentFee, available);
    }




        // Constructor:
        @Override
        public String toString (){
            String availability;
            if (this.getAvailable()){
                availability = "Available";
            } else {
                availability = "Not available at the moment";
            }
            return "ID: " + super.getId() + System.lineSeparator() + "Title: " + this.getTitle() +
                    System.lineSeparator() + "Genre: " + this.getGenre() + System.lineSeparator() +
                    "Daily rent fee: SEK" + this.getDailyRentFee() + System.lineSeparator() + availability;
        }
}



