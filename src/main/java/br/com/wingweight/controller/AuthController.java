package br.com.wingweight.controller;

import br.com.wingweight.model.User;
import br.com.wingweight.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import br.com.wingweight.model.Role;


@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody User loginData) {

        User user = userRepository.findByEmail(loginData.getEmail())
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.UNAUTHORIZED,
                        "Email ou senha inválidos"
                ));

        if (!user.getPassword().equals(loginData.getPassword())) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Email ou senha inválidos"
            );
        }

        if (!user.isActive()) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "Usuário inativo"
            );
        }

        user.setPassword(null);

        return user;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        boolean exists = userRepository.findByEmail(user.getEmail()).isPresent();

        if (exists) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Email já cadastrado"
            );
        }

        if (user.getRole() == null) {
            user.setRole(Role.USUARIO);
        }

        user.setActive(true);

        User saved = userRepository.save(user);

        saved.setPassword(null);

        return saved;
    }
}
