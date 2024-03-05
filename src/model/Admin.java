package model;

public class Admin {
    /**
     * admin_ID(8), a_password(6), name
     */
    private String admin_ID;
    private String a_password;
    private String name;

    public Admin(String admin_ID, String a_password, String name) {
        this.admin_ID = admin_ID;
        this.a_password = a_password;
        this.name = name;
    }

    public String getAdmin_ID() {
        return admin_ID;
    }

    public void setAdmin_ID(String admin_ID) {
        this.admin_ID = admin_ID;
    }

    public String getA_password() {
        return a_password;
    }

    public void setA_password(String a_password) {
        this.a_password = a_password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
