package com.testet2s.CrusT2sSpring.controller;

import com.testet2s.CrusT2sSpring.model.Movement;
import com.testet2s.CrusT2sSpring.repository.MovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movement")
public class MovementController {

    @Autowired
    public MovementRepository movementRepository;

    @GetMapping
    public List<Movement> listar(){
        return movementRepository.findAll();
    }

    @PostMapping
    public Movement adicionar(@RequestBody Movement movement){
        return movementRepository.save(movement);
    }

    @DeleteMapping
    public void delete(@RequestBody Movement movement){
        movementRepository.delete(movement);
    }

    @PutMapping
    public Movement atualizar(@RequestBody Movement movement){
        return movementRepository.save(movement);
    }
}
