package project.counterexample.domain.entity;

import lombok.Builder;
import project.counterexample.domain.type.LanguageType;

import javax.persistence.*;

@Entity
@Builder
public class Code extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "code_id")
    private Long id;

    private LanguageType language;
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

}
