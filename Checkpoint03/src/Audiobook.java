import java.util.ArrayList;

public class Audiobook implements Entity{
	public int id;
	public int year;
	public String title;
	public String genre;
	public int chapters;
	public int length;
	public ArrayList<String> authors;
	
	public Audiobook(int ID, int YEAR, String TITLE, String GENRE, int CHAPTERS, int LENGTH, ArrayList AUTHORS) {
		id = ID;
		year = YEAR;
		title = TITLE;
		genre = GENRE;
		chapters = CHAPTERS;
		length = LENGTH;
		authors = AUTHORS;
	}
	
	public void update(int YEAR, String TITLE, String GENRE, int CHAPTERS, int LENGTH, ArrayList AUTHORS) {

		year = YEAR;
		title = TITLE;
		genre = GENRE;
		chapters = CHAPTERS;
		length = LENGTH;
		authors = AUTHORS;
	}
}
