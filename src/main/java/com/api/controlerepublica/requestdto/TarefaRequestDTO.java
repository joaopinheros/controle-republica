package com.api.controlerepublica.requestdto;

import models.Pessoa;

import java.time.LocalDate;

public record TarefaRequestDTO (String tituloTarefa, LocalDate dataRealizacao,
                                boolean status, String descricaoTarefa, Pessoa pessoa) {

    /* Essa classe é uma Data Transfer Object para a comunicação do envio de requisições
     * com o banco de dados, nesse caso não passamos a id pois ela é gerada automaticamente
     * pela anotação do Spring*/
}
