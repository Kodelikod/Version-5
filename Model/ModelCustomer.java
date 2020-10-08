package Model;

public class ModelCustomer {

    private String name;
    private int userId;
    private String membership = "regular"; // to always be regular when a customer is made
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
    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
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






    public int rentingLimit (String membership){

        if(this.getMembership().equals("silver")){
            return 3;

        } else if(this.getMembership().equals("gold")){
            return 5;

        } else if(this.getMembership().equals("platinum")){
            return 7;

        } else {
        return 1;

        }
    }

    public double discount (String membership){

        if(this.getMembership().equals("silver")){
            return 0.9;

        } else if(this.getMembership().equals("gold")){
            return 0.85;

        } else if(this.getMembership().equals("platinum")){
            return 0.75;

        } else {
            return 1.0;

        }
    }

    public int credits (String membership){
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

    @Override
    public String toString() {
        return "ID: " + this.getUserId() + System.lineSeparator() + "Name: " + this.getName() +
                System.lineSeparator() + "Membership type: " + this.getMembership() + System.lineSeparator() +
                "Number of total items rented: " + this.getTotalRents() + System.lineSeparator() +
                "Amount of currently rented items: " + this.getRentingNow() + System.lineSeparator() +
                "Current credits: " + this.getCredits();
    }

}