package essential.lv2;

public class MenuItem {

    private String itemName;
    private double price;
    private String menuDescription;

    public MenuItem(String itemName, double price, String menuDescription) {
        this.itemName = itemName;
        this.price = price;
        this.menuDescription = menuDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getMenuDescription() {
        return menuDescription;
    }
}
