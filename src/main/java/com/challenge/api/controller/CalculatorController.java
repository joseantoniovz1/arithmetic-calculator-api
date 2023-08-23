package com.challenge.api.controller;

import com.challenge.api.dto.OperationDto;
import com.challenge.api.dto.RecordDto;
import com.challenge.api.service.CalculatorService;
import com.challenge.api.service.OperationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Calculator Controller",
        description = "Arithmetic Calculator REST API"
)
@CrossOrigin
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class CalculatorController {

    private CalculatorService calculatorService;

    private OperationService operationService;

    @GetMapping("/records")
    public ResponseEntity<List<RecordDto>> getOperations() {
        List<RecordDto> records = calculatorService.getRecords();
        return ResponseEntity.ok(records);
    }

    @GetMapping("/records/{email}")
    public ResponseEntity<List<RecordDto>> getOperationsByEmail(@PathVariable("email") String email) {
        List<RecordDto> records = calculatorService.getRecordsByUserId(email);
        return ResponseEntity.ok(records);
    }

    @PostMapping("/record")
    public ResponseEntity<RecordDto> performOperation(@RequestBody RecordDto recordDto) {
        log.info("Record: {}", recordDto);
        RecordDto record = calculatorService.createRecord(recordDto);
        return ResponseEntity.ok(record);
    }


    @GetMapping("/operations")
    public ResponseEntity<List<OperationDto>> getRecords() {
        List<OperationDto> operations = operationService.getOperations();
        return ResponseEntity.ok(operations);
    }


}
