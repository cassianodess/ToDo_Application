package io.github.cassianodess.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.cassianodess.domain.Todo;
import io.github.cassianodess.exceptions.TodoException;
import io.github.cassianodess.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repo;

	public Todo findById(Integer id) {
		return repo.findById(id).orElseThrow(() -> new TodoException("id not found"));
	}

	public List<Todo> listOpen() {
		return repo.findAllOpen();
	}

	public List<Todo> listClose() {
		return repo.findAllClose();
	}

	public List<Todo> listAll() {
		return repo.findAll();
	}

	public Todo save(Todo todo) {
		todo.setId(null);
		return repo.save(todo);
	}

	public void delete(Integer id) {

		findById(id);

		repo.deleteById(id);
	}

	public Todo update(Integer id, Todo todo) {

		Todo novo = findById(id);

		novo.setTitulo(todo.getTitulo());
		novo.setDescricao(todo.getDescricao());
		novo.setFinalizado(todo.getFinalizado());
		novo.setDataParaFinalizar(todo.getDataParaFinalizar());
		return repo.save(novo);

	}

}
