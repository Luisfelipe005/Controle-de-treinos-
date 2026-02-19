package com.sistema.de.controle.treinos.controle_de_treinos.repository;

import com.sistema.de.controle.treinos.controle_de_treinos.model.TipoTreino;
import com.sistema.de.controle.treinos.controle_de_treinos.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinosRepository extends JpaRepository<Treino, Long> {
    TipoTreino findyByTipoTreinoContainsIgnoreCase(TipoTreino tipo);
}
