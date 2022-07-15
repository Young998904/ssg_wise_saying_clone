package com.ll.exam;

public class WiseSaying {
    String context;
    String author;
    int id;

    public WiseSaying(int id, String context, String author) {
        this.id = id;
        this.context = context;
        this.author = author;
    }

    @Override
    public String toString() {
        return """
                WiseSaying {
                id = %d
                author = %s
                content = %s
                }""".formatted(this.id, this.context, this.author);
    }
}
