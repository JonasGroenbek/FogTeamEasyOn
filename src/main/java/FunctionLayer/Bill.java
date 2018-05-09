package FunctionLayer;
public class Bill {
    private int screws;
    private int wood;
    private int bracket;

    public int getScrews() {
        return screws;
    }

    public void setScrews(int screws) {
        this.screws = screws;
    }

    public int getWood() {
        return wood;
    }

    public void setWood(int wood) {
        this.wood = wood;
    }

    public int getBracket() {
        return bracket;
    }

    public void setBracket(int bracket) {
        this.bracket = bracket;
    }

    public Bill(int screws, int wood, int bracket) {
        this.screws = screws;
        this.wood = wood;
        this.bracket = bracket;
    }
}
