import java.util.ArrayList;
import java.util.UUID;

public class Audiobook extends Entity {
    public int year;
    public UUID id;
    public String title;
    public String genre;
    public int chapters;
    public int length;
    public ArrayList<String> authors;

    public Audiobook(int YEAR, String TITLE, String GENRE, int CHAPTERS,
            int LENGTH, ArrayList<String> AUTHORS) {
        super(YEAR, "Audiobook");
        this.title = TITLE;
        this.genre = GENRE;
        this.chapters = CHAPTERS;
        this.length = LENGTH;
        this.authors = AUTHORS;
        this.id = UUID.randomUUID();
        this.year = YEAR;
    }

    public void update(int YEAR, String TITLE, String GENRE, int CHAPTERS,
            int LENGTH, ArrayList<String> AUTHORS) {

        this.year = YEAR;
        this.title = TITLE;
        this.genre = GENRE;
        this.chapters = CHAPTERS;
        this.length = LENGTH;
        this.authors = AUTHORS;
    }

    @Override
    public String toString() {
        return "'" + this.id.toString() + "'" + ", " + "'" + this.title + "'"
                + ", " + "'" + this.genre + "'" + ", " + this.chapters + ", "
                + this.year + ", " + this.length;
    }
}
