package io.github.cassianodess;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.cassianodess.domain.Todo;
import io.github.cassianodess.service.TodoService;

@CrossOrigin("*") // Pode receber requisições de múltiplas fontes (outras portas)
@RestController
@RequestMapping("/todos")
public class TodoController {

	@Autowired
	private TodoService service;

	@GetMapping("/{id}")
	public ResponseEntity<Todo> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.findById(id));
	}

	@GetMapping("/open")
	public ResponseEntity<List<Todo>> listOpen() {
		return ResponseEntity.ok().body(service.listOpen());
	}

	@GetMapping("/close")
	public ResponseEntity<List<Todo>> listClose() {
		return ResponseEntity.ok().body(service.listClose());
	}

	@GetMapping()
	public ResponseEntity<List<Todo>> listAll() {
		return ResponseEntity.ok().body(service.listAll());
	}

	@PostMapping
	public ResponseEntity<Todo> create(@RequestBody Todo todo) {
		service.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(todo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo todo) {

		return ResponseEntity.ok().body(service.update(id, todo));

	}

}
