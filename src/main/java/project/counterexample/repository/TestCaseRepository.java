package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.domain.entity.TestCase;


public interface TestCaseRepository extends JpaRepository<TestCase,Long> {
}
