import java.util.Calendar;

public class Order {
    public int orderNumber;
    public int numDigCopies;
    public int numPhysCopies;
    public int price;
    public Calendar arrivalDate;
    public Entity media;

    public Order(int orderNumber, int numDigCopies, int price,
            Calendar arrivalDate, Entity media) {
        this.orderNumber = orderNumber;
        this.numDigCopies = numDigCopies;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.media = media;
    }
}
