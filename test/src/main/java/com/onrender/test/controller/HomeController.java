package com.onrender.test.controller;

import com.onrender.test.dto.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(HttpSession session, Model model) {
        Member user = (Member) session.getAttribute("loginUser");
        model.addAttribute("user", user);
        return "index";
    }
}
