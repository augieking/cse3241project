
public class Artist {
    String name;

    public Artist(String NAME) {
        this.name = NAME;
    }

    @Override
    public String toString() {
        return "'" + this.name + "'";
    }
}
