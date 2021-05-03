package sample.Model;

/**
 * The type Manager.
 * @author Adham Adel
 */
public class Manager extends Staff {
    private static Manager manager;
    private Manager(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.jopRole = "Manager";
    }
    public Manager createManager(String name, String id, double salary) {
        manager = new Manager(name, id, salary);
        return manager;
    }
}
