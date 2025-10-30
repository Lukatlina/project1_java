package 활동.트레이닝;

import 캐릭터.개인연습생;
import java.util.Random;

public class vocal트레이닝 extends 트레이닝 {
    private final int vocal;

    public vocal트레이닝(int health, int vocal) {
        super(health);
        this.vocal = vocal;
    }

//    @Override
//    public void 트레이닝반복(개인연습생 플레이어){
//        플레이어.addVocal(vocal);
//        플레이어.setHealth(플레이어.getHealth() - getHealth());
//        System.out.println("health : -" + getHealth() + " vocal : " + vocal);
//    }

    @Override
    public void 능력치습득(개인연습생 플레이어){
        Random random = new Random();
        int random값 = random.nextInt(3);
        if (random값 == 0){
            플레이어.addVocal(vocal+4);
            플레이어.setHealth(플레이어.getHealth() - (getHealth()+4));
            System.out.println("health : -" + (getHealth()+4) + "/ vocal : " + (vocal+4));
            System.out.println("모든 트레이닝을 습득했습니다. 능력치가 추가로 상승합니다.");
        } else if (random값 == 1) {
            플레이어.addVocal(vocal+2);
            플레이어.setHealth(플레이어.getHealth() - (getHealth()+2));
            System.out.println("health : -" + (getHealth()+2) + "/ vocal : " + (vocal+2));
            System.out.println("평범하게 트레이닝을 받았습니다.");
        }else{
            플레이어.addVocal(vocal);
            플레이어.setHealth(플레이어.getHealth() - getHealth());
            System.out.println("health : -" + getHealth() + "/ vocal : " + vocal);
            System.out.println("컨디션이 좋지 않아 실수를 반복했습니다.");
        }
    }
}
