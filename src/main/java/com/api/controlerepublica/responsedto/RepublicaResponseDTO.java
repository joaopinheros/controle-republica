package com.api.controlerepublica.responsedto;

import models.ConviteRepublica;
import models.Pessoa;
import models.Republica;

import java.util.List;


public record RepublicaResponseDTO(long idRepublica, String nomeRepublica, List<Pessoa> pessoa, List<ConviteRepublica> convites) {

    /* Essa classe é uma Data Transfer Object para a comunicação do banco de dados com
     * com o solicitação feita pelo usuario, ou seja usada para enviar os dados*/

    public RepublicaResponseDTO(Republica republica) {
        this(
                republica.getIdRepublica(),
                republica.getNomeRepublica(),
                republica.getPessoa(),
                republica.getConvites()
        );
    }
}
