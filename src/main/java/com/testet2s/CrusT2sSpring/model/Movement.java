package com.testet2s.CrusT2sSpring.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data           //Anotação do Lombok
@Entity         //Definir Entidade
public class Movement {

    @Id     //chave primária da classe
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Estratégia indica que a chave primária será gerada pelo banco de dados
    private Long idMovement;

    @Column
    private Long idContainerMovement;

    @Column
    private String tipoMov;

    @Column
    private String horaInicio;

    @Column
    private String horaFim;

}
