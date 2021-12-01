package project.counterexample.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.counterexample.domain.type.ProviderType;
import project.counterexample.domain.entity.User;
import project.counterexample.repository.UserRepository;

import javax.persistence.EntityManager;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager em;

    @Transactional
    public void changeName(Authentication auth,String name) {
        User user = findByAuth(auth);
        user.changeName(name);
        System.out.println("user.getName() = " + user.getName());
    }

    public User findByAuth(Authentication auth) {
        OAuth2User user = (OAuth2User) auth.getPrincipal();
        Map<String, Object> attributes = user.getAttributes();
        System.out.println("attributes = " + attributes.get("provider").getClass());
        ProviderType provider =(ProviderType) attributes.get("provider");

        String sub = (String) attributes.get("sub");
        return userRepository.findByProviderAndSubId(provider, sub);
    }


}
