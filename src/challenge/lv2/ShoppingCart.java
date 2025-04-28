package challenge.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 장바구니 관리 클래스
public class ShoppingCart {

    private final List<MenuItem> cartItems = new ArrayList<>();
    private double totalAmount = 0;
    Discount discount;

    // 장바구니에 선택된 메뉴 아이템을 추가하는 메소드.
    public void addCartItems(MenuItem menuItem) {
        cartItems.add(menuItem);
        totalAmount += Double.parseDouble(menuItem.getPrice());
    }

    // 현재 추가된 장바구니 목록을 보여주는 메소드
    public void showOrderTable() {
        System.out.println("[ Orders ]");
        for (MenuItem item : cartItems) {
            System.out.println(item.getItemName() + "\t| W " + item.getPrice() + " | " + item.getFoodDescription());
        }
        System.out.println("[ Total ]");
        System.out.println("W " + totalAmount);
    }

    // 주문 완료시 가격 출력과 장바구니를 초기화하는 메소드
    public void orderComplete() {
        int discountType = -1;
        Scanner sc2 = new Scanner(System.in);
        System.out.println("할인 정보를 입력해주세요.");
        System.out.println(Discount.getDiscountMenu());
        while(discountType != 0) {
            try {
                discountType = Integer.parseInt(sc2.nextLine());
                if(discountType < 1 || discountType > 4)
                {
                    System.out.println("올바른 숫자를 입력해주세요.");
                    continue;
                }
                discount = Discount.selectedDiscount(discountType);
                totalAmount = totalAmount * (100 - discount.getDiscountRate()) / 100;
                System.out.println("주문이 완료되었습니다. 가격은 W " + totalAmount + " 입니다.");
                clearCart();
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");
            }
        }
    }

    public boolean isCartItemsEmpty() {
        return cartItems.isEmpty();
    }

    public void clearCart() {
        cartItems.clear();
        totalAmount = 0;
    }

    // 람다 스트림을 이용해 원하는 아이템을 지우는 메소드
    public boolean removeItem(String itemName) {
        boolean isRemoved = cartItems.removeIf(item -> item.getItemName().equalsIgnoreCase(itemName));
        // 제거되면 가격의 총합도 람다 스트림을 이용해서 수정해준다.
        if(isRemoved) {
            // mapToDouble 메소드로 DoubleStream을 생성해서 sum()함수를 사용해 합쳐준다.
            totalAmount = cartItems.stream().mapToDouble(item -> Double.parseDouble(item.getPrice())).sum();
        }
        // 제거됐는지 안됐는지 부울값을 리턴해준다.
        return isRemoved;
    }
}