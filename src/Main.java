import 장소.상점;
import 장소.스테이지;
import 장소.의상실;
import 캐릭터.개인연습생;
import 캐릭터.라이벌;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 선언
        final Scanner sc = new Scanner(System.in);
        final Random 랜덤 = new Random();

        final int F_GOAL = 10000;
        final int D_GOAL = 200000;
        final int C_GOAL = 300000;
        final int B_GOAL = 400000;

        System.out.println("----------------------------------------");
        System.out.println(">> 소속사 아이돌 데뷔조에서 탈락했다.");
        System.out.println(">> 데뷔를 위해 준비했지만 이미지가 안 맞아서 탈락이라니. 이제 뭘 해야하지?");
        System.out.println("\n========================================");
        System.out.println("            [ 🔔 카톡! ]            "); // 중앙 정렬 및 강조
        System.out.println("========================================");
        System.out.println("\n>> 누구지? 연락올 사람이 없을텐데?");
        System.out.println("\n----------------------------------------");
        System.out.println("[팀장님] 혹시 서바이벌 프로그램 나갈 생각 없니?");
        System.out.println("[팀장님] 이번에 남자 아이돌 프로그램 새로 만든다는데");
        System.out.println("[팀장님] 네가 생각나서 연락해봤어. 실력이 너무 아깝잖아.");
        System.out.println("[팀장님] 개인연습생으로 참여 가능하다더라. 혹시 할 생각있으면 지원해봐");
        System.out.println("----------------------------------------");
        System.out.println("\n>> 전소속사 팀장님이네...프로듀스 101? 한번 도전이나 해볼까?");
        System.out.println("\n========================================"); // 선택 전 강조
        System.out.println("1. 도전하기 2. 나가기");
        System.out.println("========================================");

        int value = sc.nextInt();

        //게임 시작 여부 선택창
        if (value == 1) {

            System.out.println("========================================");
            System.out.println(">> 그래, 한번 도전해보자."); // 최종 결정 강조
            System.out.println("========================================");

            // . == at, reference 참조하다의 의미, 지역변수 이름.필드/메서드 형식으로 사용
            // 참조 연산자(.) : 지역 변수가 저장하고 있는 메모리 주소를 찾아간다(참조한다)는 의미
            System.out.println("이름을 입력해주세요.");
            final String 이름 = sc.next();
            final 의상실 의상실 = new 의상실();
            final 상점 상점 = new 상점();
            final 스테이지 스테이지 = new 스테이지();


            // 플레이어 생성
            final 개인연습생 player = new 개인연습생(
                    이름,
                    랜덤.nextInt(21) + 10,
                    랜덤.nextInt(21) + 10,
                    랜덤.nextInt(21) + 10,
                    랜덤.nextInt(21) + 10,
                    "F",
                    0,
                    200000
               );


            System.out.println();
            player.능력치보여주기();

            boolean 메인선택창 = true;
            while (메인선택창) {
                System.out.println("1. 진행하기 2. 상태창 3. 소지물품 4. 의상실 5. 상점 6. 자진하차");
                value = sc.nextInt();
                if (value == 1) {

                    System.out.println("1. 1주차 : F등급 입장가능");
                    System.out.println("2. 2주차 : D등급 입장가능");
                    System.out.println("3. 3주차 : C등급 입장가능");
                    System.out.println("4. 4주차 : B등급 입장가능");
                    value = sc.nextInt();

                    if (player.get등급().equals("F") && value == 1) {
                        스테이지.일주일루틴(player);
                        final 라이벌 D등급라이벌 = new 라이벌("라이관린", 30, 30, 50, 30, "D", 0);
                        스테이지.일요일반복(player, D등급라이벌, F_GOAL);
                    } else if (player.get등급().equals("D") && value == 2) {
                        스테이지.일주일루틴(player);
                        final 라이벌 C등급라이벌 = new 라이벌("김재환", 70, 50, 50, 50, "C", 0);
                        스테이지.일요일반복(player, C등급라이벌, D_GOAL);
                    } else if (player.get등급().equals("C") && value == 3) {
                        스테이지.일주일루틴(player);
                        final 라이벌 B등급라이벌 = new 라이벌("강다니엘", 60, 70, 70, 80, "B", 0);
                        스테이지.일요일반복(player, B등급라이벌, C_GOAL);
                    } else if (player.get등급().equals("B") && value == 4) {
                        스테이지.일주일루틴(player);
                        final 라이벌 A등급라이벌 = new 라이벌("박지훈", 90, 80, 100, 90,"A", 0);
                        스테이지.일요일반복(player, A등급라이벌, B_GOAL);
                    }else {
                        System.out.println("입장 조건을 충족하지 못했습니다.");
                        System.out.println("선택지로 다시 돌아갑니다.");
                    }


                } else if (value == 2) {
                    // 캐릭터의 능력치를 확인할 수 있는 공간, 보유 아이템도 확인 가능
                    player.능력치보여주기();
                    player.보유아이템확인하기();
                    player.의상보여주기();
                    player.신발보여주기();

                } else if (value == 3) {
                    // 소지물품 확인, 아이템 탈부착과 섭취 가능
                    // 탈출할 때 보통 break를 걺
                    boolean 인벤토리 = true;
                    while (인벤토리) {
                        System.out.println("다음 선택지를 선택해주세요.");
                        System.out.println("1. 의상 착용 2. 신발 착용 3. 아이템 사용 4. 의상 벗기 5. 신발 벗기 6. 뒤로가기");
                        value = sc.nextInt();

                        if (value == 1){
                            if (!player.get옷장().isEmpty()) {
                                player.의상보여주기();
                                System.out.println("착용하고 싶은 의상을 선택해주세요");
                                value = sc.nextInt();
                                player.의상착용하기(value);

                            }else{
                                System.out.println("옷장이 비어있습니다. 의상을 구매해주세요.");
                            }

                        } else if (value == 2) {
                            if (!player.get신발장().isEmpty()) {
                                player.신발보여주기();
                                System.out.println("착용하고 싶은 신발을 선택해주세요");
                                value = sc.nextInt();
                                player.신발착용하기(value);
                            } else {
                                System.out.println("신발장이 비어있습니다. 신발을 구매해주세요.");
                            }
                        } else if (value == 3) {
                            if (player.get목캔디().isEmpty() && player.get샐러드().isEmpty() && player.get케이크().isEmpty()) {
                                System.out.println("아이템이 없습니다. 상점에서 구매해주세요.");
                            } else {
                                player.보유아이템확인하기();
                                System.out.println("섭취할 아이템 번호를 선택해주세요.");
                                value = sc.nextInt();

                                player.아이템먹기(value);
                            }


                        } else if (value == 4) {
                            if (player.get의상() != null) {
                                player.의상벗기();
                                player.의상보여주기();
                            }else{
                                System.out.println("착용하고 있는 의상이 없습니다.");
                            }
                        } else if (value == 5) {
                            if (player.get신발() != null) {
                                player.신발벗기();
                                player.신발보여주기();
                            }else{
                                System.out.println("착용하고 있는 의상이 없습니다.");
                            }
                        } else if (value == 6) {
                            인벤토리 = false;
                            System.out.println("다음 선택지를 선택해주세요.");
                        }else{
                            System.out.println("1에서 6까지만 선택할 수 있습니다.");
                            System.out.println("다시 숫자를 입력해주세요.");
                        }

                    }
                } else if (value == 4) {
                    // 의상실 : 아이템 구매와 판매가 가능
                    System.out.println("의상실에 입장했습니다.");
                    boolean 의상실스테이지 = true;
                    while (의상실스테이지){
                        System.out.println("다음 선택지를 선택해주세요.");
                        System.out.println("1. 구매하기 2. 판매하기 3. 뒤로가기");
                        value = sc.nextInt();

                        if (value == 1) {
                            System.out.println("현재 소지금이 " + player.get소지금() + "원 있습니다.");
                            의상실.의상실아이템보기();
                            System.out.println("구매하실 아이템의 번호를 입력해주세요.");
                            value = sc.nextInt();
                            의상실.장착아이템구매하기(value, player);


                        } else if (value == 2) {
                            System.out.println("현재 소지금이 " + player.get소지금() + "원 있습니다.");
                            System.out.println("다음 선택지를 선택해주세요.");
                            System.out.println("1. 의상판매 2. 신발판매");
                            value = sc.nextInt();

                            if (value == 1 && player.get옷장().isEmpty() == false) {
                                player.의상보여주기();
                                System.out.println("판매하실 아이템의 번호를 입력해주세요.");
                                value = sc.nextInt();
                                의상실.의상판매(value, player);

                            } else if (value == 2 && player.get신발장().isEmpty() == false) {
                                player.신발보여주기();
                                System.out.println("판매하실 아이템의 번호를 입력해주세요.");
                                value = sc.nextInt();
                                의상실.신발판매(value, player);
                            }else {
                                System.out.println("판매 가능한 아이템이 없습니다.");
                            }
                        } else if (value == 3) {
                            의상실스테이지 = false;
                            System.out.println("다음 선택지를 선택해주세요.");

                        }else{
                            System.out.println("1에서 3까지만 선택할 수 있습니다.");
                            System.out.println("다시 숫자를 입력해주세요.");
                        }
                    }
                } else if (value == 5) {
                    System.out.println("상점에 입장했습니다.");
                    boolean 상점스테이지 = true;
                    while (상점스테이지) {
                        System.out.println("다음 선택지를 선택해주세요.");
                        System.out.println("1. 구매하기 2. 판매하기 3. 뒤로가기");
                        value = sc.nextInt();

                        if (value == 1){
                            System.out.println("현재 소지금이 " + player.get소지금() + "원 있습니다.");
                            상점.상점아이템보기();
                            System.out.println("구매하실 아이템의 번호를 입력해주세요.");
                            value = sc.nextInt();
                            상점.아이템구매하기(value, player);

                        } else if (value == 2) {
                            System.out.println("현재 소지금이 " + player.get소지금() + "원 있습니다.");
                            상점.상점아이템보기();
                            System.out.println("판매하실 아이템의 번호를 입력해주세요.");
                            value = sc.nextInt();
                            상점.아이템판매하기(value, player);

                        } else if (value == 3) {
                            상점스테이지 = false;
                            System.out.println("다음 선택지를 선택해주세요.");


                        }else{
                            System.out.println("1에서 3까지만 선택할 수 있습니다.");
                            System.out.println("다시 숫자를 입력해주세요.");
                        }
                    }

                } else if (value == 6) {
                    System.out.println("프로듀스 101에서 자진하차합니다.");
                    System.out.println("당신은 아이돌이 되는 것을 포기합니다.");
                    메인선택창 = false;
                } else {
                    System.out.println("1에서 6까지만 선택할 수 있습니다.");
                    System.out.println("다시 숫자를 입력해주세요.");
                }
            }

        } else {
            System.out.println("게임을 끝냅니다.");
        }
    }
}

