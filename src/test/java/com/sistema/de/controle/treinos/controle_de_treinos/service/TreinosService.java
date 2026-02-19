package com.sistema.de.controle.treinos.controle_de_treinos.service;

import com.sistema.de.controle.treinos.controle_de_treinos.exception.Nomevazioexception;
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

    public List<Treino> getTreinos(){
        return treinosRepository.findAll();
    }

    public Treino buscaByTipo(TipoTreino tipo){
       if(treinosRepository.findByTipoTreino(tipo) == null){
           throw new Treinonaoencontradoexception("Treino não foi encontrado!");
       }
       return treinosRepository.findByTipoTreino(tipo);
    }

    public Treino criaTreino(Treino treino){
        if(treino.getNome() == null){
            throw new Nomevazioexception("Verrifique se seu treino tem nome!");
        }
        return treinosRepository.save(treino);
    }

}
