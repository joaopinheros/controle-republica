package com.api.controlerepublica.requestdto;

public record RepublicaRequestDTO(String nomeRepublica) {

    /* Essa classe é uma Data Transfer Object para a comunicação do envio de requisições
    * com o banco de dados, nesse caso não passamos a id pois ela é gerada automaticamente
    * pela anotação do Spring*/
}
