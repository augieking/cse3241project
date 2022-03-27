import java.util.UUID;

public class Review {
	public UUID mediaId, reviewId;
	public int rating;
	
	public Review(UUID MEDIAID, int RATING) {
		mediaId = MEDIAID;
		reviewId = UUID.randomUUID();
		rating = RATING;
	}	
}
