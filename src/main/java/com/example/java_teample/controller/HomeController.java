package com.example.java_teample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // 기본 페이지 요청하는 메서드
    @GetMapping("/")
    public String index(){
        return "index";  // templates 폴더의 index.html을 찾아감
    } // 기본 요청이 왔을 때 "index"라는 html 파일을 연다
}
