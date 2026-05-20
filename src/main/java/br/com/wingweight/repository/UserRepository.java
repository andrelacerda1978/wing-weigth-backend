package br.com.wingweight.repository;
import br.com.wingweight.model.User; import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {}
