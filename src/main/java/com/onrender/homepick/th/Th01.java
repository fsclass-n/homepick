package com.onrender.homepick.th;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Th01 {

    @GetMapping("/th")
    public String th01(Model model) {
        model.addAttribute("message", "안녕하세요!");
        return "th/th01_텍스트";
    }
}