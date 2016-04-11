package com.pgs.workshop.domain;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class Company {

    Long id;
    String companyRegistrationNumber;
    String companyName;
    
    
}
