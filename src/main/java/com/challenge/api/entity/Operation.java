package com.challenge.api.entity;

import com.challenge.api.enums.OperationType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "operation")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    private String type;

    @Column(name = "cost")
    private float cost;

    @OneToOne(mappedBy = "operation", cascade = CascadeType.ALL)
    private Record record;

}
