package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.entity.TestCase;
import project.counterexample.entity.TestResult;


public interface TestResultRepository extends JpaRepository<TestResult,Long> {
}
