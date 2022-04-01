import java.util.UUID;

public class Employee {
    public UUID id;
    public String name;

    public Employee(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "'" + this.id.toString() + "'" + "," + "'" + this.name + "'";
    }

}
