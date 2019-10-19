package com.books.and.videos.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class FunBooksAndVideosApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunBooksAndVideosApplication.class, args);
	}

}
