package character;

import item.*;

import java.util.ArrayList;
import java.util.List;


public class IndividualTrainee extends Trainee {
    // 변수 선언
    private int money;
    private Costume costume;
    private Shoes 신발;
    private List<Costume> 옷장 = new ArrayList<Costume>();
    private List<Shoes> 신발장 = new ArrayList<Shoes>();
    private List<Food> 목캔디 = new ArrayList<Food>();
    private List<Food> 샐러드 = new ArrayList<Food>();
    private List<Food> 케이크 = new ArrayList<Food>();

    // 생성자
    // 의상 A = new 의상("한복", 400000,30);
    // 의상 B; // 변수 선언, 물리적인 자리만 만드는 것
    // B = new 의상("잠옷", 50000, 10); // 값을 할당
    public IndividualTrainee(String Name, int vocal, int rap, int charm, int dance, String grade, int voteCount, int money) {
        super(Name, vocal, rap, charm, dance, grade, voteCount);
        this.money = money;
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
        System.out.println("        money : " + getMoney());
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
        if (costume != null) {
            System.out.println("의상을 이미 착용중입니다.");
        } else if (value < 0 || value >= 옷장.size()) {
            System.out.println("해당하는 번호의 의상이 없습니다.");
        } else {
            final Costume 착용의상 = 옷장.get(value);

            setCostume(착용의상);
            addCharm(착용의상.getCharm());
            옷장.remove(value);
            System.out.println("        의상 : " + costume.getItemName());
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
            final Shoes 착용신발 = 신발장.get(value);

            set신발(착용신발);
            addDance(착용신발.getDance());
            신발장.remove(value);
            System.out.println("        신발 : " + 신발.getItemName());
            System.out.println("        신발 착용이 완료되었습니다.");
            능력치보여주기();
        }
    }

    public void 의상벗기(){
        옷장.add(costume);
        setCharm(getCharm() - costume.getCharm());
        setCostume(null);
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
            final Food 아이템 = 목캔디.get(0);

            addVocal(아이템.getVocal());
            addRap(아이템.getRap());
            System.out.println(아이템.getItemName() + "를 섭취했습니다.");
            System.out.println("vocal 수치가 " + 아이템.getVocal() + "만큼 증가했습니다.");
            System.out.println("rap 수치가 " + 아이템.getRap() + "만큼 증가했습니다.");
            목캔디.remove(0);
            능력치보여주기();
        } else if (value == 2 && !샐러드.isEmpty()) {
            final Food 아이템 = 샐러드.get(0);

            addHealth(아이템.getHealth());
            addCharm(아이템.getCharm());
            System.out.println(아이템.getItemName() + "를 섭취했습니다.");
            System.out.println("health 수치가 " + 아이템.getHealth() + "만큼 증가했습니다.");
            System.out.println("charm 수치가 " + 아이템.getCharm() + "만큼 증가했습니다.");
            샐러드.remove(0);
            능력치보여주기();
        } else if (value == 3 && !케이크.isEmpty()) {
            final Food 아이템 = 케이크.get(0);

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
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        if (money < 0) {
            this.money = 0;
        } else {
            this.money = money;
        }
    }

    public void addMoney(int money) {
        int newMoney = this.money + money;
        if (newMoney < 0) {
            this.money = 0;
        } else {
            this.money = newMoney;
        }
    }

    public List<Costume> get옷장() {
        return 옷장;
    }

    public List<Shoes> get신발장() {
        return 신발장;
    }

    public List<Food> get목캔디() {
        return 목캔디;
    }

    public List<Food> get샐러드(){
        return 샐러드;
    }

    public List<Food> get케이크() {
        return 케이크;
    }

    public Costume getCostume() {
        return costume;
    }

    public Shoes get신발() {
        return 신발;
    }

    public void setCostume(Costume Costume) {
        this.costume = Costume;
    }

    public void set신발(Shoes 신발) {
        this.신발 = 신발;
    }
}
