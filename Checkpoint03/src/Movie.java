import java.util.ArrayList;

public class Movie extends Entity {
    public String director;
    public String genre;
    public String title;
    public ArrayList<Actor> actors;

    public Movie(int YEAR, String DIRECTOR, String GENRE, String TITLE,
            ArrayList<Actor> ACTORS) {
        super(YEAR, "Movie");
        this.director = DIRECTOR;
        this.genre = GENRE;
        this.title = TITLE;
        this.actors = ACTORS;
    }

    public void update(int YEAR, String DIRECTOR, String GENRE, String TITLE,
            ArrayList<Actor> ACTORS) {

        this.year = YEAR;
        this.director = DIRECTOR;
        this.genre = GENRE;
        this.title = TITLE;
        this.actors = ACTORS;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "year: " + this.year + "director: "
                + this.director + "genre: " + this.genre + "title: "
                + this.title;
    }
}
