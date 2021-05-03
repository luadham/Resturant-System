package sample.Model;

/**
 * The type Chef.
 * @author Adham Adel
 */
public class Chef extends Staff {
    /**
     * Instantiates a new Chef.
     * @param name   the name
     * @param id     the id
     * @param salary the salary
     */
    public Chef(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.jopRole = "Chef";
    }
}
