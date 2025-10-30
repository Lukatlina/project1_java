package location;

import item.Food;
import character.*;

import java.util.List;
import java.util.Random;


public class FoodShop {
    // 음식을 사고 팔 수 있는 클래스
    private Food 목캔디 = new Food("목캔디", 5000, 0, 0, 0, 0);
    private final Food 샐러드 = new Food("샐러드", 8900, 5, 0, 0, 5 );
    private final Food 케이크 = new Food("케이크", 7000, 20, 0,0,5);

    public void 상점아이템보기() {
        System.out.println("1. " + 목캔디.getItemName() + " : vocal & rap : 0 ~ 2 / price " + 목캔디.getPrice() + "원");
        System.out.println("2. " + 샐러드.getItemName() + " : health " + 샐러드.getHealth() + " / charm " + 샐러드.getCharm() + " / price " + 샐러드.getPrice() + "원");
        System.out.println("3. " + 케이크.getItemName() + " : health " + 케이크.getHealth() + " / charm " + 케이크.getCharm() + " / price " + 케이크.getPrice() + "원");
    }

    public void 아이템구매하기(int value, IndividualTrainee 플레이어) {
        Random random = new Random();
        목캔디 = new Food("목캔디", 5000, 0, random.nextInt(2)+1, random.nextInt(2)+1, 0);
        if (value == 1) {
            음식물구매(플레이어, 목캔디, 플레이어.get목캔디());
        } else if (value == 2) {
            음식물구매(플레이어, 샐러드, 플레이어.get샐러드());
        } else if (value == 3) {
            음식물구매(플레이어, 케이크, 플레이어.get케이크());
        }
        플레이어.보유아이템확인하기();
    }

    public void 아이템판매하기(int value, IndividualTrainee 플레이어) {
        if (value == 1 && 플레이어.get목캔디().isEmpty() == false) {
            음식물판매(플레이어, 플레이어.get목캔디());
        } else if (value == 2 && 플레이어.get샐러드().isEmpty() == false) {
            음식물판매(플레이어, 플레이어.get샐러드());
        } else if (value == 3 && 플레이어.get케이크().isEmpty() == false) {
            음식물판매(플레이어, 플레이어.get케이크());
        }else{
            System.out.println("판매할 아이템이 없습니다.");
        }
    }

    private void 음식물판매(IndividualTrainee 플레이어, List<Food> Food) {
        if (Food.isEmpty() == false) {
            플레이어.addMoney(Food.get(0).getPrice());
            Food.remove(0);
            System.out.println("현재 money이 " + 플레이어.getMoney() + "원 남았습니다.");
            플레이어.보유아이템확인하기();
        } else {
            System.out.println("판매할 아이템이 없습니다.");
        }
    }

    private void 음식물구매(IndividualTrainee 플레이어, Food 변수명, List<Food> Food) {
        if (플레이어.getMoney() >= 변수명.getPrice()) {
            플레이어.addMoney(-변수명.getPrice());
            Food.add(변수명);
            System.out.println(변수명.getItemName() + " 구매가 완료되었습니다.");
            System.out.println("현재 money이 " + 플레이어.getMoney() + "원 남았습니다.");
        } else {
            System.out.println("구매가 불가능합니다.");
        }
    }
}