package br.com.wingweight.repository;

import br.com.wingweight.model.Aviary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AviaryRepository extends JpaRepository<Aviary, Long> {
}
