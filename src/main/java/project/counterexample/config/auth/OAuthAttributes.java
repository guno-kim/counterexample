package project.counterexample.config.auth;

import lombok.Builder;
import lombok.Getter;
import project.counterexample.entity.Provider;
import project.counterexample.entity.User;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private Provider provider;
    private String subId;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes,
                           String nameAttributeKey, String name,
                           String email,Provider provider,String subId) {
        this.attributes = attributes;
        this.nameAttributeKey= nameAttributeKey;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.subId = subId;
    }

    public static OAuthAttributes of(String registrationId,
                                     String userNameAttributeName,
                                     Map<String, Object> attributes) {

        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .subId((String) attributes.get("sub"))
                .provider(registrationId.equals("google") ? Provider.GOOGLE : Provider.FACEBOOK)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }



    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .provider(provider)
                .subId(subId)
                .build();
    }
}