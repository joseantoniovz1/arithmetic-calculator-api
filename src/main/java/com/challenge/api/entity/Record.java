package com.challenge.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@Entity
@Table(name = "record")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount")
    private float amount;

    @Column(name = "user_balance")
    private float userBalance;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference// This is the foreign key column in the record table
    private User user;

    //@OneToOne(cascade = CascadeType.PERSIST)
    @ManyToOne
    @JoinColumn(name = "operation_id") // This is the foreign key column in the record table
    @JsonBackReference
    private Operation operation;

}
