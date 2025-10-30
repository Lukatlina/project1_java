package character;

public class Rival extends Trainee {


    public Rival(String Name, int vocal, int rap, int charm, int dance, String grade, int voteCount) {
        super(Name, vocal, rap, charm, dance, grade, voteCount);
    }

    public void showStats() {
        System.out.println("--------------------------");
        System.out.println("        이름 : " + getName());
        System.out.println("        체력 : " + getHealth());
        System.out.println("        보컬 : " + getVocal());
        System.out.println("        랩 : " + getRap());
        System.out.println("        댄스 : " + getDance());
        System.out.println("        매력 : " + getCharm());
        System.out.println("        등급 : " + getGrade());
        System.out.println("        득표수 : " + getVoteCount());
        System.out.println("--------------------------");
    }
}
