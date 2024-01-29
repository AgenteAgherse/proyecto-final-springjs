package com.project.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "personas")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identification")
    private Integer id;

    @Column(name = "document_type")
    private String doc_type;

    private String name;
    private String surname;
    private String working_on;
    private String email;
    private String saves_percent;
    private Date birthday;
}
