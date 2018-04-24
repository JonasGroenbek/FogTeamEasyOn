package FunctionLayer;

public class Material {
    
    private int id;
    private String type;
    private int price;
    private String description;

    public Material(int id, String type, int price, String description) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", type=" + type + ", price=" + price + ", description=" + description + '}';
    }
    
}
