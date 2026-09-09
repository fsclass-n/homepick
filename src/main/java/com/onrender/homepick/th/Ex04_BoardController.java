package com.onrender.homepick.th;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Ex04_BoardController {

    // /th/board?id=10 요청 처리
    @GetMapping("/th/ex04/login")
    public String ex04login(@RequestParam("id") Long id, Model model) {
        model.addAttribute("boardId", id);
        return "th/ex04_login"; // templates/th/ex04_board.html 반환
    }

    // GET /th/board/10
    @GetMapping("/th/ex04/join/{id}")
    public String ex04join(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boardId", id);
        return "th/ex04_join";
    }

    // GET /th/board/10
    @GetMapping("/th/ex04/faq/{id}")
    public String ex04faq(@PathVariable("id") Long id, Model model) {
        model.addAttribute("boardId", id);
        return "th/ex04_faq";
    }
}