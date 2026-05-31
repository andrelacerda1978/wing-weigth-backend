package br.com.wingweight.controller;

import br.com.wingweight.model.Aviary;
import br.com.wingweight.repository.AviaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aviaries")
@RequiredArgsConstructor
public class AviaryController extends CrudController<Aviary> {
    private final AviaryRepository repository;

    protected JpaRepository<Aviary, Long> repo() {
        return repository;
    }
}
