package 캐릭터;

import 아이템.*;

import java.util.ArrayList;
import java.util.List;


public class 개인연습생 extends 연습생 {
    // 변수 선언
    private int 소지금;
    private 의상 의상;
    private 신발 신발;
    private List<의상> 옷장 = new ArrayList<의상>();
    private List<신발> 신발장 = new ArrayList<신발>();
    private List<음식물> 목캔디 = new ArrayList<음식물>();
    private List<음식물> 샐러드 = new ArrayList<음식물>();
    private List<음식물> 케이크 = new ArrayList<음식물>();

    // 생성자
    // 의상 A = new 의상("한복", 400000,30);
    // 의상 B; // 변수 선언, 물리적인 자리만 만드는 것
    // B = new 의상("잠옷", 50000, 10); // 값을 할당
    public 개인연습생(String Name, int vocal, int rap, int charm, int dance, String grade, int voteCount, int 소지금) {
        super(Name, vocal, rap, charm, dance, grade, voteCount);
        this.소지금 = 소지금;
    }

    public void 능력치보여주기() {
        System.out.println("--------------------------");
        System.out.println("        Name : " + getName());
        System.out.println("        health : " + getHealth());
        System.out.println("        vocal : " + getVocal());
        System.out.println("        rap : " + getRap());
        System.out.println("        dance : " + getDance());
        System.out.println("        charm : " + getCharm());
        System.out.println("        grade : " + getGrade());
        System.out.println("        소지금 : " + get소지금());
        System.out.println("        voteCount : " + getVoteCount());
        System.out.println("--------------------------");
    }

    public void 의상보여주기() {
        if (옷장.isEmpty()) {
            System.out.println("현재 보유한 의상이 없습니다.");
            return;
        }

        System.out.println("----------------------------------------");
        System.out.println("현재 보유한 의상 확인");
        for(int i = 0; i < 옷장.size(); i++){
            System.out.println(i + " : " + 옷장.get(i).getItemName());
        }
        System.out.println("----------------------------------------");
    }

    public void 신발보여주기() {
        if (신발장.isEmpty()){
            System.out.println("현재 보유한 신발이 없습니다.");
        }
        System.out.println("----------------------------------------");

        System.out.println("현재 보유한 신발 확인");
        for(int i = 0; i < 신발장.size(); i++ ){
            System.out.println(i + " : " + 신발장.get(i).getItemName());
        }
        System.out.println("----------------------------------------");
    }

    public void 의상착용하기(int value) {
        if (의상 != null) {
            System.out.println("의상을 이미 착용중입니다.");
        } else if (value < 0 || value >= 옷장.size()) {
            System.out.println("해당하는 번호의 의상이 없습니다.");
        } else {
            final 의상 착용의상 = 옷장.get(value);

            set의상(착용의상);
            addCharm(착용의상.getCharm());
            옷장.remove(value);
            System.out.println("        의상 : " + 의상.getItemName());
            System.out.println("        의상 착용이 완료되었습니다.");
            능력치보여주기();
        }
    }

    public void 신발착용하기(int value) {
        if (신발 != null) {
            System.out.println("신발을 이미 착용중입니다.");
        } else if (value < 0 || value >= 신발장.size()) {
            System.out.println("해당하는 번호의 신발이 없습니다.");
        } else {
            final 신발 착용신발 = 신발장.get(value);

            set신발(착용신발);
            addDance(착용신발.getDance());
            신발장.remove(value);
            System.out.println("        신발 : " + 신발.getItemName());
            System.out.println("        신발 착용이 완료되었습니다.");
            능력치보여주기();
        }
    }

    public void 의상벗기(){
        옷장.add(의상);
        setCharm(getCharm() - 의상.getCharm());
        set의상(null);
        System.out.println("의상을 벗었습니다.");
    }

    public void 신발벗기() {
        신발장.add(신발);
        setDance(getDance() - 신발.getDance());
        set신발(null);
        System.out.println("신발을 벗었습니다.");
    }

    public void 보유아이템확인하기(){
        System.out.println("현재 보유한 아이템 확인");
        System.out.println("1. 목캔디 : " + 목캔디.size() + "개");
        System.out.println("2. 샐러드 : " + 샐러드.size() + "팩");
        System.out.println("3. 케이크 : " + 케이크.size() + "조각");
    }

    public void 아이템먹기(int value){
        if (value == 1 && !목캔디.isEmpty()) {
            final 음식물 아이템 = 목캔디.get(0);

            addVocal(아이템.getVocal());
            addRap(아이템.getRap());
            System.out.println(아이템.getItemName() + "를 섭취했습니다.");
            System.out.println("vocal 수치가 " + 아이템.getVocal() + "만큼 증가했습니다.");
            System.out.println("rap 수치가 " + 아이템.getRap() + "만큼 증가했습니다.");
            목캔디.remove(0);
            능력치보여주기();
        } else if (value == 2 && !샐러드.isEmpty()) {
            final 음식물 아이템 = 샐러드.get(0);

            addHealth(아이템.getHealth());
            addCharm(아이템.getCharm());
            System.out.println(아이템.getItemName() + "를 섭취했습니다.");
            System.out.println("health 수치가 " + 아이템.getHealth() + "만큼 증가했습니다.");
            System.out.println("charm 수치가 " + 아이템.getCharm() + "만큼 증가했습니다.");
            샐러드.remove(0);
            능력치보여주기();
        } else if (value == 3 && !케이크.isEmpty()) {
            final 음식물 아이템 = 케이크.get(0);

            addHealth(아이템.getHealth());
            setCharm(getCharm() - 아이템.getCharm());
            System.out.println(아이템.getItemName() + "를 섭취했습니다.");
            System.out.println("health 수치가 " + 아이템.getHealth() + "만큼 증가했습니다.");
            System.out.println("charm 수치가 -" + 아이템.getCharm() + "만큼 감소했습니다.");
            케이크.remove(0);
            능력치보여주기();
        } else if (value >= 1 && value <= 3) {
            System.out.println("음식이 없습니다. 아이템을 구매해주세요.");
        } else {
            System.out.println("다른 선택지를 입력하셨습니다.");
        }
    }

    // getter, setter
    public int get소지금() {
        return 소지금;
    }

    public void set소지금(int 소지금) {
        if (소지금 < 0) {
            this.소지금 = 0;
        } else {
            this.소지금 = 소지금;
        }
    }

    public void add소지금(int 소지금) {
        int new소지금 = this.소지금 + 소지금;
        if (new소지금 < 0) {
            this.소지금 = 0;
        } else {
            this.소지금 = new소지금;
        }
    }

    public List<의상> get옷장() {
        return 옷장;
    }

    public List<신발> get신발장() {
        return 신발장;
    }

    public List<음식물> get목캔디() {
        return 목캔디;
    }

    public List<음식물> get샐러드(){
        return 샐러드;
    }

    public List<음식물> get케이크() {
        return 케이크;
    }

    public 의상 get의상() {
        return 의상;
    }

    public 신발 get신발() {
        return 신발;
    }

    public void set의상(의상 의상) {
        this.의상 = 의상;
    }

    public void set신발(신발 신발) {
        this.신발 = 신발;
    }
}
