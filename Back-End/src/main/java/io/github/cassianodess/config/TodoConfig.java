package io.github.cassianodess.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import io.github.cassianodess.domain.Todo;
import io.github.cassianodess.repository.TodoRepository;

@Configuration
public class TodoConfig implements CommandLineRunner {

	@Autowired
	private TodoRepository repo;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Todo t1 = new Todo("Estudar", "Estudar Java", sdf.parse("27/06/2021"), false);
		Todo t2 = new Todo("Malhar", "Treinar peitos e ombros", sdf.parse("27/06/2021"), false);
		Todo t3 = new Todo("Jiu-Jitsu", "Fazer drill de passagem de guarda", sdf.parse("27/06/2021"), false);

		repo.saveAll(List.of(t1, t2, t3));

	}

}
