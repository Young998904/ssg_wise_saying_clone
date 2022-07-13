package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    Scanner sc;
    int wiseSayingLastId;
    List<WiseSaying> wiseSayings;
    public App() {
        sc = new Scanner(System.in);
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }
    public void run() {
        String cmd;
        System.out.println("=== 명언 SSG ===");

        outer:
        while (true) {
            System.out.printf("명령 ) ");
            cmd = sc.nextLine().trim();
            switch (cmd) {
                case "종료" :
                    break outer;

                case "등록" :
                    WiseSaying wiseSaying = new WiseSaying();

                    wiseSaying.id = ++wiseSayingLastId;
                    System.out.printf("명언 : ");
                    wiseSaying.context = sc.nextLine().trim();
                    System.out.printf("작가 : ");
                    wiseSaying.author = sc.nextLine().trim();

                    wiseSayings.add(wiseSaying);

                    System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSayingLastId);
                    break;
                case "목록" :
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("=------------------------");
                    // 클래스도입
                    System.out.printf("%d / %s / %s");
                    break;
            }
        }
    }
}
