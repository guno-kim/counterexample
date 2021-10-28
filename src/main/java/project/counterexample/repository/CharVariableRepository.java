package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.entity.CharVariable;
import project.counterexample.entity.Problem;


public interface CharVariableRepository extends JpaRepository<CharVariable,Long> {
}
