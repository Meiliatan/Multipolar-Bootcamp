package com.multipolar.bootcamp.crud.service;

import com.multipolar.bootcamp.crud.domain.Todo;
import com.multipolar.bootcamp.crud.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) { //constructor
        this.todoRepository = todoRepository;
    }

    //Fungsi Get AllTodos == kembalian berupa List
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }

    //Fungsi Get todo by id
    public Optional<Todo> getTodoById(String id){
        return todoRepository.findById(id);
    }

    //Fungsi Create todo baru
    public Todo creatOrUpdateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    //Fungsi Delete todo
    public void deleteTodoById(String id){
        todoRepository.deleteById(id);
    }
}
