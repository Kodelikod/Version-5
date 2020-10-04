package Model;

public class ModelCustomer {

    private String name;
    private int userId;

    //constructor method
    public ModelCustomer(String name, int userId) {
        this.name = name;
        this.userId = userId;
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



    @Override
    public String toString() {
        return "\nName: " + name + "\nUser ID: " + userId;
    }
}


