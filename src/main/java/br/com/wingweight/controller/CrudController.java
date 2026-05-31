package br.com.wingweight.controller;

import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.*;

public abstract class CrudController<T> {
    protected abstract JpaRepository<T, Long> repo();

    @GetMapping
    public List<T> all() {
        return repo().findAll();
    }

    @GetMapping("/{id}")
    public T one(@PathVariable Long id) {
        return repo().findById(id).orElseThrow();
    }

    @PostMapping
    public T create(@Valid @RequestBody T entity) {
        return repo().save(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable Long id, @Valid @RequestBody T entity) {
        repo().findById(id).orElseThrow();
        return repo().save(entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo().deleteById(id);
    }
}
