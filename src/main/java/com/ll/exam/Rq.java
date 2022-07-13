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
    public int getIntParam(String paramName, int defaultValue) {
        // 매개변수 : 1_구하고자하는 파라미터의 이름 / 2_없을 경우의 디폴트 리턴값
        String[] urlBits = url.split("\\?", 2);
        if (urlBits.length == 1) {
            return defaultValue;
        }

        // 기존의 urlBits 는 더이상 사용하지 않으므로 재활용 가능
        urlBits = urlBits[1].split("&");
        // 추후 여러개의 paramName 이 생길 경우에 대비해 & 를 기준으로 나눔
        // ex) id=1&no=10

        for (String urlBit : urlBits) {
            String[] paramNameAndValue = urlBit.split("=", 2);
            // paramName 과 paramValue 두개로 쪼개야하므로 제한 2로 둠
            String paramName_ = paramNameAndValue[0];
            String paramValue = paramNameAndValue[1];

            if (paramName.equals(paramName_)) {
                // 찾던 paramName 이면 바로 return
                return Integer.parseInt(paramValue);
            }
        }
        // 여기까지 왔으면 찾는 paramName 은 없는 것
        return defaultValue;
    }
}
