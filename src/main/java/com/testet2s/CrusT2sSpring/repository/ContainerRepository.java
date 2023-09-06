package com.testet2s.CrusT2sSpring.repository;

import com.testet2s.CrusT2sSpring.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {

    List<Container> findByStatusContainer(String statusContainer);  //Usado pra achar pelo Status

    List<Container> findByCategoria(String categoria);              //Usado pra achar pela Categoria

    void deleteByIdContainer(Long idContainer);                     //Usado no delete container especial


}