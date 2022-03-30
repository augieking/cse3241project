import java.time.LocalDate;

public class Customer {
    public String email;
    public String address;
    public LocalDate birthDate;
    public Employee employee;

    public Customer(String email, String address, LocalDate birthDate,
            Employee employee) {
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.employee = employee;
    }

}
