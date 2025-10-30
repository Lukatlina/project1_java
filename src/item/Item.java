package item;

public abstract class Item {
    private final String itemName;
    private final int price;

    public Item(String itemName, int price) {
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

