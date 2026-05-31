package br.com.wingweight.repository;

import br.com.wingweight.model.AlertRule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRuleRepository extends JpaRepository<AlertRule, Long> {
}
