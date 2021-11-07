package project.counterexample.domain.dto;

import lombok.Data;
import lombok.ToString;
import project.counterexample.domain.entity.User;

@Data
public class UserDto {
    String name;

    public UserDto(User user) {
        this.name = user.getName();
    }
}
