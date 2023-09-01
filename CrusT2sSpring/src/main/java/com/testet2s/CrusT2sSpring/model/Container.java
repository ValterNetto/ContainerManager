package com.testet2s.CrusT2sSpring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_container;

    @Column
    private String cliente;

    @Column
    private String num_container;

    @Column
    private int tipo;

    @Column
    private String status_container;

    @Column
    private String categoria;
}
