package com.challenge.api.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OperationDto {

    private long id;

    private String type;

    private float cost;


}
