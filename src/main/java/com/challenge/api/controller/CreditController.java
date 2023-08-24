package com.challenge.api.controller;

import com.challenge.api.dto.CreditDto;
import com.challenge.api.service.CreditService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Credit Controller",
        description = "Arithmetic Calculator REST API"
)
@CrossOrigin
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CreditController {

    private CreditService service;

    @GetMapping("/credit")
    public ResponseEntity<CreditDto> getCredit() {
        return ResponseEntity.ok(service.getCredit());
    }

    @PutMapping("/credit")
    public ResponseEntity<CreditDto> updateCredit(@RequestBody CreditDto creditDto) {
        log.info("Credito id: {}, nuevo: {}", 1L, creditDto);
        return ResponseEntity.ok(service.updateCredit(1L, creditDto.getCredit()));
    }

}
