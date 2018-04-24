package FunctionLayer;

public class Order {
    private int id;
    private int userID;
    private int price;
    private int materialID;
    private int height;
    private int length;
    private int width;
    private int roofID;
    private int shedID;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMaterial() {
        return materialID;
    }

    public void setMaterial(int material) {
        this.materialID = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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

    public int getRoofID() {
        return roofID;
    }

    public void setRoofID(int roofID) {
        this.roofID = roofID;
    }

    public int getShed() {
        return shedID;
    }

    public void setShed(int shed) {
        this.shedID = shed;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", userID=" + userID + ", price=" + price + ", material=" + materialID + ", height=" + height + ", length=" + length + ", width=" + width + ", roofID=" + roofID + ", shed=" + shedID + '}';
    }
}
