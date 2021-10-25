package project.counterexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.counterexample.entity.User;


public interface UserRepository extends JpaRepository<User,Long> {
}
