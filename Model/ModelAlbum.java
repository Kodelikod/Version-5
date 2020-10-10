package Model;

public class ModelAlbum extends ModelSuperItem {
    // <artist>. Released in <release year>. Price:

    // attributes
    private String artist;
    private int releasedYear;
    private double albumPrice;
    private ModelSong newSong;

    public ModelAlbum(int id, String title, double dailyRentFee, boolean available,
                      String artist,int releasedYear,double albumPrice) {

        super(id, title, dailyRentFee, available);
        this.artist = artist;
        this.releasedYear = releasedYear;
        this.albumPrice = albumPrice;
        this.newSong = new ModelSong("",0);
    }

    // Constructor: // VARFÖR TVÅ?

    public ModelAlbum(int id, String title, String genre, double dailyRentFee, boolean available,
                      String artist,String releasedYear,double albumPrice, ModelSong newSong) {

        super(id, title, genre, dailyRentFee, available);
        this.artist = artist;
        this.releasedYear = releasedYear;
        this.albumPrice = albumPrice;
        this.newSong = newSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleasedYear() {
        return releasedYear;
    }

    public void setReleasedYear(int releasedYear) {
        this.releasedYear = releasedYear;
    }

    public double getAlbumPrice() {
        return albumPrice;
    }

    public void setAlbumPrice(double albumPrice) {
        this.albumPrice = albumPrice;
    }

    public ModelSong getNewSong() {
        return newSong;
    }

    public void setNewSong(ModelSong newSong) {
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
