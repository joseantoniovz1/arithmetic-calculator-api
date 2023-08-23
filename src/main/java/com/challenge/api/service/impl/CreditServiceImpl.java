package com.challenge.api.service.impl;

import com.challenge.api.dto.CreditDto;
import com.challenge.api.entity.Credit;
import com.challenge.api.repository.CreditRepository;
import com.challenge.api.service.CreditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class CreditServiceImpl implements CreditService {

    private CreditRepository repository;

    private ModelMapper mapper;

    @Override
    public CreditDto getCredit() {
        Optional<Credit> credit = repository.findById(1L);
        return mapper.map(credit.get(), CreditDto.class);
    }

    @Override
    public CreditDto updateCredit(long id, float amount) {
        Optional<Credit> credit = repository.findById(1L);
        if (credit.isPresent()) {
            Credit newCredit = credit.get();
            newCredit.setCredit(amount);
            return mapper.map(repository.save(newCredit), CreditDto.class);
        }
        return null;
    }


}
