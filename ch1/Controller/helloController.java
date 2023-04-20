package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //스프링은 @Controller 라고 해주어야함
public class helloController {
    // 맵어플리케이션에서 hello라고 들어오면 public String hello 메소드를 실행한다
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data","hello");
        //model view
        return "hello";
    }
}
