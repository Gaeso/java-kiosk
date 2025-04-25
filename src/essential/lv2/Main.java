package essential.lv2;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        menuItems.add(new MenuItem("ShackBurger",6.9,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack",8.9,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger",6.9,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger",5.4,"비프패티를 기반으로 야채가 들어간 기본버거"));

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
                continue;
            } catch (IllegalArgumentException e) {
                System.out.println("존재하지 않는 메뉴입니다.");
                continue;
            }
        }
        System.out.println("주문을 종료합니다.");
        sc.close();
    }
}
