package Model;

public class ModelAlbum extends ModelSuperItem {
    // <artist>. Released in <release year>. Price:

    // attributes
    private String artist;
    private String releasedYear;
    private double albumPrice;
    private ModelSong newSong;

    public ModelAlbum(int id, String title, String genre, double dailyRentFee, boolean available,
                      String artist,String releasedYear,double albumPrice) {

        super(id, title, genre, dailyRentFee, available);
        this.artist = artist;
        this.releasedYear = releasedYear;
        this.albumPrice = albumPrice;
        this.newSong = new ModelSong("",0);
    }

    // Constructor:

    public ModelAlbum(int id, String title, String genre, double dailyRentFee, boolean available,
                      String artist,String releasedYear,double albumPrice, ModelSong newSong) {

        super(id, title, genre, dailyRentFee, available);
        this.artist = artist;
        this.releasedYear = releasedYear;
        this.albumPrice = albumPrice;
        this.newSong = newSong;
    }


    @Override
    public String toString() {
        return "ModelAlbum{" +
                "albumID=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", artist='" + artist + '\'' +
                ", releasedYear=" + releasedYear +
                ", albumPrice=" + albumPrice +
                ", dailyRent=" + getDailyRentFee() +
                ", newSong=" + newSong +
                ", available=" + getAvailable() +
                '}';
    }

}
