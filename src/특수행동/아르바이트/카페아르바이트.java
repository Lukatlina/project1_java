package 특수행동.아르바이트;

import 캐릭터.개인연습생;

import java.util.Random;

public class 카페아르바이트 extends 아르바이트 {
    private final int 폐활량;
    private final int 화술;

    public 카페아르바이트(int 체력, int 일당, int 폐활량, int 화술) {
        super(체력, 일당);
        this.폐활량 = 폐활량;
        this.화술 = 화술;
    }

    @Override
    public void 능력치습득(개인연습생 플레이어){
        Random 랜덤 = new Random();
        int 랜덤값 = 랜덤.nextInt(3);
        if (랜덤값 == 0){
            플레이어.add소지금(get일당()+7000);
            플레이어.add보컬(폐활량+4);
            플레이어.add랩(화술+4);
            플레이어.set체력(플레이어.get체력() - (get체력()+5));
            System.out.println("일당 : " + (get일당()+7000) + "/ 체력 : -" + (get체력()+5) + "/ 보컬 : " + (폐활량+4) + "/ 랩 : " + (화술+4));
            System.out.println("집중해서 아르바이트를 끝냈습니다. 일을 너무 잘해서 보너스를 더 받았습니다.");
        }else if (랜덤값 == 1) {
            플레이어.add소지금(get일당()+2000);
            플레이어.add보컬(폐활량+2);
            플레이어.add랩(화술+2);
            플레이어.set체력(플레이어.get체력() - get체력()+2);
            System.out.println("일당 : " + (get일당()+2000) + "/ 체력 : -" + (get체력()+2) + "/ 보컬 : " + (폐활량+2) + "/ 랩 : " + (화술+2));
            System.out.println("평범하게 아르바이트를 끝냈습니다.");
        }else{
            플레이어.add소지금(get일당());
            플레이어.add보컬(폐활량);
            플레이어.add랩(화술);
            플레이어.set체력(플레이어.get체력() - get체력());
            System.out.println("일당 : " + get일당() + "/ 체력 : -" + get체력() + "/ 보컬 : " + 폐활량 + "/ 랩 : " + 화술);
            System.out.println("실수를 많이 했습니다. 실수로 인한 피해로 일당이 깎였습니다.");
        }
    }
}
