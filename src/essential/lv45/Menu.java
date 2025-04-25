package essential.lv45;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private final List<MenuItem> menuItems = new ArrayList<>();
    private final String menuName;
    private final String menuHeader;

    public Menu(String menuName, List<String[]> items) {
        this.menuName = menuName;
        this.menuHeader = menuName.toUpperCase() + "MENU";
        for (String[] item : items) {
            menuItems.add(new MenuItem(item[0], item[1], item[2]));
        }
    }

    public String getMenuName() {
        return menuName;
    }
    public MenuItem getMenuItem(int index) {
        return menuItems.get(index);
    }
    public void showMenuItems(){
        System.out.println("[ " + menuHeader + " ]");
        for(int i = 0; i < menuItems.size(); i++)
        {
            System.out.println(i+1 + ". " + menuItems.get(i).getItemName() + "\t| W " +
                    menuItems.get(i).getPrice() + " | " + menuItems.get(i).getFoodDescription());
        }
    }
    public List<MenuItem> getMenuItemList() {
        return menuItems;
    }
}
