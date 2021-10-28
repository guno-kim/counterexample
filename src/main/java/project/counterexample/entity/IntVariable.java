package project.counterexample.entity;

import javax.persistence.*;

@Entity
public class IntVariable {
    @Id @GeneratedValue
    @Column(name = "variable_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    private char name;
    private String max;
    private String min;
    private boolean fix;


}
