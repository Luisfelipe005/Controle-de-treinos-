package com.sistema.de.controle.treinos.controle_de_treinos.controller;

import com.sistema.de.controle.treinos.controle_de_treinos.model.TipoTreino;
import com.sistema.de.controle.treinos.controle_de_treinos.model.Treino;
import com.sistema.de.controle.treinos.controle_de_treinos.service.TreinosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Treinos")
public class TreinosController {
    private final TreinosService treinosService;

    public TreinosController(TreinosService treinosService) {
        this.treinosService = treinosService;
    }

    @GetMapping
    public List<Treino> getAll(){
        return treinosService.getTreinos();
    }

    @GetMapping("/tipo")
    public Treino buscaByTipo(@RequestParam TipoTreino tipo){
        return treinosService.buscaByTipo(tipo);
    }

    @PostMapping
    public ResponseEntity<Treino> criaTreino(@RequestBody Treino treino) {
        return ResponseEntity.status(201).body(treinosService.criaTreino(treino));
    }

    @PutMapping("/{id}")
    public Treino atualizaTreino(@PathVariable Long id, @RequestBody Treino treino){
        return treinosService.atualizaTreino(treino,id);
    }

    @PatchMapping("/{id}/concluir")
    public Treino marcarConcluido(@PathVariable Long id){
      return treinosService.marcaConcluido(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        treinosService.delete(id);
    }

}
