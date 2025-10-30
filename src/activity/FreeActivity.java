package activity;

import character.IndividualTrainee;
import java.util.Scanner;

public class FreeActivity {
    private final int cost;
    private final int health;
    private final int charm;

    public FreeActivity(int cost, int health, int charm) {
        this.cost = cost;
        this.health = health;
        this.charm = charm;
    }

    public void performFreeActivity(IndividualTrainee player){
        Scanner sc = new Scanner(System.in);
        player.showStats();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("1. 놀기 : 체력 : " + (health+5) + " / 매력 : " + (charm+10));
        System.out.println("2. 군것질 : 체력 : " + (health+40) + " / 매력 : -" + (charm+5) + " / 지출금 : -" + cost);
        System.out.println("3. 운동하기 : 체력 : " + (health) + " / 매력 : " + (charm));
        System.out.println("4. 휴식 : 체력 : " + (health+20));
        System.out.println("-------------------------------------------------------------------");
        System.out.println("자유행동 시간입니다. 어떤 행동을 할지 선택해주세요.");

        int value = sc.nextInt();
        if (value == 1) {
            player.setHealth(player.getHealth() - (health+5));
            player.addCharm((charm+5));
        } else if (value == 2) {
            player.setMoney(player.getMoney() - cost);
            player.addHealth(health+40);
            player.setCharm(player.getCharm() - (charm+5));
        } else if (value == 3) {
            player.setHealth(player.getHealth() - health);
            player.addCharm(charm);
        }else{
            player.addHealth((health+20));
        }
    }
}
