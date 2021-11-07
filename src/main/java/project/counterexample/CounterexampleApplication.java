package project.counterexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@ServletComponentScan
@EnableJpaAuditing
@SpringBootApplication
public class CounterexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CounterexampleApplication.class, args);
	}
}
