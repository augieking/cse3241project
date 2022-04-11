import java.time.LocalDate;

public class Order {
    public int orderNumber;
    public String type;
    public int numDigCopies;
    public int numPhysCopies;
    public double price;
    public LocalDate arrivalDate;
    public String mediaId;
    public String employeeId;
    public int activated;

    public Order(String type, int orderNumber, int numDigCopies,
            int numPhysCopies, double price, LocalDate arrivalDate,
            String media, String employee, int activated) {
        this.type = type;
        this.orderNumber = orderNumber;
        this.numDigCopies = numDigCopies;
        this.numPhysCopies = numPhysCopies;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.mediaId = media;
        this.employeeId = employee;
        this.activated = activated;
    }

    @Override
    public String toString() {
        return "'" + this.mediaId + "'" + "," + "'" + this.type + "'" + ","
                + this.orderNumber + "," + this.numDigCopies + ","
                + this.numPhysCopies + "," + this.price + "," + "'"
                + this.arrivalDate.toString() + "'" + "," + "'"
                + this.employeeId + "'";
    }
}
