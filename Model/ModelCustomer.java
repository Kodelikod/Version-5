package Model;

public class ModelCustomer {

    private String name;
    private int userId;
    private int credits = 0; //always start at 0 when a customer is registered, later change this back and forth
    private int totalRents = 0; //
    private int rentingNow = 0;

    //constructor method
    public ModelCustomer(String name, int userId, int credits, int totalRents, int rentingNow) {
        this.name = name;
        this.userId = userId;
        this.credits = credits;
        this.totalRents = totalRents;
        this.rentingNow = rentingNow;
    }



    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getTotalRents() {
        return totalRents;
    }

    public void setTotalRents(int totalRents) {
        this.totalRents = totalRents;
    }

    public int getRentingNow() {
        return rentingNow;
    }

    public void setRentingNow(int rentingNow) {
        this.rentingNow = rentingNow;
    }
}

