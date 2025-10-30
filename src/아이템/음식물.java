package 아이템;

public class 음식물 extends 소비품 {

    // 소비품 아래에 캔디나 다른 클래스 만들기 -> 일관성이 없음, 장비도 소비품처럼 했다면 문제는 안됐을 것

    // 생성자 여러개 만들기
    // 생성자 오버로딩
    // 보통은 itemName이 앞으로 가면 다 앞으로 감. 다형성 이용시 인자값 순서 일치하게 만듬. 갯수 차이가 있음 -> 일치시키기
    // 변수명도 각 클래스에 맞춰서 선언

    // 목캔디 생성자
    public 음식물(String itemName, int price, int health, int vocal, int rap, int charm) {
        super(itemName, price, health, vocal, rap, charm);
    }
}
