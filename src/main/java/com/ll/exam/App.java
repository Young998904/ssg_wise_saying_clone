package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;

    public App() {
        sc = new Scanner(System.in);
    }
    public void run() {
        String cmd;
        System.out.println("=== 명언 SSG ===");
        WiseSayingController wiseSayingController = new WiseSayingController(sc);

        outer:
        while (true) {
            System.out.printf("명령 ) ");
            cmd = sc.nextLine().trim();

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "종료" :
                    break outer;

                case "등록" :
                    wiseSayingController.write(rq);
                    break;
                case "목록" :
                    wiseSayingController.list(rq);
                    break;
                case "삭제" :
                    wiseSayingController.remove(rq);
                    break;
                case "수정" :
                    wiseSayingController.modify(rq);
                    break;
            }
        }
    }
}
