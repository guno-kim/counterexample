package project.counterexample.config.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import project.counterexample.domain.type.ProviderType;
import project.counterexample.domain.entity.User;
import project.counterexample.repository.UserRepository;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getClientName(); // "Google"
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName(); // "sub"

        OAuthAttributes attributes = new OAuthAttributes(provider, oAuth2User.getAttributes());

        String subId = (String) attributes.getAttributes().get("sub");

        User user = userRepository.findByProviderAndSubId(ProviderType.fromStr(provider), subId);
        if (user == null) {
            userRepository.save(attributes.toEntity());
        }

        return new DefaultOAuth2User(null, attributes.getAttributes(), userNameAttributeName);
    }

}
