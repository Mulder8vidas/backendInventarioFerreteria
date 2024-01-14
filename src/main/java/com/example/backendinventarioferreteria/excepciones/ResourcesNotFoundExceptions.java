package com.example.backendinventarioferreteria.excepciones;

import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundExceptions extends RuntimeException {
    private static final long serialVersionId = 1L;
    public ResourcesNotFoundExceptions(String mensaje){
        super(mensaje);
    }
}
