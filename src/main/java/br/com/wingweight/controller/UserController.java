package br.com.wingweight.controller;
import br.com.wingweight.model.User; import br.com.wingweight.repository.UserRepository; import lombok.RequiredArgsConstructor; import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/users") @RequiredArgsConstructor
public class UserController extends CrudController<User> { private final UserRepository repository; protected JpaRepository<User, Long> repo(){return repository;} }
