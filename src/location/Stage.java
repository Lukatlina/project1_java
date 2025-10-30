package location;

import activity.FreeActivity;
import activity.training.*;
import activity.job.*;

import java.util.Random;
import java.util.Scanner;

import character.*;

public class Stage {

    private final Training vocalTraining = new VocalTraining(1, 3);
    private final Training rapTraining = new RapTraining(1, 3);
    private final Training danceTraining = new DanceTraining(1, 3);
    private final Training charmTraining = new CharmTraining(1, 3);

    private final Job cafeJob = new CafeJob(5, 28000, 1, 1);
    private final Job mascotJob = new MascotJob(5, 38000, 1);
    private final Job promoterJob = new PromoterJob(5, 48000, 1);

    private final FreeActivity freeActivity = new FreeActivity(30000, 10, 5);

    private final Scanner sc = new Scanner(System.in);
    private final Random random = new Random();


    public void runWeeklyRoutine(IndividualTrainee player) {
        System.out.println("한 주가 시작됩니다.");
        for (int i = 0; i < 5; i++) {
            runDailyRoutine(player);
        }
        System.out.println("토요일에 할 자유행동을 선택해주세요.");
        freeActivity.performFreeActivity(player);
        player.showStats();
    }

    public void runCompetition(IndividualTrainee player, Rival rival, int targetVoteCount) {

        rival.showStats();

        System.out.println("무대를 해야 할 시간입니다. 과연 최후까지 살아남을 수 있을까요?");
        System.out.println("국민 프로듀서분들께 어필할 행동을 선택해주세요.");

        player.setVoteCount(0);
        boolean isPerforming = true;
        while (isPerforming) {
            System.out.println("1. 공연하기 2. 개인기 선보이기");
            int value = sc.nextInt();
            if (value == 1) {
                player.perform(); // 매개변수 이용 잘 못하고 있음. 매개변수 메서드를 이용해서 할 수 있다.
                System.out.println("현재 " + player.getName() + "의 voteCount는 " + player.getVoteCount() + "입니다.");
                rival.perform();
                System.out.println("현재 " + rival.getName() + "의 voteCount는 " + rival.getVoteCount() + "입니다.");

                if (player.getVoteCount() >= targetVoteCount && rival.getVoteCount() < targetVoteCount) {
                    player.promoteGrade();
                    if (player.getGrade().equals("A")) {
                        System.out.println(player.getName() + "가 Agrade이 되어 아이돌 데뷔에 성공했습니다.");
                        System.exit(0);
                    } else {
                        System.out.println("1. 진행하기 2. 상태창 3. 소지물품 4. 의상실 5. 상점 6. 자진하차");
                        break;
                    }
                } else if (player.getVoteCount() < targetVoteCount && rival.getVoteCount() >= targetVoteCount) {
                    System.out.println("아쉽게도 다른 연습생이 먼저 " + targetVoteCount + "표를 달성하여 플레이어가 탈락했습니다.");
                    System.exit(0);
                    isPerforming = false;
                } else if (player.getVoteCount() >= targetVoteCount && rival.getVoteCount() >= targetVoteCount) {
                    if (player.getVoteCount() >= rival.getVoteCount()) {
                        player.promoteGrade();
                        break;
                    } else {
                        System.out.println("아쉽게도 다른 연습생이 더 많은 voteCount를 달성하여 플레이어가 탈락했습니다.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("다시 스킬을 사용합니다.");
                }
            } else if (value == 2) {
                player.displaySkillMenu();
                value = sc.nextInt();
                player.showSpecialSkill(value);
                System.out.println("현재 " + player.getName() + "의 득표수는 " + player.getVoteCount() + "입니다.");
                rival.showSpecialSkill(random.nextInt(4) + 1);
                System.out.println("현재 " + rival.getName() + "의 득표수는 " + rival.getVoteCount() + "입니다.");
                if (player.getVoteCount() >= targetVoteCount && rival.getVoteCount() < targetVoteCount) {
                    player.promoteGrade();
                    if (player.getGrade().equals("A")) {
                        System.out.println(player.getName() + "가 A등급이 되어 아이돌 데뷔에 성공했습니다.");
                        System.exit(0);
                    } else {
                        System.out.println("1. 진행하기 2. 상태창 3. 소지물품 4. 의상실 5. 상점 6. 자진하차");
                        break;
                    }
                } else if (player.getVoteCount() < targetVoteCount && rival.getVoteCount() >= targetVoteCount) {
                    System.out.println("아쉽게도 다른 연습생이 먼저 100,000표를 달성하여 플레이어가 탈락했습니다.");
                    System.exit(0);
                } else if (player.getVoteCount() >= targetVoteCount && rival.getVoteCount() >= targetVoteCount) {
                    if (player.getVoteCount() >= rival.getVoteCount()) {
                        player.promoteGrade();
                        break;
                    } else {
                        System.out.println("아쉽게도 다른 연습생이 더 많은 득표수를 달성하여 플레이어가 탈락했습니다.");
                        System.exit(0);
                    }
                } else {
                    System.out.println("다시 스킬을 사용합니다.");
                }
            }
        }
    }

    private void selectJob(IndividualTrainee player) {
        System.out.println("1. 카페 아르바이트 2. 인형탈 아르바이트 3. 프로모터 아르바이트 4. 뒤로가기");
        int value = sc.nextInt();
        if (value == 1) {
            cafeJob.acquireStats(player);
        } else if (value == 2) {
            mascotJob.acquireStats(player);
        } else if (value == 3) {
            promoterJob.acquireStats(player);
        } else {
            System.out.println("이전 선택지로 이동합니다.");
        }
    }

    private void selectTraining(IndividualTrainee player) {
        System.out.println("1. 보컬 2. 랩 3. 댄스 4. 표정연구 5. 뒤로가기");
        int value = sc.nextInt();
        if (value == 1) {
            vocalTraining.acquireStats(player);
        } else if (value == 2) {
            rapTraining.acquireStats(player);
        } else if (value == 3) {
            danceTraining.acquireStats(player);
        } else if (value == 4) {
            charmTraining.acquireStats(player);
        } else {
            System.out.println("이전 선택지로 이동합니다.");
        }
    }

    private void runActivityChoice(IndividualTrainee player) {

        System.out.println("1. 트레이닝 2. 아르바이트. 3. 아무 것도 하지 않기");
        int value = sc.nextInt();
        if (value == 1) {
            System.out.println("트레이닝을 받습니다.");
            System.out.println("어떤 트레이닝을 받을까요?");

            selectTraining(player);

        } else if (value == 2) {
            System.out.println("아르바이트를 합니다.");
            System.out.println("어떤 아르바이트를 할까요?");
            selectJob(player);

        } else if (value == 3) {
            System.out.println("아무 것도 하지 않고 다음 스케쥴을 진행합니다.");

        } else {
            System.out.println("1에서 3까지만 선택할 수 있습니다.");
            System.out.println("다시 숫자를 입력해주세요.");
        }
    }

    private void runDailyRoutine(IndividualTrainee player) {
        System.out.println("오전에 할 일을 선택해 주세요");
        runActivityChoice(player);
        System.out.println("오후에 할 일을 선택해 주세요.");
        runActivityChoice(player);
        System.out.println("하루가 지났습니다.");
        player.showStats();
    }
}