package com.vividswan.studymate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudyMateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyMateApplication.class, args);
	}

}
