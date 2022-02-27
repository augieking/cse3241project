import java.time.LocalDate;
import java.util.UUID;

public class Order {
    public UUID orderNumber;
    public int numDigCopies;
    public int numPhysCopies;
    public double price;
    public LocalDate arrivalDate;
    public Entity media;

    public Order (int numDigCopies, int numPhysCopies, double price,
            LocalDate arrivalDate, Entity media) {
        this.orderNumber = UUID.randomUUID();
        this.numDigCopies = numDigCopies;
        this.numPhysCopies = numPhysCopies; 
        this.price = price;
        this.arrivalDate = arrivalDate;
        this.media = media;
    }

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", numDigCopies=" + numDigCopies + ", numPhysCopies="
				+ numPhysCopies + ", price=" + price + ", arrivalDate=" + arrivalDate + ", media=" + media + "]";
	}
}
