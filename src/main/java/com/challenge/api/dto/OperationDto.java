package com.challenge.api.dto;

import com.challenge.api.entity.Record;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperationDto {

    private long id;

    private String type;

    private float cost;

    private RecordDto record;

}
