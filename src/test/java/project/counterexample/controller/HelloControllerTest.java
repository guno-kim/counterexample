package project.counterexample.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import project.counterexample.entity.User;
import project.counterexample.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Commit
class HelloControllerTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest() {
        User user = new User();
        user.setName("asd");
        userRepository.save(user);

        User findUser = userRepository.findById(user.getUserId()).get();

        assertThat(user).isEqualTo(findUser);
    }
}