package activity;

import character.IndividualTrainee;
import java.util.Scanner;

public class FreeActivity {
    private final int 지출금; // 네이밍 고민해보기
    private final int health;
    private final int charm;

    public FreeActivity(int 지출금, int health, int charm) {
        this.지출금 = 지출금;
        this.health = health;
        this.charm = charm;
    }

    public void 토요일자유행동(IndividualTrainee 플레이어){
        Scanner sc = new Scanner(System.in);
        플레이어.능력치보여주기();

        System.out.println("-------------------------------------------------------------------");
        System.out.println("1. 놀기 : health : " + (health+5) + " / charm : " + (charm+10));
        System.out.println("2. 군것질 : health : " + (health+40) + " / charm : -" + (charm+5) + " / money : -" + 지출금);
        System.out.println("3. 운동하기 : health : " + (health) + " / charm : " + (charm));
        System.out.println("4. 휴식 : health : " + (health+20));
        System.out.println("-------------------------------------------------------------------");
        System.out.println("자유행동 시간입니다. 어떤 행동을 할지 선택해주세요.");

        int value = sc.nextInt();
        if (value == 1) {
            플레이어.setHealth(플레이어.getHealth() - (health+5));
            플레이어.addCharm((charm+5));
        } else if (value == 2) {
            플레이어.setMoney(플레이어.getMoney() - 지출금);
            플레이어.addHealth(health+40);
            플레이어.setCharm(플레이어.getCharm() - (charm+5));
        } else if (value == 3) {
            플레이어.setHealth(플레이어.getHealth() - health);
            플레이어.addCharm(charm);
        }else{
            플레이어.addHealth((health+20));
        }
    }
}
