package encapsulation.assigment_problems;

/**
 * Assignment Problem 5: The Shopping Cart.
 * Prices are private. Only the computed total and item count are exposed.
 */
public class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int maxItems) {
        if (maxItems < 0) {
            throw new IllegalArgumentException("Maximum items cannot be negative");
        }
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price >= 0 && itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}
