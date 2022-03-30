import java.util.ArrayList;
import java.time.LocalDate;
import java.util.UUID;

public class Music extends Entity {
	public UUID id;
    public String songName;
    public int length;
    public String albumName;
    public String genreName;
    public int year;
    public ArrayList<String> artists;

    public Music(int YEAR, int LENGTH, String ALBUMNAME, String SONGNAME, String GENRENAME,
            ArrayList<String> ARTISTS) {
        super(YEAR, "Music");
        this.length = LENGTH;
        this.albumName = ALBUMNAME;
        this.songName = SONGNAME;
        this.artists = ARTISTS;
        year = YEAR;
        genreName = GENRENAME;
    }

    public void update(int YEAR, int LENGTH, String ALBUMNAME, String SONGNAME,
            ArrayList<String> ARTISTS) {
        this.year = YEAR;
        this.length = LENGTH;
        this.albumName = ALBUMNAME;
        this.songName = SONGNAME;
        this.artists = ARTISTS;
    }

    @Override
    public String toString() {
        return id + ", " + songName + ", " + length + ", " + albumName + ", " + genreName + ", " + year;
    }
}
