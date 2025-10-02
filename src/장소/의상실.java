package 장소;

import 캐릭터.*;
import 아이템.*;

import java.util.ArrayList;
import java.util.List;

// 사고 파는 과정을 보이기 위한 클래스
public class 의상실 {
    private 의상 트레이닝복 = new 의상("트레이닝복", 100000, 10);
    private 의상 테크웨어 = new 의상("테크웨어", 150000, 20);
    private 의상 수트 = new 의상("수트", 200000, 30);
    private 신발 운동화 = new 신발("운동화", 100000, 10);
    private 신발 부츠 = new 신발("부츠", 150000, 15);
    private 신발 구두 = new 신발("구두", 200000, 20);


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


    // 리스트 유형을 의상 클래스나 신발 클래스로 설정했기 때문에 중복값 확인시에 해당 아이템명이 아닌 변수명이 들어가야 함
    // 다형성(Polymorphism) -> 시도한다면 빨간색 먼저 없애고 하기
    public void 옷사기(개인연습생 플레이어, 의상 변수명, List<의상> 의상) {
        if (플레이어.get소지금() >= 변수명.get가격() && 의상.contains(변수명) == false) {
            플레이어.set소지금(플레이어.get소지금() - 변수명.get가격());
            // 플레이어 앞에서 연습생이라고 해서 가져와서 오류가 나게 됨. 상위클래스가 아닌 하위클래스를 가져와야 함.
            플레이어.get옷장().add(변수명);
            System.out.println(변수명.get물품명() + " 구매가 완료되었습니다.");
            System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
            의상확인(플레이어);
        } else {
            System.out.println("구매가 불가능합니다.");
        }
    }

    public void 신발사기(개인연습생 player, 신발 변수명, List<신발> 신발) {
        if (player.get소지금() >= 변수명.get가격() && 신발.contains(변수명) == false) {
            player.set소지금(player.get소지금() - 변수명.get가격());
            player.get신발장().add(변수명);
            System.out.println(변수명.get물품명() + " 구매가 완료되었습니다.");
            System.out.println("현재 소지금이 " + player.get소지금() + "원 남았습니다.");
            의상확인(player);
        } else {
            System.out.println("구매가 불가능합니다.");
        }
    }

    public void 의상구매하기(int value, 개인연습생 플레이어) {
        if (value == 1) {
            옷사기(플레이어, 트레이닝복, 플레이어.get옷장());
        } else if (value == 2) {
            옷사기(플레이어, 테크웨어, 플레이어.get옷장());
        } else if (value == 3) {
            옷사기(플레이어, 수트, 플레이어.get옷장());
        } else if (value == 4) {
            신발사기(플레이어, 운동화, 플레이어.get신발장());
        } else if (value == 5) {
            신발사기(플레이어, 부츠, 플레이어.get신발장());
        } else if (value == 6) {
            신발사기(플레이어, 구두, 플레이어.get신발장());
        }
    }

    public void 의상확인(개인연습생 플레이어) {
        System.out.println("현재 보유한 의상");
//        for (의상 c : player.get옷장()) {
//            System.out.println(c.물품명);}
        for (int i = 0; i < 플레이어.get옷장().size(); i++) {
            System.out.println(i + " : " + 플레이어.get옷장().get(i).get물품명());
        }
    }

    public void 신발확인(개인연습생 플레이어) {
        System.out.println("현재 보유한 신발");
        for (int i = 0; i < 플레이어.get신발장().size(); i++) {
            System.out.println(i + " : " + 플레이어.get신발장().get(i).get물품명());
        }
    }
    // 리스트 안에 물건이 없다면 접근 못하게 막기 -> 리스트에 값이 없으면 null값, get value가 안되서 오류가 생기는 것. 예외처리?
    // -> 방법이 두가지가 있음. 첫번째는 크게 이 조건문을 감싸는 조건문을 만들어서 리스트에 값이 있는지 확인하기, 리스트에 값이 하나라도 있는지 확인하기
    // contains : 리스트 안에 어떤 객체가 있는지 확인해서 true나 false를 반환하는 메소드
    // get(index) : 해당 인덱스의 값을 반환하는 메소드
    public void 의상판매(int value, 개인연습생 플레이어) {
        if (플레이어.get옷장().contains(플레이어.get옷장().get(value)) == true) {
            if (value <= 플레이어.get옷장().size()){
                플레이어.add소지금(플레이어.get옷장().get(value).get가격());
                System.out.println(플레이어.get옷장().get(value).get물품명() + " 판매가 완료되었습니다.");
                플레이어.get옷장().remove(value);
                System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
            }else{
                System.out.println("보유 아이템이 없습니다.");
            }

        } else {
            System.out.println("보유 아이템이 없습니다.");
        }
    }

    public void 신발판매(int value, 개인연습생 플레이어) {
        if (플레이어.get신발장().contains(플레이어.get신발장().get(value)) == true) {
            플레이어.add소지금(플레이어.get신발장().get(value).get가격());
            System.out.println(플레이어.get신발장().get(value).get물품명() + " 판매가 완료되었습니다.");
            플레이어.get신발장().remove(value);
            System.out.println("현재 소지금이 " + 플레이어.get소지금() + "원 남았습니다.");
        } else {
            System.out.println("보유 아이템이 없습니다.");
        }
    }
}





