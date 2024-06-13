package com.api.controlerepublica.controller;

import com.api.controlerepublica.responsedto.RepublicaResponseDTO;
import com.api.controlerepublica.repository.RepublicaRepository;
import com.api.controlerepublica.requestdto.RepublicaRequestDTO;
import models.Republica;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/rep")
public class RepublicaController {

    @Autowired
    private RepublicaRepository republicaRepository;

    /* crud para criação de republica, usando o dto para facilitar a conexão com o frontend */
    @PostMapping("/cadastro")
    public ResponseEntity<Republica> criarRepublica(@RequestBody RepublicaRequestDTO data) {
        Republica novaRepublica = new Republica(data);
        Republica republicaSalva = republicaRepository.save(novaRepublica);
        return ResponseEntity.ok(republicaSalva);
    }

    @GetMapping("/{idRepublica}")
    public ResponseEntity<RepublicaResponseDTO> buscarRepublica(@PathVariable Long idRepublica) {
        Optional<Republica> republicaBuscada = republicaRepository.findById(idRepublica);
        if (republicaBuscada.isPresent()) {
            RepublicaResponseDTO republicaEncontrada = new RepublicaResponseDTO(republicaBuscada.get());
            return ResponseEntity.ok(republicaEncontrada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{idRepublica}")
    public ResponseEntity<Republica> alterarDadosRupublica(@RequestBody RepublicaRequestDTO data,
                                                           @PathVariable Long idRepublica){
        Optional<Republica> republicaBuscada = republicaRepository.findById(idRepublica);
        if (republicaBuscada.isPresent()){
            Republica republicaAlterada = republicaBuscada.get();
            BeanUtils.copyProperties(data, republicaAlterada, "idRepublica");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/{idRepublica}")
    public ResponseEntity<Void> deletarRepublica(@PathVariable Long idRepublica){
        Optional<Republica> republicaBuscada = republicaRepository.findById(idRepublica);
        if (republicaBuscada.isPresent()){
            republicaRepository.deleteById(idRepublica);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
