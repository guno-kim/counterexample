package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.entity.Problem;
import project.counterexample.entity.TestCase;


public interface TestCaseRepository extends JpaRepository<TestCase,Long> {
}
