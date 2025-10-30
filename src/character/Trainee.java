package character;

import java.util.Random;


public abstract class Trainee {
    private final String name;
    private int health = 100;
    private int vocal;
    private int rap;
    private int charm;
    private int dance;
    private String grade;
    private int voteCount;
    private final Random random = new Random();

    // 생성자
    public Trainee(String name, int vocal, int rap, int charm, int dance, String grade, int voteCount) {
        this.name = name;
        this.vocal = vocal;
        this.rap = rap;
        this.charm = charm;
        this.dance = dance;
        this.grade = grade;
        this.voteCount = voteCount;
    }

    // 변수 접근자를 private로 만들었기 때문에 자식클래스가 상속해서 사용하기 위해서는 getter/setter를 사용해야 한다.
    public void perform() {
        // random으로 Good / SoSo / Bad 선택
        // random으로 상, 중, 하로 점수를 주도록 만듦.
        int outcome = random.nextInt(3);
        int baseStat = Math.max(vocal, rap);
        double modifier;
        if (outcome == 0) {
            modifier = 1.2;
        } else if (outcome == 1) {
            modifier = 1.0;
        } else {
            modifier = 0.8;
        }
        int calculatedVotes = (int) (baseStat * getDance() * getCharm() * modifier);
        addVoteCount(calculatedVotes);
    }

    public void showSpecialSkill(int value) {
        if (value == 1) {
            showcaseVocalSkill();
        } else if (value == 2) {
            showcaseDanceSkill();
        } else if (value == 3) {
            performAegyo();
        } else {
            performCryingAct();
        }
    }

    public void displaySkillMenu() {
        System.out.println("1. 노래부르기 : 보컬 or 랩 수치의 10배 ~ 100배 만큼 득표수를 얻을 수 있다.");
        System.out.println("2. 댄스 스킬 보이기 : 댄스 수치의 10배 ~ 100배 만큼 득표수를 얻을 수 있다.");
        System.out.println("3. 애교부리기 : 애교 수치의 10배 ~ 100배 만큼 득표수를 얻을 수 있다.");
        System.out.println("4. 눈물흘리기 : 애교 수치의 10배 ~ 500배 만큼 득표수를 얻을 수 있다. 단, 매력수치가 70이하일 경우 득표수가 랜덤으로 감소하게 된다.");
    }

    public void promoteGrade() {
        switch (getGrade()) {
            case "F":
                grade="D";
                System.out.println("F등급에서 D등급으로 상승했습니다.");
                break;

            case "D":
                grade="C";
                System.out.println("D등급에서 C등급으로 상승했습니다.");
                break;

            case "C":
                grade="B";
                System.out.println("C등급에서 B등급으로 상승했습니다.");
                break;

            case "B":
                grade="A";
                System.out.println("B등급에서 A등급으로 상승했습니다.");
                break;
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 0) {
            // health이 0보다 작으면 0으로 설정
            this.health = 0;
        } else {
            this.health = Math.min(health, 100);
        }
    }

    public void addHealth(int amount) {
        setHealth(this.health + amount);
    }

    public int getVocal() {
        return vocal;
    }

    public void addVocal(int vocal) {
        int newVocal = this.vocal + vocal;

        if (newVocal < 0) {
            this.vocal = 0;

        } else {
            this.vocal = Math.min(newVocal, 100);
        }
    }

    public int getRap() {
        return rap;
    }

    public void addRap(int rap) {
        int newRap = this.rap + rap;

        if (newRap < 0) {
            this.rap = 0;

        } else {
            this.rap = Math.min(newRap, 100);
        }
    }

    public int getCharm() {
        return charm;
    }

    public void setCharm(int charm) {
        if (charm < 0) {
            this.charm = 0;
        } else {
            this.charm = Math.min(charm, 100);
        }
    }

    public void addCharm(int charm) {
        int newCharm = this.charm + charm;

        if (newCharm < 0) {
            this.charm = 0;

        } else {
            this.charm = Math.min(newCharm, 100);
        }
    }

    public int getDance() {
        return dance;
    }

    public void setDance(int dance) {
        if (dance < 0) {
            this.dance = 0;
        } else {
            this.dance = Math.min(dance, 100);
        }
    }

    public void addDance(int dance) {
        int newDance = this.dance + dance;

        if (newDance < 0) {
            this.dance = 0;

        } else {
            this.dance = Math.min(newDance, 100);
        }
    }

    public String getGrade() {
        return grade;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = Math.max(voteCount, 0);
    }

    private void performCryingAct() {
        int voteCount;
        if (charm >= 70) {
            // 성공 : voteCount 증가 10배 - 300배
            int bonusMultiplier = random.nextInt(291) + 10;
            voteCount = charm * bonusMultiplier;
            addVoteCount(voteCount);
            System.out.println("눈물 연기가 성공하여 voteCount +" + voteCount + "를 획득했습니다.");
        } else {
            // 실패 : voteCount 감소
            // 매력수치가 70미만일 경우 매력수치의 10배에서 500배 사이 수치만큼 득표수 하락
            int penaltyMultiplier = random.nextInt(501) + 10;
            voteCount = charm * penaltyMultiplier;
            setVoteCount(this.voteCount - voteCount);
            System.out.println("어색한 연기로 voteCount -" + voteCount + "만큼 하락했습니다!");
        }
    }

    private void showcaseVocalSkill() {
        if (vocal > getRap()) {
            int voteCount = vocal * random.nextInt(101) + 10;
            addVoteCount(voteCount); // 매개변수가 직접 들어가는 것보다 늘어난 부분을 계산하는 식을 따로 넣는 것도 좋음. 가독성의 문제
        } else {
            int voteCount = rap * random.nextInt(101) + 10;
            addVoteCount(voteCount);
        }
    }

    private void  showcaseDanceSkill() {
        int voteCount = dance * random.nextInt(101) + 10;
        addVoteCount(voteCount);
    }

    private void performAegyo() {
        int voteCount = charm * random.nextInt(101) + 10;
        addVoteCount(voteCount);
    }
    
    private void addVoteCount(int voteCount) {
        int newVoteCount = this.voteCount + voteCount;
        this.voteCount = Math.max(newVoteCount, 0);
    }

    public boolean isEliminated() {
        return this.health <= 0;
    }
}