package com.challenge.api.service;

import com.challenge.api.dto.RecordDto;

import java.util.List;

public interface CalculatorService {

    List<RecordDto> getRecords();

    RecordDto createRecord(RecordDto recordDto);

    List<RecordDto> getRecordsByUserId(String email);

}
