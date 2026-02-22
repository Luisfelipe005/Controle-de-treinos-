package com.sistema.de.controle.treinos.controle_de_treinos.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Globalexceptionhandler {
    @ExceptionHandler(Treinonaoencontradoexception.class)
    public ResponseEntity<String> responseEntity(Treinonaoencontradoexception treinonaoencontradoexception){
        return ResponseEntity.status(404).body(treinonaoencontradoexception.getMessage());
    }

    @ExceptionHandler(Camposvazioexception.class)
    public ResponseEntity<String> responseEntity2(Camposvazioexception camposvazioexception){
        return ResponseEntity.status(400).body(camposvazioexception.getMessage());
    }

    @ExceptionHandler(Erroexception.class)
    public ResponseEntity<String> responseEntity3(Erroexception erroexception){
        return ResponseEntity.status(404).body(erroexception.getMessage());
    }
    @ExceptionHandler(Nomeduplicadoexception.class)
    public ResponseEntity<String> responseEntity4(Nomeduplicadoexception nomeduplicadoexception){
        return ResponseEntity.status(404).body(nomeduplicadoexception.getMessage());
    }
}
