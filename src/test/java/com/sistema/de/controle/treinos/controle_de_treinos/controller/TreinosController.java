package com.sistema.de.controle.treinos.controle_de_treinos.controller;

import com.sistema.de.controle.treinos.controle_de_treinos.model.TipoTreino;
import com.sistema.de.controle.treinos.controle_de_treinos.model.Treino;
import com.sistema.de.controle.treinos.controle_de_treinos.service.TreinosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
        return treinosService.treinos();
    }

    @GetMapping("/tipo")
    public List<Treino> buscaByTipo(@RequestParam TipoTreino tipo){
        return
    }
}
