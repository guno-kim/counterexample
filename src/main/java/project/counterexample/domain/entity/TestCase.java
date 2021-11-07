package project.counterexample.domain.entity;

import javax.persistence.*;

@Entity
public class TestCase {

    @Id @GeneratedValue
    @Column(name = "testcase_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;


}
