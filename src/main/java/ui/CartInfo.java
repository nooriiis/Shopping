package ui;

public class CartInfo {

    private int cartItemId;
    private int cartItemQuantity;
    private String cartItemName;
    private int cartItemPrice;

    public CartInfo(int cartItemId, int cartItemQuantity, String cartItemName, int cartItemPrice) {
        this.cartItemId = cartItemId;
        this.cartItemQuantity = cartItemQuantity;
        this.cartItemName = cartItemName;
        this.cartItemPrice = cartItemPrice;
    }

    public int getCartItemId() {
        return cartItemId;
    }

    public void setCartItemId(int cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(int cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    public String getCartItemName() {
        return cartItemName;
    }

    public void setCartItemName(String cartItemName) {
        this.cartItemName = cartItemName;
    }

    public int getCartItemPrice() {
        return cartItemPrice;
    }

    public void setCartItemPrice(int cartItemPrice) {
        this.cartItemPrice = cartItemPrice;
    }
}
