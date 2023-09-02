package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@Log4j2
public class SampleController {

    @GetMapping("/hello")
    public void hello() {
        log.info("hello................");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1..........");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    // 스프링MVC의 파라미터는 기본적으로 전달된 파라미터 이름을 기준으로 동작하지만
    // 파라미터가 전달되지 않으면 문제가 발생할 수 있음
    // @RequestParam의 defaultValue속성으로 기본값 지정 가능
    @GetMapping("/ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                    @RequestParam(name = "age", defaultValue = "20") int age) {

        log.info("ex2..........");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3............");
        log.info("dueDate: " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model) {
        log.info("--------------------------");

        model.addAttribute("message", "Hello world");
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("name", "ABC");             // 쿼리스트링으로 추가됨
        redirectAttributes.addFlashAttribute("result", "success");  // 화면에서 일회용으로 사용됨. 새로고침하면 사라짐.

        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6() {

    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2) {
        log.info("p1......" + p1);
        log.info("p2......" + p2);
    }
}
