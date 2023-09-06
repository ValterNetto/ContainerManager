package com.testet2s.CrusT2sSpring.controller;

import com.testet2s.CrusT2sSpring.model.Container;
import com.testet2s.CrusT2sSpring.model.Movement;
import com.testet2s.CrusT2sSpring.repository.MovementRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")     //Configurando CORS para aceitar o Vue
@RestController                                     //Definindo como controlador
@RequestMapping("/movement")                        //Definindo EndPoints
public class MovementController {

    @Autowired  //Injetando Dependências
    public MovementRepository movementRepository;

    @GetMapping
    public List<Movement> listar(){ return movementRepository.findAll(); }

    @PostMapping
    public Movement adicionar(@RequestBody Movement movement){
        return movementRepository.save(movement);
    }

    @Transactional          //Pra se caso der errado, ele dar um rollback
    @DeleteMapping("/{idMovement}")
    public void delete(@PathVariable Long idMovement){
        movementRepository.deleteByIdMovement(idMovement);
    }

    @PutMapping
    public Movement atualizar(@RequestBody Movement movement){
        return movementRepository.save(movement);
    }
}