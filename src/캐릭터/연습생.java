package 캐릭터;

import java.util.Random;


public class 연습생 {
    private String 이름;
    private int 체력 = 100;
//    private int 최대체력 = 100;
    private int 보컬;
//    private int 최대보컬 = 100;
    private int 랩;
//    private int 최대랩 = 100;
    private int 매력;
//    private int 최대매력 = 100;
    private int 댄스;
//    private int 최대댄스 = 100;
    private String 등급;
    private int 득표수 = 0;
    Random 랜덤 = new Random();

    // 생성자
    public 연습생(String 이름, int 보컬, int 랩, int 매력, int 댄스, String 등급, int 득표수) {
        this.이름 = 이름;
        this.보컬 = 보컬;
        this.랩 = 랩;
        this.매력 = 매력;
        this.댄스 = 댄스;
        this.등급 = 등급;
        this.득표수 = 득표수;
    }

// 변수 접근자를 private로 만들었기 때문에 자식클래스가 상속해서 사용하기 위해서는 getter/setter를 사용해야 한다.
    public int 공연하기(){
        if(get보컬() > get랩()) {
            // 랜덤으로 Good / SoSo / Bad 선택
            int 랜덤값 = 랜덤.nextInt(3);
            int 득표수 = 0;
            // 랜덤으로 상, 중, 하로 점수를 주도록 만듦.
            if (랜덤값 == 0) {
                득표수 = (int) ((int) (get보컬() * get댄스() * get매력() * 1.2));
            } else if (랜덤값 == 1) {
                득표수 = (int) (get보컬() * get댄스() * get매력());
            } else {
                득표수 = (int) ((int) (get보컬() * get댄스() * get매력() * 0.8));
            }
            add득표수(득표수);
        }else{
            // 랜덤으로 Good / SoSo / Bad 선택
            int 랜덤값 = 랜덤.nextInt(3);
            int 득표수 = 0;
            // 랜덤으로 상, 중, 하로 점수를 주도록 만듦.
            if (랜덤값 == 0) {
                득표수 = (int) ((int) (get랩() * get댄스() * get매력() * 1.2));
            } else if (랜덤값 == 1) {
                득표수 = (int) (get랩() * get댄스() * get매력());
            } else {
                득표수 = (int) ((int) (get랩() * get댄스() * get매력() * 0.8));
            }
            add득표수(득표수);
        }return 득표수;
    }

    public void 눈물흘리기() {
        if (get매력() >= 70){
            int 득표수 = (int) (get매력() * 랜덤.nextInt(101)+10);
            add득표수(득표수);
        }else{
            int 득표수 = (int) (get매력() * 랜덤.nextInt(101)+10);
            set득표수(get득표수() - 득표수); // 매력수치가 70미만일 경우 10배에서 500배 사이 수치만큼 득표수 하락
        }

    }

    public void 가창력선보이기() {
        if (get보컬() > get랩()) {
            int 득표수 = (int) (get보컬() * 랜덤.nextInt(101)+10);
            add득표수(득표수); // 매개변수가 직접 들어가는 것보다 늘어난 부분을 계산하는 식을 따로 넣는 것도 좋음. 가독성의 문제
        } else {
            int 득표수 = (int) (get랩() * 랜덤.nextInt(101)+10);
            add득표수(득표수);
        }
    }

    public void 댄스스킬보이기() {
        int 득표수 = (int) (get댄스() * 랜덤.nextInt(101)+10);
        add득표수(득표수);
    }

    public void 애교부리기() {
        int 득표수 = (int) (get매력() * 랜덤.nextInt(101)+10);
        add득표수(득표수);
    }


    public void 개인기선보이기(int value){
        if (value == 1) {
            가창력선보이기();
        } else if (value == 2) {
            댄스스킬보이기();
        } else if (value == 3) {
            애교부리기();
        } else {
            눈물흘리기();
        }
    }

    public void 자기소개타임(){
        System.out.println("1. 노래부르기 : 보컬 or 랩 수치의 10배 ~ 100배 만큼 득표수를 얻을 수 있다.");
        System.out.println("2. 댄스 스킬 보이기 : 댄스 수치의 10배 ~ 100배 만큼 득표수를 얻을 수 있다.");
        System.out.println("3. 애교부리기 : 애교 수치의 10배 ~ 100배 만큼 득표수를 얻을 수 있다.");
        System.out.println("4. 눈물흘리기 : 애교 수치의 10배 ~ 500배 만큼 득표수를 얻을 수 있다. 단, 매력수치가 70이하일 경우 득표수가 랜덤으로 감소하게 된다.");
    }

    public void 등급상승(){
        if (get등급().equals("F")){
            set등급("D");
            System.out.println("F등급에서 D등급으로 상승했습니다.");
        } else if (get등급().equals("D")) {
            set등급("C");
            System.out.println("D등급에서 C등급으로 상승했습니다.");
        } else if (get등급().equals("C")) {
            set등급("B");
            System.out.println("C등급에서 B등급으로 상승했습니다.");
        }else {
            set등급("A");
            System.out.println("B등급에서 A등급으로 상승했습니다.");
        }
    }


    public String get이름() {
        return 이름;
    }

    public void set이름(String name) {
        this.이름 = 이름;
    }

    public int get체력() {
        return 체력;
    }

    public void set체력(int 체력) {
        this.체력 = 체력;
    }

    public void add체력(int 체력) {
        this.체력 += 체력;
    }

    public int get보컬() {
        return 보컬;
    }

    public void set보컬(int 보컬) {
        this.보컬 = 보컬;
    }

    // 메소드명 중복 방지하기
    public void add보컬(int 보컬) {
        this.보컬 += 보컬;
    }

    public int get랩() {
        return 랩;
    }

    public void set랩(int 랩) {
        this.랩 = 랩;
    }

    public void add랩(int 랩) {
        this.랩 += 랩;
    }

    public int get매력() {
        return 매력;
    }

    public void set매력(int 매력) {
        this.매력 = 매력;
    }

    public void add매력(int 매력) {
        this.매력 += 매력;
    }

    public int get댄스() {
        return 댄스;
    }

    public void set댄스(int 댄스) {
        this.댄스 = 댄스;
    }

    public void add댄스(int 댄스) {
        this.댄스 += 댄스;
    }


    public String get등급() {
        return 등급;
    }

    public void set등급(String 등급) {
        this.등급 = 등급;
    }

    public int get득표수() {
        return 득표수;
    }

    public void set득표수(int 득표수) {
        this.득표수 = 득표수;
    }

    public void add득표수(int 득표수) {
        this.득표수 += 득표수;
    }
}
