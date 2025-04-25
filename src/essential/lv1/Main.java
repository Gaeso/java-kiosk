package essential.lv1;

import java.util.Scanner;

public class Main {

    public static void showMenu() {
        System.out.println("[ SHACK SHACK MENU ]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. 종료");
    }

    public static void main(String[] args) {
        int selectNumber = -1;

        Scanner sc = new Scanner(System.in);

        while(selectNumber != 0) {
            showMenu();
            try {
                selectNumber = Integer.parseInt(sc.nextLine());
                if(selectNumber < 0 || selectNumber > 4)
                {
                    System.out.println("존재하지 않는 메뉴입니다.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
                continue;
            }

            switch(selectNumber)
            {
                case 1 -> System.out.println("ShackBurger 주문완료.");
                case 2 -> System.out.println("SmokeShack 주문완료.");
                case 3 -> System.out.println("CheeseBurger 주문완료.");
                case 4 -> System.out.println("Hamburger 주문완료.");
            }
        }
        System.out.println("주문을 종료합니다.");
        sc.close();
    }
}
