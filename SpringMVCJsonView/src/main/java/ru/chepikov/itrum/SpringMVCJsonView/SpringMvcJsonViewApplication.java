package ru.chepikov.itrum.SpringMVCJsonView;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ru.chepikov.itrum.SpringMVCJsonView.entity.User;
import ru.chepikov.itrum.SpringMVCJsonView.repository.UserRepo;

import java.util.stream.IntStream;

@SpringBootApplication
public class SpringMvcJsonViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcJsonViewApplication.class, args);
	}

}
