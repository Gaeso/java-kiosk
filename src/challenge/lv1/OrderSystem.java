package challenge.lv1;

import java.util.List;
import java.util.Scanner;

// 메뉴 출력, 사용자의 입력 처리를 관리하는 클래스
public class OrderSystem implements AutoCloseable {

    private final Scanner sc;
    private boolean continueFlag = false; // true : continue
    private boolean breakFlag = false;
    private boolean menuFlag = false; // false : 일반메뉴, true : 장바구니 메뉴
    private final ShoppingCart shoppingCart = new ShoppingCart();

    public OrderSystem() {
        sc = new Scanner(System.in);
    }

    // Scanner 를 클래스가 사라질때 닫아준다.
    @Override
    public void close() {
        sc.close();
    }

    // 메뉴 목록을 보여주는 메소드.
    public void showAllMenu(int i, List<Menu> menuList) {
        System.out.println("[ MAIN MENU ]");
        for(Menu menu : menuList)
        {
            System.out.println(i + ". " + menu.getMenuName());
            i++;
        }
        System.out.println("0. 종료");

        // 쇼핑카트가 비어있지 않으면 Order Menu를 출력한다.
        if(!shoppingCart.isCartItemsEmpty())
        {
            System.out.println("[ ORDER MENU ]");
            System.out.println(i + ". Orders");
            System.out.println(i + 1 + ". Cancel");
        }
    }

    // 입력받은 menu 번호를 받아 검증후 입력된 메뉴 번호를 리턴하는 메소드
    public int validateAndSelectMenu(List<Menu> menuList) {
        continueFlag = false;
        try {
            int selectedMenuNumber = Integer.parseInt(sc.nextLine());

            // 쇼핑카트가 비어있을시
            if(shoppingCart.isCartItemsEmpty()) {
                if (selectedMenuNumber < 0 || selectedMenuNumber > menuList.size()) {
                    System.out.println("올바른 카테고리를 선택해주세요.");
                    continueFlag = true;
                    return -1;
                }
            } // 쇼핑카트가 존재할시 예외처리 범위가 2 늘어난다.
            else {
                if(selectedMenuNumber < 0 || selectedMenuNumber > menuList.size() + 2) {
                    System.out.println("올바른 카테고리를 선택해주세요.");
                    continueFlag = true;
                    return -1;
                    }
                }
            if(selectedMenuNumber == 0) {
                continueFlag = true;
                return -1;
            }
            return selectedMenuNumber;
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            continueFlag = true;
            return -1;
        }
    }

    // 선택된 메뉴의 모든 아이템들을 보여준다.
    public void showAllItems(List<Menu> menuList, int selectedMenuNumber) {
        // 일반 메뉴와 Order 메뉴의 아이템을 나누기위한 플래그
        menuFlag = false;
        breakFlag = false;

        if(selectedMenuNumber <= menuList.size())
        {
            menuList.get(selectedMenuNumber-1).showMenuItems();
            System.out.println("0. 뒤로가기");
        } // Orders 메뉴 선택시
        else if(selectedMenuNumber == menuList.size() + 1)
        {
            System.out.println("아래와 같이 주문하시겠습니까?");
            shoppingCart.showOrderTable();
            System.out.println("1. 주문 \t 2.메뉴판");
            // 주문 입력을 받기위해 menuFlag를 true로 바꿔준다.
            menuFlag = true;
        } // Cancel 메뉴 선택시
        else {
            shoppingCart.clearCart();
            breakFlag = true;
            System.out.println("장바구니를 비웠습니다.");
        }
    }

    // 선택된 아이템들을 검증해서 반환해주는 메소드.
    public int validateAndSelectItems(List<Menu> menuList, int selectedMenuNumber) {
        continueFlag = false;
        breakFlag = false;
        try {
            int selectedItemNumber = Integer.parseInt(sc.nextLine());

            // 일반 메뉴 선택시 입력 처리
            if(!menuFlag) {
                if(selectedItemNumber < 0 || selectedItemNumber > menuList.get(selectedMenuNumber-1).getMenuItemList().size()) {
                    System.out.println("올바른 메뉴를 선택해주세요.");
                    continueFlag = true;
                    return -1;
                }
                if(selectedItemNumber == 0)
                {
                    continueFlag = true;
                    return 0;
                }
                return selectedItemNumber;

                // 장바구니 메뉴 선택시 입력 처리
            } else {
                if(selectedItemNumber == 1) {
                    shoppingCart.orderComplete();
                    breakFlag = true;
                    return -1;
                } else if (selectedItemNumber == 2) {
                    breakFlag = true;
                    return -1;
                } else {
                    continueFlag = true;
                    System.out.println("올바른 숫자를 입력해주세요.");
                    return -1;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력해주세요.");
            continueFlag = true;
            return -1;
        }
    }

    public void addSelectedItemToCart(List<Menu> menuList, int selectedMenuNumber, int selectedItemNumber) {
        int cartFlag = -1;

        // 사용자가 고른 메뉴의 아이템들을 가져와 menuItems 리스트에 저장한다.
        List<MenuItem> menuItems = menuList.get(selectedMenuNumber-1).getMenuItemList();

        // 사용자가 고른 품목의 객체를 가져와 menuItem에 저장.
        MenuItem menuItem = menuItems.get(selectedItemNumber-1);

        // 선택한 메뉴를 출력후에 장바구니에 추가할지 질문
        System.out.println("선택한 메뉴 : " + menuItem.getItemName() + " | W " + menuItem.getPrice() + " | " +
                menuItem.getFoodDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1.확인\t2.취소");

        while(cartFlag < 1 || cartFlag > 2)
        {
            try {
                cartFlag = Integer.parseInt(sc.nextLine());
                if(cartFlag < 1 || cartFlag > 2) {
                    System.out.println("올바른 값만 입력해주세요.");
                }
                if(cartFlag == 1)
                {
                    shoppingCart.addCartItems(menuItem);
                    System.out.println("장바구니에 추가되었습니다.");
                }

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    public boolean shouldContinue() {
        return continueFlag;
    }

    public boolean shouldBreak() {
        return breakFlag;
    }
}
