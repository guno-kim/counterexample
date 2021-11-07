package project.counterexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.counterexample.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser() {

    }


}
