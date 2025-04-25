package essential.lv3;

public class MenuItem {

    private String itemName;
    private String price;
    private String menuDescription;

    public MenuItem(String itemName, String price, String menuDescription) {
        this.itemName = itemName;
        this.price = price;
        this.menuDescription = menuDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPrice() {
        return price;
    }

    public String getMenuDescription() {
        return menuDescription;
    }
}
