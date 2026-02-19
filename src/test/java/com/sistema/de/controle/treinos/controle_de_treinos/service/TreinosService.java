package com.sistema.de.controle.treinos.controle_de_treinos.service;

import com.sistema.de.controle.treinos.controle_de_treinos.exception.Treinonaoencontradoexception;
import com.sistema.de.controle.treinos.controle_de_treinos.model.TipoTreino;
import com.sistema.de.controle.treinos.controle_de_treinos.model.Treino;
import com.sistema.de.controle.treinos.controle_de_treinos.repository.TreinosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreinosService {
    private final TreinosRepository treinosRepository;

    public TreinosService(TreinosRepository treinosRepository) {
        this.treinosRepository = treinosRepository;
    }

    public List<Treino> treinos(){
        return treinosRepository.findAll();
    }

    public List<Treino> buscaByTipo(TipoTreino tipo){
        if (treinosRepository.findyByTipoTreinoContainsIgnoreCase(tipo).name().isEmpty()){
            throw new Treinonaoencontradoexception("Treino não encontrado");
        }
        return treinosRepository.findyByTipoTreinoContainsIgnoreCase(tipo).
                /*parei aqui, tem que ver oq ta dando erro, acho que é porque não volta um treino e sim o enum*/

    }
}
