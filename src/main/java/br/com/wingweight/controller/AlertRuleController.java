package br.com.wingweight.controller;
import br.com.wingweight.model.AlertRule; import br.com.wingweight.repository.AlertRuleRepository; import lombok.RequiredArgsConstructor; import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/alert-rules") @RequiredArgsConstructor
public class AlertRuleController extends CrudController<AlertRule> { private final AlertRuleRepository repository; protected JpaRepository<AlertRule, Long> repo(){return repository;} }
