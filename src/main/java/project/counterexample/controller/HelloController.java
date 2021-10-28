package project.counterexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.counterexample.repository.UserRepository;


@RestController
@RequiredArgsConstructor
public class HelloController {

    private final UserRepository userRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/save")
    public String save() {
        User2 user = new User2();
        user.setName("guno");
        return "sss";
    }
}
