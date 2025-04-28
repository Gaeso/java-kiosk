package challenge.lv2;

// 상세 아이템들을 관리하는 클래스
public class MenuItem {

    private final String itemName;
    private final String price;
    private final String foodDescription;

    public MenuItem(String itemName, String price, String foodDescription) {
        this.itemName = itemName;
        this.price = price;
        this.foodDescription = foodDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPrice() {
        return price;
    }

    public String getFoodDescription() {
        return foodDescription;
    }
}
