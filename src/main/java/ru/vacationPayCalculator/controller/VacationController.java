package ru.vacationPayCalculator.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.vacationPayCalculator.model.VacationDto;
import ru.vacationPayCalculator.service.VacationService;


@RestController
@Validated
public class VacationController {

    @Autowired
    private  VacationService vacationService;

    @GetMapping("/calculate")
    public ResponseEntity<String> getVacationPay(@RequestBody @Valid VacationDto vacationDto)
    {
        return ResponseEntity.ok("Сумма отпускных: "
                + vacationService.calculateVacationPay(vacationDto));
    }





}
