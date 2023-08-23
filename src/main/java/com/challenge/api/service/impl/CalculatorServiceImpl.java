package com.challenge.api.service.impl;

import com.challenge.api.dto.CreditDto;
import com.challenge.api.dto.RecordDto;
import com.challenge.api.entity.Credit;
import com.challenge.api.entity.Record;
import com.challenge.api.entity.User;
import com.challenge.api.repository.CreditRepository;
import com.challenge.api.repository.RecordRepository;
import com.challenge.api.repository.UserReporsitory;
import com.challenge.api.service.CalculatorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class CalculatorServiceImpl implements CalculatorService {

    private RecordRepository repository;

    private UserReporsitory userReporsitory;

    private ModelMapper mapper;

    @Override
    public List<RecordDto> getRecords() {
        List<Record> records = repository.findAll();
        return records.stream().map((record -> mapper.map(record, RecordDto.class)))
                .collect(Collectors.toList());
    }

    @Override
    public RecordDto createRecord(RecordDto recordDto) {
        //float userBalance = recordDto.getAmount() - recordDto.getOperationId()
        Record record = mapper.map(recordDto, Record.class);
        return mapper.map(repository.save(record), RecordDto.class);
    }

    @Override
    public List<RecordDto> getRecordsByUserId(String email) {
        User user = userReporsitory.findUserByEmail(email);
        log.info("Usuario encontrado: {}", user);
        if(user != null) {
            List<Record> records = repository.findRecordsByUserId(user.getId());
            return records.stream().map((record -> mapper.map(record, RecordDto.class)))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
