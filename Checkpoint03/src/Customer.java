import java.time.LocalDate;

public class Customer {
    public String email;
    public String name;
    public String address;
    public LocalDate birthDate;
    public String employeeId;

    public Customer(String email, String name, String address,
            LocalDate birthDate, String employee) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.birthDate = birthDate;
        this.employeeId = employee;
    }

    @Override
    public String toString() {
        return "Customer [email=" + this.email + ", name=" + this.name
                + ", address=" + this.address + ", birthDate=" + this.birthDate
                + ", employeeId=" + this.employeeId + "]";
    }

}
