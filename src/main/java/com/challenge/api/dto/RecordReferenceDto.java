package com.challenge.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class RecordReferenceDto {

    private long id;

    private float amount;

    private float userBalance;

    private Date date;

    private OperationDto operation;

}
