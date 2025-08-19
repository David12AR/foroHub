package com.foros.foroHub.infra.security.exceptions;

import com.foros.foroHub.ValidacionException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.dao.DataIntegrityViolationException;


@RestControllerAdvice
public class GestorDeErrores {
@ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarError404(EntityNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("El recurso solicitado no existe. Verifique el ID.");
}
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarError400(MethodArgumentNotValidException ex){
    var errores = ex.getFieldErrors();

        return ResponseEntity.badRequest().body(errores.stream().map(DatosErrorValidacion::new).toList());
    }
    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity tratarErrorDeValidacion(ValidacionException e){

        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity gestionarErrorDuplicados(DataIntegrityViolationException e) {
        return ResponseEntity.badRequest().body("El título o mensaje ya existe en la base de datos.");
    }

    public record DatosErrorValidacion(String campo, String mensaje){
    public DatosErrorValidacion(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }

    }

}
