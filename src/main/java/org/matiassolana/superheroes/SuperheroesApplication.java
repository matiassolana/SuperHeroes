package org.matiassolana.superheroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan("org.matiassolana.*")

public class SuperheroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

}
