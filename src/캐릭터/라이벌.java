package 캐릭터;

public class 라이벌 extends 연습생{


    public 라이벌(String Name, int vocal, int rap, int charm, int dance, String grade, int voteCount) {
        super(Name, vocal, rap, charm, dance, grade, voteCount);
    }

    public void 능력치보여주기() {
        System.out.println("--------------------------");
        System.out.println("        Name : " + getName());
        System.out.println("        health : " + getHealth());
        System.out.println("        vocal : " + getVocal());
        System.out.println("        rap : " + getRap());
        System.out.println("        dance : " + getDance());
        System.out.println("        charm : " + getCharm());
        System.out.println("        grade : " + getGrade());
        System.out.println("        voteCount : " + getVoteCount());
        System.out.println("--------------------------");
    }
}
