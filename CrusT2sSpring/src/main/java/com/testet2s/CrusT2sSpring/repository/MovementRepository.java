package com.testet2s.CrusT2sSpring.repository;

import com.testet2s.CrusT2sSpring.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Movement, Long> {
}
