package sample.Model;

/**
 * The type Staff.
 * @author Adham Adel
 */
public abstract class Staff {
    String name;
    String id;
    String jopRole;
    double salary;
    Account account;

    public Account getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getJopRole() {
        return jopRole;
    }

    public double getSalary() {
        return salary;
    }
}
