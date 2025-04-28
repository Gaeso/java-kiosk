package challenge.lv2;

public enum Discount {
    NATIONAL_MERIT("국가유공자", 10),
    SOLDIER("군인", 5),
    STUDENT("학생", 3),
    GENERAL("일반", 0);

    private final String discountName;
    private final int discountRate;

    Discount(String discountName, int discountRate) {
        this.discountName = discountName;
        this.discountRate = discountRate;
    }

    public int getDiscountRate() {
        return discountRate;
    }

    public static String getDiscountMenu() {
        StringBuilder sb = new StringBuilder();
        Discount[] types = values();

        for (int i = 0; i < types.length; i++) {
            sb.append(i + 1).append(". ")
                    .append(String.format("%-5s: %d%%",
                            types[i].discountName,
                            types[i].discountRate));

            if (i < types.length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static Discount selectedDiscount(int select) {
        try {
            return values()[select-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            return GENERAL;
        }
    }
}
