package com.onrender.homepick.th;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Ex04Controller {
    
    @GetMapping("/th/ex04")
    public String ex04(Model model) {
        model.addAttribute("message", "안녕하세요!");

        // user 객체를 모델에 추가 (th:if="${user != null}" 통과)
        model.addAttribute("user", new Ex02Dto("홍길동"));

        // itemList 생성 후 Model에 추가
        List<Ex03Dto> items = List.of(
            new Ex03Dto("노트북"),
            new Ex03Dto("무선 마우스"),
            new Ex03Dto("기계식 키보드")
        );
        model.addAttribute("itemList", items);

        // board 객체 추가 (id=10L 지정)
        model.addAttribute("board", new Ex04Dto(10L, "첫 번째 게시글"));

        return "th/ex04";
    }
}