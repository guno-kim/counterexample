package project.counterexample.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@ToString
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
    private Provider provider;

    @Builder
    public User(String subId, String name, String email, Provider provider) {
        this.subId = subId;
        this.name = name;
        this.email = email;
        this.provider = provider;
    }

    public User update(String name, String picture) {
        this.name = name;
        return this;
    }

}