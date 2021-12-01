package project.counterexample.domain.dto;

import lombok.Data;
import lombok.ToString;
import project.counterexample.domain.entity.User;
import project.counterexample.domain.type.LanguageType;

@Data
public class UserDto {
    String name;
    LanguageType language;

    public UserDto(User user) {
        this.name = user.getName();
        this.language = user.getLanguage();
    }
}
