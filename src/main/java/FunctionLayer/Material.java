package FunctionLayer;

public class Material {
    
    private int id;
    private String type;
    private String name;
    private int price;
    private String description;

    public Material(int id, String type, String name, int price, String description) {
        this.id = id;
        this.type = type;
        this.name = name;
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
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", type=" + type + ", price=" + price + ", description=" + description + '}';
    }
    
}
