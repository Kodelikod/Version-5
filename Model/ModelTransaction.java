package Model;

public class ModelTransaction {

    private int itemId;
    private int customerId;
    private double totalRentCost;


    public ModelTransaction(int itemId, int customerId, double totalRentCost) {
        this.itemId = itemId;
        this.customerId = customerId;
        this.totalRentCost = totalRentCost;

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public double getTotalRentCost() {
        return totalRentCost;
    }

    public void setTotalRentCost(double totalRentCost) {
        this.totalRentCost = totalRentCost;
    }



    @Override
    public String toString() {
        return "ModelTransaction{" +
                "itemId=" + itemId +
                ", customerId=" + customerId +
                ", totalRentCost=" + totalRentCost +
                '}';
    }
}
