package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.domain.entity.IntVariable;


public interface IntVariableRepository extends JpaRepository<IntVariable,Long> {
}
