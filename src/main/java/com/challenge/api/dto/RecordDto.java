package com.challenge.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class RecordDto {

    @JsonIgnore
    private long id;

    private OperationDto operation;

    private long userId;

    private float amount;

    private float userBalance;

    private Date date;

}
