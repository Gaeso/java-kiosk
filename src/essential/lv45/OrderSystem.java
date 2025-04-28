package essential.lv45;

import java.util.List;
import java.util.Scanner;

// 메뉴 출력, 사용자의 입력 처리를 관리하는 클래스
public class OrderSystem implements AutoCloseable {

    private final Scanner sc;
    private boolean breakFlag = false;

    public OrderSystem() {
        sc = new Scanner(System.in);
    }

    // 스캐너를 클래스가 사라질때 close하기 위해
    @Override
    public void close() {
        sc.close();
    }

    public void showAllMenu(int i, List<Menu> menuList) {
        System.out.println("[ MAIN MENU ]");
        for(Menu menu : menuList)
        {
            System.out.println(i + ". " + menu.getMenuName());
            i++;
        }
        System.out.println("0. 종료");
    }

    public int validateAndSelectMenu(List<Menu> menuList) {
        breakFlag = false;
        try {
            int selectedMenuNumber = Integer.parseInt(sc.nextLine());
            if(selectedMenuNumber < 0 || selectedMenuNumber > menuList.size()) {
                System.out.println("올바른 카테고리를 선택해주세요.");
                breakFlag = true;
                return -1;
            }
            if(selectedMenuNumber == 0) {
                breakFlag = true;
                return -1;
            }
            return selectedMenuNumber;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            breakFlag = true;
            return -1;
        }
    }

    public void showAllItems(List<Menu> menuList, int selectedMenuNumber) {
        menuList.get(selectedMenuNumber-1).showMenuItems();
        System.out.println("0. 뒤로가기");
    }

    public int validateAndSelectItems(List<Menu> menuList,int selectedMenuNumber) {
        breakFlag = false;
        try {
            int selectedItemNumber = Integer.parseInt(sc.nextLine());
            if(selectedItemNumber < 0 || selectedItemNumber > menuList.get(selectedMenuNumber-1).getMenuItemList().size()) {
                System.out.println("올바른 메뉴를 선택해주세요.");
                breakFlag = true;
                return -1;
            }
            if(selectedItemNumber == 0)
            {
                breakFlag = true;
                return -1;
            }
            return selectedItemNumber;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            breakFlag = true;
            return -1;
        }
    }

    public void showSelectedItem(List<Menu> menuList, int selectedMenuNumber, int selectedItemNumber) {
        List<MenuItem> menuItems = menuList.get(selectedMenuNumber-1).getMenuItemList();
        MenuItem menuItem = menuItems.get(selectedItemNumber-1);
        System.out.println("선택된 메뉴 : " + menuItem.getItemName() + " | W " + menuItem.getPrice() + " | " +
                menuItem.getFoodDescription());
    }

    public boolean shouldContinue() {
        return breakFlag;
    }
}
