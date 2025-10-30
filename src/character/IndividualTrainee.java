package character;

import item.*;

import java.util.ArrayList;
import java.util.List;


public class IndividualTrainee extends Trainee {
    // 변수 선언
    private int money;
    private Costume costume;
    private Shoes shoes;
    private final List<Costume> wardrobe = new ArrayList<>();
    private final List<Shoes> shoeRack = new ArrayList<>();
    private final List<Food> throatCandies = new ArrayList<>();
    private final List<Food> salads = new ArrayList<>();
    private final List<Food> cakes = new ArrayList<>();

    public IndividualTrainee(String Name, int vocal, int rap, int charm, int dance, String grade, int voteCount, int money) {
        super(Name, vocal, rap, charm, dance, grade, voteCount);
        this.money = money;
    }

    public void showStats() {
        System.out.println("--------------------------");
        System.out.println("        이름 : " + getName());
        System.out.println("        체력 : " + getHealth());
        System.out.println("        보컬 : " + getVocal());
        System.out.println("        랩 : " + getRap());
        System.out.println("        댄스 : " + getDance());
        System.out.println("        매력 : " + getCharm());
        System.out.println("        등급 : " + getGrade());
        System.out.println("        소지금 : " + getMoney());
        System.out.println("        득표수 : " + getVoteCount());
        System.out.println("--------------------------");
    }

    public void showWardrobe() {
        if (wardrobe.isEmpty()) {
            System.out.println("현재 보유한 의상이 없습니다.");
            return;
        }

        System.out.println("----------------------------------------");
        System.out.println("현재 보유한 의상 확인");
        for(int i = 0; i < wardrobe.size(); i++){
            System.out.println(i + " : " + wardrobe.get(i).getItemName());
        }
        System.out.println("----------------------------------------");
    }

    public void showShoeRack() {
        if (shoeRack.isEmpty()){
            System.out.println("현재 보유한 신발이 없습니다.");
        }
        System.out.println("----------------------------------------");

        System.out.println("현재 보유한 신발 확인");
        for(int i = 0; i < shoeRack.size(); i++ ){
            System.out.println(i + " : " + shoeRack.get(i).getItemName());
        }
        System.out.println("----------------------------------------");
    }

    public void equipCostume(int value) {
        if (costume != null) {
            System.out.println("의상을 이미 착용중입니다.");
        } else if (value < 0 || value >= wardrobe.size()) {
            System.out.println("해당하는 번호의 의상이 없습니다.");
        } else {
            final Costume equippedCostume = wardrobe.get(value);

            setCostume(equippedCostume);
            addCharm(equippedCostume.getCharm());
            wardrobe.remove(value);
            System.out.println("        의상 : " + costume.getItemName());
            System.out.println("        의상 착용이 완료되었습니다.");
            showStats();
        }
    }

    public void equipShoes(int value) {
        if (shoes != null) {
            System.out.println("신발을 이미 착용중입니다.");
        } else if (value < 0 || value >= shoeRack.size()) {
            System.out.println("해당하는 번호의 신발이 없습니다.");
        } else {
            final Shoes equippedShoes = shoeRack.get(value);

            setShoes(equippedShoes);
            addDance(equippedShoes.getDance());
            shoeRack.remove(value);
            System.out.println("        신발 : " + shoes.getItemName());
            System.out.println("        신발 착용이 완료되었습니다.");
            showStats();
        }
    }

    public void unequipCostume(){
        wardrobe.add(costume);
        setCharm(getCharm() - costume.getCharm());
        setCostume(null);
        System.out.println("의상을 벗었습니다.");
    }

    public void unequipShoes() {
        shoeRack.add(shoes);
        setDance(getDance() - shoes.getDance());
        setShoes(null);
        System.out.println("신발을 벗었습니다.");
    }

    public void showConsumableStock(){
        System.out.println("현재 보유한 아이템 확인");
        System.out.println("1. 목캔디 : " + throatCandies.size() + "개");
        System.out.println("2. 샐러드 : " + salads.size() + "팩");
        System.out.println("3. 케이크 : " + cakes.size() + "조각");
    }

    public void consumeItem(int value){
        if (value == 1 && !throatCandies.isEmpty()) {
            final Food item = throatCandies.getFirst();

            addVocal(item.getVocal());
            addRap(item.getRap());
            System.out.println(item.getItemName() + "를 섭취했습니다.");
            System.out.println("보컬 수치가 " + item.getVocal() + "만큼 증가했습니다.");
            System.out.println("랩 수치가 " + item.getRap() + "만큼 증가했습니다.");
            throatCandies.removeFirst();
            showStats();
        } else if (value == 2 && !salads.isEmpty()) {
            final Food item = salads.getFirst();

            addHealth(item.getHealth());
            addCharm(item.getCharm());
            System.out.println(item.getItemName() + "를 섭취했습니다.");
            System.out.println("체력 수치가 " + item.getHealth() + "만큼 증가했습니다.");
            System.out.println("매력 수치가 " + item.getCharm() + "만큼 증가했습니다.");
            salads.removeFirst();
            showStats();
        } else if (value == 3 && !cakes.isEmpty()) {
            final Food item = cakes.getFirst();

            addHealth(item.getHealth());
            setCharm(getCharm() - item.getCharm());
            System.out.println(item.getItemName() + "를 섭취했습니다.");
            System.out.println("체력 수치가 " + item.getHealth() + "만큼 증가했습니다.");
            System.out.println("매력 수치가 -" + item.getCharm() + "만큼 감소했습니다.");
            cakes.removeFirst();
            showStats();
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
        this.money = Math.max(money, 0);
    }

    public void addMoney(int money) {
        int newMoney = this.money + money;
        this.money = Math.max(newMoney, 0);
    }

    public List<Costume> getWardrobe() {
        return wardrobe;
    }

    public List<Shoes> getShoeRack() {
        return shoeRack;
    }

    public List<Food> getThroatCandies() {
        return throatCandies;
    }

    public List<Food> getSalads(){
        return salads;
    }

    public List<Food> getCakes() {
        return cakes;
    }

    public Costume getCostume() {
        return costume;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setCostume(Costume Costume) {
        this.costume = Costume;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }
}
