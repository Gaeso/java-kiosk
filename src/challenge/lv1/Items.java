package challenge.lv1;

import java.util.ArrayList;
import java.util.List;

// 메뉴 아이템에 들어갈 상세 내용들을 관리하는 클래스
public class Items {

    private final List<String[]> burgerItems = new ArrayList<>();
    private final List<String[]>  drinkItems = new ArrayList<>();
    private final List<String[]> dessertItems = new ArrayList<>();

    public Items() {
        burgerItems.add(new String[]{"ShackBurger", "6.9", "토마토, 양상추, 쉑소스가 토핑된 치즈버거"});
        burgerItems.add(new String[]{"SmokeShack", "8.9", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"});
        burgerItems.add(new String[]{"Cheeseburger", "6.9", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"});
        burgerItems.add(new String[]{"Hamburger", "5.4", "비프패티를 기반으로 야채가 들어간 기본버거"});

        drinkItems.add(new String[]{"MilkShake", "5.0", "우유 짱많이 들어간 밀크쉐이크"});
        drinkItems.add(new String[]{"Coke", "2.0", "그냥 콜라"});
        drinkItems.add(new String[]{"ZeroCoke", "2.0", "제로 콜라"});

        dessertItems.add(new String[]{"IceCream", "2.5", "살살녹는 밀크 아이스크림"});
        dessertItems.add(new String[]{"ChocoIceCream", "2.5", "살살녹는 초코 아이스크림"});
    }

    public List<String[]> getBurgerItems() {
        return burgerItems;
    }

    public List<String[]> getDrinkItems() {
        return drinkItems;
    }

    public List<String[]> getDessertItems() {
        return dessertItems;
    }
}
