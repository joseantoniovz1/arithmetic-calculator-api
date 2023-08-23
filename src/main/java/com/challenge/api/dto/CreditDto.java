package com.challenge.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditDto {

    @JsonIgnore
    private long id;

    private long user_id;

    private float credit;

}
