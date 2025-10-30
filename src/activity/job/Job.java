package activity.job;

import character.IndividualTrainee;

public abstract class Job {
    private final int health;
    private final int wage;

    public Job(int health, int wage) {
        this.health = health;
        this.wage = wage;
    }

    public abstract void acquireStats(IndividualTrainee player);

    protected int getHealth() {
        return health;
    }

    protected int getWage() {
        return wage;
    }

}
