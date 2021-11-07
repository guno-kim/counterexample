package project.counterexample.domain.entity;

import javax.persistence.*;

@Entity
public class Block {
    @Id @GeneratedValue
    @Column(name = "block_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    private Problem problem;

    private char[][] content;
    private int verticalRep;
    private int horizonalRep;
    private boolean space;

}
