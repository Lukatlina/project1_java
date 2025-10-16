package 캐릭터;

import 아이템.*;
import 특수행동.*;

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
    // 몸통이라고 하면 뭘하지라고 생각이 들게 됨
    // 상식적으로 좀 이상하다 -> 생각해보기



    // 생성자
    // 의상 A = new 의상("한복", 400000,30); //
    // 의상 B; // 변수 선언, 물리적인 자리만 만드는 것
    // B = new 의상("잠옷", 50000, 10); // 값을 할당
    public 개인연습생(String 이름, int 보컬, int 랩, int 매력, int 댄스, String 등급, int 득표수, int 소지금) {
        super(이름, 보컬, 랩, 매력, 댄스, 등급, 득표수);
        this.소지금 = 소지금;
    }


    public void 능력치보여주기() {
        System.out.println("--------------------------");
        System.out.println("        이름 : " + get이름());
        System.out.println("        체력 : " + get체력());
        System.out.println("        보컬 : " + get보컬());
        System.out.println("        랩 : " + get랩());
        System.out.println("        댄스 : " + get댄스());
        System.out.println("        매력 : " + get매력());
        System.out.println("        등급 : " + get등급());
        System.out.println("        소지금 : " + get소지금());
        System.out.println("        득표수 : " + get득표수());
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
            System.out.println(i + " : " + 옷장.get(i).get물품명());
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
            System.out.println(i + " : " + 신발장.get(i).get물품명());
        }
        System.out.println("----------------------------------------");
    }
    // 몸통이 리스트여서 여러개 집어넣을 수 있기 때문에 문제가 생길 수도 있음 -> 보통 코드의 상식과 다르다.
    // 코드를 봤을 때 뭐를 하겠다 추론을 할 수 있는데 굳이 리스트로 할 필요가 있을까?

    // 개인연습생에서 장비착용이라 하고 파라미터로 장비를 받아서 그 안에서 의상과 신발을 각각 받아올 수 있음 -> 답은 아니고 예시를 들어서 설명한 것
    public void 의상착용하기(int value) {
        if (의상 != null) {
            System.out.println("의상을 이미 착용중입니다.");
        } else if (value < 0 || value >= 옷장.size()) {
            System.out.println("해당하는 번호의 의상이 없습니다.");
        } else {
            final 의상 착용의상 = 옷장.get(value);

            set의상(착용의상);
            add매력(착용의상.get매력());
            옷장.remove(value);
            System.out.println("        의상 : " + 의상.get물품명());
            System.out.println("        의상 착용이 완료되었습니다.");
            능력치보여주기();
        }
    }


    // 개인연습생에서 장비착용이라 하고 파라미터로 장비를 받아서 그 안에서 의상과 신발을 각각 받아올 수 있음 -> 답은 아니고 예시를 들어서 설명한 것
    public void 신발착용하기(int value) {
        if (신발 != null) {
            System.out.println("신발을 이미 착용중입니다.");
        } else if (value < 0 || value >= 신발장.size()) {
            System.out.println("해당하는 번호의 신발이 없습니다.");
        } else {
            final 신발 착용신발 = 신발장.get(value);

            set신발(착용신발);
            add댄스(착용신발.get댄스());
            신발장.remove(value);
            System.out.println("        신발 : " + 신발.get물품명());
            System.out.println("        신발 착용이 완료되었습니다.");
            능력치보여주기();
        }
    }


    public void 의상벗기(){
        옷장.add(의상);
        set매력(get매력() - 의상.get매력());
        set의상(null);
        System.out.println("의상을 벗었습니다.");
    }

    public void 신발벗기() {
        신발장.add(신발);
        set댄스(get댄스() - 신발.get댄스());
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
        // player.get목캔디().get(0) -> 변수에 저장해서 사용하면 더 직관적, 성능적으로도 좀 좋지 않음, 코드가 긴것보다 짧은것이 나음
        // 파라미터에 덧셈을 꼭 넣지 않아도 됨. setter 기존값에 더하고 빼줄것 , 내가 지금 보컬값에 얼마를 더하겠다 정의하는 것이 더 간단한 방식
        // 만약 다르게 메소드를 쓸 일이 있으면 메소드 두개 만드는 것이 좋음 ex) sum보컬
        // 습관과 관점의 문제 -> 코드 짤 때 효율을 추구하는 것이 좋음. -> 지속적으로 코드의 효율을 봐야 함.
        // -> 코드 참고시 코드의 장단점과 어떻게 사용하는 것이 좋을지 생각해야 함 -> 코드를 대하는 자세가 다 차이가 있음
        // 타인의 코드를 항상 의심해보기, 적합한지 이해하고 생각하고 적절한지 볼 것 -> 이후에는 결국에 남들이 짜지 않는 코드를 짜야 한다.
        // 코드를 검색하려면 코드에 이름이 있어야 하는데 이후에는 세세하게 검색할 수 없다. 코드를 부를 만한 명칭이 대부분 없다.
        // 그런 코드를 잘 작성하기 위해서는 많이 짜보고 이 코드가 좋은지 스스로 생각하고 판단할 수 있어야 한다.
        // 참고는 문법정도로 해야한다.
        // 합치는 작업해보기!
        // 툴에서 제공하는 기능들 더 찾아보기
        // 오타 실수는 코드가 정리 안되어 있으면 주로 나기 때문에 간단하게 만들기 -> 생산성에 영향을 끼침
        if (value == 1 && !목캔디.isEmpty()) {
            final 음식물 아이템 = 목캔디.get(0);

            add보컬(아이템.get보컬());
            add랩(아이템.get랩());
            System.out.println(아이템.get물품명() + "를 섭취했습니다.");
            System.out.println("보컬 수치가 " + 아이템.get보컬() + "만큼 증가했습니다.");
            System.out.println("랩 수치가 " + 아이템.get랩() + "만큼 증가했습니다.");
            목캔디.remove(0);
            능력치보여주기();
        } else if (value == 2 && !샐러드.isEmpty()) {
            final 음식물 아이템 = 샐러드.get(0);

            add체력(아이템.get체력());
            add매력(아이템.get매력());
            System.out.println(아이템.get물품명() + "를 섭취했습니다.");
            System.out.println("체력 수치가 " + 아이템.get체력() + "만큼 증가했습니다.");
            System.out.println("매력 수치가 " + 아이템.get매력() + "만큼 증가했습니다.");
            샐러드.remove(0);
            능력치보여주기();
        } else if (value == 3 && !케이크.isEmpty()) {
            final 음식물 아이템 = 케이크.get(0);

            add체력(아이템.get체력());
            set매력(get매력() - 아이템.get매력());
            System.out.println(아이템.get물품명() + "를 섭취했습니다.");
            System.out.println("체력 수치가 " + 아이템.get체력() + "만큼 증가했습니다.");
            System.out.println("매력 수치가 -" + 아이템.get매력() + "만큼 감소했습니다.");
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
        this.소지금 = 소지금;
    }

    public void add소지금(int 소지금) {
        this.소지금 += 소지금;
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
