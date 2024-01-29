package com.project.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "estadisticas")
@Data
public class Resumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "register_id")
    private Integer id;

    private Integer person_id;
    private Date created_at;
    private Double utilities;
    private Double saves;
}
