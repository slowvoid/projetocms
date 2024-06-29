package cca.dsoo.ufscar.cms.model;

public class UserModel extends Model{
    private String name;
    private String email;
    private String password;

    public UserModel() {
        super();
    }

    public void SetName(String inName) {
        this.name = inName;
    }

    public String Getname() {
        return this.name;
    }

    public void SetEmail(String inEmail) {
        this.email = inEmail;
    }

    public String GetEmail() {
        return this.email;
    }

    public void SetPassword(String inPassword) {
        this.password = inPassword;
    }

    public String GetPassword() {
        return this.password;
    }
}
