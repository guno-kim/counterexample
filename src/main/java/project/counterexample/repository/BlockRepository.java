package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.domain.entity.Block;


public interface BlockRepository extends JpaRepository<Block,Long> {
}
