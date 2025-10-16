package 아이템;

public class 신발 extends 장비 {

    private final int 댄스;

    // 생성자
    public 신발(String 물품명, int 가격, int 댄스) {
        super(물품명, 가격);
        this.댄스 = 댄스;
    }

    public int get댄스() {
        return 댄스;
    }

}
