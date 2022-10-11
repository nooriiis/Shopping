package bo;

import db.ItemDB;
import java.util.Collection;

/**
 * Represents the logic methods and attributes for an Item.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
public class Item {

    private int itemId;
    private String itemName;
    private int itemPrice;
    private String itemInfo;

    /**
     * Creates an Item with no parameters.
     */
    protected Item(){

    }

    /**
     * Creates an Item by initializing itemId, itemName, itemPrice, itemInfo.
     * @param itemId the ID.
     * @param itemName the name of the Item.
     * @param itemPrice the price of the Item.
     * @param itemInfo the info of the Item.
     */
    protected Item(int itemId, String itemName, int itemPrice, String itemInfo){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemInfo = itemInfo;
    }

    /**
     * Creates an Item by initializing itemId, itemName, itemPrice.
     * @param itemId the ID.
     * @param itemName the name of the Item.
     * @param itemPrice the price of the Item.
     */
    protected Item(int itemId, String itemName, int itemPrice){
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    /**
     * Searches through the database to find the Items in the table "product".
     * @param items string of the name to search in the column "itemGroup" in the database.
     * @return the desired Items from the database.
     */
    public static Collection searchItems(String items){
        return ItemDB.searchItems(items);
    }

    /**
     * Gets the ID of an Item.
     * @return the ID.
     */
    public int getItemId() {
        return itemId;
    }

    /**
     * Sets the ID of an Item.
     * @param itemId the ID.
     */
    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    /**
     * Gets the name of an Item.
     * @return the name.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Sets the name of an Item.
     * @param itemName the name.
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * Gets the price of an Item.
     * @return the price.
     */
    public int getItemPrice() {
        return itemPrice;
    }

    /**
     * Sets the price of an Item.
     * @param itemPrice the price.
     */
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    /**
     * Gets the info of an Item.
     * @return the info.
     */
    public String getItemInfo() {
        return itemInfo;
    }

    /**
     * Sets the info of an Item.
     * @param itemInfo the info.
     */
    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    /**
     * General toString method containing the ID, name, price and info.
     * @return the Item string.
     */
    @Override
    public String toString(){
        return "Item: "+ itemId +'\''+" Name: " + itemName +'\''+" Price: " + itemPrice + " Info: " + itemInfo;
    }
}
