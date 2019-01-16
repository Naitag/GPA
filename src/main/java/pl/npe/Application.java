package pl.npe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.npe.models.User;
import pl.npe.repositories.UserRepository;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			User user = new User();
			user.setEnabled(true);
			user.setUsername("login");
			user.setPassword(new BCryptPasswordEncoder().encode("password"));
			user.setRole("user");
			user.setLastLogin(LocalDateTime.now());

			repository.save(user);

			System.out.println(repository.findAll());
		};
	}

}
