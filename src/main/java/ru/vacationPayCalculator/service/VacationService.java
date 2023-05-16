package ru.vacationPayCalculator.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.vacationPayCalculator.model.VacationDto;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@Validated
public class VacationService {


    public Integer calculateVacationPay(@Valid VacationDto vacationDto) {

        if(vacationDto.getFirstVacationDay().isAfter(vacationDto.getLastVacationDay()))
        {
            throw new RuntimeException("Дата начала отпуска больше даты конца отпуска");
        }
        LocalDate currentDate = vacationDto.getFirstVacationDay();
        ArrayList<LocalDate> holidaysList = createHolidaysList(vacationDto.getFirstVacationDay().getYear());
        if (vacationDto.getFirstVacationDay().getYear() != vacationDto.getLastVacationDay().getYear())
            holidaysList.addAll(createHolidaysList(vacationDto.getLastVacationDay().getYear()));
        int workDays = 0;

        while (currentDate.isBefore(vacationDto.getLastVacationDay())) {
            if (!holidaysList.contains(currentDate))
                workDays++;
            currentDate = currentDate.plusDays(1);
        }
        return (int)(vacationDto.getSalary() / 29.3 * workDays);
    }

    //список праздничных дней
    public ArrayList<LocalDate> createHolidaysList(int year) {
        ArrayList<LocalDate> holidaysList = new ArrayList<>();
        holidaysList.add(LocalDate.of(year, 5, 9));
        holidaysList.add(LocalDate.of(year, 1, 2));
        holidaysList.add(LocalDate.of(year, 1, 3));
        holidaysList.add(LocalDate.of(year, 1, 4));
        holidaysList.add(LocalDate.of(year, 1, 5));
        holidaysList.add(LocalDate.of(year, 1, 6));
        holidaysList.add(LocalDate.of(year, 1, 7));
        holidaysList.add(LocalDate.of(year, 1, 8));
        holidaysList.add(LocalDate.of(year, 3, 23));
        holidaysList.add(LocalDate.of(year, 11, 4));
        holidaysList.add(LocalDate.of(year, 5, 1));
        holidaysList.add(LocalDate.of(year, 6, 12));
        holidaysList.add(LocalDate.of(year, 1, 1));
        return holidaysList;
    }


}
