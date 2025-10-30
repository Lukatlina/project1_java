package item;

public class Costume extends Equipment {
    private final int charm;
    // 생성자

    public Costume(String itemName, int price, int charm) {
        super(itemName, price);
        this.charm = charm;
    }

    public int getCharm() {
        return charm;
    }

}
