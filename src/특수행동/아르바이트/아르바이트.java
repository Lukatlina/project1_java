package 특수행동.아르바이트;

import 캐릭터.개인연습생;
import java.util.Random;

// 책추천? -> 객체지향의 사실과 오해
// 객체라는 개념은 일상에서 접할 수 있다. new로 만들면 됨.
// 추상클래스가 객체를 만들 수가 없음. -> 일상생활에서도 똑같이 느낄 수 있다.
// 신이 있다 할 때 눈 앞에 없지만 존재한다 믿음. 사랑같은 것도 마찬가지임. -> 대답 불가능
// 도대체 뭐를 객체화 하고 싶은건가?를 생각해야 한다.

public abstract class 아르바이트 {
    private int 체력;
    private int 일당;

    public 아르바이트(int 체력, int 일당) {
        this.체력 = 체력;
        this.일당 = 일당;
    }


// 꼭 매번 메소드를 구현해서 써야 하는 형태라면 써도 됨.
// 메소드 상속시 일반 메소드는 super 사용가능하지만 추상메소드는 안에 내용물이 없기때문에 상속 불가능
//    public void 알바반복(개인연습생 플레이어);

    public abstract void 능력치습득(개인연습생 플레이어);



    public int get체력() {
        return 체력;
    }

    public void set체력(int 체력) {
        this.체력 = 체력;
    }

    public int get일당() {
        return 일당;
    }

    public void set일당(int 일당) {
        this.일당 = 일당;
    }
}
