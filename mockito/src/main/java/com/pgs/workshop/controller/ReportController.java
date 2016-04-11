package com.pgs.workshop.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.pgs.workshop.domain.Balance;
import com.pgs.workshop.service.BalanceService;

@Controller
public class ReportController {
    
    @Autowired
    private BalanceService balanceService;
    
    public BigDecimal provideMonthlyUserBalance(Long userId, Integer year, Integer month) {
        Balance monthlyUserBalance = balanceService.provideMonthlyUserBalance(userId, year, month);
        return monthlyUserBalance.getValue();
    }
    
    public BigDecimal provideWeeklyCompanyBalance(Long companyId, Integer year, Integer week) {
        Balance weeklyCompanyBalance = balanceService.provideWeeklyCompanyBalance(companyId, year, week);
        return weeklyCompanyBalance.getValue();
    }
    
}
