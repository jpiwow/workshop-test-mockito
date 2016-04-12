package com.pgs.workshop.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.argThat;

import static com.pgs.workshop.testutils.MyCustomIdMatcher.myIdEqualsTo;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.pgs.workshop.domain.Balance;
import com.pgs.workshop.domain.Balance.BalancePeriod;
import com.pgs.workshop.domain.Balance.BalanceType;
import com.pgs.workshop.service.BalanceService;

@RunWith(MockitoJUnitRunner.class)
public class ReportControllerTest {
    
    @InjectMocks
    private ReportController reportController;
    
    @Mock
    private BalanceService balanceService;
    
    @Test
    public void shouldProvideMonthlyUserBalance() {
        //given
        Long userId = 12345L;
        Integer year = 2016;
        Integer month = 4;
        Balance expectedBalance = Balance.builder()
                .value(new BigDecimal("40000.00"))
                .currencyCode("EUR")
                .balanceType(BalanceType.USER)
                .periodType(BalancePeriod.MONTHLY)
                .build(); 
        
        //when
        when(balanceService.provideMonthlyUserBalance(userId, year, month)).thenReturn(expectedBalance);
        BigDecimal result = reportController.provideMonthlyUserBalance(userId, year, month);
        
        //then
        verify(balanceService, times(1)).provideMonthlyUserBalance(argThat(myIdEqualsTo(userId)),
                eq(year), eq(month));
        verify(balanceService, never()).provideWeeklyCompanyBalance(any(), any(), any());
        assertNotNull(result);
        assertEquals(expectedBalance.getValue(), result);
        
    }
    
}
