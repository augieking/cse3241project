import java.util.UUID;

public class Entity {
    public UUID id;
    public int year;

    public Entity(int year) {
        this.id = UUID.randomUUID();
        this.year = year;
    }
}
