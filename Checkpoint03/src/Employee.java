import java.util.UUID;

public class Employee {
    public UUID id;
    public String name;

    public Employee(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
        return "'" + this.id.toString() + "'" + "," + "'" + this.name + "'";
    }

}
