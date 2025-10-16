package 아이템;

// 장비, 소비 아이템으로 나눌 것 -> 로직 합쳐서 관리하기 어려워짐
// 아이템 조작시 음식물까지 코드에 영향을 줄 수도 있음 -> 적절한 분리 필요
public abstract class 아이템 {
    private final String 물품명;
    private final int 가격;

    public 아이템(String 물품명, int 가격) {
        this.물품명 = 물품명;
        this.가격 = 가격;
    }

    public String get물품명() {
        return 물품명;
    }

    public int get가격() {
        return 가격;
    }

}

