package com.pgs.workshop.domain;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class Balance {

    public static enum BalancePeriod {
        DAILY, WEEKLY, MONTHLY, YEARLY;
    
        public String getName() {
            return name();
        }
    };
    
    public static enum BalanceType {
        USER, COMPANY;
    
        public String getName() {
            return name();
        }
    };
    
    private BalancePeriod periodType;
    private BalanceType balanceType;
    private BigDecimal value;
    private String currencyCode;
    
}
