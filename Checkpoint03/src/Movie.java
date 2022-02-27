import java.util.ArrayList;
import java.util.Map;

public class Movie implements Entity {
	public int id;
	public int year;
	public String director;
	public String genre;
	public String title;
	public int length;
	public ArrayList<Actor> actors;

	public Movie(int ID, int YEAR, String DIRECTOR, String GENRE, String TITLE, int LENGTH, ArrayList ACTORS) {
		id = ID;
		year = YEAR;
		director = DIRECTOR;
		genre = GENRE;
		title = TITLE;
		length = LENGTH;
		actors = ACTORS;
	}
	
	public void update( int YEAR, String DIRECTOR, String GENRE, String TITLE, int LENGTH, ArrayList ACTORS) {

		year = YEAR;
		director = DIRECTOR;
		genre = GENRE;
		title = TITLE;
		length = LENGTH;
		actors = ACTORS;
	}
}
