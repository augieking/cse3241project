import java.util.HashMap;

public class Actor {
    public String name;
    public HashMap<Movie, String> movieRelation = new HashMap<Movie, String>();

    public Actor(String NAME) {
        this.name = NAME;
    }

    public void addMovieRelation(Movie movie, String role) {
        this.movieRelation.put(movie, role);
    }

    @Override
    public String toString() {
        return "'" + this.name + "'";
    }
}
