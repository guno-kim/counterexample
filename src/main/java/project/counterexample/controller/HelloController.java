package project.counterexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import project.counterexample.entity.User;
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
        User user = new User();
        user.setName("guno");
        userRepository.save(user);
        return "sss";
    }
}
