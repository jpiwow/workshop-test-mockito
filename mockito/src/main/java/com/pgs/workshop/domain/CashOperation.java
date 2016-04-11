package com.pgs.workshop.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class CashOperation {

    Long id;
    String title;
    User userCommiting;
    BigDecimal value;
    String currencyCode;
    Date transferDate;
    
}
