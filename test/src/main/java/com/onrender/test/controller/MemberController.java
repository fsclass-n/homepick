package com.onrender.test.controller;

import com.onrender.test.dto.LoginRequest;
import com.onrender.test.dto.Member;
import com.onrender.test.repository.MemberRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository repository;

    @GetMapping("/register")
    public String registerForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Member member, Model model) {
        if (repository.existsByEmail(member.getEmail())) {
            model.addAttribute("error", "이미 사용 중인 이메일입니다.");
            return "register";
        }
        repository.save(member);
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginRequest req, HttpSession session, Model model) {
        Member member = repository.findByEmail(req.getEmail()).orElse(null);

        if (member == null || !member.getPassword().equals(req.getPassword())) {
            model.addAttribute("error", "이메일 또는 비밀번호가 일치하지 않습니다.");
            return "login";
        }

        session.setAttribute("loginUser", member);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
