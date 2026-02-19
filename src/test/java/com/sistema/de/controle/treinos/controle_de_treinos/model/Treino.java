package com.sistema.de.controle.treinos.controle_de_treinos.model;

import jakarta.persistence.*;
import org.springframework.validation.annotation.Validated;

@Entity
@Table(name = "Tabela_Treinos")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private TipoTreino tipo;
    private Integer duracaoemminutos;
    private boolean concluido;

    public Treino(Long id, String nome, TipoTreino tipo, Integer duracaoemminutos) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.duracaoemminutos = duracaoemminutos;
        this.concluido = false;
    }

    public Treino() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoTreino getTipo() {
        return tipo;
    }

    public void setTipo(TipoTreino tipo) {
        this.tipo = tipo;
    }

    public Integer getDuracaoemminutos() {
        return duracaoemminutos;
    }

    public void setDuracaoemminutos(Integer duracaoemminutos) {
        this.duracaoemminutos = duracaoemminutos;
    }

    public boolean isConcluido() {
        return concluido;
    }

    public void setConcluido(boolean concluido) {
        this.concluido = concluido;
    }
}
