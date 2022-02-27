import java.util.Calendar;
import java.util.UUID;

public class MediaInstance {
    public UUID id;
    public String type;
    public Calendar dueDate;
    public String returnStatus;
    public UUID mediaID;
    public String customerEmail;

    public MediaInstance(String type, Calendar dueDate, String returnStatus,
            UUID mediaID, String customerEmail) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.dueDate = dueDate;
        this.returnStatus = returnStatus;
        this.mediaID = mediaID;
        this.customerEmail = customerEmail;
    }

}
