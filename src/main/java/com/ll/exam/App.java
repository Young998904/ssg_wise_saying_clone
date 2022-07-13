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

            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
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
                    System.out.println("-------------------------");

                    for (int i=wiseSayings.size()-1; i >=0 ; i--) {
                        System.out.printf("%d / %s / %s \n",
                                wiseSayings.get(i).id, wiseSayings.get(i).author, wiseSayings.get(i).context);
                    }
                    break;
                case "삭제" :
                    int paramId = rq.getIntParam("id", 0);
                    // 0은 id 값으로 있을 수 없으므로 defaultValue 로 적합

                    if (paramId == 0) {
                        System.out.println("id를 입력해주세요.");
                        continue;
                    }

                    WiseSaying wiseSaying_ = null;

                    // 탐색
                    for (WiseSaying wiseSaying__ : wiseSayings) {
                        if(wiseSaying__.id == paramId) {
                            wiseSaying_ = wiseSaying__;
                        }
                    }

                    if (wiseSaying_ == null) {
                        System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
                        continue;
                    }

                    wiseSayings.remove(wiseSaying_);

                    System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
                    break;
            }
        }
    }
}
