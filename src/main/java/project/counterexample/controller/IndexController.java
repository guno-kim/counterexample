package project.counterexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final HttpSession httpSession;
    @Value("${client-url}")
    private String clientUrl;

    @GetMapping("/")
    public String index(Principal principal){
        System.out.println("====================");
        System.out.println("/ called");
//        System.out.println("req = " + principal.getName());
        System.out.println("principal = " + principal);
        System.out.println("====================");
        return String.format("redirect:%s",clientUrl);
    }

    @GetMapping("/test")
    public String  test(Principal principal) {
        System.out.println("----------------");
        System.out.println("----------------");
        return "redirect:http://www.naver.com";
    }
}