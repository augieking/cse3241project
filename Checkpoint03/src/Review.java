import java.util.UUID;

public class Review {
    public UUID reviewId;
    public Entity media;
    public int rating;

    public Review(Entity media, int RATING) {
        this.media = media;
        this.reviewId = UUID.randomUUID();
        this.rating = RATING;
    }

    @Override
    public String toString() {
        return "'" + this.reviewId.toString() + "'" + "," + this.rating;
    }

}
