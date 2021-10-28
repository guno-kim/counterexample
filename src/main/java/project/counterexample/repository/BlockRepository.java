package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.entity.Block;
import project.counterexample.entity.Problem;


public interface BlockRepository extends JpaRepository<Block,Long> {
}
