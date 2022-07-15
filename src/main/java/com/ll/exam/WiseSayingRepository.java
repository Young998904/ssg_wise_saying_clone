package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingRepository { // 데이터 담당
    public int wiseSayingLastId;
    public List<WiseSaying> wiseSayings;
    public WiseSayingRepository () {
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }
    public WiseSaying findById(int paramId) {
        // 탐색
        for (WiseSaying wiseSaying : wiseSayings) {
            if(wiseSaying.id == paramId) {
                return wiseSaying;
            }
        }
        return null;
    }
}
