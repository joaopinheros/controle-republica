package com.api.controlerepublica.responsedto;

import models.Pessoa;
import models.Tarefas;

import java.time.LocalDate;

public record TarefaResponseDTO (long idTarefa, String tituloTarefa, LocalDate dataRealizacao,
                                boolean status, String descricaoTarefa, Pessoa pessoa){

    /* Essa classe é uma Data Transfer Object para a comunicação do banco de dados com
     * com o solicitação feita pelo usuario, ou seja usada para enviar os dados*/

    public TarefaResponseDTO(Tarefas tarefas){
        this(
                tarefas.getIdTarefa(),
                tarefas.getTituloTarefa(),
                tarefas.getDataRealizacao(),
                tarefas.isStatus(),
                tarefas.getDescricaoTarefa(),
                tarefas.getPessoa()
        );
    }
}
