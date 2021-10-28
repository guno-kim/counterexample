package project.counterexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class IndexController {
    private final HttpSession httpSession;

    @GetMapping("/")
    public String index(Principal principal){
//        model.addAttribute("posts", postsService.findAllDesc());
        System.out.println("====================");
        System.out.println("/ called");
        System.out.println("req = " + principal.getName());
        System.out.println("principal = " + principal);
        System.out.println("====================");
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//
//        if(user != null){
//            model.addAttribute("userName", user.getName());
//        }
        return "redirect:http://localhost:3000/problem";
    }

//    @GetMapping("/user/auth")
//    public AuthResponse auth(Principal principal) {
//        System.out.println("principal = " + principal);
//        AuthResponse res = new AuthResponse();
//        res.success= principal != null;
//        return res;
//    }

    @GetMapping("/user/auth")
    public AuthResponse  auth(Principal principal) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAuth(principal!=null);
        return authResponse;
    }

}