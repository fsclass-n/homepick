package com.onrender.homepick.th;

public class Ex02Dto_ {

    // 필드
    private String name;

    // 기본 생성자 함수 -> @NoArgsConstructor
    public Ex02Dto_() {
        
    }
    // 모든 필드를 매개변수로 하는 생성자
    // @AllArgsConstructor
    public Ex02Dto_(String name) {
        this.name = name;
    }

    // 타임리프의 ${user.name} 접근을 위해 Getter 필수
    // 메서드(getter(읽기), setter(설정))
    // @getter
    public String getName() {
        return name;
    }
}