package 캐릭터;

public class 라이벌 extends 연습생{


    public 라이벌(String 이름, int 보컬, int 랩, int 매력, int 댄스, String 등급, int 득표수) {
        super(이름, 보컬, 랩, 매력, 댄스, 등급, 득표수);
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
        System.out.println("        득표수 : " + get득표수());
        System.out.println("--------------------------");
    }
}
