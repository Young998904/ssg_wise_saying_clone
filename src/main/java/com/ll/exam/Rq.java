package com.ll.exam;

public class Rq {
    String url;

    public Rq (String url) {
        this.url = url;
    }

    public String getPath() {
        String[] urlBits = url.split("\\?", 2);
        return urlBits[0];
    }
}
