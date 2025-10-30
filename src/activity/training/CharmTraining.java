package activity.training;

import character.IndividualTrainee;
import java.util.Random;

public class CharmTraining extends Training {
    private final int charm;

    public CharmTraining(int health, int charm) {
        super(health);
        this.charm = charm;
    }
    
    @Override
    public void 능력치습득(IndividualTrainee 플레이어){
        Random random = new Random();
        int random값 = random.nextInt(3);
        if (random값 == 0){
            플레이어.addCharm(charm+4);
            플레이어.setHealth(플레이어.getHealth() - (getHealth()+4));
            System.out.println("health : -" + (getHealth()+4) + "/ charm : " + (charm+4));
            System.out.println("모든 트레이닝을 습득했습니다. 능력치가 추가로 상승합니다.");
        } else if (random값 == 1) {
            플레이어.addCharm(charm+2);
            플레이어.setHealth(플레이어.getHealth() - (getHealth()+2));
            System.out.println("health : -" + (getHealth()+2) + "/ charm : " + (charm+2));
            System.out.println("평범하게 트레이닝을 받았습니다.");
        }else{
            플레이어.addCharm(charm);
            플레이어.setHealth(플레이어.getHealth() - getHealth());
            System.out.println("health : -" + getHealth() + "/ charm : " + charm);
            System.out.println("컨디션이 좋지 않아 실수를 반복했습니다.");
        }
    }
}
