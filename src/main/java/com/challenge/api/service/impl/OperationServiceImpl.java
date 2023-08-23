package com.challenge.api.service.impl;

import com.challenge.api.dto.OperationDto;
import com.challenge.api.entity.Operation;
import com.challenge.api.repository.OperationRepository;
import com.challenge.api.service.OperationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class OperationServiceImpl implements OperationService {

    private OperationRepository repository;

    private ModelMapper mapper;

    @Override
    public List<OperationDto> getOperations() {
        List<Operation> operations = repository.findAll();
        return operations.stream().map((record -> mapper.map(record, OperationDto.class)))
                .collect(Collectors.toList());
    }

}
