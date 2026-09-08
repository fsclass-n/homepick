package com.onrender.homepick.basic;

import java.util.List;

public class Ex02_ListOf {
        public static void main(String[] args){
        // 선언과 동시에 초기화
        List<String> colors = List.of("Red", "Green", "Blue");

        System.out.println(colors.get(0)); // "Red"
        System.out.println("크기: " + colors.size()); // 3

        // 주의: 아래 코드는 모두 런타임 에러(UnsupportedOperationException) 발생
        // colors.add("Yellow");
        // colors.set(0, "Black");
        // colors.remove(0);

        // 주의: null 포함 불가 (NullPointerException 발생)
        // List<String> errorList = List.of("A", null);
    }
}
