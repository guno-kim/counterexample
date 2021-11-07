package project.counterexample.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "PROBLEM_LIKE")
public class ProblemLike {

    @Id
    @GeneratedValue
    @Column(name = "problem_like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    private boolean like;
}
