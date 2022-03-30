import java.util.ArrayList;
import java.util.UUID;

public class Movie extends Entity {
	public int year;
	public UUID id;
    public String director;
    public String genre;
    public String title;
    public int length;
    public ArrayList<Actor> actors;

    public Movie(int YEAR, String DIRECTOR, String GENRE, String TITLE, int LENGTH,
            ArrayList<Actor> ACTORS) {
        super(YEAR, "Movie");
        this.director = DIRECTOR;
        this.genre = GENRE;
        this.title = TITLE;
        this.length = LENGTH;
        this.actors = ACTORS;
        id = UUID.randomUUID();
        year = YEAR;
    }

    public void update(int YEAR, String DIRECTOR, String GENRE, String TITLE, int LENGTH,
            ArrayList<Actor> ACTORS) {

        this.year = YEAR;
        this.director = DIRECTOR;
        this.genre = GENRE;
        this.title = TITLE;
        this.length = LENGTH;
        this.actors = ACTORS;
    }

    @Override
    public String toString() {
        return id + ", " + title + ", " + year + ", " + director + ", " + genre;
    }
}
