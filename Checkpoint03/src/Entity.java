import java.util.UUID;

public class Entity {
    public UUID id;
    public int year;
    public String type;

    public Entity(int year, String type) {
        this.id = UUID.randomUUID();
        this.year = year;
        this.type = type;
    }
}
