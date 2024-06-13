package com.api.controlerepublica.controller;

import com.api.controlerepublica.repository.TarefasRepository;
import com.api.controlerepublica.requestdto.TarefaRequestDTO;
import com.api.controlerepublica.responsedto.TarefaResponseDTO;
import models.Tarefas;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tarefas")
public class TarefasController {

    @Autowired
    private TarefasRepository tarefasRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Tarefas> cadastrarTarefa(@RequestBody TarefaRequestDTO data){
        Tarefas novaTarefa = new Tarefas(data);
        Tarefas tarefaSalva = tarefasRepository.save(novaTarefa);
        return ResponseEntity.ok(tarefaSalva);
    }

    @GetMapping
    public List<TarefaResponseDTO> listarTaredas(){
        return tarefasRepository.findAll()
                .stream()
                .map(TarefaResponseDTO :: new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{idTarefa}")
    public ResponseEntity<TarefaResponseDTO> buscarTarefa(@PathVariable long idTarefa){
        Optional<Tarefas> tarefaBuscada = tarefasRepository.findById(idTarefa);
        if (tarefaBuscada.isPresent()){
            TarefaResponseDTO tarefaEncontrada = new TarefaResponseDTO(tarefaBuscada.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(tarefaEncontrada);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{idTarefa}")
    public ResponseEntity<Void>  deletarTarefa(@PathVariable long idTarefa){
        Optional<Tarefas> tarefaBuscada = tarefasRepository.findById(idTarefa);
        if (tarefaBuscada.isPresent()){
            tarefasRepository.deleteById(idTarefa);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("{idTarefa}")
    public ResponseEntity<Tarefas> alterarTarefa(@PathVariable long idTarefa,
                                                          @RequestBody TarefaRequestDTO data){
        Optional<Tarefas> tarefaBuscada = tarefasRepository.findById(idTarefa);
        if (tarefaBuscada.isPresent()){
            Tarefas tarefaSalva = tarefaBuscada.get();
            BeanUtils.copyProperties(data, tarefaSalva, "idTarefa");
            return ResponseEntity.status(HttpStatus.CREATED).body(tarefaSalva);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
