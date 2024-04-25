package bean;
public class Type {
    private String brand;
    private String model;
    private String license_plate;
    private  int price;
    private  int number;
    public Type() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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