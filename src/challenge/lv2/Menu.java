package challenge.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Menu {

    private final List<MenuItem> menuItems = new ArrayList<>();
    private final String menuName;
    private final String menuHeader;

    public Menu(String menuName, List<String[]> items) {
        this.menuName = menuName;
        this.menuHeader = menuName.toUpperCase() + " MENU";
        for (String[] item : items) {
            menuItems.add(new MenuItem(item[0], item[1], item[2]));
        }
    }

    public String getMenuName() {
        return menuName;
    }

    public void showMenuItems(){
        System.out.println("[ " + menuHeader + " ]");

        //IntStream을 이용해 메뉴 아이템들을 출력하기. For 문을 이런식으로 바꿀 수 있다.
        IntStream.range(0, menuItems.size())
                .forEach(i -> System.out.println(
                        (i + 1) + ". " + menuItems.get(i).getItemName() + "\t| W " +
                                menuItems.get(i).getPrice() + " | " +
                                menuItems.get(i).getFoodDescription()
                ));
    }
    public List<MenuItem> getMenuItemList() {
        return menuItems;
    }
}
