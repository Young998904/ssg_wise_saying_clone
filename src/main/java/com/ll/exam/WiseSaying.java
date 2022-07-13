package com.ll.exam;

public class WiseSaying {
    String context;
    String author;
    int id;

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
