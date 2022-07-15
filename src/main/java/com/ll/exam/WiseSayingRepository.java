package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingRepository { // 데이터 담당
    private int wiseSayingLastId;
    private List<WiseSaying> wiseSayings;
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

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying write(String context, String author) {
        WiseSaying wiseSaying = new WiseSaying (++wiseSayingLastId, context, author);
        wiseSayings.add(wiseSaying);

        return wiseSaying;
    }

    public void remove(WiseSaying foundWiseSaying) {
        wiseSayings.remove(foundWiseSaying);
    }

    public void modify(int paramId, String context, String author) {
        WiseSaying foundWiseSaying = findById(paramId);
        foundWiseSaying.context = context;
        foundWiseSaying.author = author;
    }
}
