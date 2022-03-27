import java.time.LocalDate;
import java.util.UUID;

public class MediaInstance {
    public UUID id;
    public String type;
    public LocalDate dueDate;
    public String returnStatus;
    public Entity media;
    public Customer customer;

    public MediaInstance(String type, LocalDate dueDate, String returnStatus,
            Entity media, Customer customer) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.dueDate = dueDate;
        this.returnStatus = returnStatus;
        this.media = media;
        this.customer = customer;
    }

}
