package 아이템;

public class 의상 extends 장비 {
    private final int charm;
    // 생성자

    public 의상(String itemName, int price, int charm) {
        super(itemName, price);
        this.charm = charm;
    }

    public int getCharm() {
        return charm;
    }

}
