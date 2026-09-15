package com.onrender.homepick.controller;

import com.onrender.homepick.dto.RegisterRequest;
import com.onrender.homepick.repository.InMemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Bean(빈)
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class RegisterController{

    // DI(의존성 주입)
    private final InMemoryMemberRepository repository;

    @GetMapping("/register")
    public String form(){
        return "member/register"; // templates/member/register.html
    }

    @PostMapping("/register")
    public String process(@ModelAttribute RegisterRequest req, Model model){
        //
        if (repository.existsByEmail(req.getEmail())) {
            model.addAttribute("error", "이미 사용 중인 이메일입니다.");
            return "member/register";
        }
        repository.save(req);

        // 콘솔 창에 출력하여 확인
        System.out.println(">> 신규 회원가입 등록 완료: " + req.getName() + " (" + req.getEmail() + ")");

        return "redirect:/member/login";
    }

    // 회원 가입 목록 페이지 조회 추가
    @GetMapping("/admin")
    public String memberList(Model model) {
        model.addAttribute("members", repository.findAll());
        return "member/admin"; // templates/member/list.html
    }
}