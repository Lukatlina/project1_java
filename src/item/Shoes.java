package item;

public class Shoes extends Equipment {

    private final int dance;

    // 생성자
    public Shoes(String itemName, int price, int dance) {
        super(itemName, price);
        this.dance = dance;
    }

    public int getDance() {
        return dance;
    }

}
