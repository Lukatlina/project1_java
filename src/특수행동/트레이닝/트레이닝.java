package 특수행동.트레이닝;

import 캐릭터.*;

public abstract class 트레이닝 {
    int 체력;
    private int 보컬;


    public 트레이닝(int 체력) {
        this.체력 = 체력;
    }

    // 추상메소드
//    public abstract void 트레이닝반복(개인연습생 플레이어);
    public abstract void 능력치습득(개인연습생 플레이어);


    public int get체력() {
        return 체력;
    }

    public void set체력(int 체력) {
        this.체력 = 체력;
    }
}
