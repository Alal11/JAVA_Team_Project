package com.example.java_teample.controller;

import com.example.java_teample.dto.MemberDTO;
import com.example.java_teample.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    // 객체 주입 방식 3가지
    // 1. 생성자 주입
    private final MemberService memberService;

    // 회원가입 페이지 출력 요청
    @GetMapping("/member/save")
    public String saveForm(){
        return "save";
    }

    @PostMapping("/member/save")  // name 값을 requestparam에 담아온다
    public String save(@ModelAttribute MemberDTO memberDTO){
        System.out.println("MemberController.save");
        // 단축키 soutp
        System.out.println("memberDTO = " + memberDTO);
        memberService.save(memberDTO);

        return "index";
    }
}
