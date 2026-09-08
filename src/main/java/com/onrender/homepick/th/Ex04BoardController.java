package com.onrender.homepick.th;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex04BoardController {

    // /th/login?id=10 요청 처리
    @GetMapping("/th/ex04/board")
    public String ex04Login(@RequestParam("id") Long id, Model model) {
        model.addAttribute("login", id);
        return "th/ex04_login"; // templates/th/ex04_login.html 반환
    }

    // GET /th/qna/10
    @GetMapping("/th/ex04/board/{id}")
    public String ex04Qna(@PathVariable("id") Long id, Model model) {
        model.addAttribute("qna", id);
        return "th/ex04_qna";
    }
}