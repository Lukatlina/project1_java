package 장소;

import 활동.자유행동;
import 활동.트레이닝.*;
import 활동.아르바이트.*;

import java.util.Random;
import java.util.Scanner;

import 캐릭터.*;

public class 스테이지 {

    private final 트레이닝 vocal트레이닝 = new vocal트레이닝(1, 3);
    private final 트레이닝 rap트레이닝 = new rap트레이닝(1, 3);
    private final 트레이닝 dance트레이닝 = new dance트레이닝(1, 3);
    private final 트레이닝 표정연구하기 = new 표정연구하기(1, 3);

    private final 아르바이트 카페아르바이트 = new 카페아르바이트(5, 28000, 1, 1);
    private final 아르바이트 인형탈아르바이트 = new 인형탈아르바이트(5, 38000, 1);
    private final 아르바이트 프로모터아르바이트 = new 프로모터아르바이트(5, 48000, 1);

    private final 자유행동 자유행동 = new 자유행동(30000, 10, 5);

    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();


    public void 일주일루틴(개인연습생 플레이어) {
        System.out.println("한 주가 시작됩니다.");
        for (int i = 0; i < 5; i++) {
            하루루틴(플레이어);
        }
        System.out.println("토요일에 할 자유행동을 선택해주세요.");
        자유행동.토요일자유행동(플레이어);
        플레이어.능력치보여주기();
    }

    public void 일요일반복(개인연습생 플레이어, 라이벌 라이벌, int 달성voteCount) {

        라이벌.능력치보여주기();

        System.out.println("무대를 해야 할 시간입니다. 과연 최후까지 살아남을 수 있을까요?");
        System.out.println("국민 프로듀서분들께 어필할 행동을 선택해주세요.");

        플레이어.setVoteCount(0);
        boolean 공연 = true;
        while (공연) {
            System.out.println("1. 공연하기 2. 개인기 선보이기");
            int value = sc.nextInt();
            if (value == 1) {
                플레이어.공연하기(); // 매개변수 이용 잘 못하고 있음. 매개변수 메서드를 이용해서 할 수 있다.
                System.out.println("현재 " + 플레이어.getName() + "의 voteCount는 " + 플레이어.getVoteCount() + "입니다.");
                라이벌.공연하기();
                System.out.println("현재 " + 라이벌.getName() + "의 voteCount는 " + 라이벌.getVoteCount() + "입니다.");

                if (플레이어.getVoteCount() >= 달성voteCount && 라이벌.getVoteCount() < 달성voteCount) {
                    플레이어.grade상승();
                    if (플레이어.getGrade().equals("A")) {
                        System.out.println(플레이어.getName() + "가 Agrade이 되어 아이돌 데뷔에 성공했습니다.");
                        System.exit(0);
                    } else {
                        System.out.println("1. 진행하기 2. 상태창 3. 소지물품 4. 의상실 5. 상점 6. 자진하차");
                        break;
                    }
                } else if (플레이어.getVoteCount() < 달성voteCount && 라이벌.getVoteCount() >= 달성voteCount) {
                    System.out.println("아쉽게도 다른 연습생이 먼저 " + 달성voteCount + "표를 달성하여 플레이어가 탈락했습니다.");
                    System.exit(0);
                    공연 = false;
                } else if (플레이어.getVoteCount() >= 달성voteCount && 라이벌.getVoteCount() >= 달성voteCount) {
                    if (플레이어.getVoteCount() >= 라이벌.getVoteCount()) {
                        플레이어.grade상승();
                        break;
                    } else {
                        System.out.println("아쉽게도 다른 연습생이 더 많은 voteCount를 달성하여 플레이어가 탈락했습니다.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("다시 스킬을 사용합니다.");
                }
            } else if (value == 2) {
                플레이어.자기소개타임();
                value = sc.nextInt();
                플레이어.개인기선보이기(value);
                System.out.println("현재 " + 플레이어.getName() + "의 voteCount는 " + 플레이어.getVoteCount() + "입니다.");
                라이벌.개인기선보이기(random.nextInt(4) + 1);
                System.out.println("현재 " + 라이벌.getName() + "의 voteCount는 " + 라이벌.getVoteCount() + "입니다.");
                if (플레이어.getVoteCount() >= 달성voteCount && 라이벌.getVoteCount() < 달성voteCount) {
                    플레이어.grade상승();
                    if (플레이어.getGrade().equals("A")) {
                        System.out.println(플레이어.getName() + "가 Agrade이 되어 아이돌 데뷔에 성공했습니다.");
                        System.exit(0);
                    } else {
                        System.out.println("1. 진행하기 2. 상태창 3. 소지물품 4. 의상실 5. 상점 6. 자진하차");
                        break;
                    }
                } else if (플레이어.getVoteCount() < 달성voteCount && 라이벌.getVoteCount() >= 달성voteCount) {
                    System.out.println("아쉽게도 다른 연습생이 먼저 100,000표를 달성하여 플레이어가 탈락했습니다.");
                    System.exit(0);
                } else if (플레이어.getVoteCount() >= 달성voteCount && 라이벌.getVoteCount() >= 달성voteCount) {
                    if (플레이어.getVoteCount() >= 라이벌.getVoteCount()) {
                        플레이어.grade상승();
                        break;
                    } else {
                        System.out.println("아쉽게도 다른 연습생이 더 많은 voteCount를 달성하여 플레이어가 탈락했습니다.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("다시 스킬을 사용합니다.");
                }
            }
        }
    }

    private void 아르바이트선택(개인연습생 플레이어) {
        System.out.println("1. 카페아르바이트 2. 인형탈아르바이트 3. 프로모터아르바이트 4. 뒤로가기");
        int value = sc.nextInt();
        if (value == 1) {
            카페아르바이트.능력치습득(플레이어);
        } else if (value == 2) {
            인형탈아르바이트.능력치습득(플레이어);
        } else if (value == 3) {
            프로모터아르바이트.능력치습득(플레이어);
        } else {
            System.out.println("이전 선택지로 이동합니다.");
        }
    }

    private void 트레이닝선택(개인연습생 플레이어) {
        System.out.println("1. vocal 2. rap 3. dance 4. 표정연구 5. 뒤로가기");
        int value = sc.nextInt();
        if (value == 1) {
            vocal트레이닝.능력치습득(플레이어);
        } else if (value == 2) {
            rap트레이닝.능력치습득(플레이어);
        } else if (value == 3) {
            dance트레이닝.능력치습득(플레이어);
        } else if (value == 4) {
            표정연구하기.능력치습득(플레이어);
        } else {
            System.out.println("이전 선택지로 이동합니다.");
        }
    }

    private void 하루선택지(개인연습생 플레이어) {

        System.out.println("1. 트레이닝 2. 아르바이트. 3. 아무 것도 하지 않기");
        int value = sc.nextInt();
        if (value == 1) {
            System.out.println("트레이닝을 받습니다.");
            System.out.println("어떤 트레이닝을 받을까요?");

            트레이닝선택(플레이어);

        } else if (value == 2) {
            System.out.println("아르바이트를 합니다.");
            System.out.println("어떤 아르바이트를 할까요?");
            아르바이트선택(플레이어);

        } else if (value == 3) {
            System.out.println("아무 것도 하지 않고 다음 스케쥴을 진행합니다.");

        } else {
            System.out.println("1에서 3까지만 선택할 수 있습니다.");
            System.out.println("다시 숫자를 입력해주세요.");
        }
    }

    private void 하루루틴(개인연습생 플레이어) {
        System.out.println("오전에 할 일을 선택해 주세요");
        하루선택지(플레이어);
        System.out.println("오후에 할 일을 선택해 주세요.");
        하루선택지(플레이어);
        System.out.println("하루가 지났습니다.");
        플레이어.능력치보여주기();
    }
}