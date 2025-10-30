package activity.training;

import character.IndividualTrainee;
import java.util.Random;

public class RapTraining extends Training {
    private final int rap;

    public RapTraining(int health, int rap) {
        super(health);
        this.rap = rap;
    }

    @Override
    public void 능력치습득(IndividualTrainee 플레이어){
        Random random = new Random();
        int random값 = random.nextInt(3);
        if (random값 == 0){
            플레이어.addRap(rap+4);
            플레이어.setHealth(플레이어.getHealth() - (getHealth()+4));
            System.out.println("health : -" + (getHealth()+4) + "/ rap : " + (rap+4));
            System.out.println("모든 트레이닝을 습득했습니다. 능력치가 추가로 상승합니다.");
        } else if (random값 == 1) {
            플레이어.addRap(rap+2);
            플레이어.setHealth(플레이어.getHealth() - (getHealth()+2));
            System.out.println("health : -" + (getHealth()+2) + "/ rap : " + (rap+2));
            System.out.println("평범하게 트레이닝을 받았습니다.");
        }else{
            플레이어.addRap(rap);
            플레이어.setHealth(플레이어.getHealth() - getHealth());
            System.out.println("health : -" + getHealth() + "/ rap : " + rap);
            System.out.println("컨디션이 좋지 않아 실수를 반복했습니다.");
        }
    }
}
