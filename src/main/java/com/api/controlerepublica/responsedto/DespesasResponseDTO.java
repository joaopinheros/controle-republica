package com.api.controlerepublica.responsedto;

import models.Despesas;
import models.Pessoa;

import java.time.LocalDate;

public record DespesasResponseDTO (long idDespesa,String tituloDespesa, double valor,
                                  LocalDate prazoVencimento, boolean status, Pessoa pessoa){

    /* Essa classe é uma Data Transfer Object para a comunicação do banco de dados com
     * com o solicitação feita pelo usuario, ou seja usada para enviar os dados*/

    public DespesasResponseDTO(Despesas despesas){
        this(
                despesas.getIdDespesa(),
                despesas.getTituloDespesa(),
                despesas.getValor(),
                despesas.getPrazoVencimento(),
                despesas.isStatus(),
                despesas.getPessoa()
        );
    }
}
