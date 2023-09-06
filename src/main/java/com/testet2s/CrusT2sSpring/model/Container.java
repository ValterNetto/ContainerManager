package com.testet2s.CrusT2sSpring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data       //Lombok
@Entity     //Definição de Entidade
public class Container {

    @Id     //Chave Primária da classe
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Estratégia indica que a chave primária será gerada pelo banco de dados
    private Long idContainer;

    @Column
    private String cliente;

    @Column
    private String numContainer;

    @Column
    private int tipo;

    @Column
    private String statusContainer;

    @Column
    private String categoria;


}
