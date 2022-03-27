import java.util.HashMap;

public class Actor {
	public String name;
	public HashMap<Movie, String> movieRelation = new HashMap<Movie, String>();
	
	public Actor(String NAME) {
		name = NAME;
	}
	
	public void addMovieRelation(Movie movie, String role) {
		movieRelation.put(movie, role);
	}
}
