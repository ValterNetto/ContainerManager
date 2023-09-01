package com.testet2s.CrusT2sSpring.controller;


import com.testet2s.CrusT2sSpring.model.Container;
import com.testet2s.CrusT2sSpring.repository.ContainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/container")
public class ContainerController {

    @Autowired
    private ContainerRepository containerRepository;

    @GetMapping
    public List<Container> listar(){
        return containerRepository.findAll();
    }

    @PostMapping
    public Container adicionar (@RequestBody Container container){
        return containerRepository.save(container);
    }

    @DeleteMapping
    public void delete(@RequestBody Container container){
        containerRepository.delete(container);
    }

    @PutMapping
    public Container atualiza (@RequestBody Container container){
        return containerRepository.save(container);
    }
}