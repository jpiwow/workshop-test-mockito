package com.pgs.workshop.service;

import static org.apache.commons.collections4.CollectionUtils.isEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgs.workshop.dao.CashOperationDao;
import com.pgs.workshop.dao.UserDao;
import com.pgs.workshop.domain.Balance;
import com.pgs.workshop.domain.Balance.BalancePeriod;
import com.pgs.workshop.domain.Balance.BalanceType;
import com.pgs.workshop.domain.CashOperation;
import com.pgs.workshop.domain.User;

@Service
public class BalanceService {

    @Autowired
    private CashOperationDao cashOperationDao;
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private DateService dateService;
    
    public Balance provideMonthlyUserBalance(Long userId, Integer year, Integer month) {
        Date periodStart = dateService.provideFirstDayOfMonth(year, month);
        Date periodEnd = dateService.provideLastDayOfMonth(year, month);
        
        List<CashOperation> userCashOperations = cashOperationDao
                .fetchListOfUserOperations(userId, periodStart, periodEnd);
        
        String balanceCurrencyCode = isEmpty(userCashOperations) ? "" : userCashOperations.get(0).getCurrencyCode();
        
        BigDecimal balanceValue = sumCashOperationValues(userCashOperations);
        
        Balance userBalance = Balance.builder()
                .balanceType(BalanceType.USER)
                .periodType(BalancePeriod.MONTHLY)
                .value(balanceValue)
                .currencyCode(balanceCurrencyCode)
                .build();
        return userBalance;
    }

    public Balance provideWeeklyCompanyBalance(Long companyId, Integer year, Integer week) {
        Date periodStart = dateService.provideFirstDayOfWeek(year, week);
        Date periodEnd = dateService.provideLastDayOfWeek(year, week);
        
        List<User> companyUsers = userDao.fetchAllForCompany(companyId);
        
        List<CashOperation> companyUsersCashOperations = new ArrayList<>();
        for(User user:companyUsers) {
            List<CashOperation> userCashOperations = cashOperationDao
                    .fetchListOfUserOperations(user.getId(), periodStart, periodEnd);
            companyUsersCashOperations.addAll(userCashOperations);
        }
        
        String balanceCurrencyCode = isEmpty(companyUsersCashOperations) ?
                "" : companyUsersCashOperations.get(0).getCurrencyCode();
        
        BigDecimal balanceValue = sumCashOperationValues(companyUsersCashOperations);
        
        Balance companyBalance = Balance.builder()
                .balanceType(BalanceType.COMPANY)
                .periodType(BalancePeriod.WEEKLY)
                .value(balanceValue)
                .currencyCode(balanceCurrencyCode)
                .build();
        
        return companyBalance;
    }
    
    private BigDecimal sumCashOperationValues(List<CashOperation> userCashOperations) {
        BigDecimal balanceValue = userCashOperations.stream()
            .map(cashOperation -> cashOperation.getValue())
            .reduce(BigDecimal.ZERO, (accumulator, _item) -> accumulator = accumulator.add(_item));
        return balanceValue;
    }
    
}
