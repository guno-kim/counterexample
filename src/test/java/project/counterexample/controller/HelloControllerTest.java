package project.counterexample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import project.counterexample.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Commit
class HelloControllerTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void saveTest() {
        User2 user = new User2();
        user.setName("asd");
        userRepository.save(user);

        User2 findUser = userRepository.findById(user.getUserId()).get();

        assertThat(user).isEqualTo(findUser);
    }
}