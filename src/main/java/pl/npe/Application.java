package pl.npe;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.npe.model.NpeView;
import pl.npe.model.User;
import pl.npe.repository.UserRepository;

import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			User npeUser = new User();
			npeUser.setName("name");
			npeUser.setEmail("mail@mail.com");
			npeUser.setUsername("login");
			npeUser.setPassword(new BCryptPasswordEncoder().encode("password"));
//			npeUser.setRoles(Arrays.asList("npeUser"));
//			npeUser.setLastLogin(LocalDateTime.now());

			repository.save(npeUser);

			List<NpeView> views = new ArrayList<>();

			NpeView npeView = new NpeView();

			npeView.setIdn("views");
			npeView.setName("Views");
			npeView.setPath("/views");
			npeView.setComponent("ViewsComponent");
			npeView.setShowInNav(true);

			views.add(npeView);

			NpeView documentConfigList = new NpeView();

			documentConfigList.setIdn("documentConfigList");
			documentConfigList.setName("DocumentConfigList");
			documentConfigList.setPath("/document-config-list");
			documentConfigList.setComponent("DocumentConfigList");
			documentConfigList.setShowInNav(true);

			npeView = new NpeView();

			npeView.setIdn("home");
			npeView.setName("Home");
			npeView.setPath("/home");
			npeView.setComponent("HomeComponent");
			npeView.setShowInNav(true);
			npeView.setChildren(Collections.singletonList(documentConfigList));

			views.add(npeView);

			try (Writer writer = new FileWriter("views.json")) {
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				gson.toJson(views, writer);
			}
		};
	}

}
