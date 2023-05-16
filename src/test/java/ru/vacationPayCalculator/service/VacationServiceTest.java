package ru.vacationPayCalculator.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vacationPayCalculator.model.VacationDto;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VacationServiceTest {

    @Autowired
    private VacationService vacationService;

    @Test
    void calculateVacationPayWithYearDifference() {
        VacationDto vacationDto = new VacationDto(20000,
                LocalDate.of(2022,12,28),
                LocalDate.of(2023,1,5));
        Integer result = vacationService.calculateVacationPay(vacationDto);
        assertEquals(result, 2730);
    }


}
