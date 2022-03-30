import java.time.LocalDate;
import java.util.UUID;

public class Order {
    public UUID orderNumber;
    public String type;
    public int numDigCopies;
    public int numPhysCopies;
    public double price;
    public LocalDate arrivalDate;
    public Entity media;

    public Order(String type, int numDigCopies, int numPhysCopies, double price,
            LocalDate arrivalDate, Entity media) {
        this.type = type;
        this.orderNumber = UUID.randomUUID();
        this.numDigCopies = numDigCopies;
        this.numPhysCopies = numPhysCopies;
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.media = media;
    }

    @Override
    public String toString() {
        return "Order [orderNumber=" + this.orderNumber + ", numDigCopies="
                + this.numDigCopies + ", numPhysCopies=" + this.numPhysCopies
                + ", price=" + this.price + ", arrivalDate=" + this.arrivalDate
                + ", media=" + this.media + "]";
    }
}
