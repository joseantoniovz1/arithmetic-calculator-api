package com.challenge.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "operation_id")
    private Operation operation;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "amount")
    private float amount;

    @Column(name = "user_balance")
    private float userBalance;

    @Column(name = "date")
    private Date date;

}
