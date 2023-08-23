package com.challenge.api.service;

import com.challenge.api.dto.CreditDto;
import com.challenge.api.entity.Credit;

public interface CreditService {

    CreditDto getCredit();

    CreditDto updateCredit(long id, float amount);

}
