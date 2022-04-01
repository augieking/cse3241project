import java.time.LocalDate;

public class Order {
    public int orderNumber;
    public String type;
    public int numDigCopies;
    public int numPhysCopies;
    public double price;
    public LocalDate arrivalDate;
    public Entity media;
    public Employee employee;

    public Order(String type, int orderNumber, int numDigCopies,
            int numPhysCopies, double price, LocalDate arrivalDate,
            Entity media, Employee employee) {
        this.type = type;
        this.orderNumber = orderNumber;
        this.numDigCopies = numDigCopies;
        this.numPhysCopies = numPhysCopies;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.media = media;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "'" + this.media.id.toString() + "'" + "," + "'" + this.type
                + "'" + "," + this.orderNumber + "," + this.numDigCopies + ","
                + this.numPhysCopies + "," + this.price + "," + "'"
                + this.arrivalDate.toString() + "'" + "," + "'"
                + this.employee.id.toString() + "'";
    }
}
