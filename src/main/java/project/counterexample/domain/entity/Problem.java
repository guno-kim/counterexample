package project.counterexample.domain.entity;

import lombok.Builder;
import project.counterexample.domain.type.ProblemType;

import javax.persistence.*;

@Entity
@Builder
public class Problem extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "problem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private ProblemType problemType;

    private Long problemNum;
    private String title;
    private String description;

    @OneToOne()
    @JoinColumn(name = "code_id")
    private Code answerCode;

}
