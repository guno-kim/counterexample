package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.entity.Problem;


public interface ProblemRepository extends JpaRepository<Problem,Long> {
}
