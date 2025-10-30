package 아이템;

public class 소비품 extends 아이템{
    private final int vocal;
    private final int rap;
    private final int health;
    private final int charm;

    public 소비품(String itemName, int price, int health, int vocal, int rap, int charm) {
        super(itemName, price);
        this.health = health;
        this.vocal = vocal;
        this.rap = rap;
        this.charm = charm;
    }

        public int getVocal(){
            return vocal;
        }

        public int getRap() {
            return rap;
        }

        public int getHealth(){
            return health;
        }

        public int getCharm(){
            return charm;
        }

    }

