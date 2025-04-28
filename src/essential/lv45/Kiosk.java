package essential.lv45;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menuList;
    private final Scanner sc = new Scanner(System.in);

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {

        int selectedMenuNumber = -1;

        // 메뉴 선택 반복문
        while(selectedMenuNumber != 0) {
            int selectedItemNumber = -1;
            int i = 1;

            System.out.println("[ MAIN MENU ]");
            for(Menu menu : menuList)
            {
                System.out.println(i + ". " + menu.getMenuName());
                i++;
            }
            System.out.println("0. 종료");

            // 메뉴 선택 입력문
            try {
                selectedMenuNumber = Integer.parseInt(sc.nextLine());
                if(selectedMenuNumber < 0 || selectedMenuNumber > menuList.size()) {
                    System.out.println("올바른 카테고리를 선택해주세요.");
                    continue;
                }
                if(selectedMenuNumber == 0)
                    continue;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                continue;
            }

            // 아이템 선택 반복문
            while(selectedItemNumber != 0) {
                menuList.get(selectedMenuNumber-1).showMenuItems();
                System.out.println("0. 뒤로가기");

                // 아이템 선택 입력문
                try {
                    selectedItemNumber = Integer.parseInt(sc.nextLine());
                    if(selectedItemNumber < 0 || selectedItemNumber > menuList.get(selectedMenuNumber-1).getMenuItemList().size()) {
                        System.out.println("올바른 메뉴를 선택해주세요.");
                        continue;
                    }
                    if(selectedItemNumber == 0)
                    {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("숫자만 입력해주세요.");
                }

                List<MenuItem> menuItems = menuList.get(selectedMenuNumber-1).getMenuItemList();
                MenuItem menuItem = menuItems.get(selectedItemNumber-1);
                System.out.println("선택된 메뉴 : " + menuItem.getItemName() + " | W " + menuItem.getPrice() + " | " +
                        menuItem.getFoodDescription());
            }
        }
        System.out.println("주문을 종료합니다.");
        sc.close();
    }
}
