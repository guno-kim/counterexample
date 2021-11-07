package project.counterexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import project.counterexample.domain.dto.AuthDto;
import project.counterexample.domain.dto.UserDto;
import project.counterexample.domain.entity.User;
import project.counterexample.repository.UserRepository;
import project.counterexample.service.UserService;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping("/user/auth")
    public AuthDto auth(Authentication auth) {
        return new AuthDto(auth!=null);
    }

    @GetMapping("/user")
    public UserDto getUser(Authentication auth) {
        User user = userService.findByAuth(auth);
        return new UserDto(user);
    }

    @PostMapping("/user")
    public void updateUser(@RequestBody Map<String, Object> params , Authentication auth) {
        userService.changeName(auth, (String) params.get("name"));
    }
}
