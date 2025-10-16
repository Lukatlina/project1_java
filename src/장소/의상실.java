package 장소;

import 캐릭터.*;
import 아이템.*;

import java.util.List;

// 사고 파는 과정을 보이기 위한 클래스
public class 의상실 {
    private final 의상 트레이닝복 = new 의상("트레이닝복", 100000, 10);
    private final 의상 테크웨어 = new 의상("테크웨어", 150000, 20);
    private final 의상 수트 = new 의상("수트", 200000, 30);
    private final 신발 운동화 = new 신발("운동화", 100000, 10);
    private final 신발 부츠 = new 신발("부츠", 150000, 15);
    private final 신발 구두 = new 신발("구두", 200000, 20);


    public void 의상실아이템보기() {
        System.out.println("구매하실 물품의 번호를 입력해 주세요.");
        System.out.println("-----------------------------------------------");
        System.out.println("1. " + 트레이닝복.get물품명() + " : 매력 " + 트레이닝복.get매력() + " / 가격 " + 트레이닝복.get가격() + "원");
        System.out.println("2. " + 테크웨어.get물품명() + " : 매력 " + 테크웨어.get매력() + " / 가격 " + 테크웨어.get가격() + "원");
        System.out.println("3. " + 수트.get물품명() + " : 매력 " + 수트.get매력() + " / 가격 " + 수트.get가격() + "원");
        System.out.println("4. " + 운동화.get물품명() + " : 댄스 " + 운동화.get댄스() + " / 가격 " + 운동화.get가격() + "원");
        System.out.println("5. " + 부츠.get물품명() + " : 댄스 " + 부츠.get댄스() + " / 가격 " + 부츠.get가격() + "원");
        System.out.println("6. " + 구두.get물품명() + " : 댄스 " + 구두.get댄스() + " / 가격 " + 구두.get가격() + "원");
        System.out.println("-----------------------------------------------");
    }

    public void 장착아이템구매하기(int value, 개인연습생 플레이어) {

        if (value == 1) {
            장비아이템사기(플레이어, 트레이닝복);
        } else if (value == 2) {
            장비아이템사기(플레이어, 테크웨어);
//            옷사기(플레이어, 테크웨어, 플레이어.get옷장());
        } else if (value == 3) {
            장비아이템사기(플레이어, 수트);
//            옷사기(플레이어, 수트, 플레이어.get옷장());
        } else if (value == 4) {
            장비아이템사기(플레이어, 운동화);
//            신발사기(플레이어, 운동화, 플레이어.get신발장());
        } else if (value == 5) {
//            신발사기(플레이어, 부츠, 플레이어.get신발장());
            장비아이템사기(플레이어, 부츠);
        } else if (value == 6) {
//            신발사기(플레이어, 구두, 플레이어.get신발장());
            장비아이템사기(플레이어, 구두);
        }else{
            System.out.println("번호에 해당하는 아이템이 없습니다.");
        }
    }

    private void 장비아이템사기(개인연습생 플레이어, 장비 장비) {
        if ((장비 instanceof 의상 && 플레이어.get옷장().contains(장비)) ||
                (장비 instanceof 신발 && 플레이어.get신발장().contains(장비))) {
            System.out.println(장비.get물품명() + "은 이미 소유하고 있습니다. 구매가 불가능합니다.");
            return;
        }

        if (플레이어.get소지금() < 장비.get가격()) {
            System.out.println("소지금 부족으로 구매가 불가능합니다.");
            return;
        }

        if (장비 instanceof 의상) { // 의상인 경우
            플레이어.set소지금(플레이어.get소지금() - 장비.get가격());
            // 플레이어 앞에서 연습생이라고 해서 가져와서 오류가 나게 됨. 상위클래스가 아닌 하위클래스를 가져와야 함.
            플레이어.get옷장().add((의상)장비);
            System.out.println(장비.get물품명() + " 구매가 완료되었습니다.");
            System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
            플레이어.의상보여주기();

        } else if (장비 instanceof 신발) { // 신발인 경우
            플레이어.set소지금(플레이어.get소지금() - 장비.get가격());
            플레이어.get신발장().add((신발)장비);
            System.out.println(장비.get물품명() + " 구매가 완료되었습니다.");
            System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
            플레이어.신발보여주기();
        }
    }

    // 리스트 안에 물건이 없다면 접근 못하게 막기 -> 리스트에 값이 없으면 null값, get value가 안되서 오류가 생기는 것. 예외처리?
    // -> 방법이 두가지가 있음. 첫번째는 크게 이 조건문을 감싸는 조건문을 만들어서 리스트에 값이 있는지 확인하기, 리스트에 값이 하나라도 있는지 확인하기
    // contains : 리스트 안에 어떤 객체가 있는지 확인해서 true나 false를 반환하는 메소드
    // get(index) : 해당 인덱스의 값을 반환하는 메소드
//    public void 의상판매(int value, 개인연습생 플레이어) {
//        if (플레이어.get옷장().contains(플레이어.get옷장().get(value)) == true) {
//            if (value <= 플레이어.get옷장().size()){
//                플레이어.add소지금(플레이어.get옷장().get(value).get가격());
//                System.out.println(플레이어.get옷장().get(value).get물품명() + " 판매가 완료되었습니다.");
//                플레이어.get옷장().remove(value);
//                System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
//            }else{
//                System.out.println("보유 아이템이 없습니다.");
//            }
//
//        } else {
//            System.out.println("보유 아이템이 없습니다.");
//        }
//    }
//
//    public void 신발판매(int value, 개인연습생 플레이어) {
//        if (플레이어.get신발장().contains(플레이어.get신발장().get(value)) == true) {
//            플레이어.add소지금(플레이어.get신발장().get(value).get가격());
//            System.out.println(플레이어.get신발장().get(value).get물품명() + " 판매가 완료되었습니다.");
//            플레이어.get신발장().remove(value);
//            System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
//        } else {
//            System.out.println("보유 아이템이 없습니다.");
//        }
//    }

    public void 의상판매(int value, 개인연습생 플레이어) {
        if (플레이어.get옷장().size() <= value || value < 0) {
            System.out.println("보유 아이템이 없습니다.");
            return;
        }

        final 의상 의상 = 플레이어.get옷장().get(value);
        플레이어.add소지금(의상.get가격());
        System.out.println(의상.get물품명() + " 판매가 완료되었습니다.");
        플레이어.get옷장().remove(value);
        System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
    }

    public void 신발판매(int value, 개인연습생 플레이어) {
        if (플레이어.get신발장().size() <= value || value < 0) {
            System.out.println("보유 아이템이 없습니다.");
            return;
        }

        final 신발 신발 = 플레이어.get신발장().get(value);
        플레이어.add소지금(신발.get가격());
        System.out.println(신발.get물품명() + " 판매가 완료되었습니다.");
        플레이어.get신발장().remove(value);
        System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
    }


}