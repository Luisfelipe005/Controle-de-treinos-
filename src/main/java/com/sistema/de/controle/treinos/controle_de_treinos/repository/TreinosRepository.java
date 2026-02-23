package com.sistema.de.controle.treinos.controle_de_treinos.repository;

import com.sistema.de.controle.treinos.controle_de_treinos.model.TipoTreino;
import com.sistema.de.controle.treinos.controle_de_treinos.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinosRepository extends JpaRepository<Treino, Long> {
    Treino findByTipo(TipoTreino tipo);
    boolean existsBynome(String nome);
    List<Treino> findByconcluido(boolean concluido);
    Treino findBynomeContainsIgnoreCase(String nome);
}
