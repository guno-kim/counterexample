package project.counterexample.domain.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import project.counterexample.domain.type.LanguageType;
import project.counterexample.domain.type.ProviderType;

import javax.persistence.*;
import java.util.Locale;

@Getter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false,name = "sub_id")
    private String subId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProviderType provider;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LanguageType language;

    @Builder
    public User(String subId, String name, String email, ProviderType provider) {
        this.subId = subId;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.language = LanguageType.PYTHON;
    }

    public void changeName(String name) {
        this.name = name;
    }

    public void changeLanguage(String language) {
        this.language = LanguageType.valueOf(language.toUpperCase(Locale.ROOT));
    }

}