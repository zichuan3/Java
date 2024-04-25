package bean;
public class User {
    private String username;
    private String password;
    private int type;
    private String brand;
    private String model;
    private String license_plate;
    private  int price;
    private  int number;
    public User() {
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setModel(String model) {
        this.model=model;
    }

    public String getModel() {
        return model;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    public int getPrice(){return price;}

    public void setNumber(int number) {
        this.number=number;
    }

    public int getNumber(){return number;}

    public void setLicense_plate(String license_plate) {
        this.license_plate=license_plate;
    }

    public String getLicense_plate(){return license_plate;}
}
