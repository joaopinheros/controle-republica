package com.api.controlerepublica.controller;

import com.api.controlerepublica.repository.DespesasRepository;
import com.api.controlerepublica.requestdto.DespesasRequestDTO;
import com.api.controlerepublica.responsedto.DespesasResponseDTO;
import models.Despesas;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.font.OpenType;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/despesas")
public class DespesasController {

    @Autowired
    private DespesasRepository despesasRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<Despesas> cadastrarDespesas(@RequestBody DespesasRequestDTO data){
        Despesas novaDespesa = new Despesas(data);
        Despesas despesaSalva = despesasRepository.save(novaDespesa);
        return ResponseEntity.ok(despesaSalva);
    }

    @GetMapping
    public List<DespesasResponseDTO> listarDespesas(){
        return despesasRepository.findAll()
                .stream()
                .map(DespesasResponseDTO :: new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{idDespesa}")
    public ResponseEntity<DespesasResponseDTO> buscarDespesa(@PathVariable long idDespesa){
        Optional<Despesas> despesaBuscada = despesasRepository.findById(idDespesa);
        if (despesaBuscada.isPresent()){
            DespesasResponseDTO despesaEncotrada = new DespesasResponseDTO(despesaBuscada.get());
            return ResponseEntity.ok(despesaEncotrada);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{idDespesa}")
    public ResponseEntity<Void> deletarDespesa (@PathVariable long idDespesa){
        Optional<Despesas> despesaBuscada = despesasRepository.findById(idDespesa);
        if (despesaBuscada.isPresent()){
            despesasRepository.deleteById(idDespesa);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PutMapping("/{idDespesa}")
    public ResponseEntity<Despesas> alterarDespesa(@PathVariable long idDespesa,
                                                   @RequestBody DespesasRequestDTO data){
        Optional<Despesas> despesaBuscada = despesasRepository.findById(idDespesa);
        if (despesaBuscada.isPresent()){
            Despesas despesaSalva = despesaBuscada.get();
            BeanUtils.copyProperties(data, despesaSalva, "idDespesa");
            return ResponseEntity.status(HttpStatus.CREATED).body(despesaSalva);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
