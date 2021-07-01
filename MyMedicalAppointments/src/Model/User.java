package Model;

public abstract class User {
    private int id;
    private String name;
    private String addres;
    private String email;
    private String phoneNumber;


    public User(String name, String email){
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() > 10){
            System.out.println("El numero telefonico debe de ser de 10 digitos");
        }else if (phoneNumber.length() == 10){
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "Model.User: " + name + ", Email: " +email+
                "\nAddreess: "+addres+ ", Phone: " +phoneNumber;
    }

    public abstract void showDataUser();


}
