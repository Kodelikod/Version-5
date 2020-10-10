package Model;

public class ModelRating {

    private int number; // STRING?
    private String review;

    public ModelRating(int number, String review) {
        this.number = number;
        this.review = review;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }


}
