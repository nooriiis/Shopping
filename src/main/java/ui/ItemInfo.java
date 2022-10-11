package ui;

public class ItemInfo {

    private int itemId;
    private String itemName;
    private int itemPrice;
    private String itemInfo;
    private int itemQuantity;

    public ItemInfo(int itemId, String itemName, int itemPrice, String itemInfo) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemInfo = itemInfo;
    }

    public ItemInfo(int itemId, int itemQuantity, String itemName, int itemPrice) {
        this.itemId = itemId;
        this.itemQuantity = itemQuantity;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }


}
