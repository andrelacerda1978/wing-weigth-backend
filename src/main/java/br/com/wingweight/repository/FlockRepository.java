package br.com.wingweight.repository;
import br.com.wingweight.model.Flock; import org.springframework.data.jpa.repository.JpaRepository;
public interface FlockRepository extends JpaRepository<Flock, Long> {}
