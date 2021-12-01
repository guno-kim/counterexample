package project.counterexample.domain.entity;

import javax.persistence.*;

@Entity
public class TestResult {
    @Id @GeneratedValue
    @Column(name = "testresult_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @OneToOne()
    @JoinColumn(name = "testcase_id")
    private TestCase testCase;

    @OneToOne()
    @JoinColumn(name = "code_id")
    private Code code;

    private int time;
    private String errorMessage;
    private String output;

}
