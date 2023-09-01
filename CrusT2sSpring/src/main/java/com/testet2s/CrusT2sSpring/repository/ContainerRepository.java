package com.testet2s.CrusT2sSpring.repository;

import com.testet2s.CrusT2sSpring.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContainerRepository extends JpaRepository<Container, Long> {
}
