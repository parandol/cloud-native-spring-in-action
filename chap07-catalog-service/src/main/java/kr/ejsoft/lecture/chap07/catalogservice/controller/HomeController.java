package kr.ejsoft.lecture.chap05.catalogservice.controller;

import kr.ejsoft.lecture.chap07.catalogservice.property.PolarProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HomeController {
    private final PolarProperties polarProperties;

    @GetMapping("/")
    public String getGreeting() {
//        return "도서 카탈로그에 오신 것을 환영합니다.";
//        return "Welcome to the book catalog.";
        return polarProperties.getGreeting();
    }
}
