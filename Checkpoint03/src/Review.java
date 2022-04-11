import java.util.UUID;

public class Review {
    public UUID reviewId;
    public String mediaId;
    public int rating;

    public Review(String media, int RATING) {
        this.reviewId = UUID.randomUUID();
        this.mediaId = media;
        this.rating = RATING;
    }

    @Override
    public String toString() {
        return "'" + this.reviewId.toString() + "'" + "," + this.rating;
    }

}
