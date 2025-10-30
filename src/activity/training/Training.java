package activity.training;

import character.*;

public abstract class Training {
    private final int health;

    public Training(int health) {
        this.health = health;
    }

    // 추상메소드
    public abstract void acquireStats(IndividualTrainee player);

    protected int getHealth() {
        return health;
    }

}
