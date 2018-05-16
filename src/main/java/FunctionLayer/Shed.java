package FunctionLayer;

public class Shed {
    private int id;
    private int length;
    private int width;
    private int price;

    public Shed(int id, int length, int width, int price) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.price = price;
    }
    public Shed(int length, int width, int price) {
        this.length = length;
        this.width = width;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Shed{" + "id=" + id + ", length=" + length + ", width=" + width + ", price=" + price + '}';
    }
    
}
