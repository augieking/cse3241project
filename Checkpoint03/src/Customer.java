import java.time.LocalDate;

public class Customer {
    public String email;
    public String name;
    public String address;
    public LocalDate birthDate;
    public Employee employee;

    public Customer(String email, String name, String address,
            LocalDate birthDate, Employee employee) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "'" + this.email + "'" + "," + "'" + this.name + "'" + "," + "'"
                + this.address.toString() + "'" + "," + "'"
                + this.employee.id.toString() + "'";
    }

}
