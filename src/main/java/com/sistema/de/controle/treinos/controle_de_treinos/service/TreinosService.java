package com.sistema.de.controle.treinos.controle_de_treinos.service;

import com.sistema.de.controle.treinos.controle_de_treinos.exception.Camposvazioexception;
import com.sistema.de.controle.treinos.controle_de_treinos.exception.Erroexception;
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

    /*Mostra lista*/
    public List<Treino> getTreinos(){
        return treinosRepository.findAll();
    }
    /*Mostra lista pelo tipo de treino*/
    public Treino buscaByTipo(TipoTreino tipo){
       if(treinosRepository.findByTipo(tipo) == null){
           throw new Treinonaoencontradoexception("Treino não foi encontrado!");
       }
       return treinosRepository.findByTipo(tipo);
    }

    /*Cria treino*/
    public Treino criaTreino(Treino treino){
        if(treino.getNome() == null || treino.getNome().isEmpty() || treino.getDuracaoemminutos() <= 1){
            throw new Camposvazioexception("Verifique se seu treino tem nome ou se seu treino tem mais que 0 minutos!");
        }
        return treinosRepository.save(treino);
    }
    /*Atualiza treino*/
    public Treino atualizaTreino(Treino treino, Long id){
        Optional<Treino> optionalTreino = treinosRepository.findById(id);

        Treino treino2 = optionalTreino.get();
        treino2.setNome(treino.getNome());
        treino2.setTipo(treino.getTipo());
        treino2.setDuracaoemminutos(treino.getDuracaoemminutos());
        treino2.setConcluido(treino.isConcluido());
       return treinosRepository.save(treino2);
    }

    /*Marca como concluido*/
    public Treino marcaConcluido(Long id){
        Treino treino = treinosRepository.findById(id).orElseThrow(() -> new Erroexception("Este treino não existe!"));

        if(treino.isConcluido()){
            treino.setConcluido(false);
        }else {
            treino.setConcluido(true);
        }
           return treinosRepository.save(treino);
    }

    /*Deleta treino pelo id*/
    public void delete(Long id){
        treinosRepository.deleteById(id);
    }

}
