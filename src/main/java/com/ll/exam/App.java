package com.ll.exam;

import java.util.Scanner;

public class App {
    Scanner sc;
    public App() {
        sc = new Scanner(System.in);
    }
    public void run() {
        String cmd;
        System.out.println("=== 명언 SSG ===");

        outer:
        while (true) {
            System.out.printf("명령 ) ");
            cmd = sc.nextLine();
            switch (cmd) {
                case "종료" :
                    break outer;
            }
        }
    }
}
