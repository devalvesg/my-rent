package com.devalvesg.my_rent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.devalvesg.my_rent.Infrastructure.Repositories")
public class MyRentApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRentApplication.class, args);
	}

}
