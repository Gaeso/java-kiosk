package essential.lv45;

import java.util.List;
import java.util.Scanner;

public class Kiosk {

    private final List<Menu> menuList;
    private final Scanner sc = new Scanner(System.in);
    private final OrderSystem os = new OrderSystem();

    public Kiosk(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public void start() {

        int selectedMenuNumber = -1;

        // 메뉴 선택 반복문
        while(selectedMenuNumber != 0) {
            int selectedItemNumber = -1;
            int i = 1;

            // 메뉴 목록 출력
            os.showAllMenu(i, menuList);

            // 메뉴 선택 입력문
            selectedMenuNumber = os.validateAndSelectMenu(menuList);
            if(os.shouldContinue())
                continue;

            // 아이템 선택 반복문
            while(selectedItemNumber != 0) {

                // 아이템 목록 출력
                os.showAllItems(menuList, selectedMenuNumber);

                // 아이템 선택 입력
                selectedItemNumber = os.validateAndSelectItems(menuList, selectedMenuNumber);
                if(os.shouldContinue())
                    continue;

                // 선택 아이템 출력
                os.showSelectedItem(menuList, selectedMenuNumber, selectedItemNumber);
            }
        }
        System.out.println("주문을 종료합니다.");
        sc.close();
    }
}
