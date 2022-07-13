package com.ll.exam;

import java.util.Scanner;

public class App {
    Scanner sc;
    public App() {
        sc = new Scanner(System.in);
    }
    public void run() {
        String cmd;
        int wiseSayingLastId = 0;
        System.out.println("=== 명언 SSG ===");

        outer:
        while (true) {
            System.out.printf("명령 ) ");
            cmd = sc.nextLine();
            switch (cmd) {
                case "종료" :
                    break outer;

                case "등록" :
                    String context;
                    String author;
                    System.out.printf("명언 : ");
                    context = sc.nextLine();
                    System.out.printf("작가 : ");
                    author = sc.nextLine();

                    System.out.println(context);
                    System.out.println(author);

                    System.out.printf("%d번 명언이 등록되었습니다.\n", ++wiseSayingLastId);
            }
        }
    }
}
