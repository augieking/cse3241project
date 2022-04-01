
public class Author {
    String name;

    public Author(String NAME) {
        this.name = NAME;
    }

    @Override
    public String toString() {
        return "'" + this.name + "'";
    }
}
