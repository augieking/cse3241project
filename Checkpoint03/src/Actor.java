import java.util.HashMap;

public class Actor {
    public String name, role;
    public HashMap<Movie, String> movieRelation = new HashMap<Movie, String>();

    public Actor(String NAME, String ROLE) {
        this.name = NAME;
        this.role = ROLE;
    }

    public void addMovieRelation(Movie movie, String role) {
        this.movieRelation.put(movie, role);
    }

    @Override
    public String toString() {
        return "'" + this.name + "'";
    }
}
