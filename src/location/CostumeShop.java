package location;

import character.*;
import item.*;

// 사고 파는 과정을 보이기 위한 클래스
public class CostumeShop {
    private final Costume trainingSuit = new Costume("트레이닝복", 100000, 10);
    private final Costume techWear = new Costume("테크웨어", 150000, 20);
    private final Costume suit = new Costume("수트", 200000, 30);
    private final Shoes sneakers = new Shoes("운동화", 100000, 10);
    private final Shoes boots = new Shoes("부츠", 150000, 15);
    private final Shoes dressShoes = new Shoes("구두", 200000, 20);


    public void showItems() {
        System.out.println("구매하실 물품의 번호를 입력해 주세요.");
        System.out.println("-----------------------------------------------");
        System.out.println("1. " + trainingSuit.getItemName() + " : 매력 " + trainingSuit.getCharm() + " / 가격 " + trainingSuit.getPrice() + "원");
        System.out.println("2. " + techWear.getItemName() + " : 매력 " + techWear.getCharm() + " / 가격 " + techWear.getPrice() + "원");
        System.out.println("3. " + suit.getItemName() + " : 매력 " + suit.getCharm() + " / 가격 " + suit.getPrice() + "원");
        System.out.println("4. " + sneakers.getItemName() + " : 댄스 " + sneakers.getDance() + " / 가격 " + sneakers.getPrice() + "원");
        System.out.println("5. " + boots.getItemName() + " : 댄스 " + boots.getDance() + " / 가격 " + boots.getPrice() + "원");
        System.out.println("6. " + dressShoes.getItemName() + " : 댄스 " + dressShoes.getDance() + " / 가격 " + dressShoes.getPrice() + "원");
        System.out.println("-----------------------------------------------");
    }

    public void buyEquipment(int value, IndividualTrainee player) {

        if (value == 1) {
            processPurchase(player, trainingSuit);
        } else if (value == 2) {
            processPurchase(player, techWear);
        } else if (value == 3) {
            processPurchase(player, suit);
        } else if (value == 4) {
            processPurchase(player, sneakers);
        } else if (value == 5) {
            processPurchase(player, boots);
        } else if (value == 6) {
            processPurchase(player, dressShoes);
        }else{
            System.out.println("번호에 해당하는 아이템이 없습니다.");
        }
    }

    public void sellCostume(int value, IndividualTrainee player) {
        if (player.getWardrobe().size() <= value || value < 0) {
            System.out.println("보유 아이템이 없습니다.");
            return;
        }

        final Costume costume = player.getWardrobe().get(value);
        player.addMoney(costume.getPrice());
        System.out.println(costume.getItemName() + " 판매가 완료되었습니다.");
        player.getWardrobe().remove(value);
        System.out.println("현재 소지금이 " + player.getMoney() + "원 남았습니다.");
    }

    public void sellShoes(int value, IndividualTrainee player) {
        if (player.getShoeRack().size() <= value || value < 0) {
            System.out.println("보유 아이템이 없습니다.");
            return;
        }

        final Shoes shoes = player.getShoeRack().get(value);
        player.addMoney(shoes.getPrice());
        System.out.println(shoes.getItemName() + " 판매가 완료되었습니다.");
        player.getShoeRack().remove(value);
        System.out.println("현재 소지금이 " + player.getMoney() + "원 남았습니다.");
    }

    private void processPurchase(IndividualTrainee player, Equipment equipment) {
        if ((equipment instanceof Costume && player.getWardrobe().contains(equipment)) ||
                (equipment instanceof Shoes && player.getShoeRack().contains(equipment))) {
            System.out.println(equipment.getItemName() + "은 이미 소유하고 있습니다. 구매가 불가능합니다.");
            return;
        }

        if (player.getMoney() < equipment.getPrice()) {
            System.out.println("소지금 부족으로 구매가 불가능합니다.");
            return;
        }

        if (equipment instanceof Costume) { // 의상인 경우
            player.setMoney(player.getMoney() - equipment.getPrice());
            // player 앞에서 연습생이라고 해서 가져와서 오류가 나게 됨. 상위클래스가 아닌 하위클래스를 가져와야 함.
            player.getWardrobe().add((Costume) equipment);
            System.out.println(equipment.getItemName() + " 구매가 완료되었습니다.");
            System.out.println("현재 소지금이 " + player.getMoney() + "원 남았습니다.");
            player.showWardrobe();

        } else if (equipment instanceof Shoes) { // 신발인 경우
            player.setMoney(player.getMoney() - equipment.getPrice());
            player.getShoeRack().add((Shoes) equipment);
            System.out.println(equipment.getItemName() + " 구매가 완료되었습니다.");
            System.out.println("현재 소지금이 " + player.getMoney() + "원 남았습니다.");
            player.showShoeRack();
        }
    }


}