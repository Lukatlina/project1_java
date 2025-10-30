package location;

import character.*;
import item.*;

// 사고 파는 과정을 보이기 위한 클래스
public class CostumeShop {
    private final Costume 트레이닝복 = new Costume("트레이닝복", 100000, 10);
    private final Costume 테크웨어 = new Costume("테크웨어", 150000, 20);
    private final Costume 수트 = new Costume("수트", 200000, 30);
    private final Shoes 운동화 = new Shoes("운동화", 100000, 10);
    private final Shoes 부츠 = new Shoes("부츠", 150000, 15);
    private final Shoes 구두 = new Shoes("구두", 200000, 20);


    public void 의상실아이템보기() {
        System.out.println("구매하실 물품의 번호를 입력해 주세요.");
        System.out.println("-----------------------------------------------");
        System.out.println("1. " + 트레이닝복.getItemName() + " : charm " + 트레이닝복.getCharm() + " / price " + 트레이닝복.getPrice() + "원");
        System.out.println("2. " + 테크웨어.getItemName() + " : charm " + 테크웨어.getCharm() + " / price " + 테크웨어.getPrice() + "원");
        System.out.println("3. " + 수트.getItemName() + " : charm " + 수트.getCharm() + " / price " + 수트.getPrice() + "원");
        System.out.println("4. " + 운동화.getItemName() + " : dance " + 운동화.getDance() + " / price " + 운동화.getPrice() + "원");
        System.out.println("5. " + 부츠.getItemName() + " : dance " + 부츠.getDance() + " / price " + 부츠.getPrice() + "원");
        System.out.println("6. " + 구두.getItemName() + " : dance " + 구두.getDance() + " / price " + 구두.getPrice() + "원");
        System.out.println("-----------------------------------------------");
    }

    public void 장비아이템구매하기(int value, IndividualTrainee 플레이어) {

        if (value == 1) {
            장비아이템사기(플레이어, 트레이닝복);
        } else if (value == 2) {
            장비아이템사기(플레이어, 테크웨어);
        } else if (value == 3) {
            장비아이템사기(플레이어, 수트);
        } else if (value == 4) {
            장비아이템사기(플레이어, 운동화);
        } else if (value == 5) {
            장비아이템사기(플레이어, 부츠);
        } else if (value == 6) {
            장비아이템사기(플레이어, 구두);
        }else{
            System.out.println("번호에 해당하는 아이템이 없습니다.");
        }
    }

    public void 의상판매(int value, IndividualTrainee 플레이어) {
        if (플레이어.get옷장().size() <= value || value < 0) {
            System.out.println("보유 아이템이 없습니다.");
            return;
        }

        final Costume Costume = 플레이어.get옷장().get(value);
        플레이어.addMoney(Costume.getPrice());
        System.out.println(Costume.getItemName() + " 판매가 완료되었습니다.");
        플레이어.get옷장().remove(value);
        System.out.println("현재 money이 " + 플레이어.getMoney() + "원 남았습니다.");
    }

    public void 신발판매(int value, IndividualTrainee 플레이어) {
        if (플레이어.get신발장().size() <= value || value < 0) {
            System.out.println("보유 아이템이 없습니다.");
            return;
        }

        final Shoes 신발 = 플레이어.get신발장().get(value);
        플레이어.addMoney(신발.getPrice());
        System.out.println(신발.getItemName() + " 판매가 완료되었습니다.");
        플레이어.get신발장().remove(value);
        System.out.println("현재 money이 " + 플레이어.getMoney() + "원 남았습니다.");
    }

    private void 장비아이템사기(IndividualTrainee 플레이어, Equipment Equipment) {
        if ((Equipment instanceof Costume && 플레이어.get옷장().contains(Equipment)) ||
                (Equipment instanceof Shoes && 플레이어.get신발장().contains(Equipment))) {
            System.out.println(Equipment.getItemName() + "은 이미 소유하고 있습니다. 구매가 불가능합니다.");
            return;
        }

        if (플레이어.getMoney() < Equipment.getPrice()) {
            System.out.println("money 부족으로 구매가 불가능합니다.");
            return;
        }

        if (Equipment instanceof Costume) { // 의상인 경우
            플레이어.setMoney(플레이어.getMoney() - Equipment.getPrice());
            // 플레이어 앞에서 연습생이라고 해서 가져와서 오류가 나게 됨. 상위클래스가 아닌 하위클래스를 가져와야 함.
            플레이어.get옷장().add((Costume) Equipment);
            System.out.println(Equipment.getItemName() + " 구매가 완료되었습니다.");
            System.out.println("현재 money이 " + 플레이어.getMoney() + "원 남았습니다.");
            플레이어.의상보여주기();

        } else if (Equipment instanceof Shoes) { // 신발인 경우
            플레이어.setMoney(플레이어.getMoney() - Equipment.getPrice());
            플레이어.get신발장().add((Shoes) Equipment);
            System.out.println(Equipment.getItemName() + " 구매가 완료되었습니다.");
            System.out.println("현재 money이 " + 플레이어.getMoney() + "원 남았습니다.");
            플레이어.신발보여주기();
        }
    }


}