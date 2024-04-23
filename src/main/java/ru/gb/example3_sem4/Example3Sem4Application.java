package ru.gb.example3_sem4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class Example3Sem4Application {

	public static void main(String[] args) {
		SpringApplication.run(Example3Sem4Application.class, args);
	}

}
