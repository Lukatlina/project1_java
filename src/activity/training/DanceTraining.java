package activity.training;

import character.IndividualTrainee;
import java.util.Random;

public class DanceTraining extends Training {
    private final int dance;

    public DanceTraining(int health, int dance) {
        super(health);
        this.dance = dance;
    }

    // 어느 위치에 넣어놓느냐의 문제 스테이지 안에 이 코드가 있으면 지저분해짐
    // 더 리팩토링 가능하지만 문제가 생길 수도 있다
    // 메소드를 사용하는 개발자의 입장에서 간편하게 쓰는 것
    // 내가 그렇게 만들어 놓으면 다른 개발자가 할 일이 없어지기 때문에 그게 중요하다. 위치에 따라 다른 개발자들이 신경을 덜 쓰게 된다.
    // 대부분의 작업이 코드 양이 줄어드는 것 보다 위치만 바뀐다. 이게 나중에 다시 사용될 것을 생각해보자. 결과가 많이 달라진다.
    @Override
    public void acquireStats(IndividualTrainee player){
        Random random = new Random();
        int outcome = random.nextInt(3);
        if (outcome == 0){
            player.addDance(dance+4);
            player.setHealth(player.getHealth() - (getHealth()+4));
            System.out.println("체력 : -" + (getHealth()+4) + "/ 댄스 : " + (dance+4));
            System.out.println("모든 트레이닝을 습득했습니다. 능력치가 추가로 상승합니다.");
        } else if (outcome == 1) {
            player.addDance(dance+2);
            player.setHealth(player.getHealth() - (getHealth()+2));
            System.out.println("체력 : -" + (getHealth()+2) + "/ 댄스 : " + (dance+2));
            System.out.println("평범하게 트레이닝을 받았습니다.");
        }else{
            player.addDance(dance);
            player.setHealth(player.getHealth() - getHealth());
            System.out.println("체력 : -" + getHealth() + "/ 댄스 : " + dance);
            System.out.println("컨디션이 좋지 않아 실수를 반복했습니다.");
        }
    }
}
