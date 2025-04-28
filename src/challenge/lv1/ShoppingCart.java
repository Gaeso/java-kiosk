package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private final List<MenuItem> cartItems = new ArrayList<>();
    private double totalAmount = 0;

    public void addCartItems(MenuItem menuItem) {
        cartItems.add(menuItem);
        totalAmount += Double.parseDouble(menuItem.getPrice());
    }

    public void showOrderTable() {
        System.out.println("[ Orders ]");
        for (MenuItem item : cartItems) {
            System.out.println(item.getItemName() + "\t| W " + item.getPrice() + " | " + item.getFoodDescription());
        }
        System.out.println("[ Total ]");
        System.out.println("W " + totalAmount);
    }

    public void orderComplete() {
        System.out.println("주문이 완료되었습니다. 가격은 W " + totalAmount + " 입니다.");
        clearCart();
    }

    public boolean isCartItemsEmpty() {
        return cartItems.isEmpty();
    }

    public void clearCart() {
        cartItems.clear();
    }
}