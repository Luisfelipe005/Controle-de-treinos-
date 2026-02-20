package com.sistema.de.controle.treinos.controle_de_treinos.service;

import com.sistema.de.controle.treinos.controle_de_treinos.exception.Nomevazioexception;
import com.sistema.de.controle.treinos.controle_de_treinos.exception.Treinonaoencontradoexception;
import com.sistema.de.controle.treinos.controle_de_treinos.model.TipoTreino;
import com.sistema.de.controle.treinos.controle_de_treinos.model.Treino;
import com.sistema.de.controle.treinos.controle_de_treinos.repository.TreinosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
       if(treinosRepository.findByTipo(tipo) == null){
           throw new Treinonaoencontradoexception("Treino não foi encontrado!");
       }
       return treinosRepository.findByTipo(tipo);
    }

    public Treino criaTreino(Treino treino){
        if(treino.getNome() == null){
            throw new Nomevazioexception("Verrifique se seu treino tem nome!");
        }
        return treinosRepository.save(treino);
    }

    public Treino atualizaTreino(Treino treino, Long id){
        Optional<Treino> optionalTreino = treinosRepository.findById(id);

        Treino treino2 = optionalTreino.get();
        treino2.setNome(treino.getNome());
        treino2.setTipo(treino.getTipo());
        treino2.setDuracaoemminutos(treino.getDuracaoemminutos());
        treino2.setConcluido(treino.isConcluido());
       return treinosRepository.save(treino2);
    }

    public void marcaConcluido(Long id){
        if(treinosRepository.findById(id).get().isConcluido()){
            treinosRepository.findById(id).get().setConcluido(false);
        }
        treinosRepository.findById(id).get().setConcluido(true);
    }

    public void delete(Long id){
        treinosRepository.deleteById(id);
    }

}
