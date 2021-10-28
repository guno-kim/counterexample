package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.entity.CharVariable;
import project.counterexample.entity.IntVariable;


public interface IntVariableRepository extends JpaRepository<IntVariable,Long> {
}
