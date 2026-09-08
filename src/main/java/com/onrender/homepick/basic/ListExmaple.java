package com.onrender.homepick.basic;

import java.util.ArrayList;
import java.util.List;

public class ListExmaple {
        public static void main(String[] args){
        // 1. 리스트 선언 및 생성
        List<String> fruits = new ArrayList<>();

        // 2. 요소 추가 (add)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // 3. 요소 접근 및 수정
        String firstFruit = fruits.get(0); // "Apple"
        fruits.set(1, "Blueberry");        // "Banana" -> "Blueberry"

        // 4. 요소 삭제 (remove)
        fruits.remove("Cherry");           // 값으로 삭제
        fruits.remove(0);                  // 인덱스로 삭제

        // 5. 크기 확인 및 순회
        System.out.println("크기: " + fruits.size());
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
