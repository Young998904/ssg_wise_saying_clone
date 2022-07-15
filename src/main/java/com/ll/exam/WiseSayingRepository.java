package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingRepository { // 데이터 담당
    int wiseSayingLastId;
    List<WiseSaying> wiseSayings;
    public WiseSayingRepository () {
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }
}
