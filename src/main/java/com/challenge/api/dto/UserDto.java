package com.challenge.api.dto;

import com.challenge.api.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @JsonIgnore
    private long id;
    private String email;

    private String password;

    private String status;

}
