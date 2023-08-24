package com.challenge.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

    private long id;
    private String email;

    private String password;

    private String status;

    private List<RecordReferenceDto> records;

}
