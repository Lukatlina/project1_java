package 특수행동.트레이닝;

import 캐릭터.개인연습생;
import java.util.Random;

public class 표정연구하기 extends 트레이닝 {
    private final int 매력;

    public 표정연구하기(int 체력, int 매력) {
        super(체력);
        this.매력 = 매력;
    }
    
    @Override
    public void 능력치습득(개인연습생 플레이어){
        Random 랜덤 = new Random();
        int 랜덤값 = 랜덤.nextInt(3);
        if (랜덤값 == 0){
            플레이어.add매력(매력+4);
            플레이어.set체력(플레이어.get체력() - (get체력()+4));
            System.out.println("체력 : -" + (get체력()+4) + "/ 매력 : " + (매력+4));
            System.out.println("모든 트레이닝을 습득했습니다. 능력치가 추가로 상승합니다.");
        } else if (랜덤값 == 1) {
            플레이어.add매력(매력+2);
            플레이어.set체력(플레이어.get체력() - (get체력()+2));
            System.out.println("체력 : -" + (get체력()+2) + "/ 매력 : " + (매력+2));
            System.out.println("평범하게 트레이닝을 받았습니다.");
        }else{
            플레이어.add매력(매력);
            플레이어.set체력(플레이어.get체력() - get체력());
            System.out.println("체력 : -" + get체력() + "/ 매력 : " + 매력);
            System.out.println("컨디션이 좋지 않아 실수를 반복했습니다.");
        }
    }
}
