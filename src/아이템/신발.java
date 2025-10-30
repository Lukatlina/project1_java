package 아이템;

public class 신발 extends 장비 {

    private final int dance;

    // 생성자
    public 신발(String itemName, int price, int dance) {
        super(itemName, price);
        this.dance = dance;
    }

    public int getDance() {
        return dance;
    }

}
