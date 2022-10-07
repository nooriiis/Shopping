package bo;

import db.ItemDB;
import java.util.Collection;

public class Item {

    private int itemId;
    private String itemName;
    private int itemPrice;
    private String itemInfo;

    public static Collection searchItems(String items){
        return ItemDB.searchItems(items);
    }

    protected Item(){

    }

    protected Item(int itemId, String itemName, int itemPrice, String itemInfo){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemInfo = itemInfo;
    }

    protected Item(int itemId, String itemName, int itemPrice){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    @Override
    public String toString(){
        return "Item: "+ itemId +'\''+" Name: " + itemName +'\''+" Price: " + itemPrice + " Info: " + itemInfo;
    }
}
