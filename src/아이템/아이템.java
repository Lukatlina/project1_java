package 아이템;

// 장비, 소비 아이템으로 나눌 것 -> 로직 합쳐서 관리하기 어려워짐
// 아이템 조작시 음식물까지 코드에 영향을 줄 수도 있음 -> 적절한 분리 필요
public abstract class 아이템 {
    private final String itemName;
    private final int price;

    public 아이템(String itemName, int price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public int getPrice() {
        return price;
    }

}

