package br.com.wingweight.controller;

import br.com.wingweight.model.Alert;
import br.com.wingweight.repository.AlertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alerts")
@RequiredArgsConstructor
public class AlertController extends CrudController<Alert> {
    private final AlertRepository repository;

    protected JpaRepository<Alert, Long> repo() {
        return repository;
    }
}
