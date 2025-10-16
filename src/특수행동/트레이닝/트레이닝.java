package 특수행동.트레이닝;

import 캐릭터.*;

public abstract class 트레이닝 {
    private int 체력;

    public 트레이닝(int 체력) {
        this.체력 = 체력;
    }

    // 추상메소드
    public abstract void 능력치습득(개인연습생 플레이어);

    protected int get체력() {
        return 체력;
    }

}
