package 특수행동;

import 캐릭터.개인연습생;
import java.util.Scanner;

public class 자유행동 {
    private int 소지금; // 네이밍 고민해보기
    private int 체력;
    private int 매력;


    public 자유행동(int 소지금, int 체력, int 매력) {
        this.소지금 = 소지금;
        this.체력 = 체력;
        this.매력 = 매력;
    }

    public void 휴식능력치보기(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("1. 놀기 : 체력 : " + (get체력()+5) + " / 매력 : " + (get매력()+10));
        System.out.println("2. 군것질 : 체력 : " + (get체력()+40) + " / 매력 : -" + (get매력()+5) + " / 소지금 : -" + get소지금());
        System.out.println("3. 운동하기 : 체력 : " + (get체력()) + " / 매력 : " + (get매력()));
        System.out.println("4. 휴식 : 체력 : " + (get체력()+20));
        System.out.println("-------------------------------------------------------------------");
    }

    //
    public void 토요일자유행동(개인연습생 플레이어){
        Scanner sc = new Scanner(System.in);
        플레이어.능력치보여주기();
        휴식능력치보기();
        System.out.println("자유행동 시간입니다. 어떤 행동을 할지 선택해주세요.");
        int value = sc.nextInt();
        if (value == 1) {
            플레이어.set체력(플레이어.get체력() - (get체력()+5));
            플레이어.add매력((get매력()+5));
        } else if (value == 2) {
            플레이어.set소지금(플레이어.get소지금() - get소지금());
            플레이어.add체력(get체력()+40);
            플레이어.set매력(플레이어.get매력() - (get매력()+5));
        } else if (value == 3) {
            플레이어.set체력(플레이어.get체력() - get체력());
            플레이어.add매력(get매력());
        }else{
            플레이어.add체력((get체력()+20));
        }
    }

    public int get소지금() {
        return 소지금;
    }

    public void set소지금(int 소지금) {
        this.소지금 = 소지금;
    }

    public int get체력() {
        return 체력;
    }

    public void set체력(int 체력) {
        this.체력 = 체력;
    }

    public int get매력() {
        return 매력;
    }

    public void set매력(int 매력) {
        this.매력 = 매력;
    }

}
