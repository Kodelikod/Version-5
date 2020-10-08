package Model;

public class ModelSuperItem {

    //The totalRentFee calculation for returning a specific game should be in the game and not in the controller.
    //The game object has the information of its daily price, so it should be calculated in the Game object.
    //I suggest adjusting that in your GameController class. This argument also applies to Employee and the calculation
    //of its netSalary in the EmployeeController.

        // Attributes in Common (Album/Game)
        // <ID> : <Title> (<genre>). <daily rent>. Status: <rent status> (Ratings)
        private int Id;
        private String title;
        private String genre;
        private double dailyRentFee;
        private boolean available = true;
        private int ratings = 0 ;


        //Recall to fix the visibility of your attributes in your GameController, some of the attributes
        // (input and totalRent) are not private. Also, consider adding Constructors to your controllers as
        // a way to initialize the variable.

        // Super class constructor:

        public ModelSuperItem(int id, String title, String genre, double dailyRentFee, boolean available, int ratings) {
            Id = id;
            this.title = title;
            this.genre = genre;
            this.dailyRentFee = dailyRentFee;
            this.available = available;
            this.ratings = ratings;
        }
        // Super class Setters && Getters:

        public int getId() { return Id; }
        public void setId(int id) { Id = id; }
        public String getTitle() { return title; }
        public void setTitle(String title) { this.title = title; }
        public String getGenre() { return genre; }
        public void setGenre(String genre) { this.genre = genre; }
        public double getDailyRentFee() { return dailyRentFee; }
        public void setDailyRentFee(double dailyRentFee) { this.dailyRentFee = dailyRentFee; }
        public boolean getAvailable() { return available; }
        public void setAvailable(boolean available) { this.available = available; }
        public int getRatings() {return ratings;}
        public void setRatings (int ratings) {this.ratings = ratings;}

        public void retrieveAverageRating (){

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

        }


        // Super class toString:

        @Override
        public String toString() {
            return "Item{" +
                    "Id=" + Id +
                    ", title='" + title + '\'' +
                    ", genre='" + genre + '\'' +
                    ", dailyRentFee=" + dailyRentFee +
                    ", available=" + available +
                    ", ratings =" + getRatings() +
                    '}';
        }




}

