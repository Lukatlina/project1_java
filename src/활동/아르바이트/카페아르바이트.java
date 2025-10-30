package 활동.아르바이트;

import 캐릭터.개인연습생;

import java.util.Random;

public class 카페아르바이트 extends 아르바이트 {
    private final int 폐활량;
    private final int 화술;

    public 카페아르바이트(int health, int 일당, int 폐활량, int 화술) {
        super(health, 일당);
        this.폐활량 = 폐활량;
        this.화술 = 화술;
    }

    @Override
    public void 능력치습득(개인연습생 플레이어){
        Random random = new Random();
        int random값 = random.nextInt(3);
        if (random값 == 0){
            플레이어.add소지금(get일당()+7000);
            플레이어.addVocal(폐활량+4);
            플레이어.addRap(화술+4);
            플레이어.setHealth(플레이어.getHealth() - (getHealth()+5));
            System.out.println("일당 : " + (get일당()+7000) + "/ health : -" + (getHealth()+5) + "/ vocal : " + (폐활량+4) + "/ rap : " + (화술+4));
            System.out.println("집중해서 아르바이트를 끝냈습니다. 일을 너무 잘해서 보너스를 더 받았습니다.");
        }else if (random값 == 1) {
            플레이어.add소지금(get일당()+2000);
            플레이어.addVocal(폐활량+2);
            플레이어.addRap(화술+2);
            플레이어.setHealth(플레이어.getHealth() - getHealth()+2);
            System.out.println("일당 : " + (get일당()+2000) + "/ health : -" + (getHealth()+2) + "/ vocal : " + (폐활량+2) + "/ rap : " + (화술+2));
            System.out.println("평범하게 아르바이트를 끝냈습니다.");
        }else{
            플레이어.add소지금(get일당());
            플레이어.addVocal(폐활량);
            플레이어.addRap(화술);
            플레이어.setHealth(플레이어.getHealth() - getHealth());
            System.out.println("일당 : " + get일당() + "/ health : -" + getHealth() + "/ vocal : " + 폐활량 + "/ rap : " + 화술);
            System.out.println("실수를 많이 했습니다. 실수로 인한 피해로 일당이 깎였습니다.");
        }
    }
}
