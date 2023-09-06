package com.testet2s.CrusT2sSpring.repository;

import com.testet2s.CrusT2sSpring.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository     //Marcação de Repositório
public interface MovementRepository extends JpaRepository<Movement, Long> {

    void deleteByIdContainerMovement(Long idContainerMovement); //Definindo um deleteByIdContainerMovement

    boolean existsByIdContainerMovement(Long idContainerMovement); //Usado para pegar o delete no container especial

    void deleteByIdMovement(Long idMovement);                   //Delete no Movement
}
