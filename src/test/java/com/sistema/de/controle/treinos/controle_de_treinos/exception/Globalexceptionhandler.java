package com.sistema.de.controle.treinos.controle_de_treinos.exception;

import com.sistema.de.controle.treinos.controle_de_treinos.model.Treino;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class Globalexceptionhandler {
    @ExceptionHandler(Treinonaoencontradoexception.class)
    public ResponseEntity<String> responseEntity(Treinonaoencontradoexception treinonaoencontradoexception){
        return ResponseEntity.status(404).body(treinonaoencontradoexception.getMessage());
    }

    @ExceptionHandler(Nomevazioexception.class)
    public ResponseEntity<String> responseEntity2(Nomevazioexception nomevazioexception){
        return ResponseEntity.status(400).body(nomevazioexception.getMessage());
    }
}
