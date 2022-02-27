import java.util.ArrayList;

public class Movie implements Entity {
    public int id;
    public int year;
    public String director;
    public String genre;
    public String title;
    public int length;
    public ArrayList<Actor> actors;

    public Movie(int ID, int YEAR, String DIRECTOR, String GENRE, String TITLE,
            int LENGTH, ArrayList<Actor> ACTORS) {
        this.id = ID;
        this.year = YEAR;
        this.director = DIRECTOR;
        this.genre = GENRE;
        this.title = TITLE;
        this.length = LENGTH;
        this.actors = ACTORS;
    }

    public void update(int YEAR, String DIRECTOR, String GENRE, String TITLE,
            int LENGTH, ArrayList<Actor> ACTORS) {

        this.year = YEAR;
        this.director = DIRECTOR;
        this.genre = GENRE;
        this.title = TITLE;
        this.length = LENGTH;
        this.actors = ACTORS;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "year: " + this.year + "director: "
                + this.director + "genre: " + this.genre + "title: "
                + this.title + "length: " + this.length;
    }
}
