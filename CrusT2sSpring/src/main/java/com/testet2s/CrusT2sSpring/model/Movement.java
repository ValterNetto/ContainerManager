package com.testet2s.CrusT2sSpring.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_movement;

    @Column
    private Long id_container_movement;

    @Column
    private String tipo_mov;

    @Column
    private String hora_inicio;

    @Column
    private String hora_fim;
}
