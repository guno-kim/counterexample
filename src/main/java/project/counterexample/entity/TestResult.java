package project.counterexample.entity;

import javax.persistence.*;

@Entity
public class TestResult {
    @Id @GeneratedValue
    @Column(name = "testresult_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User2 user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "testcase_id")
    private TestCase testCase;

    private String testCode;
    private int testTime;
    private int answerTime;
    private String errorMessage;
    private String testOutput;
    private String answerOutput;

}
