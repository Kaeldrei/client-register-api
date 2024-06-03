package com.example.client_register_api.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

@Component
public class DateUtils {

    public static LocalDate parseToLocalDate(String date){
        return isNull(date) ? null : LocalDate.parse(date);
    }

    public static LocalDateTime parseToLocalDateTime(String date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, dtf);
    }

    public static LocalTime parseToLocalTime(String time){
        return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
    }
}
