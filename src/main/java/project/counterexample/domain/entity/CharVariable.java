package project.counterexample.domain.entity;

import javax.persistence.*;

@Entity
public class CharVariable {
    @Id @GeneratedValue
    @Column(name = "variable_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    private char name;
    private char[] candidates;

}
