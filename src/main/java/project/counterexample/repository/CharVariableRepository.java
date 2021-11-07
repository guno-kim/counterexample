package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.domain.entity.CharVariable;


public interface CharVariableRepository extends JpaRepository<CharVariable,Long> {
}
