package essential.lv45;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Items items = new Items();

        List<Menu> menuList = new ArrayList<>();

        menuList.add(new Menu("Burgers", items.getBurgerItems()));
        menuList.add(new Menu("Drinks", items.getDrinkItems()));
        menuList.add(new Menu("Dessert", items.getDessertItems()));

        Kiosk kiosk = new Kiosk(menuList);
        kiosk.start();
    }
}
