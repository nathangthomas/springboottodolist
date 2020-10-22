package com.example.springboottodolist.controller;

import com.example.springboottodolist.model.TodoItem;
import com.example.springboottodolist.repo.TodoRepo;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoRepo todoRepo;

    @GetMapping
    public List<TodoItem> findAll(){
        return todoRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<TodoItem> findById(@PathVariable Long id){
        return todoRepo.findById(id);
    }

    @PostMapping
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @PutMapping
    public TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem){
        return todoRepo.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        todoRepo.deleteById(id);
    }
}


