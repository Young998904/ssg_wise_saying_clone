package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        this.wiseSayingRepository = new WiseSayingRepository();
    }
    public void write (Rq rq) {
        WiseSaying wiseSaying = new WiseSaying();
        wiseSaying.id = ++wiseSayingRepository.wiseSayingLastId;
        System.out.printf("명언 : ");
        wiseSaying.context = sc.nextLine().trim();
        System.out.printf("작가 : ");
        wiseSaying.author = sc.nextLine().trim();

        wiseSayingRepository.wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSayingRepository.wiseSayingLastId);
    }
    public void list (Rq rq){
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------------");

        for (int i=wiseSayingRepository.wiseSayings.size()-1; i >=0 ; i--) {
            System.out.printf("%d / %s / %s \n",
                    wiseSayingRepository.wiseSayings.get(i).id, wiseSayingRepository.wiseSayings.get(i).author, wiseSayingRepository.wiseSayings.get(i).context);
        }
    }
    public void remove(Rq rq) {
        int paramId = rq.getIntParam("id", 0);
        // 0은 id 값으로 있을 수 없으므로 defaultValue 로 적합

        if (paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying foundWiseSaying = wiseSayingRepository.findById(paramId);

        if (foundWiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", paramId);
            return;
        }

        wiseSayingRepository.wiseSayings.remove(foundWiseSaying);

        System.out.printf("%d번 명언이 삭제되었습니다.\n", paramId);
    }

    public void modify(Rq rq) {
        int _paramId = rq.getIntParam("id", 0);
        // 0은 id 값으로 있을 수 없으므로 defaultValue 로 적합

        if (_paramId == 0) {
            System.out.println("id를 입력해주세요.");
            return;
        }

        WiseSaying _wiseSaying = wiseSayingRepository.findById(_paramId);

        if (_wiseSaying == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다..\n", _paramId);
            return;
        }

        System.out.printf("명언 (기존) : %s \n", _wiseSaying.context);
        System.out.printf("명언 : ");
        _wiseSaying.context = sc.nextLine();
        System.out.printf("작가 (기존) : %s\n", _wiseSaying.author);
        System.out.printf("작가 : ");
        _wiseSaying.author = sc.nextLine();
    }
}
