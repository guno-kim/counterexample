package project.counterexample.entity;

import lombok.Builder;

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
    private String answerCode;



}
