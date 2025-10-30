package activity.job;

import character.IndividualTrainee;

import java.util.Random;

public class MascotJob extends Job {

    private final int dance;

    public MascotJob(int health, int wage, int dance) {
        super(health, wage);
        this.dance = dance;
    }

    //
    @Override
    public void acquireStats(IndividualTrainee player){
        Random random = new Random();
        int outcome = random.nextInt(3);
        if (outcome == 0){
            player.addMoney(getWage()+7000);
            player.addDance(dance+4);
            player.setHealth(player.getHealth() - (getHealth()+5));
            System.out.println("일당 : " + (getWage() +7000) + "/ 체력 : -" + (getHealth()+5) + "/ 댄스 : " + (dance+4));
            System.out.println("집중해서 아르바이트를 끝냈습니다. 일을 너무 잘해서 보너스를 더 받았습니다.");
        } else if (outcome == 1) {
            player.addMoney(getWage()+2000);
            player.addDance(dance+2);
            player.setHealth(player.getHealth() - (getHealth()+2));
            System.out.println("일당 : " + (getWage() +2000) + "/ 체력 : -" + (getHealth()+2) + "/ 댄스 : " + (dance+2));
            System.out.println("평범하게 아르바이트를 끝냈습니다.");
        }else{
            player.addMoney(getWage());
            player.addDance(dance);
            player.setHealth(player.getHealth() - getHealth());
            System.out.println("일당 : " + getWage() + "/ 체력 : -" + getHealth() + "/ 댄스 : " + dance);
            System.out.println("실수를 많이 했습니다. 실수로 인한 피해로 일당이 깎였습니다.");
        }
    }
}
