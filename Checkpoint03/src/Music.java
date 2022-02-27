import java.util.ArrayList;

public class Music extends Entity {
    public int length;
    public String albumName;
    public String songName;
    public ArrayList<String> artists;

    public Music(int YEAR, int LENGTH, String ALBUMNAME, String SONGNAME,
            ArrayList<String> ARTISTS) {
        super(YEAR);
        this.length = LENGTH;
        this.albumName = ALBUMNAME;
        this.songName = SONGNAME;
        this.artists = ARTISTS;
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
        return "ID: " + this.id + "year: " + this.year + "album: "
                + this.albumName + "song: " + this.songName;
    }
}
