package com.pgs.workshop.service;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateService {

    public Date provideFirstDayOfMonth(Integer year, Integer month) {
        return new Date();
    }
    
    public Date provideLastDayOfMonth(Integer year, Integer month) {
        return new Date();
    }
    
    public Date provideFirstDayOfWeek(Integer year, Integer week) {
        return new Date();
    }
    
    public Date provideLastDayOfWeek(Integer year, Integer week) {
        return new Date();
    }
    
}
