package br.com.wingweight.controller;

import br.com.wingweight.dto.DashboardDTO;
import br.com.wingweight.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
@CrossOrigin("*")
public class DashboardController {

    private final DashboardService service;

    @GetMapping
    public DashboardDTO summary() {
        return service.summary();
    }

    @GetMapping("/aviary/{aviaryId}")
    public DashboardDTO summaryByAviary(
            @PathVariable Long aviaryId
    ) {
        return service.summaryByAviary(aviaryId);
    }
}