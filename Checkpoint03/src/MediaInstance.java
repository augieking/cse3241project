import java.time.LocalDate;
import java.util.UUID;

public class MediaInstance {
    public UUID id;
    public String type;
    public LocalDate dueDate;
    public String returnStatus;
    public Entity media;
    public Customer customer;
    public Order order;

    public MediaInstance(String type, LocalDate dueDate, String returnStatus,
            Entity media, Customer customer, Order order) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.dueDate = dueDate;
        this.returnStatus = returnStatus;
        this.media = media;
        this.customer = customer;
        this.order = order;
    }

    @Override
    public String toString() {
        return "'" + this.id.toString() + "'" + "," + "'" + this.type + "'"
                + "," + "'" + this.media.id.toString() + "'" + "," + "'"
                + this.dueDate.toString() + "'" + "," + this.order.orderNumber;
    }

}
