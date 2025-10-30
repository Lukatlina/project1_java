package 활동.트레이닝;

import 캐릭터.*;

public abstract class 트레이닝 {
    private final int health;

    public 트레이닝(int health) {
        this.health = health;
    }

    // 추상메소드
    public abstract void 능력치습득(개인연습생 플레이어);

    protected int getHealth() {
        return health;
    }

}
