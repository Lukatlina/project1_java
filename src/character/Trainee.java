package character;

import java.util.Random;


public abstract class Trainee {
    private final String Name;
    private int health = 100;
    private int vocal;
    private int rap;
    private int charm;
    private int dance;
    private String grade;
    private int voteCount;
    private final Random random = new Random();

    // 생성자
    public Trainee(String Name, int vocal, int rap, int charm, int dance, String grade, int voteCount) {
        this.Name = Name;
        this.vocal = vocal;
        this.rap = rap;
        this.charm = charm;
        this.dance = dance;
        this.grade = grade;
        this.voteCount = voteCount;
    }

    // 변수 접근자를 private로 만들었기 때문에 자식클래스가 상속해서 사용하기 위해서는 getter/setter를 사용해야 한다.
    public int 공연하기() {
        // random으로 Good / SoSo / Bad 선택
        // random으로 상, 중, 하로 점수를 주도록 만듦.
        int random값 = random.nextInt(3);
        int voteCount = 0;
        if (vocal > getRap()) {
            System.out.println(voteCount);
            if (random값 == 0) {
                voteCount = (int) ((vocal * getDance() * getCharm() * 1.2));
            } else if (random값 == 1) {
                voteCount = vocal * getDance() * getCharm();
            } else {
                voteCount = (int) ((vocal * getDance() * getCharm() * 0.8));
            }
            addVoteCount(voteCount);
        } else {
            System.out.println(voteCount);
            if (random값 == 0) {
                voteCount = (int) ((getRap() * getDance() * getCharm() * 1.2));
            } else if (random값 == 1) {
                voteCount = getRap() * getDance() * getCharm();
            } else {
                voteCount = (int) ((getRap() * getDance() * getCharm() * 0.8));
            }
            addVoteCount(voteCount);
        }
        return voteCount;
    }

    public void 개인기선보이기(int value) {
        if (value == 1) {
            가창력선보이기();
        } else if (value == 2) {
            dance스킬보이기();
        } else if (value == 3) {
            애교부리기();
        } else {
            눈물흘리기();
        }
    }

    public void 자기소개타임() {
        System.out.println("1. 노래부르기 : vocal or rap 수치의 10배 ~ 100배 만큼 voteCount를 얻을 수 있다.");
        System.out.println("2. dance 스킬 보이기 : dance 수치의 10배 ~ 100배 만큼 voteCount를 얻을 수 있다.");
        System.out.println("3. 애교부리기 : 애교 수치의 10배 ~ 100배 만큼 voteCount를 얻을 수 있다.");
        System.out.println("4. 눈물흘리기 : 애교 수치의 10배 ~ 500배 만큼 voteCount를 얻을 수 있다. 단, charm수치가 70이하일 경우 voteCount가 random으로 감소하게 된다.");
    }

    public void grade상승() {
        if (getGrade().equals("F")) {
            grade="D";
            System.out.println("Fgrade에서 Dgrade으로 상승했습니다.");
        } else if (getGrade().equals("D")) {
            grade="C";
            System.out.println("Dgrade에서 Cgrade으로 상승했습니다.");
        } else if (getGrade().equals("C")) {
            grade="B";
            System.out.println("Cgrade에서 Bgrade으로 상승했습니다.");
        } else {
            grade="A";
            System.out.println("Bgrade에서 Agrade으로 상승했습니다.");
        }
    }

    public String getName() {
        return Name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            // health이 0보다 작으면 0으로 설정
            this.health = 0;
            System.out.println("health이 고갈되어 더 이상 진행할 수 없습니다. 자진하차를 선택했습니다.");
            // 프로그램 종료
            System.exit(0);

        } else if (health > 100) {
            // health이 100보다 클 수 없도록 이상이여도 100으로 설정
            this.health = 100;

        } else {
            this.health = health;
        }
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public int getVocal() {
        return vocal;
    }

    public void addVocal(int vocal) {
        int newvocal = this.vocal + vocal;

        if (newvocal < 0) {
            this.vocal = 0;

        } else if (newvocal > 100) {
            this.vocal = 100;

        } else {
            this.vocal = newvocal;
        }
    }

    public int getRap() {
        return rap;
    }

    public void addRap(int rap) {
        int newrap = this.rap + rap;

        if (newrap < 0) {
            this.rap = 0;

        } else if (newrap > 100) {
            this.rap = 100;

        } else {
            this.rap = newrap;
        }
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        if (charm < 0) {
            this.charm = 0;
        } else if (charm > 100) {
            this.charm = 100;
        } else {
            this.charm = charm;
        }
    }

    public void addCharm(int charm) {
        int newcharm = this.charm + charm;

        if (newcharm < 0) {
            this.charm = 0;

        } else if (newcharm > 100) {
            this.charm = 100;

        } else {
            this.charm = newcharm;
        }
    }

    public int getDance() {
        return dance;
    }

    public void setDance(int dance) {
        if (dance < 0) {
            this.dance = 0;
        } else if (dance > 100) {
            this.dance = 100;
        } else {
            this.dance = dance;
        }
    }

    public void addDance(int dance) {
        int newdance = this.dance + dance;

        if (newdance < 0) {
            this.dance = 0;

        } else if (newdance > 100) {
            this.dance = 100;

        } else {
            this.dance = newdance;
        }
    }

    public String getGrade() {
        return grade;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        if (voteCount < 0) {
            this.voteCount = 0;
        } else {
            this.voteCount = voteCount;
        }
    }

    private void 눈물흘리기() {
        int voteCount;
        if (charm >= 70) {
            // 성공 : voteCount 증가 10배 - 300배
            int 증가random값 = random.nextInt(291) + 10;
            voteCount = charm * 증가random값;
            addVoteCount(voteCount);
            System.out.println("눈물 연기가 성공하여 voteCount +" + voteCount + "를 획득했습니다.");
        } else {
            // 실패 : voteCount 감소
            // charm수치가 70미만일 경우 charm수치의 10배에서 500배 사이 수치만큼 voteCount 하락
            int 하락random값 = random.nextInt(501) + 10;
            voteCount = charm * 하락random값;
            setVoteCount(voteCount - voteCount);
            System.out.println("어색한 연기로 voteCount -" + voteCount + "만큼 하락했습니다!");
        }
    }

    private void 가창력선보이기() {
        if (vocal > getRap()) {
            int voteCount = vocal * random.nextInt(101) + 10;
            addVoteCount(voteCount); // 매개변수가 직접 들어가는 것보다 늘어난 부분을 계산하는 식을 따로 넣는 것도 좋음. 가독성의 문제
        } else {
            int voteCount = rap * random.nextInt(101) + 10;
            addVoteCount(voteCount);
        }
    }

    private void dance스킬보이기() {
        int voteCount = dance * random.nextInt(101) + 10;
        addVoteCount(voteCount);
    }

    private void 애교부리기() {
        int voteCount = charm * random.nextInt(101) + 10;
        addVoteCount(voteCount);
    }
    
    private void addVoteCount(int voteCount) {
        int newvoteCount = this.voteCount + voteCount;

        if (newvoteCount < 0) {
            this.voteCount = 0;

        } else {
            this.voteCount = newvoteCount;
        }
    }
}