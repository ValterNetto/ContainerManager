package com.testet2s.CrusT2sSpring.controller;


import com.testet2s.CrusT2sSpring.model.Container;
import com.testet2s.CrusT2sSpring.repository.ContainerRepository;
import com.testet2s.CrusT2sSpring.repository.MovementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")     //Configurando CORS para aceitar o Vue
@RestController                                     //Definindo como controlador
@RequestMapping("/container")                       //Definindo EndPoints
public class ContainerController {

    @Autowired                                      //Injetando Dependências
    private ContainerRepository containerRepository;
    @Autowired                                      //Injetando Dependências
    private MovementRepository movementRepository;

    @GetMapping
    public List<Container> listar() {
        return containerRepository.findAll(Sort.by(
                Sort.Direction.ASC, "cliente"));
    }

    @PostMapping
    public Container adicionar(@RequestBody Container container) {
        return containerRepository.save(container);
    }

    @Transactional                                  //Pra se caso der errado, ele dar um rollback
    @DeleteMapping("/{idContainer}")
    public void delete(@PathVariable Long idContainer) {
        if(movementRepository.existsByIdContainerMovement(idContainer)) {
            movementRepository.deleteByIdContainerMovement(idContainer);
        }
        containerRepository.deleteByIdContainer(idContainer);
    }

    @PutMapping
    public Container atualiza(@RequestBody Container container) {
        return containerRepository.save(container);
    }

    //usado no front
    @GetMapping("/status")
    public List<Container> filtrarContStatusContainer(@RequestParam String statusContainer) {
        return containerRepository.findByStatusContainer(statusContainer);
    }
    //usado no front
    @GetMapping("/categoria")
    public List<Container> filtrarContCategoria(@RequestParam String categoria) {
        return containerRepository.findByCategoria(categoria);
    }
}