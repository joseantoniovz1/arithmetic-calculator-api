package com.challenge.api.service.impl;

import com.challenge.api.dto.RecordDto;
import com.challenge.api.dto.UserReferenceDto;
import com.challenge.api.entity.Record;
import com.challenge.api.entity.User;
import com.challenge.api.exceptions.DeniedRequestException;
import com.challenge.api.repository.OperationRepository;
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
        return records.stream().map(record -> {
            RecordDto recordDto = mapper.map(record, RecordDto.class);

            if (record.getUser() != null) {
                UserReferenceDto userReferenceDto = new UserReferenceDto();
                userReferenceDto.setId(record.getUser().getId());
                userReferenceDto.setEmail(record.getUser().getEmail());
                recordDto.setUser(userReferenceDto);
            }

            return recordDto;
        }).collect(Collectors.toList());
    }

    @Override
    public RecordDto createRecord(RecordDto recordDto) {
        float userBalance = recordDto.getUserBalance() - recordDto.getAmount();
        User user = userReporsitory.findUserByEmail(recordDto.getUser().getEmail());
        if(userBalance >= 0 && user != null) {
            recordDto.setUserBalance(userBalance);
            recordDto.setUser(mapper.map(user, UserReferenceDto.class));
            Record record = mapper.map(recordDto, Record.class);

            return mapper.map(repository.save(record), RecordDto.class);
        } else {
            throw new DeniedRequestException("Request Denied, not enough balance.");
        }
    }

    @Override
    public List<RecordDto> getRecordsByUserId(String email) {
        User user = userReporsitory.findUserByEmail(email);
        if(user != null) {
            List<Record> records = repository.findRecordsByUserId(user.getId());
            return records.stream().map((record -> mapper.map(record, RecordDto.class)))
                    .collect(Collectors.toList());
        }
        return null;
    }
}
