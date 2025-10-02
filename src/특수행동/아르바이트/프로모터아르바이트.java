package 특수행동.아르바이트;

import 캐릭터.개인연습생;

import java.util.Random;

public class 프로모터아르바이트 extends 아르바이트{

    private int 매력;

    public 프로모터아르바이트(int 체력, int 일당, int 매력) {
        super(체력, 일당);
        this.매력 = 매력;
    }

    @Override
    public void 능력치습득(개인연습생 플레이어){
        Random 랜덤 = new Random();
        int 랜덤값 = 랜덤.nextInt(3);
        if (랜덤값 == 0){
            플레이어.add소지금(get일당()+7000);
            플레이어.add매력(get매력()+4);
            플레이어.set체력(플레이어.get체력() - (get체력()+5));
            System.out.println("일당 : " + (get일당()+7000) + "/ 체력 : -" + (get체력()+5) + "/ 매력 : " + (get매력()+4));
            System.out.println("집중해서 아르바이트를 끝냈습니다. 일을 너무 잘해서 보너스를 더 받았습니다.");
        } else if (랜덤값 == 1) {
            플레이어.add소지금(get일당()+2000);
            플레이어.add매력(get매력()+2);
            플레이어.set체력(플레이어.get체력() - (get체력()+2));
            System.out.println("일당 : " + (get일당()+2000) + "/ 체력 : -" + (get체력()+2) + "/ 매력 : " + (get매력()+2));
            System.out.println("평범하게 아르바이트를 끝냈습니다.");
        }else{
            플레이어.add소지금(get일당());
            플레이어.add매력(get매력());
            플레이어.set체력(플레이어.get체력() - get체력());
            System.out.println("일당 : " + get일당() + "/ 체력 : -" + get체력() + "/ 매력 : " + get매력());
            System.out.println("실수를 많이 했습니다. 실수로 인한 피해로 일당이 깎였습니다.");
        }
    }

    public int get매력() {
        return 매력;
    }

    public void set매력(int 매력) {
        this.매력 = 매력;
    }
}
