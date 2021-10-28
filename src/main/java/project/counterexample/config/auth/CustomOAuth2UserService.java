package project.counterexample.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import project.counterexample.entity.Provider;
import project.counterexample.entity.User;
import project.counterexample.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId(); // "google"
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName(); // "sub"

        ClientRegistration clientRegistration = userRequest.getClientRegistration();



        System.out.println("----------------------------------------");
        System.out.println("registrationId = " + registrationId);
        System.out.println("userNameAttributeName = " + userNameAttributeName);
        System.out.println("clientRegistration = " + clientRegistration);
        System.out.println("oAuth2User = " + oAuth2User.getAttributes());
        System.out.println("----------------------------------------");

        OAuthAttributes attributes = OAuthAttributes.
                of(registrationId, userNameAttributeName, oAuth2User.getAttributes());


        User user = userRepository.findByProviderAndSubId(attributes.getProvider(),attributes.getSubId());
        if (user == null) {
            userRepository.save(attributes.toEntity());
        }
        System.out.println("user = " + user);
        System.out.println("attributes.toEntity() = " + attributes.toEntity());

        return new DefaultOAuth2User(
                null,
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

//    private User saveOrUpdate(OAuthAttributes attributes) {
//        User user = userRepository.findByEmail(attributes.getEmail())
//                .map(entity -> entity.update(attributes.getName(),attributes.getPicture()))
//                .orElse(attributes.toEntity());
//
//        return userRepository.save(user);
//    }
}
