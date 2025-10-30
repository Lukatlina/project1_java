package activity.job;

import character.IndividualTrainee;

import java.util.Random;

public class CafeJob extends Job {
    private final int lungCapacity;
    private final int speechSkill;

    public CafeJob(int health, int wage, int lungCapacity, int speechSkill) {
        super(health, wage);
        this.lungCapacity = lungCapacity;
        this.speechSkill = speechSkill;
    }

    @Override
    public void acquireStats(IndividualTrainee player){
        Random random = new Random();
        int outcome = random.nextInt(3);
        if (outcome == 0){
            player.addMoney(getWage()+7000);
            player.addVocal(lungCapacity+4);
            player.addRap(speechSkill+4);
            player.setHealth(player.getHealth() - (getHealth()+5));
            System.out.println("일당 : " + (getWage()+7000) + "/ 체력 : -" + (getHealth()+5) + "/ 보컬 : " + (lungCapacity+4) + "/ 랩 : " + (speechSkill+4));
            System.out.println("집중해서 아르바이트를 끝냈습니다. 일을 너무 잘해서 보너스를 더 받았습니다.");
        }else if (outcome == 1) {
            player.addMoney(getWage()+2000);
            player.addVocal(lungCapacity+2);
            player.addRap(speechSkill+2);
            player.setHealth(player.getHealth() - getHealth()+2);
            System.out.println("일당 : " + (getWage()+2000) + "/ 체력 : -" + (getHealth()+2) + "/ 보컬 : " + (lungCapacity+2) + "/ 랩 : " + (speechSkill+2));
            System.out.println("평범하게 아르바이트를 끝냈습니다.");
        }else{
            player.addMoney(getWage());
            player.addVocal(lungCapacity);
            player.addRap(speechSkill);
            player.setHealth(player.getHealth() - getHealth());
            System.out.println("일당 : " + getWage() + "/ 체력 : -" + getHealth() + "/ 보컬 : " + lungCapacity + "/ 랩 : " + speechSkill);
            System.out.println("실수를 많이 했습니다. 실수로 인한 피해로 일당이 깎였습니다.");
        }
    }
}
