import java.util.UUID;

public class MediaInstance {
    public UUID id;
    public String type;
    public String format;
    public String mediaId;
    public int orderNum;

    public MediaInstance(String type, String format, String mediaId,
            int orderNum) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.format = format;
        this.mediaId = mediaId;
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        return "MediaInstance [id=" + this.id + ", type=" + this.type
                + ", mediaId=" + this.mediaId + ", orderNum=" + this.orderNum
                + "]";
    }

}
