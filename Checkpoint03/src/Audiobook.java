import java.util.ArrayList;

public class Audiobook extends Entity {
    public String title;
    public String genre;
    public int chapters;
    public int length;
    public ArrayList<String> authors;

    public Audiobook(int YEAR, String TITLE, String GENRE, int CHAPTERS,
            int LENGTH, ArrayList<String> AUTHORS) {
        super(YEAR);
        this.title = TITLE;
        this.genre = GENRE;
        this.chapters = CHAPTERS;
        this.length = LENGTH;
        this.authors = AUTHORS;
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
        return "ID: " + this.id + "year: " + this.year + "title: " + this.title
                + "genre: " + this.genre + "chapters: " + this.chapters
                + "length: " + this.length;
    }
}
