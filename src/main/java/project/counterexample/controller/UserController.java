package project.counterexample.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import project.counterexample.repository.UserRepository;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/user/auth")
    public AuthResponse  auth(Principal principal) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAuth(principal!=null);
        return authResponse;
    }


}
