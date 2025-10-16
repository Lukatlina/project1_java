package 아이템;

public class 소비품 extends 아이템{
    private int 보컬;
    private int 랩;
    private int 체력;
    private int 매력;

    public 소비품(String 물품명, int 가격, int 체력, int 보컬, int 랩, int 매력) {
        super(물품명, 가격);
        this.체력 = 체력;
        this.보컬 = 보컬;
        this.랩 = 랩;
        this.매력 = 매력;
    }

        public int get보컬(){
            return 보컬;
        }

        public int get랩() {
            return 랩;
        }

        public int get체력(){
            return 체력;
        }

        public int get매력(){
            return 매력;
        }

    }

