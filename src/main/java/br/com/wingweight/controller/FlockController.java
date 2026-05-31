package br.com.wingweight.controller;

import br.com.wingweight.model.Flock;
import br.com.wingweight.repository.FlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/flocks")
@RequiredArgsConstructor
public class FlockController extends CrudController<Flock> {
    private final FlockRepository repository;

    protected JpaRepository<Flock, Long> repo() {
        return repository;
    }
}
