package activity.training;

import character.IndividualTrainee;
import java.util.Random;

public class VocalTraining extends Training {
    private final int vocal;

    public VocalTraining(int health, int vocal) {
        super(health);
        this.vocal = vocal;
    }

    @Override
    public void acquireStats(IndividualTrainee player){
        Random random = new Random();
        int outcome = random.nextInt(3);
        if (outcome == 0){
            player.addVocal(vocal+4);
            player.setHealth(player.getHealth() - (getHealth()+4));
            System.out.println("체력 : -" + (getHealth()+4) + "/ 보컬 : " + (vocal+4));
            System.out.println("모든 트레이닝을 습득했습니다. 능력치가 추가로 상승합니다.");
        } else if (outcome == 1) {
            player.addVocal(vocal+2);
            player.setHealth(player.getHealth() - (getHealth()+2));
            System.out.println("체력 : -" + (getHealth()+2) + "/ 보컬 : " + (vocal+2));
            System.out.println("평범하게 트레이닝을 받았습니다.");
        }else{
            player.addVocal(vocal);
            player.setHealth(player.getHealth() - getHealth());
            System.out.println("체력 : -" + getHealth() + "/ 보컬 : " + vocal);
            System.out.println("컨디션이 좋지 않아 실수를 반복했습니다.");
        }
    }
}
