package 아이템;

public class 의상 extends 장비 {
    private int 매력;
    // 생성자

    public 의상(String 물품명, int 가격, int 매력) {
        super(물품명, 가격);
        this.매력 = 매력;
    }

    public int get매력() {
        return 매력;
    }

    public void set매력(int 매력) {
        this.매력 = 매력;
    }
}
