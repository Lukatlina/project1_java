package location;

import item.Food;
import character.*;

import java.util.List;
import java.util.Random;


public class FoodShop {
    // 음식을 사고 팔 수 있는 클래스
    private Food throatCandies = new Food("목캔디", 5000, 0, 0, 0, 0);
    private final Food salads = new Food("샐러드", 8900, 5, 0, 0, 5 );
    private final Food cakes = new Food("케이크", 7000, 20, 0,0,5);

    public void showItems() {
        System.out.println("1. " + throatCandies.getItemName() + " : 보컬 & 랩 : 0 ~ 2 / 가격 " + throatCandies.getPrice() + "원");
        System.out.println("2. " + salads.getItemName() + " : 체력 " + salads.getHealth() + " / 매력 " + salads.getCharm() + " / 가격 " + salads.getPrice() + "원");
        System.out.println("3. " + cakes.getItemName() + " : 체력 " + cakes.getHealth() + " / 매력 " + cakes.getCharm() + " / 가격 " + cakes.getPrice() + "원");
    }

    public void buyItem(int value, IndividualTrainee player) {
        Random random = new Random();
        throatCandies = new Food("목캔디", 5000, 0, random.nextInt(2)+1, random.nextInt(2)+1, 0);
        if (value == 1) {
            processPurchase(player, throatCandies, player.getThroatCandies());
        } else if (value == 2) {
            processPurchase(player, salads, player.getSalads());
        } else if (value == 3) {
            processPurchase(player, cakes, player.getCakes());
        }
        player.showConsumableStock();
    }

    public void sellItem(int value, IndividualTrainee player) {
        if (value == 1 && !player.getThroatCandies().isEmpty()) {
            processSale(player, player.getThroatCandies());
        } else if (value == 2 && !player.getSalads().isEmpty()) {
            processSale(player, player.getSalads());
        } else if (value == 3 && !player.getCakes().isEmpty()) {
            processSale(player, player.getCakes());
        }else{
            System.out.println("판매할 아이템이 없습니다.");
        }
    }

    private void processSale(IndividualTrainee player, List<Food> Food) {
        if (!Food.isEmpty()) {
            player.addMoney(Food.getFirst().getPrice());
            Food.removeFirst();
            System.out.println("현재 소지금이 " + player.getMoney() + "원 남았습니다.");
            player.showConsumableStock();
        } else {
            System.out.println("판매할 아이템이 없습니다.");
        }
    }

    private void processPurchase(IndividualTrainee player, Food item, List<Food> Food) {
        if (player.getMoney() >= item.getPrice()) {
            player.addMoney(-item.getPrice());
            Food.add(item);
            System.out.println(item.getItemName() + " 구매가 완료되었습니다.");
            System.out.println("현재 소지금이 " + player.getMoney() + "원 남았습니다.");
        } else {
            System.out.println("구매가 불가능합니다.");
        }
    }
}