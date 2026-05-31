package br.com.wingweight.controller;

import br.com.wingweight.model.ScaleDevice;
import br.com.wingweight.repository.ScaleDeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class ScaleDeviceController extends CrudController<ScaleDevice> {
    private final ScaleDeviceRepository repository;

    protected JpaRepository<ScaleDevice, Long> repo() {
        return repository;
    }
}
