package FunctionLayer;

public class Material {
    
    private int id;
    private String description;
    private String length;
    private String unit;
    private String desc;
    private int price;
    public Material(int id, String description, String length, String unit, String desc, int price) {
        this.id = id;
        this.description = description;
        this.length = length;
        this.unit = unit;
        this.desc = desc;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", type=" + description + ", price=" + price + ", description=" + desc + '}';
    }
    
}
