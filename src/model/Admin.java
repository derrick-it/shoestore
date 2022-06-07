package model;

public class Admin extends User {
    private String name;

    public Admin(String username, String password, String name) {
        super("A",username, password);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
