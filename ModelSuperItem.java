package Model;

public class ModelSuperItem {

        // Attributes in Common (Album/Game)
        // <ID> : <Title> (<genre>). <daily rent>. Status: <rent status> (Ratings)
        private int Id;
        private String title;
        private String genre;
        private double dailyRentFee;
        private boolean available = true;
        //private int ratings;

        // Super class constructor:

        public ModelSuperItem(int id, String title, String genre, double dailyRentFee, boolean available) {
            Id = id;
            this.title = title;
            this.genre = genre;
            this.dailyRentFee = dailyRentFee;
            this.available = available;
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

        // Super class toString:

        @Override
        public String toString() {
            return "Item{" +
                    "Id=" + Id +
                    ", title='" + title + '\'' +
                    ", genre='" + genre + '\'' +
                    ", dailyRentFee=" + dailyRentFee +
                    ", available=" + available +
                    '}';
        }




}

