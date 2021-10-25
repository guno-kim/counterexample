package project.counterexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CounterexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterexampleApplication.class, args);
	}

}
