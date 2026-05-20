package br.com.wingweight.exception;
import org.springframework.http.*; import org.springframework.web.bind.MethodArgumentNotValidException; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestControllerAdvice
public class ApiExceptionHandler {
 @ExceptionHandler(NoSuchElementException.class) ResponseEntity<?> notFound(Exception e){return ResponseEntity.status(404).body(Map.of("erro","Registro não encontrado"));}
 @ExceptionHandler(MethodArgumentNotValidException.class) ResponseEntity<?> validation(MethodArgumentNotValidException e){return ResponseEntity.badRequest().body(Map.of("erro","Dados inválidos", "detalhes", e.getBindingResult().getFieldErrors().stream().map(f->f.getField()+": "+f.getDefaultMessage()).toList()));}
}
