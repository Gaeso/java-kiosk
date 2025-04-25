package essential.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuItems = new ArrayList<>();

    // 생성자에서 MenuItems를 인자로 받아서 입력한다.
    public Kiosk(List<String[]> items) {
        for (String[] item : items) {
            menuItems.add(new MenuItem(item[0], item[1], item[2]));
        }
    }

    public void start() {
        int selectNumber = -1;

        Scanner sc = new Scanner(System.in);

        while(selectNumber != 0) {
            // 메뉴 리스트 출력
            System.out.println("[ SHACKSHACK Burger]");
            for(int i = 0; i < menuItems.size(); i++)
            {
                System.out.println(i+1 + ". " + menuItems.get(i).getItemName() + "\t| W " +
                        menuItems.get(i).getPrice() + " | " + menuItems.get(i).getMenuDescription());
            }
            System.out.println("0. 종료");

            try {
                selectNumber = Integer.parseInt(sc.nextLine());
                if(selectNumber < 0 || selectNumber > menuItems.size())
                {
                    throw new IllegalArgumentException();
                }
                if(selectNumber == 0)
                {
                    continue;
                }
                MenuItem selectedMenu = menuItems.get(selectNumber - 1);
                System.out.println("선택된 메뉴 : " + selectedMenu.getItemName() + " , W "
                        + selectedMenu.getPrice() + " , " + selectedMenu.getMenuDescription());

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println("존재하지 않는 메뉴입니다.");
            }
        }
        System.out.println("주문을 종료합니다.");
        sc.close();
    }
}
